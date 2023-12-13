package com.example.connectionlifecycle.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Aspect
@Component
public class DatasourceAspect {
    @Around("target(javax.sql.DataSource)")
    public Object datasourceAspect(ProceedingJoinPoint proceedingJoinPoint)
        throws Throwable{

            System.out.println("Method invoked::"+proceedingJoinPoint
                    .getSignature().getName());

            Object obj = proceedingJoinPoint.proceed();
            if (obj instanceof Connection){
                return createConnectionProxy((Connection) obj);
        }
        return obj;
    }

    private Connection createConnectionProxy(Connection connection){
        return (Connection) Proxy.newProxyInstance(
                DatasourceAspect.class.getClassLoader(),
                new Class[] {Connection.class},
                new ConnectionInvocationHandler(connection)
        );
    }

}

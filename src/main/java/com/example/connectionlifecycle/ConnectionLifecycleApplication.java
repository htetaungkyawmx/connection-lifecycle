package com.example.connectionlifecycle;

import com.example.connectionlifecycle.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@RequiredArgsConstructor
public class ConnectionLifecycleApplication {
    private final EmployeeService employeeService;

    @Bean
    public ApplicationRunner runner(){
        return runner -> {
            employeeService.withoutTransaction();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ConnectionLifecycleApplication.class, args);
    }

}

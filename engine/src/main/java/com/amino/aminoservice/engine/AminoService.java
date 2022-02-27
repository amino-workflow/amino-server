package com.amino.aminoservice.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sridharswain
 */
@SpringBootApplication
@EnableTransactionManagement
public class AminoService {

    public static void main(String[] args) {
        SpringApplication.run(AminoService.class, args);
    }
}

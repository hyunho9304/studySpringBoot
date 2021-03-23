package com.test.hyunho;

import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;

@SpringBootApplication  //  스프링 부트의 자동설정 , 기본적인 최초 설정
public class Application {

    public static void main( String [] args ) {
        SpringApplication.run( Application.class , args ) ;
    }
}
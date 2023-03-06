package com.igate.SpringBoot.service;

import org.springframework.stereotype.Service;

@Service
public class CalService {

    public double add(double a, double b){
        System.out.println("Inside service method addition");
        return a+b;
    }

    public double sub(double a, double b){
       return a-b;
    }

    public double multiply(double a, double b){
        return a*b;
    }

    public double div(double a, double b){
        return a/b;
    }
}

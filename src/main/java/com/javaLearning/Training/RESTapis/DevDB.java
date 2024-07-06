package com.javaLearning.Training.RESTapis;

public class DevDB implements DB {
    @Override
    public String getData(){
        return "dev data";
    }
}

package com.example.demo.util;


public class Fibonacci {

    public int compute(int rank){
        if(rank == 0){
            return 0;
        }
        if(rank == 1){
            return 1;
        }
        return compute(rank - 1) + compute(rank - 2);
    }
}
package com.example.demo.util;


public class Fibonacci {

    public int compute(int rank){
        System.out.println("Fib compute " + rank);
        if (rank <= 1) {return rank;}
        else {return compute(rank-1) + compute(rank-2);}
    }
}
package com.allan.algorithm.taolu;

public class FindPrime {


    public static void main(String[] args) {

        int number = 18;
        boolean isPrime = isPrime(number);
        System.out.println(isPrime);

        for (int i = 1; i < 200; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

        for (int i = 1; i < 200; i++) {
            if (isPrimeEfficient(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeEfficient(int number) {
        if (number < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

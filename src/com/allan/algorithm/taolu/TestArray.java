package com.allan.algorithm.taolu;

public class TestArray {



    public static void main(String[] args) {

        int age = 3;
        int[] ages = new int[10];
        System.out.println("Age: " + age);
        System.out.println("Ages: " + ages[2]);
        System.out.println("Ages length " + ages.length);

        int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        char[] tictactoe = {'x', 'o'};

        String[] daysOfTheweek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        System.out.println(daysOfTheweek[2]);
        System.out.println(daysOfTheweek.length);

        for(int i = 0; i < daysOfTheweek.length; i++) {
            System.out.println(daysOfTheweek[i]);
        }

        for(int i = 0; i < months.length; i++){
            System.out.println(months[i] * 2);
        }

        for(int i = daysOfTheweek.length - 1; i >= 0 ; i-- ){
            System.out.println(daysOfTheweek[i]);
        }

        System.out.println(isPrime(2037));
    }

    public static boolean isPrime(int number) {
        for( int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

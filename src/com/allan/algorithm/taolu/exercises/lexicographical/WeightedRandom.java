package com.allan.algorithm.taolu.exercises.lexicographical;


import java.util.LinkedHashMap;
import java.util.Map;

public class WeightedRandom {

//
//    Problem:
//    Create a weighted random number generator. Create a class (be it Java, C++ or python) with 1 method (let say "getCountry()" )
//    and will return the country depending on the weights. The input is a table (let say hashTable) with the following data:
//
//    country  |  weight (%)
//    ------------------------------
//            --
//    US        | 44.75%
//    UK        | 22.2%
//    China    | 33.05%

    public static void main(String[] args) {

        Map<String,Double> countries = new LinkedHashMap<>();
        countries.put("US", 44.75);
        countries.put("UK", 22.2);
        countries.put("China", 33.05);

        for( int i = 0; i < 10; i++) {
            String country = getCountry(countries);
            System.out.println(String.format("%s) %s", i + 1, country));
        }
    }

    private static String getCountry(Map<String, Double> countries) {
        double random = Math.random();

        for(Map.Entry<String,Double> entry: countries.entrySet())
        {
            double percentage = entry.getValue() * 0.01;
            if(random < percentage) {
                return entry.getKey();
            }
            random -= percentage;
        }
        System.out.print("ramdom: " + random);
        return null;
    }
}

package org.example;

public class example {
    public static void main(String[] args) {
        double[] numbers = {1,5.5, 6.3, 4, 6.84};

        System.out.println(numbers[0]);
        System.out.println(numbers[4]);
        for(int i = numbers.length-1; i>=0; i--){
            System.out.println(numbers[i]);
        }
    }

}

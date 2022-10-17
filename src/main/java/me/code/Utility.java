package me.code;

import java.util.List;

public class Utility {

    /*
    Skriv ett program som räknar ut om ett visst tal är ett primtal eller inte.
     */

    public static boolean isPrime(int num) {
        if (num <= 0) return false;
        if (num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    /*
    Skriv ett program som räknar ut hur mycket pengar man kommer ha efter ett visst antal år
    om startsumman ökar med en viss procent varje år
     */

    public static double calculateMoney(int years, double startSum, double percentage) {
        var balance = startSum;
        for (int i = 0; i < years; i++) {
            balance *= percentage;
        }

        return balance;
    }

    /*
    Skriv ett program som tar in ett visst antal nummer och räknar ut medelvärdet.
     */
    public static double calculateAverage(List<Double> numbers) {
        if (numbers.isEmpty()) {
            throw new RuntimeException("cannot check for empty list");
        }

        double all = 0;
        for (double num : numbers) {
            all += num;
        }

        return all / (double) numbers.size();
    }
}

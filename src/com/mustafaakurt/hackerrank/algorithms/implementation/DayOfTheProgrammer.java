package com.mustafaakurt.hackerrank.algorithms.implementation;

import java.io.*;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        if (year == 1918) {
            return "26.09.1918";
        }

        boolean isJulianLeap = (year < 1918 && year % 4 == 0);
        boolean isGregorianLeap = (year > 1918 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)));

        int day = (isJulianLeap || isGregorianLeap) ? 12 : 13;

        return String.format("%02d.09.%d", day, year);
    }

}

public class DayOfTheProgrammer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


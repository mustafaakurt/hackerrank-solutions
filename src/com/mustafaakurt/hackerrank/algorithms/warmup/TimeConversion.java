package com.mustafaakurt.hackerrank.algorithms.warmup;

import java.io.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        char amOrPm = s.charAt(8);
        String hh = null;
        String mm = s.substring(3,5);
        String ss = s.substring(6,8);
        if (amOrPm == 'A') {
            hh = s.substring(0, 2);
            if (Integer.parseInt(hh) == 12) {
                hh = "00";
            }
        } else if (amOrPm == 'P') {
            hh = s.substring(0, 2);
            if (Integer.parseInt(hh) < 12) {
                hh = String.valueOf(Integer.parseInt(hh) + 12);
            }
        }
        return hh+":"+ mm + ":" +ss;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

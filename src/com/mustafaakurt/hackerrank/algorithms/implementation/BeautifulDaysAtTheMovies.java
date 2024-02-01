import java.io.*;

class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
        int number = 0;
        int reversedNumber = 0;
        int beautifulNumber = 0;
        int remainder = 0;
        double result = 0;
        for (int a = i; a <= j; a++) {
            number = a;
            while (number != 0) {
                remainder = number % 10;
                reversedNumber = reversedNumber * 10 + remainder;
                number = number / 10;
            }
            number = a;

            result = (double) Math.abs(number - reversedNumber) / k;
            reversedNumber = 0;
            remainder = 0;

            if (result == (int) result) {
                beautifulNumber++;
                reversedNumber = 0;
                remainder = 0;
            }

        }
        return beautifulNumber;

    }

}

public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

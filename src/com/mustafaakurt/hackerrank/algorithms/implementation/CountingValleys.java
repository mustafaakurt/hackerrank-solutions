import java.io.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int seaLevel = 0;
        int valleyCount = 0;
        int altitude = 0;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                altitude++;
            } else if (path.charAt(i) == 'D') {
                altitude--;
            }

            // we need to control is step Uphill and are we in seaLevel because if it's not we can say this is valley
            if (path.charAt(i) == 'U' && altitude == seaLevel) {
                valleyCount++;
            }
        }
        return valleyCount;

    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

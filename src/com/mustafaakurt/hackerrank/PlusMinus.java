import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int arraySize = arr.size();
        double positives = 0;
        double negatives = 0;
        double zeros = 0;
        for (int i = 0; i < arraySize; i++) {
            if (arr.get(i) > 0) {
                positives++;
            } else if (arr.get(i) < 0) {
                negatives++;
            } else if (arr.get(i) == 0) {
                zeros++;
            }
        }
        String positiveRatio = String.format("%.6f", (double) positives / arraySize);
        System.out.println(positiveRatio);
        String negativeRatio = String.format("%.6f", (double) negatives / arraySize);
        System.out.println(negativeRatio);
        String zeroRatio = String.format("%.6f", (double) zeros / arraySize);
        System.out.println(zeroRatio);
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

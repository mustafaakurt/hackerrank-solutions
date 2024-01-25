import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        int arraySize = arr.size();
        long sum = 0;
        long minimumNumber = Long.MAX_VALUE;
        long maximumNumber = Long.MIN_VALUE;


        for (int i = 0; i < arraySize; i++) {
            sum += arr.get(i);
            minimumNumber = Math.min(minimumNumber,arr.get(i));
            maximumNumber = Math.max(maximumNumber,arr.get(i));
        }

        System.out.println((sum-maximumNumber) + " " + (sum-minimumNumber));
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

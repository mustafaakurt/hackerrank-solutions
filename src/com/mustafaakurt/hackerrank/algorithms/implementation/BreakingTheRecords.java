import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int scoreSize = scores.size();//9
        int minimum = scores.get(0);//10
        int maximum = scores.get(0);//10
        List<Integer> minMaxCounter = new ArrayList<>();
        minMaxCounter.add(0);
        minMaxCounter.add(0);
        for (int i = 0; i < scoreSize; i++) {
            if (scores.get(i) < minimum) {
                minMaxCounter.set(1, minMaxCounter.get(1) + 1);
                minimum = scores.get(i);
            } else if (scores.get(i) > maximum) {
                minMaxCounter.set(0, minMaxCounter.get(0) + 1);
                maximum = scores.get(i);
            }
        }
        return minMaxCounter;
    }

}

public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

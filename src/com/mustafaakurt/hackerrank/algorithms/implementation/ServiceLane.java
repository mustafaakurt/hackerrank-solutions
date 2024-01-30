import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY cases
     */

    // You need to add List<Integer> width as a parameter because you need it this parameter when you are try to solve
    public static List<Integer> serviceLane(int n, List<Integer> width, List<List<Integer>> cases) {
        int caseSize = cases.size();
        List<Integer> maximumWidths = new ArrayList<>();

        for (int i = 0; i < caseSize; i++) {
            int lowerBound = cases.get(i).get(0);
            int upperBound = cases.get(i).get(1);
            int maximumWidth = Integer.MAX_VALUE;

            for (int k = lowerBound; k <= upperBound; k++) {
                if (width.get(k) < maximumWidth) {
                    maximumWidth = width.get(k);
                }
            }
            maximumWidths.add(maximumWidth);
        }
        return maximumWidths;
    }

}

public class ServiceLane {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.serviceLane(n, width, cases);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

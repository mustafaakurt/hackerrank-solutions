import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        /* This one is also working, but we can do it simple way using ascii codes of the letters
        /*
        List<Character> alphabet = new ArrayList<>();
        List<Integer> letterIndex = new ArrayList<>();
        int tallestLetter = 0;


        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabet.add(ch);
        }

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < alphabet.size(); j++) {
                if (word.charAt(i) == alphabet.get(j)) {
                    letterIndex.add(j);
                }
            }
        }
        for (int k = 0; k < letterIndex.size(); k++) {
            if (tallestLetter < h.get(letterIndex.get(k))) {
                tallestLetter = h.get(letterIndex.get(k));
            }
        }
        return tallestLetter * word.length();

         */

        int tallestLetter = 0;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int index = currentChar - 'a';

            // if you want you can write your own returnMax code with basic if else
            tallestLetter = Math.max(tallestLetter, h.get(index));
        }
        return tallestLetter * word.length();
    }

}

public class DesignerPDFViewer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

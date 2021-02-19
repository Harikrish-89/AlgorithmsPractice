import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Candy {

    static long candies(int n, int[] arr) {
        long intialCandies = n;
        int[] extraCandies = new int[n];
        extraCandies[0] = arr[0] > arr[1] ? 1 : 0;
        for (int i = 1; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1] || arr[i] > arr[i - 1]) {
                extraCandies[i] = extraCandies[i - 1] + 1;
            } else {
                extraCandies[i] = 0;
            }
        }
        if (arr[n - 1] > arr[n - 2]) {
            extraCandies[n - 1] = extraCandies[n - 2] + 1;
        } else {
            extraCandies[n - 2] = extraCandies[n - 2] + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "=>" + extraCandies[i]);
        }
        return intialCandies + IntStream.of(extraCandies).sum();
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

    }
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxSubsetSum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] trackMaxSums = new int[arr.length + 1];
        trackMaxSums[0] = arr[0];
        trackMaxSums[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            trackMaxSums[i] = Math.max(Math.max(trackMaxSums[i - 1], arr[i]), arr[i] + trackMaxSums[i - 2]);
        }
        return trackMaxSums[arr.length];
    };

    public static void main(String[] args) throws IOException {
        maxSubsetSum(new int[] { 2, 1, -5, 8, 4, 7, -8, 10, 9 });
    }
}

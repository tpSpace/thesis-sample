import java.util.Arrays;

public class BubbleSortTester {

    // Reference correct implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    // Utility to compare two arrays
    public static boolean isEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    // Runs a single test case
    public static void runTest(int[] input, int[] expected) {
        int[] testCase = Arrays.copyOf(input, input.length);
        bubbleSort(testCase);

        System.out.println("Input:    " + Arrays.toString(input));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Output:   " + Arrays.toString(testCase));
        System.out.println(isEqual(testCase, expected) ? "✅ Test Passed" : "❌ Test Failed");
        System.out.println();
    }

    public static void main(String[] args) {
        // You can add test cases here manually or generate them automatically

        runTest(new int[] { 5, 3, 8, 4, 2 }, new int[] { 2, 3, 4, 5, 8 });
        runTest(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
        runTest(new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 });
        runTest(new int[] {}, new int[] {});
        runTest(new int[] { 10 }, new int[] { 10 });
        runTest(new int[] { 9, 7, 5, 3, 1 }, new int[] { 1, 3, 5, 7, 9 });

        // Optional: auto-generated test case from a machine
        int[] autoCase = { 100, 1, 50, 25 };
        int[] autoExpected = { 1, 25, 50, 100 };
        runTest(autoCase, autoExpected);
    }
}

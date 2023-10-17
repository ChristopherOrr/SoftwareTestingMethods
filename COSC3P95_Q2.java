/*
 * COSC 3P95: Question 2
 * Monday, Oct. 16th 2023
 * Chris Orr - #6755383 - co19ua
 */
package cosc3p95_q2;

import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author Chris Orr
 */
public class COSC3P95_Q2 {

    public static class outOfBoundsException extends Exception {

        public outOfBoundsException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        int minimumValue = 1;
        int maximumValue = 1000;
        int numOfArrays = 5;

        try {
            for (int i = 0; i < numOfArrays; i++) {

                int randomArray[] = generateRandomArray(minimumValue, maximumValue);
                System.out.println("Random Array " + (i + 1) + " of Size " + randomArray.length + ":\n" + Arrays.toString(randomArray));

                bubbleSort(randomArray);
                System.out.println("Sorted Array " + (i + 1) + ":\n" + Arrays.toString(randomArray));

                boolean isSorted = verifySorted(randomArray);
                System.out.println("Is Sorted Correctly? " + isSorted + "\n");
            }
        } catch (outOfBoundsException e) {
            System.out.println("Exception occurred: ERROR");

        }

    }

    /* Method: generateRandomArray
     * Creates a random array of integers with random lengths.
     * @params: int length, int min, int max
     */
    public static int[] generateRandomArray(int min, int max) throws outOfBoundsException {

        Random random = new Random(); // Declare new random object
        int length = random.nextInt(20 - 10 + 1) + 10; // Pick length for the array
        int[] newArray = new int[length]; // Generate a new array with given parameters

        for (int i = 0; i < length; i++) { // When an arrayOutOfBoundsException is introduced in the code, such as "i < length + 1", exception will be thrown.

            if (i >= length) {
                throw new outOfBoundsException("Error: Array index out of bounds at index " + i);
            }
            newArray[i] = random.nextInt(max - min + 1) + min; // Pick a random number between the min and max and store it in the array
        }
        return newArray;
    }

    /* Method: bubbleSort
     * Sorts an array using bubble sort technique.
     * @params: int arr[]
     */
    static void bubbleSort(int arr[]) throws outOfBoundsException {
        int i, j, temp;
        boolean swap; // Keep track of swap or not
        int n = arr.length; // Store array length for iterations

        for (i = 0; i < n - 1; i++) {
            swap = false;
            for (j = 0; j < n - i - 1; j++) {

                if (arr[j] < arr[j + 1]) { // If sorting logic is incorrect, such as "arr[j] < arr[j + 1]", verifySorted will return false.

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }

            if (swap == false) {
                break;
            }
        }
    }

    static boolean verifySorted(int arr[]) {
        // Verify if the array is sorted correctly
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false; // Array is not sorted correctly
            }
        }
        return true; // Array is sorted correctly
    }

}

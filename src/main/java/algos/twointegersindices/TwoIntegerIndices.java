package algos.twointegersindices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given an array of integers, return the indices of two numbers such that the numbers add up to a
// specific target number.
// https://medium.com/better-programming/solving-the-most-common-tech-interview-question-798a2e3d1db7
public class TwoIntegerIndices {

  private static final String NO_INDICES_MATCHING = "No indices matching ";

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 5};
    printTwoIntegerIndicesBruteForceWay(arr, 5);
    // below is useful when you want to reduce time complexity and you can afford O(N) space.
    printTwoIntegerIndices(arr, 5);
    // below is useful when it is a big array and you cannot afford O(N) space.
    printTwoIntegerIndicesOneMoreWay(arr, 5);

  }

  // This approach runs in O(n * log(n)) time and O(1) space. This assumes that we use a sorting
  // method that runs in O(n * log(n)) time and O(1) space, such as heapsort.

  // we will first sort the array and use properties of a sorted array to improve our time
  // complexity without needing to use auxiliary space.
  // To do this, we will use a two-pointer method. We start one pointer at the first element and the
  // second pointer at the last element. We then check the sum of the two elements pointed to by
  // those pointers.
  // If the sum is too high, then we decrement the second pointer which decreases the sum, and if
  // the sum is too low, then we increment the first pointer which increases the sum.
  // We can only use this approach because the array is sorted, so we can guarantee that the array
  // is non-decreasing.

  private static void printTwoIntegerIndicesOneMoreWay(int[] arr, int sum) {
    // Sorting introduced O(n * log(n))
    Arrays.sort(arr);
    int left = 0;
    int right = arr.length - 1;
    // below O(n/2), but ignored as sort is higher order and dominating
    while (left < right) {
      if (arr[left] + arr[right] == sum) {
        System.out.printf("%n Found indices matching %d %d ", left, right);
        return;
      } else if (arr[left] + arr[right] < sum) {
        left++;
      } else {
        right--;
      }
    }
    System.out.println(NO_INDICES_MATCHING);
  }

  // Time Complexity = O(n), Space = O(n)

  // You start by initializing an empty map, which will be used to store previously-seen elements
  // and their indices.
  // Then, for each element in the list, you first check if you have seen sum_val - current_element
  // previously by checking if it is in your map’s key-set. If so, then you have found your desired
  // pair, since current_element + (sum_val - current_element) == sum_val .
  // Otherwise, you add current_element to your map and move on to the next element.


  public static void printTwoIntegerIndices(int[] arr, int sum) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int indice = 0; indice < arr.length; indice++) {
      if (map.containsKey(sum - arr[indice])) {
        System.out.printf("%n Found indices matching %d %d ", map.get(sum - arr[indice]), indice);
        return;
      } else {
        map.put(arr[indice], indice);
      }
    }
    System.out.println(NO_INDICES_MATCHING);
  }

  // Time Complexity = O(n2), Space = O(1)
  public static void printTwoIntegerIndicesBruteForceWay(int[] arr, int sum) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (i != j && arr[i] + arr[j] == sum) {
          System.out.printf("%n Found indices matching %d %d", i, j);
          return;
        }
      }
    }
    System.out.println(NO_INDICES_MATCHING);
  }
}

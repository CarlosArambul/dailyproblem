public final class Problem_0002 {

  /**
   * Given an array of integers, return a new array such that each element at index i of the new
   * array is the product of all the numbers in the original array except the one at i.
   *
   * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40,
   * 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
   *
   * Follow-up: what if you can't use division?
   */
  public static int[] getProductOfAllExcludingCurrentIndex(int[] numbers) {

     if (numbers == null || numbers.length < 2) {
         throw new IllegalArgumentException("There must be at least 2 numbers in the array");
     }

     int length = numbers.length;
     int[] products = new int[length];

      for (int i = 0; i < length; i++) {
          int product = 1;
          for (int j = 0; j < length; j++) {
              // exclude current index
              if (j != i) {
                 product *= numbers[j];
             }
         }
          products[i] = product;
     }

      return products;
  }
}

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem_0002Test {

  @Test
  void productMatches() {

    assertArrayEquals(new int[] { 120, 60, 40,30, 24 },
            Problem_0002.getProductOfAllExcludingCurrentIndex(new int[] { 1, 2, 3, 4, 5 }));

    assertArrayEquals(new int[] { 2, 3, 6 },
            Problem_0002.getProductOfAllExcludingCurrentIndex(new int[] { 3, 2, 1 }));
  }

  @Test
  void productNotMatching() {

    assertNotEquals(new int[] { 1, 2, 3, 4, 5 },
            Problem_0002.getProductOfAllExcludingCurrentIndex(new int[] { 120, 60, 40,30, 24 }));

    assertNotEquals(new int[] { 3, 2, 1 },
            Problem_0002.getProductOfAllExcludingCurrentIndex(new int[] { 2, 3, 6 }));
  }

  @Test
  void productThrowsIllegalArgumentException() {

    assertThrows(IllegalArgumentException.class, () -> {
          Problem_0002.getProductOfAllExcludingCurrentIndex(new int[] {1});
    });
  }

}
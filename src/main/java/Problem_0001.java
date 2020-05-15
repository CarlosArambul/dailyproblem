import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem_0001 {

    public static final int MINIMUM_NUMBERS = 2;

    /**
     * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
     * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
     * Bonus: Can you do this in one pass?
     * @param numbers a list of numbers
     * @param k a number
     */
    public static boolean sumAddsUp(List<Integer> numbers, int k) {

        if (numbers == null || numbers.size() < MINIMUM_NUMBERS) {
            throw new IllegalArgumentException("List must contain at least two numbers");
        }

        Set<Integer> previous = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {

            int current = numbers.get(i);
            if (previous.contains(k - current)) {
                return true;
            }
            previous.add(current);
        }

        return false;
    }
}

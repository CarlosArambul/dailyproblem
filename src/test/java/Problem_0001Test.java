import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem_0001Test {

    @Test
    void sumAddsUp() {

        assertTrue(Problem_0001.sumAddsUp(Arrays.asList(10, 15, 3, 7), 17));
    }

    @Test
    void sumNotAddingUp() {

        assertFalse(Problem_0001.sumAddsUp(Arrays.asList(10, 15, 3, 7), 19));
    }

    @Test
    void sumThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Problem_0001.sumAddsUp(Arrays.asList(10), 19);
        });
    }
}
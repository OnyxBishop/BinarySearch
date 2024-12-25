package ram;

import org.junit.jupiter.api.Test;
import static ram.FooArray.*;
import static org.assertj.core.api.Assertions.*;

public class FooArrayTest {
    @Test
    public void whenIntegerArrayThenResult() {
        int[] array = {1, 2, 3, 5, 8, 14};
        int index = binarySearch(array, 8);
        int expected = 4;
        assertThat(index).isEqualTo(expected);
    }

    @Test
    public void whenStringArrayThenResult() {
        String[] strArray = {"apple", "banana", "cherry", "pineapple"};
        int index = binarySearch(strArray, "cherry", String::compareTo);
        int expected = 2;
        assertThat(index).isEqualTo(expected);
    }
}

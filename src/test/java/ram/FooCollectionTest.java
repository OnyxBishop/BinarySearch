package ram;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ram.FooCollection.*;

public class FooCollectionTest {

    @Test
    public void whenListIntegerThenResult() {
        List<Integer> list = java.util.Arrays.asList(2, 4, 6, 8, 10);
        int index = binarySearch(list, 6);
        int expected = 2;
        assertThat(index).isEqualTo(expected);
    }
}

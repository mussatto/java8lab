package lab.j8;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

public class StreamLabTest {

    @Test
    public void testFilterAndGetPairs() {
        List<Integer> listTest = DataFactory.createListInteger(10);
        List<Integer> returnedList = listTest.stream().filter(i -> i % 2 ==0).collect(Collectors.toList());

        assertTrue(returnedList.size() > 0);
        assertTrue(returnedList.size() != 10);
        assertTrue(returnedList.get(0) == 0);
        assertTrue(returnedList.get(1) == 2);
        assertTrue(returnedList.get(2) == 4);
    }
}

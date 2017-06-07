package lab.j8;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by mussa on 6/6/2017.
 */
public class SteramSortTest {

    @Test
    public void testStreamSortString(){

        List<Customer> customers = DataFactory.createCustomersNeg(10);
        System.out.println("Unordered");
        System.out.println(customers);
        List<Customer> sortedByName = customers
                .stream()
                .sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());
        System.out.println("Ordered By Name");
        System.out.println(sortedByName);
        assertEquals(10, sortedByName.size());

        List<Customer> sortedById = customers
                .stream()
                .sorted(Comparator.comparing(Customer::getId)).collect(Collectors.toList());
        System.out.println("Ordered By Id");
        System.out.println(sortedById);
    }
}

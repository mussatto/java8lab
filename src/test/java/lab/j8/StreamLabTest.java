package lab.j8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

public class StreamLabTest {

    @Test
    public void testFilterAndGetPairs() {
        List<Integer> listTest = DataFactory.createListInteger(10);
        List<Integer> returnedList = listTest.stream().filter(i -> i % 2 ==0).collect(Collectors.toList());

        System.out.println(returnedList);
        assertTrue(returnedList.size() > 0);
        assertTrue(returnedList.size() != 10);
        assertTrue(returnedList.size() == 6);
        assertTrue(returnedList.get(0) == 0);
        assertTrue(returnedList.get(1) == 2);
        assertTrue(returnedList.get(2) == 4);
    }

    @Test
    public void testFilterAndGetCustomers() {
        List<Customer> customers = DataFactory.createCustomers(10);
        List<Customer> filteredCustomers = customers.stream().filter(c -> c.getId() % 2 ==0).collect(Collectors.toList());

        assertTrue(filteredCustomers.size() > 0);
        assertTrue(filteredCustomers.size() != 10);
        assertTrue(filteredCustomers.size() == 6);
        assertTrue(filteredCustomers.get(0).getId() == 0);
        assertTrue(filteredCustomers.get(1).getId() == 2);
        assertTrue(filteredCustomers.get(2).getId() == 4);
    }

    @Test
    public void testFilterAndGetCustomersIds() {
        List<Customer> customers = DataFactory.createCustomers(10);
        List<Integer> filteredCustomersId = customers.stream().filter(c -> c.getId() % 2 ==0)
                .mapToInt(Customer::getId).boxed().collect(Collectors.toList());

        assertTrue(filteredCustomersId.size() > 0);
        assertTrue(filteredCustomersId.size() != 10);
        assertTrue(filteredCustomersId.size() == 6);
        assertTrue(filteredCustomersId.get(0) == 0);
        assertTrue(filteredCustomersId.get(1) == 2);
        assertTrue(filteredCustomersId.get(2) == 4);
    }

    @Test
    public void testFilterAndGetCustomersIdsParallel() {
        List<Customer> customers = DataFactory.createCustomers(5000000);
        Instant e1 = Instant.now();
        List<Integer> filteredCustomersId = customers.stream().filter(c -> c.getId() % 2 ==0)
                .mapToInt(Customer::getId).boxed().collect(Collectors.toList());
        Duration elapsed = Duration.between(e1, Instant.now());
        System.out.println("elapsed 1:" +elapsed.toString());
        assertTrue(filteredCustomersId.size() > 0);
        assertTrue(filteredCustomersId.get(0) == 0);
        assertTrue(filteredCustomersId.get(1) == 2);
        assertTrue(filteredCustomersId.get(2) == 4);

        Instant e2 = Instant.now();
        filteredCustomersId = customers.parallelStream().filter(c -> c.getId() % 2 ==0)
                .mapToInt(Customer::getId).boxed().collect(Collectors.toList());
        elapsed = Duration.between(e2, Instant.now());

        System.out.println("elapsed 2:" +elapsed.toString());
    }
}

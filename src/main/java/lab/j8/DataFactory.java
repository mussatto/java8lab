package lab.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DataFactory {

    public static List<Integer> createListInteger(int maxSize){
//        List<Integer> myList = new ArrayList<>();
//        for(int i=0; i<maxSize; i++){
//            myList.add(i);
//        }

        List<Integer> myList = new ArrayList<>();
        IntStream.rangeClosed(0, maxSize).forEach(myList::add);

        return myList;
    }

    public static List<Customer> createCustomers(int maxSize){
        List<Customer> customers = new ArrayList<>();
        IntStream.rangeClosed(0, maxSize).forEach( i -> customers.add(new Customer(i, "Customer "+i)));

        return customers;
    }
}

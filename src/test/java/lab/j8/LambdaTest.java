package lab.j8;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by mussa on 6/7/2017.
 */
public class LambdaTest {

    @Test
    public void testLambda() {

        int sum = 0;
        List<Integer> numbers = DataFactory.createListInteger(100);
        // java < 8 way:
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
        // java >= 8 way:

        Counter counter = new Counter();
        numbers.forEach(counter::add);
        System.out.println(counter.getSum());
//        Integer mySum =0;
//        numbers.forEach( i -> mySum = mySum+ i);

        //Another way to write lambda

        Counter newCounter = new Counter();
        numbers.forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer integer) {
                newCounter.add(integer);
            }
        });
        System.out.println(newCounter.getSum());
    }
}

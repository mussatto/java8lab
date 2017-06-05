package lab.j8;

import java.util.List;
import java.util.stream.Collectors;

public class StreamLab {

    public static List<Integer> getAllPairs(List<Integer> list){
        return list.stream().filter(i -> i % 2 ==0).collect(Collectors.toList());
    }
}

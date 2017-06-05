package lab.j8;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    public static List<Integer> createListInteger(int maxSize){
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<maxSize; i++){
            myList.add(i);
        }

        return myList;
    }
}

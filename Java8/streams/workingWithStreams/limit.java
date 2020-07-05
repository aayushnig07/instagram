package Java8.streams.workingWithStreams;

import java.util.Arrays;
import java.util.List;

public class limit {
    public static void main(String[]args){
        List<Integer> elements = Arrays.asList(1,3,5,5,7,65,6,45,
                                        6,3,4,5,5,67,56,687,865,466);
        findFirst4EvenNumbers(elements);
    }   
    
    public static void findFirst4EvenNumbers(List<Integer> elements){
        elements.stream()
                .filter(i->i%2==0)
                .limit(4) //will return a new stream containing only 4 elements
                .forEach(System.out::println);
                /*
                Output
                6
                6
                4
                56
                */
        
    }
    
}
package Java8.streams.workingWithStreams;

import java.util.Arrays;
import java.util.List;

public class distinct {
    public static void main(String[]args){
        List<Integer>elements = Arrays.asList(1,2,3,4,2,3,4,54,4,65,3,2,35,342,45,434,542,45);

        //function to find all even distince elements in the list
        findAllEvenElementsInAList(elements);
    }

    public static void findAllEvenElementsInAList(List<Integer>elements){
        elements.stream() //convert to stream
                .filter(i->i%2==0) //filter using the predicate (i->i%2==0)
                .distinct() //get the distince elements
                .forEach(System.out::println);
                /*Output
                2
                4
                54
                342
                434
                542 */
    }    
}
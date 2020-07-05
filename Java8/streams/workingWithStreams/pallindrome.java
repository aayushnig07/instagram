package Java8.streams.workingWithStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class pallindrome {
    public static void main(String[]args){
        List<String>elements = Arrays.asList("101","102","23123","44323","abba");
        findAllPallindromesInAList(elements);
    }   
    
    public static void findAllPallindromesInAList(List<String> elements){
        for (String element : elements) {
            String tempElement = element;
            int len = tempElement.length();
            boolean result = IntStream.range(0, tempElement.length()/2)
                                      .noneMatch(i->tempElement.charAt(i)!=tempElement.charAt(len-i-1));
            System.out.println(result);      
        }
    }
}

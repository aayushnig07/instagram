package Java8.BasicExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;

/*WAP to sort names in ascending order*/
public class Example01 {
    static List<String> names = new ArrayList<>();
    public static void main(String []args){
        names.add("Rames");
        names.add("Suresh");
        names.add("Surender");
        names.add("Zeba");
        names.add("Tom");

        //calling sort function which will use java 7
        usingJava7(names);

        //calling sort function which will use java 8
        usingJava8(names);

    }

    public static void usingJava7(List<String>names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
               return s1.compareTo(s2);
            }
         });    
         System.out.println(names);
         //[Rames, Surender, Suresh, Tom, Zeba]
    }

    public static void usingJava8(List<String>names){
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNames);
        //[Rames, Surender, Suresh, Tom, Zeba]
    }
    
}
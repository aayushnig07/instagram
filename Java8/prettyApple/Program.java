package Java8.prettyApple;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void prettyPrintApples(List<Apple> inventory, AppleFormatter appleFormatter){
        for(Apple apple: inventory){
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String []args){
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("Green", 100));
        inventory.add(new Apple("Red", 159));
        inventory.add(new Apple("Green", 200));
        prettyPrintApples(inventory, new AppleFanceFormatter());
    }
    
}
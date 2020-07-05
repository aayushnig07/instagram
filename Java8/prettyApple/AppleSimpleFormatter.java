package Java8.prettyApple;

public class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return "An Apple of " + apple.getWeight() + " grams";
    }
    
}
package Java8.prettyApple;

public class AppleFanceFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        String characteristics = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristics + " " + apple.getColor() + " apple";
    }

}
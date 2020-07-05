package Java8.streams.MenuProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    //populate the list with data of dishes
    static List<Menu> menu = Arrays.asList(new Menu("Dal Ka Dulha", true, 500, Menu.Type.VEGAN),
            new Menu("Butter Chicken", false, 800, Menu.Type.MEAT), new Menu("Dal Makhni", true, 200, Menu.Type.VEGAN),
            new Menu("Fish Fry", false, 400, Menu.Type.FISH), new Menu("Idli Dosa", true, 100, Menu.Type.OTHERS));

    public static void main(String[] args) {
        threeHighCaloriesDishes(menu);
        onlyVegetarianDishesName(menu);
        totalCaloriesInMenu(menu);
    }

    //Java 7 implementation
    public static void getNamesOfDishesWithCaloriValueLessThan400(List<Menu>dishes){
        List<Menu> lowCalorieDishes = new ArrayList<>();
        for(Menu m: dishes){
            if(m.getCalories()<400){//filter the elements using an accumulator
                lowCalorieDishes.add(m);
            }
        }

        Collections.sort(lowCalorieDishes,new Comparator<Menu>() {//sort the dishes with an annonymous class
            public int compare(Menu m1, Menu m2){
                return Integer.compare(m1.getCalories(), m2.getCalories());
            }
        });

        List<String>lowCalorieDishesName = new ArrayList<>();
        for(Menu m: lowCalorieDishes){ //process the sorted list to get the name of dishes
            lowCalorieDishesName.add(m.getName());
            //return the name of the dishes in sorted order
            //whose calorie is less than 400 
            System.out.println(lowCalorieDishes);//["Dal makhni", "Idli Dosa"]
        }
    }

    //Java 8 implementation using streams
    public static void getNamesOfDishesWithCaloriValueLessThan400UsingStreams(List<Menu>dishes){
        List<String>dishNameWithCalorieValueLessThan400 = dishes.stream() //converted to a stream of data
                                                                .filter(d->d.getCalories()<400) //use filter to apply the condition
                                                                .sorted() //sort the data
                                                                .map(Menu::getName) //get the names of the dishes using map
                                                                .collect(Collectors.toList()); //collect the data and convert it to a list
        System.out.println(dishNameWithCalorieValueLessThan400);
        //["Dal makhni", "Idli Dosa"]

    }

    public static void onlyVegetarianDishesName(List<Menu> dishes) {
        List<String> onlyVegetarianDishesName = dishes.stream().filter(Menu::isVegetarian).map(Menu::getName)
                .collect(Collectors.toList());
        System.out.println(onlyVegetarianDishesName);
    }

    public static void totalCaloriesInMenu(List<Menu> dishes) {
        int totalCalories = dishes.stream().map(Menu::getCalories).mapToInt(Integer::intValue).sum();
        System.out.println(totalCalories);
    }

    public static void threeHighCaloriesDishes(List<Menu> dishes) {
        List<String> threeHighCaloriesDishes = dishes.stream().filter(d -> d.getCalories() >= 200).map(m -> m.getName())
                .limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloriesDishes);

    }

}
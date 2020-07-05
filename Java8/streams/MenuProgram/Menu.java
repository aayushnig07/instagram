package Java8.streams.MenuProgram;

//Lets create a bean class menu
public class Menu {
    private String name;//name of the dish
    private boolean isVegetarian;//is the dish vegetarian
    private int calories;//calorie in that dish
    private Type type;//type of the dish (vegan, meat, fish, others)

    enum Type{
        VEGAN,
        MEAT,
        FISH,
        OTHERS
    }

    //parameterized constructor
    public Menu(String name, boolean isVegetarian, int calories, Type type){
        this.name = name;
        this.isVegetarian=isVegetarian;
        this.calories=calories;
        this.type=type;
    }

    //getter function
    public String getName(){
        return this.name;
    }

    public boolean isVegetarian(){
        return this.isVegetarian;
    }

    public int getCalories(){
        return this.calories;
    }

    public Type getType(){
        return this.type;
    }
    
}
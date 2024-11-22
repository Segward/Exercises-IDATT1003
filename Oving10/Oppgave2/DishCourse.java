public class DishCourse {
    Dish appetizer;
    Dish mainCourse;
    Dish dessert;
    String name;

    public DishCourse(String name, Dish appetizer, Dish mainCourse, Dish dessert) {
        this.name = name;
        this.appetizer = appetizer;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return name + ":\nAppetizer: " + appetizer.name + "\nMain course: " + mainCourse.name + "\nDessert: " + dessert.name;
    }
}
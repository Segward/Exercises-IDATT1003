public class Menu {

    Dish[] dishes;
    String name;
    DishCourse[] dishCourses;

    public Menu(Dish[] dishes, String name) {
        this.dishes = dishes;
        this.name = name;
        this.dishCourses = new DishCourse[0];
    }

    public int getMenuPrice() {
        int price = 0;
        for (Dish dish : dishes) {
            price += dish.price;
        }
        return price;
    }

    public void addDish(Dish dish) {
        Dish[] newDishes = new Dish[dishes.length + 1];
        System.arraycopy(dishes, 0, newDishes, 0, dishes.length);
        newDishes[dishes.length] = dish;
        dishes = newDishes;
    }

    public void addDishCourse(DishCourse dishCourse) {
        DishCourse[] newDishCourses = new DishCourse[dishCourses.length + 1];
        System.arraycopy(dishCourses, 0, newDishCourses, 0, dishCourses.length);
        newDishCourses[dishCourses.length] = dishCourse;
        dishCourses = newDishCourses;
    }

    public Dish getDish(String name) {
        for (Dish dish : dishes) {
            if (dish.name.equals(name)) {
                return dish;
            }
        }
        return null;
    }

    public Dish[] getDishsByType(String type) {
        // Count number of dishes with the given type
        int count = 0;
        for (Dish dish : dishes) {
            if (dish.type.equals(type)) {
                count++;
            }
        }

        // Create a new array with the size of the count
        Dish[] newDishes = new Dish[count];
        int index = 0;
        for (Dish dish : dishes) {
            if (dish.type.equals(type)) {
                newDishes[index] = dish;
                index++;
            }
        }
        return newDishes;
    }

    public String getMenuAsString() {
        String menu = "Menu: " + name + "\n";
        int price = getMenuPrice();
        menu += "Price: " + price + "nok\n";
        for (Dish dish : dishes) {
            menu += dish.toString() + "\n";
        }

        menu += "\nCourses:\n\n";
        for (DishCourse dishCourse : dishCourses) {
            menu += dishCourse.toString() + "\n\n";
        }
        return menu;
    }

    @Override // [MISBRUK AV TOSTRING] fra LA override burde brukes for debugging, lag heller en dedikert metode for å printe ut menyen
    public String toString() {
        String menu = "Menu: " + name + "\n";
        for (Dish dish : dishes) {
            menu += dish.toString() + "\n";
        }
        for (DishCourse dishCourse : dishCourses) {
            menu += dishCourse.toString() + "\n\n";
        }
        return menu;
    }

}

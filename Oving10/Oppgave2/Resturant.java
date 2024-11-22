
public class Resturant {

    static Dish[] dishes1 = {
        new Dish("Pizza", 100, "Main course", "Pizza with cheese and tomato"),
        new Dish("Pasta", 80, "Main course", "Pasta with tomato sauce"),
        new Dish("Salad", 50, "Appetizer", "Salad with lettuce and tomato"),
        new Dish("Ice cream", 30, "Dessert", "Ice cream with chocolate sauce")
    };

    static DishCourse ItalianStyles = new DishCourse("American Style", dishes1[2], dishes1[1], dishes1[3]);

    static Dish[] dishes2 = {
        new Dish("Burger", 120, "Main course", "Burger with beef and cheese"),
        new Dish("Fries", 40, "Appetizer", "Fries with ketchup"),
        new Dish("Cake", 60, "Dessert", "Cake with cream and strawberries"),
        new Dish("Pizza", 100, "Main course", "Pizza with cheese and tomato"),
    };

    static DishCourse AmericanStyle = new DishCourse("American Style", dishes2[1], dishes2[0], dishes2[2]);

    public static void main(String[] args) {

        Menu menu1 = new Menu(dishes1, "Menu 1");
        Menu menu2 = new Menu(dishes2, "Menu 2");
        
        menu1.addDishCourse(ItalianStyles);
        menu2.addDishCourse(AmericanStyle);

        MenuRegister menuRegister = new MenuRegister(new Menu[] {menu1, menu2});

        UserInterface userInterface = new UserInterface(menuRegister);

        while (true) {
            userInterface.getOption();
        }

    }
    
}

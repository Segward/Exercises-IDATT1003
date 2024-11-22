
import java.util.Scanner;

public class UserInterface {

    MenuRegister menuRegister;
    Scanner scanner;

    public UserInterface(MenuRegister menuRegister) {
        this.menuRegister = menuRegister;
        this.scanner = new Scanner(System.in);
    }

    public void getOption() {
        System.out.println("\n\n1. Register new menu");
        System.out.println("2. Add dish to menu");
        System.out.println("3. Print all menus");
        System.out.println("4. Get dish by name");
        System.out.println("5. Get dishes by type (Appetizer, Main course, Dessert)");
        System.out.println("6. Print all menus within price range");
        System.out.println("7. Create course from existing dishes");
        System.out.println("8. Exit");
        System.out.print("Enter option: ");
        
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:

                System.out.print("\nEnter menu name: ");
                String menuName0 = scanner.nextLine();
                menuRegister.createMenu(menuName0);
                System.out.println("Menu created");
                return;
            
            case 2:

                // Get menu names
                System.out.println("\nAvailable menus:");
                for (Menu menu : menuRegister.menus) {
                    System.out.println(menu.name);
                }

                // Get menu name for dish
                System.out.print("\nEnter menu name: ");
                String menuName1 = scanner.nextLine();

                // Get dish details
                System.out.print("\nEnter dish name: ");
                String name = scanner.nextLine();
                System.out.print("\nEnter dish price: ");
                int price = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("\nEnter dish type (Appetizer, Main course, Dessert): ");
                String type = scanner.nextLine();
                System.out.print("\nEnter dish description: ");
                String description = scanner.nextLine();
                Dish dish = new Dish(name, price, type, description);
                menuRegister.addDishToMenu(menuName1, dish);

                System.out.println("Dish added to menu");

                return;

            case 3:

                System.out.println("\n");
                menuRegister.printAllMenus();

                return;

            case 4:

                System.out.print("\nEnter dish name: ");
                String dishName = scanner.nextLine();

                Dish dish1 = menuRegister.getDish(dishName);
                System.out.println("\n");
                if (dish1 != null) {
                    System.out.println(dish1.toString());
                } else {
                    System.out.println("Dish not found");
                }
                
                return;

            case 5:

                System.out.print("\nEnter dish type: ");
                String dishType = scanner.nextLine();

                Dish[] dishes = menuRegister.getDishesByType(dishType);
                System.out.println("\n");
                if (dishes.length > 0) {
                    for (Dish dish2 : dishes) {
                        System.out.println(dish2.toString());
                    }
                } else {
                    System.out.println("No dishes found");
                }
                
                return;

            case 6:

                System.out.print("\nEnter minimum price: ");
                int minimum = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("\nEnter maximum price: ");
                int maximum = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Menu[] menus = menuRegister.getMenusWithinPriceRange(minimum, maximum);

                System.out.println("\n");
                if (menus.length > 0) {
                    for (Menu menu : menus) {
                        System.out.println(menu.toString());
                    }
                } else {
                    System.out.println("No menus found");
                }
                    
                return;

            case 7:
                
                // Get menu names
                System.out.println("\nAvailable menus:");
                for (Menu menu : menuRegister.menus) {
                    System.out.println(menu.name);
                }

                // Get menu name for dish
                System.out.print("\nEnter menu name: ");
                String menuName2 = scanner.nextLine();

                // Get menu from name
                Menu menu = menuRegister.getMenu(menuName2);

                if (menu == null) {
                    System.out.println("Menu not found");
                    return;
                }

                // Get name for course
                System.out.print("\nEnter course name: ");
                String courseName = scanner.nextLine();

                // Print all appetizers in menu
                System.out.println("\nAppetizers in menu:");
                for (Dish dish3 : menu.dishes) {
                    if (dish3.type.equals("Appetizer")) {
                        System.out.println(dish3.name);
                    }
                }

                // Get appetizer
                System.out.print("\nEnter appetizer name: ");
                String appetizerName = scanner.nextLine();

                // Print all main courses in menu
                System.out.println("\nMain courses in menu:");
                for (Dish dish4 : menu.dishes) {
                    if (dish4.type.equals("Main course")) {
                        System.out.println(dish4.name);
                    }
                }

                // Get main course
                System.out.print("\nEnter main course name: ");
                String mainCourseName = scanner.nextLine();

                // Print all desserts in menu
                System.out.println("\nDesserts in menu:");
                for (Dish dish5 : menu.dishes) {
                    if (dish5.type.equals("Dessert")) {
                        System.out.println(dish5.name);
                    }
                }

                // Get dessert
                System.out.print("\nEnter dessert name: ");
                String dessertName = scanner.nextLine();

                Dish appetizer = menuRegister.getDish(appetizerName);
                Dish mainCourse = menuRegister.getDish(mainCourseName);
                Dish dessert = menuRegister.getDish(dessertName);

                if (appetizer == null || mainCourse == null || dessert == null) {
                    System.out.println("Dish not found");
                    return;
                }

                Dish[] dishes1 = {appetizer, mainCourse, dessert};
                menuRegister.addDishesToMenu(menuName2, dishes1, courseName);

                return;

            case 8:
                System.out.println("\nExiting...");
                System.exit(0);

            default:
                System.out.println("\nInvalid option");
                return;
        }
    }

}

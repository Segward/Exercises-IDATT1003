
public class MenuRegister {

    Menu[] menus;

    public MenuRegister(Menu[] menus) {
        this.menus = menus;
    }

    public Menu[] getMenusWithinPriceRange(int minimum, int maximum) {
        // Count number of menus within the price range
        int count = 0;
        for (Menu menu : menus) {
            if (menu.getMenuPrice() >= minimum && menu.getMenuPrice() <= maximum) {
                count++;
            }
        }

        // Create a new array with the size of the count
        Menu[] newMenus = new Menu[count];
        int index = 0;
        for (Menu menu : menus) {
            if (menu.getMenuPrice() >= minimum && menu.getMenuPrice() <= maximum) {
                newMenus[index] = menu;
                index++;
            }
        }
        return newMenus;
    }

    public void printAllMenus() {
        for (Menu menu : menus) {
            System.out.println(menu.toString());
        }
    }

    public Menu getMenu(String name) {
        for (Menu menu : menus) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public Dish getDish(String name) {
        for (Menu menu : menus) {
            Dish dish = menu.getDish(name);
            if (dish != null) {
                return dish;
            }
        }
        return null;
    }

    public Dish[] getDishesByType(String type) {
        // Count number of dishes with the given type
        int count = 0;
        for (Menu menu : menus) {
            count += menu.getDishsByType(type).length;
        }

        // Create a new array with the size of the count
        Dish[] newDishes = new Dish[count];
        int index = 0;
        for (Menu menu : menus) {
            Dish[] dishes = menu.getDishsByType(type);
            for (Dish dish : dishes) {
                newDishes[index] = dish;
                index++;
            }
        }
        return newDishes;
    }

    public void createMenu(String name) {
        Menu[] newMenus = new Menu[menus.length + 1];
        System.arraycopy(menus, 0, newMenus, 0, menus.length);
        newMenus[menus.length] = new Menu(new Dish[0], name);
        menus = newMenus;
    }
    
    public void addDishToMenu(String menuName, Dish dish) {
        for (Menu menu : menus) {
            if (menu.name.equals(menuName)) {
                menu.addDish(dish);
            }
        }
    }

    public void addDishesToMenu(String menuName, Dish[] dishes, String courseName) {
        for (Menu menu : menus) {
            if (menu.name.equals(menuName)) {
                DishCourse dishCourse = new DishCourse(courseName, dishes[0], dishes[1], dishes[2]);
                menu.addDishCourse(dishCourse);
            }
        }
    }
}

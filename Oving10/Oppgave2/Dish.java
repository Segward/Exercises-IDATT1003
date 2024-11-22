public class Dish {
    String name;
    int price;
    String type;
    String description;

    public Dish(String name, int price, String type, String description) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n" + name + " " + price + "nok " + type + " \n" + description;
    }
}

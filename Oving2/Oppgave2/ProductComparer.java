
// This program compares the price to weight ratio between two products
public class ProductComparer
{
    // This class represents a product
    public static class Product {
        public double price;
        public double weight; 

        // This is the constructor of the class Product
        public Product(double price, double weight) {
            this.price = price;
            this.weight = weight;
        }

        // This function returns the price to weight ratio
        double getRatio() {
            return price / weight;
        }
    }

    // This function returns the product with lowest price to weight ratio
    public static Product getProductWithBetterRatio(Product productA, Product productB) {
        if (productA.getRatio() < productB.getRatio()) {
            return productA;
        }
        return productB;
    }

    // This is the main function
    public static void main(String[] args) 
    {
        // Compare two products and print the product with the lowest price to weight ratio
        Product productA = new Product(35.90, 0.45);
        Product productB = new Product(39.50, 0.5);
        Product productWithBetterRatio = getProductWithBetterRatio(productA, productB);
        System.out.println(String.format("The product with price of %s and weight of %skg is the better option", 
        productWithBetterRatio.price, productWithBetterRatio.weight));
    }
}


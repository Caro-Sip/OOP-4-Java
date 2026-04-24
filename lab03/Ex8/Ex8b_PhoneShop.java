package Ex8;


class Category {
    String name;
    String description;
    
    public Category() {}
    
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

class Product {
    String productId;
    String productName;
    double price;
    int stock;
    Category category;
    
    public Product() {}
    
    public Product(String productId, String productName, double price, int stock, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    public void setValues(String productId, String productName, double price, int stock, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    public void display() {
        System.out.printf("ID: %s | Name: %-15s | Price: $%.2f | Stock: %d | Category: %s%n", 
            productId, productName, price, stock, category.name);
    }
}

public class Ex8b_PhoneShop {
    public static void main(String[] args) {
        Category cat1 = new Category("Smartphone", "Mobile phones");
        Category cat2 = new Category("Accessories", "Phone accessories");
        
        Product prod1 = new Product();
        prod1.setValues("P001", "iPhone 15 Pro", 999.99, 15, cat1);
        
        Product prod2 = new Product();
        prod2.setValues("P002", "Samsung Galaxy S24", 899.99, 20, cat1);
        
        Product prod3 = new Product();
        prod3.setValues("P003", "Phone Case", 19.99, 50, cat2);
        
        Product[] products = new Product[3];
        products[0] = prod1;
        products[1] = prod2;
        products[2] = prod3;
        
        System.out.println("\n=== Phone Shop Inventory ===");
        for (Product product : products) {
            product.display();
        }
    }
}

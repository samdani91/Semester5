package Task1;

public abstract class Product {
    public String name;
    public String category;
    public double price;

    public Product(String name, String category, double price){
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product(Product product){
        if(product != null){
            this.name = product.name;
            this.category = product.category;
            this.price = product.price;
        }
    }

    public abstract Product clone();

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Product)){
            return false;
        }
        Product  product = (Product) object;
        return product.name == name &&
                product.category == category &&
                product.price == price;
    }

}

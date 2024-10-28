package Task1;

public class ClothingProduct extends Product{
    public String color;
    public String size;
    public ClothingProduct(String name, String category, double price, String color, String size){
        super(name, category, price);
        this.color = color;
        this.size = size;
    }
    public ClothingProduct(ClothingProduct clothingProduct){
        super(clothingProduct);
        if(clothingProduct != null){
            this.color = clothingProduct.color;
            this.size = clothingProduct.size;
        }
    }
    public Product clone(){
        return new ClothingProduct(this);
    }

    public boolean equals(Object object){
        if(!(object instanceof ClothingProduct) || !super.equals(object)){
            return false;
        }
        ClothingProduct clothingProduct = (ClothingProduct) object;
        return clothingProduct.color == color &&
                clothingProduct.size == size;
    }

    @Override
    public String toString(){
        return "Product name:"+this.name + "\nColor:" + this.color + "\nSize:" + this.size + "\nPrice:"+this.price;
    }
}

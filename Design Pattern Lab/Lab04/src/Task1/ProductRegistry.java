package Task1;

import java.util.HashMap;
import java.util.Map;

public class ProductRegistry {
    private Map<String, Product> registry = new HashMap<>();
    public ProductRegistry(){
        ClothingProduct shirt = new ClothingProduct("Shirt", "Cloth", 650, "White", "XL");
        ElectronicProduct smartphone1 = new ElectronicProduct("Smartphone", "Electronic Device", 25000, "8/256", "5000 mAh");
        ElectronicProduct smartphone2 = new ElectronicProduct("Smartphone", "Electronic Device", 30000, "8/256", "5000 mAh");
        registry.put("White-Shirt-XL", shirt);
        registry.put("Smartphone-25k", smartphone1);
        registry.put("Smartphone-30k", smartphone2);
    }
    public Product put(String key, Product product){
        registry.put(key, product);
        return product;
    }
    public Product get(String key){
        return registry.get(key).clone();
    }
}

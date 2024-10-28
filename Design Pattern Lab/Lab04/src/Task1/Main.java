package Task1;


public class Main {
    public static void main(String[] args) {
        ProductRegistry productRegistry = new ProductRegistry();
        Product shirt = productRegistry.get("White-Shirt-XL");
        Product smartphone1 = productRegistry.get("Smartphone-30k");
        Product smartphone2 = productRegistry.get("Smartphone-30k");

        System.out.println(shirt);
        System.out.println();
        System.out.println(smartphone1);
        System.out.println();
        System.out.println(smartphone2);
        System.out.println();

        if(smartphone1!=smartphone2){
            System.out.println("Smartphone-30k are two different objects");
            if(smartphone1.equals(smartphone2)){
                System.out.println("Identical objects");
            }else{
                System.out.println("Not identical objects");
            }
        }else{
            System.out.println("Smartphone objects are the same");
        }
    }
}
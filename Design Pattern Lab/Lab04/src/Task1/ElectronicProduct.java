package Task1;

public class ElectronicProduct extends Product{
    public String storageCapacity;
    public String batteryLife;
    public ElectronicProduct(String name, String category, double price, String storageCapacity, String batteryLife){
        super(name, category, price);
        this.storageCapacity = storageCapacity;
        this.batteryLife = batteryLife;
    }
    public ElectronicProduct(ElectronicProduct electronicProduct){
        super(electronicProduct);
        if(electronicProduct != null){
            this.storageCapacity = electronicProduct.storageCapacity;;
            this.batteryLife = electronicProduct.batteryLife;
        }
    }
    public Product clone(){
        return new ElectronicProduct(this);
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof ElectronicProduct) || !super.equals(object)){
            return false;
        }
        ElectronicProduct electronicProduct = (ElectronicProduct) object;
        return electronicProduct.storageCapacity == storageCapacity &&
                electronicProduct.batteryLife == batteryLife;
    }

    @Override
    public String toString(){
        return "Product name:"+this.name + "\nPrice:" + this.price;
    }
}

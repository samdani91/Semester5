package task2;

public class ModernFurnitureFactory implements FurnitureFactory {
    private static FurnitureFactory instance;

    private int id;

    public ModernFurnitureFactory(int id){
        this.id=id;
    }


    public static FurnitureFactory getInstance(int id) {
        FurnitureFactory res = instance;
        if(res!=null) return res;

        synchronized (FurnitureFactory.class){
            if(instance==null) instance = new ModernFurnitureFactory(id);
            return instance;
        }
    }

    @Override
    public Chair createChair(int id) {
        return new ModernChair(this.id);
    }

    @Override
    public Table createTable(int id) {
        return new ModernTable(this.id);
    }

    @Override
    public Sofa createSofa(int id) {
        return new ModernSofa(this.id);
    }

}


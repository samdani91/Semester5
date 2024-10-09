package task2;

public class RusticFurnitureFactory implements FurnitureFactory {
    private static RusticFurnitureFactory instance;


    private int id;

    public RusticFurnitureFactory(int id){
        this.id=id;
    }

    public static FurnitureFactory getInstance(int id) {
        FurnitureFactory res = instance;
        if(res!=null) return res;

        synchronized (FurnitureFactory.class){
            if(instance==null) instance = new RusticFurnitureFactory(id);
            return instance;
        }
    }

    @Override
    public Chair createChair(int id) {
        return new RusticChair(this.id);
    }

    @Override
    public Table createTable(int id) {
        return new RusticTable(this.id);
    }

    @Override
    public Sofa createSofa(int id) {
        return new RusticSofa(this.id);
    }
}


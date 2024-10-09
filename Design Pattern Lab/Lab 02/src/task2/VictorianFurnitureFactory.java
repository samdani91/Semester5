package task2;

public class VictorianFurnitureFactory implements FurnitureFactory {
    private static VictorianFurnitureFactory instance;
    private int id;

    public VictorianFurnitureFactory(int id){
        this.id=id;
    }

    public static FurnitureFactory getInstance(int id) {
        FurnitureFactory res = instance;
        if(res!=null) return res;

        synchronized (FurnitureFactory.class){
            if(instance==null) instance = new VictorianFurnitureFactory(id);
            return instance;
        }
    }

    @Override
    public Chair createChair(int id) {
        return new VictorianChair(this.id);
    }

    @Override
    public Table createTable(int id) {
        return new VictorianTable(this.id);
    }

    @Override
    public Sofa createSofa(int id) {
        return new VictorianSofa(this.id);
    }

}


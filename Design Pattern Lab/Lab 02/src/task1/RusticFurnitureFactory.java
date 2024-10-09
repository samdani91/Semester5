package task1;

public class RusticFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new RusticChair();
    }

    @Override
    public Table createTable() {
        return new RusticTable();
    }

    @Override
    public Sofa createSofa() {
        return new RusticSofa();
    }
}

package task2;

public class VictorianSofa implements Sofa {
    private int id;

    public VictorianSofa(int id) {
        this.id = id;
    }

    @Override
    public void lieOn() {
        System.out.println("Lies on Victorian Sofa with id:"+id);
    }

    @Override
    public int getId() {
        return id;
    }
}

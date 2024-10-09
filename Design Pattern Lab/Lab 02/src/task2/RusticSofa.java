package task2;

public class RusticSofa implements Sofa {
    private int id;

    public RusticSofa(int id) {
        this.id = id;
    }

    @Override
    public void lieOn() {
        System.out.println("Lies on Rustic Sofa with id:"+id);
    }

    @Override
    public int getId() {
        return id;
    }
}

package task2;

public class ModernSofa implements Sofa {
    int id;

    public ModernSofa(int id) {
        this.id = id;
    }

    @Override
    public void lieOn() {
        System.out.println("Lies on Modern Sofa with ID:"+id);
    }

    @Override
    public int getId() {
        return id;
    }
}

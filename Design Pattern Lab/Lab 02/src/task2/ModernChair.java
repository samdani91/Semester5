package task2;

public class ModernChair extends Chair {

    public ModernChair(int id) {
        this.setId(id);
    }

    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair... ");
    }
}

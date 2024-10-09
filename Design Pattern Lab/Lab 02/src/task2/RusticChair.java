package task2;

public class RusticChair extends Chair {

    public RusticChair(int id) {
        this.setId(id);
    }

    @Override
    public void sitOn() {
        System.out.println("Sitting on a rustic chair...");
    }
}

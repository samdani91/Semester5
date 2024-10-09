package task2;

public class VictorianChair extends Chair {

    public VictorianChair(int id) {
        this.setId(id);
    }

    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair..." );
    }

}

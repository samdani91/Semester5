package task2;

public class VictorianTable extends Table {

    public VictorianTable(int id) {
        this.setId(id);
    }

    @Override
    public void use() {
        System.out.println("Using Victorian Table...");
    }

}

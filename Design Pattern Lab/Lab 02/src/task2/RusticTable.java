package task2;

public class RusticTable extends Table {

    public RusticTable(int id) {
        this.setId(id);
    }

    @Override
    public void use() {
        System.out.println("Using Rustic Table...");
    }


}

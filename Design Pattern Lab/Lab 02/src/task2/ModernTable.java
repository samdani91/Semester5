package task2;

public class ModernTable extends Table {

    public ModernTable(int id) {
        this.setId(id);
    }

    @Override
    public void use() {
        System.out.println("Using Modern Table...");
    }

}

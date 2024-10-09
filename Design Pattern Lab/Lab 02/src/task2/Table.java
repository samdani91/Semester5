package task2;

public abstract class Table {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void use();

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                '}';
    }
}

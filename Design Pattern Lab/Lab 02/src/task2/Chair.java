package task2;

public abstract class Chair {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void sitOn();

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                '}';
    }
}

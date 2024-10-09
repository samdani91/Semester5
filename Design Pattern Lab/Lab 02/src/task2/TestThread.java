package task2;

public class TestThread extends Thread{
    private int id;
    public TestThread(int id){
        this.id=id;
    }
    public void run(){
        try{
            FurnitureFactory factory = ModernFurnitureFactory.getInstance(id);
            System.out.println(factory.createChair(id));
//            System.out.println(new ModernFurnitureFactory(id).createChair(id));
        }catch (Exception e){
            System.out.println(e);
        }
    }


}

package task1;

import java.util.Scanner;

public class Client {
    private Chair chair;
    private Table table;
    private Sofa sofa;

    public Client(FurnitureFactory factory) {
        chair = factory.createChair();
        table = factory.createTable();
        sofa = factory.createSofa();
    }

    public void useFurniture() {
        chair.sitOn();
        table.use();
        sofa.lieOn();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String typeOfFurniture;
        System.out.print("Enter Type of furniture:");
        typeOfFurniture = sc.nextLine();

        FurnitureFactory myFurniture;

        if(typeOfFurniture.equalsIgnoreCase("Modern")){
            myFurniture=new ModernFurnitureFactory();
        }else if(typeOfFurniture.equalsIgnoreCase("Victorian")){
            myFurniture=new VictorianFurnitureFactory();
        }else if(typeOfFurniture.equalsIgnoreCase("Rustic")){
            myFurniture=new RusticFurnitureFactory();
        }else{
            System.out.println("Wrong Choice");
            return;
        }

        Client modernClient = new Client(myFurniture);
        modernClient.useFurniture();

    }
}

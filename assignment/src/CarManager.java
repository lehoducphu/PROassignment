
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//test commit
public class CarManager {

    public static void main(String[] args) {
        
        //test commit lên github
        //danh sách các tùy chọn trong menu trong menu
        ArrayList<String> ops = new ArrayList();
        ops.add("List all brand");
        ops.add("Add a new brand");
        ops.add("Search a brand based");
        ops.add("Update a brand");
        ops.add("Save brands to the file");
        ops.add("List all cars in ascending order of brand names");
        ops.add("List cars based on a part of an input brand name");
        ops.add("Add a car");
        ops.add("Remove a car");
        ops.add("Update a car based on its ID");
        ops.add("Save cars to file");
        ops.add("exit");

        BrandList bList = new BrandList();
        CarList cList = new CarList(bList);
        
        bList.loadFromFile("brands.txt");//load danh sách brand từ file brands
        cList.loadFromFile("cars.txt");//load danh sách brand từ file brands
        int choice = 0;
        int stop = 0;
        do {
            System.out.println("List of functions:\n");
            choice = Menu.int_getChoice(ops);//in ra danh sách các chức năng, 
            //người dùng nhập số đứng trước chức năng để chọn chức năng.
            switch (choice) {
                case 1:
                    BrandList.listBrands();
                    pressAnyKeyToContinue();
                     break;
                case 2: 
                    BrandList.addBrand();
                    pressAnyKeyToContinue();
                     break;
                case 3:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter id that you want to find ");
                    String bID = sc.nextLine();
                    BrandList.searchID(bID);
                    pressAnyKeyToContinue();
                    break;
                case 4:
                    //Update a brand
                    BrandList.updateBrand();
                    pressAnyKeyToContinue();
                    break;
                case 5:
                    //Save brands to the file
                    BrandList.saveToFile("brands.txt");
                    pressAnyKeyToContinue();
                    break;
                case 6:
                    //List all cars in ascending order of brand names
                    cList.listCars();
                    pressAnyKeyToContinue();
                    break;
               case 7:
                    // List cars a part of brandID
                    cList.ListCarOfBrandName();
                    pressAnyKeyToContinue();
                    break;
                case 8:
                    //Add a car
                    cList.addCar(); 
                    
                    if(cList.saveToFile("cars.txt")){
                        System.out.println(" Add car successful");
                    }
                    pressAnyKeyToContinue();
                    break;
                case 9:
                    //Remove a car

                    if (cList.removeCar()) {
                        cList.saveToFile("cars.txt");
                        System.out.println("Remove successfully.");
                        pressAnyKeyToContinue();
                    }
                    pressAnyKeyToContinue();
                    break;
                case 10:
                    //Update a car based on its ID
                    cList.updateCar();
                    pressAnyKeyToContinue();
                    break;
                case 11:
                    //Save cars to file
                    boolean check = cList.saveToFile("cars.txt");
                    if(check == true){
                                System.out.println("Save to file successfully!");
                    }
                    pressAnyKeyToContinue();

                    break;
                case 12:
                    stop = 1;
                    System.out.println("Have a nice day!");
                    break;
                default:

            }

        } while (stop == 0);//bắt nhập lại nếu nhập số nhỏ hơn 1 và vượt quá số lựa chọn
    }

    public static void pressAnyKeyToContinue() {
        //nhập phím bất kì để tiếp tục.
        System.out.print("Press Enter key to continue\n");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}

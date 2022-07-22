
import java.io.IOException;
import java.util.ArrayList;

public class CarManager {

    public static void main(String[] args) {

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
        Object choi = Menu.ref_getChoice(ops);//tạo menu chọn chức năng
        do {
            System.out.println("List of functions:\n");
            choice = Menu.int_getChoice(ops);//in ra danh sách các chức năng, 
            //người dùng nhập số đứng trước chức năng để chọn chức năng.
            switch (choice) {
                case 1:
                    //List all brand
                    break;
                case 2:
                    //Add a new brand
                    break;
                case 3:
                    //Search a brand based
                    break;
                case 4:
                    //Update a brand
                    break;
                case 5:
                    //Save brands to the file
                    break;
                case 6:
                    //List all cars in ascending order of brand names
                    break;
                case 7:
                    //List cars based on a part of an input brand name
                    break;
                case 8:
                    //Add a car
                    break;
                case 9:
                    //Remove a car
                    break;
                case 10:
                    //Update a car based on its ID
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
        System.out.print("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}

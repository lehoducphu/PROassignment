
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

        do {
            System.out.println("List of functions:\n");
            choice = Menu.int_getChoice(ops);//in ra danh sách các chức năng, 
            //người dùng nhập số đứng trước chức năng để chọn chức năng.
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    stop = 1;
                    System.out.println("Have a nice day!");
                    break;
                default:

            }
            pressAnyKeyToContinue();

        } while (stop == 0);//bắt nhập lại nếu nhập số nhỏ hơn 1 và vượt quá số lựa chọn
    }

    public static void pressAnyKeyToContinue() {
        System.out.print("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}

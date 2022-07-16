/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.*;

/**
 *
 * @author LENOVO
 */
public class CarList {

    ArrayList<Brand> bList = new ArrayList<>();
    static ArrayList<Car> cList = new ArrayList<>();

    public CarList(ArrayList<Car> cList, BrandList bList) {
        this.cList = cList;
        this.bList = bList.brandList;

    }

    public boolean loadFromFile(String str) {
        return true;
    }

    public boolean saveToFile(String str) {
        return true;
    }

    public int searchID(String carID) {
        int N = cList.size();
        for (int i = 0; i < N; i++) {
            String str = cList.get(i).getCarID();
            if (carID.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        return 0;
    }

    public int searchEngine(String eID) {
        return 0;
    }

    public void addCar() {

    }

    public void printBasedBrandName() {

    }

    public boolean removeCar() {
        return true;
    }

    public boolean updateCar() {
        //cập nhật 1 phần tử trong arrayList cList
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CarID: ");
        String updatedID = sc.next();
        int pos = searchID(updatedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            Brand b = (Brand) Menu.ref_getChoice(bList);
            String color = inputColor();

            System.out.print("Enter Frame ID: ");
            String FrameID = inputStr("FrameID", 'F', true, true);

            System.out.print("Enter Engine ID: ");
            String EngineID = inputStr("EngineID", 'E', true, true);

            Car c = new Car(cList.get(pos).getCarID(), b, color, FrameID, EngineID);
            cList.set(pos, c);
        }
        return true;
    }

    public void listCars() {
        //sắp xếp cList theo chiều tăng dần của BrandName
        Collections.sort(cList);
        int N = cList.size();
        for(int i = 0; i< N;i++){
            Car c = cList.get(i);
            System.out.println(c.screenString());
        }
    }

    public static String inputColor() {
        //chọn màu cho Car
        ArrayList<String> colorList = new ArrayList<>();
        colorList.add("Red");
        colorList.add("Orange");
        colorList.add("Yellow");
        colorList.add("Green");
        colorList.add("Blue");
        colorList.add("Purple");
        colorList.add("Pink");
        colorList.add("Brown");
        colorList.add("Gray");
        colorList.add("Black");
        colorList.add("White");
        String chosen = (String) Menu.ref_getChoice(colorList);

        return chosen;
    }

    public static String inputStr(String ID) {

        //method nhập ID kiểm tra độ dài
        //ID dùng để chọn FrameID hoặc EngineID để nhập
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (true) {
            if (input.length() == 6) {
                break;
            } else if (ID.equals("FrameID")) {
                System.err.println("You've enter a string with length: " + input.length());
                System.err.print("Please enter the Frame ID again: ");
                input = sc.nextLine();
            } else {
                System.err.println("You've enter a string with length: " + input.length());
                System.err.print("Please enter the Engine ID again: ");
                input = sc.nextLine();
            }
        }
        return input;
    }

    public static boolean firstChar(String input, char c) {
        //kiểm tra kí tự đầu
        if (input.charAt(0) == c) {
            return true;
        }
        return false;
    }

    public static boolean isIncludeDigits(String input) {
        //check 5 kí tự sau kí tự đầu có phải số ko
        
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean notDuplicate_FEID(String ID, String input) {

        //chỉ sử dụng để check trùng FrameID và EngineID
        //trả về true thì không trùng, trả về false thì trùng
        //ID dùng để chọn FrameID hoặc EngineID để kiểm tra trùng
        //input là chuỗi để kiểm tra trùng
        
        int check = 0;
        if (ID.equals("FrameID")) {

            for (int i = 0; i < cList.size(); i++) {
                if (cList.get(i).getFrameID().equals(input)) {
                    check = 1;
                }
            }
            if (check == 0) {
                return true;
            } else {
                return false;
            }
        } else {
                for (int i = 0; i < cList.size(); i++) {
                    if (cList.get(i).getEngineID().equals(input)) {
                        check = 1;
                    }
                }
                if (check == 0) {
                    return true;
                } else {
                    return false;
                }

            }

        }
    
    public static String inputStr(String ID, char c) {
        String result = inputStr(ID);
        if (ID.equals("FrameID")) {
            while (true) {
                if (firstChar(result, c)) {
                    break;
                } else {
                    System.err.println("You have entered wrong string. Reason: First character of ID must be F.");
                    System.err.print("Please enter the Frame ID again: ");
                    result = inputStr(ID);
                }
            }
        } else {
            while (true) {
                if (firstChar(result, c)) {
                    break;
                } else {
                    System.err.println("You have entered wrong string. Reason: First character of ID must be E.");
                    System.err.print("Please enter the Engine ID again: ");
                    result = inputStr(ID);
                }
            }
        }
        return result;
    }

    public static String inputStr(String ID, char c, boolean isIncludeDigits) {
        String result = inputStr(ID, c);
        while (true) {
            if (isIncludeDigits(result) == isIncludeDigits) {
                break;
            } else if (ID.equals("FrameID")) {
                System.err.println("You have entered wrong string. Reason: String must be digits only");
                System.err.print("Please enter the Frame ID again: ");
                result = inputStr(ID);
            } else {
                System.err.println("You have entered wrong string. Reason: String must be digits only");
                System.err.print("Please enter the Engine ID again: ");
                result = inputStr(ID);
            }
        }
        return result;
    }

    public static String inputStr(String ID, char c, boolean isIncludeDigits, boolean notDuplicate) {
        String result = inputStr(ID, c, isIncludeDigits);
        while (true) {
            if (notDuplicate_FEID(ID, result) == notDuplicate) {
                break;
            } else if (ID.equals("FrameID")) {
                System.err.println("The ID you just entered has been duplicated.");
                System.err.print("Please enter the Frame ID again: ");
                result = inputStr(ID);
            } else {
                System.err.println("The ID you just entered has been duplicated.");
                System.err.print("Please enter the Engine ID again: ");
                result = inputStr(ID);
            }
        }
        return result;
    }

}

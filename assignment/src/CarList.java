/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.xml.internal.ws.util.StreamUtils;
import java.io.*;

import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class CarList {

    static ArrayList<Brand> bList = new ArrayList();
    static ArrayList<Car> cList = new ArrayList();
    String[] strs;

    public CarList(BrandList bList) {
        this.bList = bList.arrBrand;

    }

    public static boolean loadFromFile(String loadFName) {//lấy thông tin từ file
        File f = new File(loadFName);
        if (f != null) {//kiểm tra file có trống ko
            try {
                FileReader fr = new FileReader(loadFName);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();//đọc từng dòng trong file 
                    if (line == null) {
                        break;
                    }
                    String[] st = line.split("[,\\:]");
                    String carID = st[0].trim();
                    String brand = st[1].trim();
                    String color = st[2].trim();
                    String frameID = st[3].trim();
                    String engineID = st[4].trim();
                    int pos = BrandList.searchID(brand);
                    Brand b = bList.get(pos);
                    Car obj = new Car(carID, b, color, frameID, engineID);
                    cList.add(obj);
                }
                fr.close();

            } catch (Exception e) {
            }
            return true;

        } else {
            return false;
        }
    }

    public boolean saveToFile(String saveFName) {//lưu thông tin vào file

        try {
            FileWriter fw = new FileWriter(saveFName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < cList.size(); i++) {
                bw.write(cList.get(i).toString());
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(CarList.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static int searchID(String carID) {
        //tìm carID trong cList
        int N = cList.size();
        for (int i = 0; i < N; i++) {
            String str = cList.get(i).getCarID();
            if (carID.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static int searchFrame(String fID) {
        int N = cList.size();
        for(int i =0; i< N;i++){
            if(cList.get(i).getFrameID().equals(fID) ){
                return i;
            }
        }
        return -1;
    }

    public static int searchEngine(String eID) {
        int N = cList.size();
        for(int i =0; i< N;i++){
            if(cList.get(i).getEngineID().equals(eID) ){
                return i;
            }
        }
        return -1;
    }

    public void addCar() {
// vu minh dang        
// Thêm một car 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CarID: ");
        String carID = inputCar("Car", 'C');

        System.out.println("Enter BrandID");
        Brand b = (Brand) Menu.ref_getChoice(bList);
        String color = inputColor();

        System.out.print("Enter Frame ID: ");
        String FrameID = inputStr("FrameID", 'F', true, true);

        System.out.print("Enter Engine ID: ");
        String EngineID = inputStr("EngineID", 'E', true, true);

        Car newCar = new Car(carID, b, color, FrameID, EngineID);
        cList.add(newCar);
        System.out.println("ADD: " + carID + "," + b + "," + color + "," + FrameID + "," + EngineID);

    }

    public boolean removeCar() {
        // vu minh dang
        // xóa một car theo ID
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID remove");

        String updatedID = sc.nextLine();
        int pos = searchID(updatedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            cList.remove(pos);
        }

        return true;
    }

    public void ListCarOfBrandName() {
        // vu minh dang 
        // hiện thị car theo tìm kiếm theo một phần của brand name ex: BMW 730Li 
        // input: 730Li
        // output: all the same input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a part of an input brand name ");
        String input = sc.nextLine().toUpperCase();

        boolean flag = true;
        // dùng flag để đặt vào điều ko tìm thấy brandName nếu ko có brand name
        // nào được tìm thấy thì flag bằng false rồi if in ra "no result" 
        for (int i = 0; i < bList.size(); i++) {
            String brandName = bList.get(i).getBrandName().toUpperCase();
            String[] words = brandName.split("\\s+");
            if (words[1].equals(input)) {
                System.out.println(bList.get(i));

            }
            if (words[1] == null ? input != null : !words[1].equals(input)) {
                flag = false;
            }
        }

        if (flag == false) {
            System.out.println("NO result");
        }

    }

    public static String checkLengCarID(String ID) {
        //method nhập ID CAR kiểm tra độ dài " C00 "
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (true) {
            if (input.length() == 3) {
                break;
            } else {
                System.err.println("You've enter a string with length: " + input.length());
                System.err.print("Please enter the Car ID again: ");
                input = sc.nextLine();
            }
        }
        return input;
    }

    public static String inputCar(String ID, char c) {
        // vu minhd dang
        String result = checkLengCarID(ID);
        if (ID.equals("Car")) {
            while (true) {
                if (firstChar(result, c)) {
                    break;
                } else {
                    System.err.println("You have entered wrong string. Reason: First character of ID must be 'C' uppercasse");
                    System.err.print("Please enter the Car ID again: ");
                    result = inputStr(ID);
                }
            }
        }
        return result;

    }

    public boolean updateCar() {
        
        //cập nhật 1 phần tử trong arrayList cList
        
        System.out.println("List of cars:\n");
        int pos = Menu.int_getChoice(cList);
            Brand b = (Brand) Menu.ref_getChoice(bList);//chọn Brand
            String color = inputColor();//chọn color

            System.out.print("Enter Frame ID: ");
            String FrameID = inputStr("FrameID", 'F', true, true);//nhập và kiểm tra FrameID

            System.out.print("Enter Engine ID: ");
            String EngineID = inputStr("EngineID", 'E', true, true);//nhập và kiểm tra EngineID

            Car c = new Car(cList.get(pos).getCarID(), b, color, FrameID, EngineID);//khởi tạo đối tượng vừa nhập
            cList.set(pos, c);
        
        return true;
    }

    public static void listCars() {
        //sắp xếp cList theo chiều tăng dần của BrandName
        
        Collections.sort(cList);
        int N = cList.size();
        for (int i = 0; i < N; i++) {
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
        if (ID.equals("Car")) {
            if(searchID(input)!=-1){
                return false;
            }else{
                return true;
            }
        }

        if (ID.equals("FrameID")) {
            if(searchFrame(input)!=-1){
                return false;
            }else{
                return true;
            }
            
        } else {
            if(searchEngine(input)!=-1){
                return false;
            }else{
                return true;
            }

        }

    
    }
    public static String inputStr(String ID, char c) {
        //method nhập ID kiểm tra độ dài, kiểm tra kí tự đầu ID
        //char c phụ thuộc vào FrameID (c = 'F') và EngineID (c= 'E')
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
        //method nhập ID kiểm tra độ dài, kiểm tra kí tự đầu ID, kiểm tra 5 kí tự sau kí tự đầu có phải số ko
        String result = inputStr(ID, c);
        while (true) {
            if (isIncludeDigits(result) == isIncludeDigits) {
                break;
            } else if (ID.equals("FrameID")) { //nếu nhập FrameID
                System.err.println("You have entered wrong string. Reason: String must be digits only");
                System.err.print("Please enter the Frame ID again: ");
                result = inputStr(ID, c);
            } else {
                System.err.println("You have entered wrong string. Reason: String must be digits only");
                System.err.print("Please enter the Engine ID again: ");
                result = inputStr(ID, c);
            }
        }
        return result;
    }

    public static String inputStr(String ID, char c, boolean isIncludeDigits, boolean notDuplicate) {
        //method nhập ID kiểm tra độ dài, kiểm tra kí tự đầu ID, kiểm tra 5 kí tự sau kí tự đầu có phải số ko, kiểm có trùng FrameID,EngineID trong list ko
        String result = inputStr(ID, c, isIncludeDigits); //lấy String từ method kiểm tra kí tự đầu và digit
        while (true) {
            if (notDuplicate_FEID(ID, result) == notDuplicate) {
                break;
            } else if (ID.equals("FrameID")) {
                System.err.println("The ID you just entered has been duplicated.");
                System.err.print("Please enter the Frame ID again: ");
                result = inputStr(ID, c, isIncludeDigits);
            } else {
                System.err.println("The ID you just entered has been duplicated.");
                System.err.print("Please enter the Engine ID again: ");
                result = inputStr(ID, c, isIncludeDigits);
            }
        }
        return result;
    }

}

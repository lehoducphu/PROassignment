
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BrandList extends Brand {

    static ArrayList<Brand> arrBrand = new ArrayList();

    public BrandList() {
        super();
    }

    public static boolean loadFromFile(String loadFName) {
        File f = new File(loadFName);
        if (f != null) {
            try {
                FileReader fr = new FileReader(loadFName);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] st = line.split("[,\\:]");
                    String brandId = st[0].trim();
                    String brandName = st[1].trim();
                    String soundBrand = st[2].trim();
                    double price = Double.parseDouble(st[3]);
                    Brand obj = new Brand(brandId, brandName, soundBrand, price);
                    arrBrand.add(obj);
                }
                fr.close();
            } catch (Exception e) {
            }
            return true;

        } else {
            return false;
        }
    }
//    
//    

    public static boolean saveToFile(String saveFName) {
        //đọc dữ liệu từ savaFName bằng loadFromFile

        ArrayList<Brand> arr = arrBrand;
        try {
            FileWriter fw = new FileWriter(saveFName);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = "";
            while (true) {
                for (int i = 0; i < arr.size(); i++) {
                    bw.write(arr.get(i).toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();

            }
        } catch (Exception e) {
        }
        return true;
    }

//    
//    
    public static int searchID(String bID) {
        for (int i = 0; i < arrBrand.size(); i++) {
            if (arrBrand.get(i).getBrandId().equals(bID)) {
                return i;
            }
        }
        return -1;
    }

    public static void addBrand() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string ");
//        String brandId = MyLib.brandId();
        System.out.println("Enter brandName");
        String brandName = MyLib.brandName();
        System.out.println("Enter soundBrand");
        String soundBrand = sc.nextLine();
        double price = Double.parseDouble(sc.nextLine());
//        Brand obj = new Brand(brandId, brandName, soundBrand, price);
//        arrBrand().add(obj);
        try {
            FileWriter fw = new FileWriter("data1.txt", true);
            BufferedWriter br = new BufferedWriter(fw);
            for (Brand brand : arrBrand) {
                fw.write(brand.toString());
                br.newLine();
            }

            fw.close();

        } catch (Exception e) {
        }

        for (Brand brand : arrBrand) {
            System.out.println(brand);
        }
    }

    public static boolean notDuplicate_brandID(String input) {

        //trả về true thì không trùng, trả về false thì trùng
        //input là chuỗi để kiểm tra trùng
        int check = 0;

        for (int i = 0; i < arrBrand.size(); i++) {
            if (arrBrand.get(i).getBrandId().equals(input)) {
                check = 1;
            }
        }
        if (check == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void updateBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the brand ID: ");
        String brandID = sc.nextLine();
        int Pos = searchID(brandID);
        if (Pos < 0) {
            System.out.println("Not found!");
        } else {
            System.out.print("Enter new brandName: ");
            String brandName = sc.nextLine();
            arrBrand.get(Pos).setBrandName(brandName.trim());
            System.out.print("Enter new soundBrand: ");
            String soundBrand = sc.nextLine();
            arrBrand.get(Pos).setSoundBrand(soundBrand.trim());
            System.out.print("Enter new price: ");
            double price;
            do {
                price = sc.nextDouble();
                if (price <= 0) {
                    System.out.println("Invalid price!");
                }
            } while (price <= 0);
            arrBrand.get(Pos).setPrice(price);
            System.out.println("Updated succesfully!");
        }

    }

    public static void listBrands() {

        ArrayList<Brand> arr = arrBrand;
        for (Brand brand : arr) {
            System.out.println(brand);

        }

    }

}

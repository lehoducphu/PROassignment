
public class CarManager {

    public static void main(String[] args) {
        BrandList bList = new BrandList();
        CarList cList = new CarList(bList);
//        int i = s1.searchID("B7-MS");
//        System.out.println(i);
//        s1.addBrand();
//        s1.listBrands();
//        s1.updateBrand();
//        s1.listBrands();
//        System.out.println(s1.loadFromFile());
//        System.out.println(s1.saveToFile("brands.txt"));
//        s1.listBrands();

boolean h = cList.loadFromFile("cars.txt");

cList.listCars();
boolean cc = cList.updateCar();
    }

}


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
        System.out.println(bList.loadFromFile("brands.txt"));
//        bList.listBrands();
        System.out.println(cList.loadFromFile("cars.txt"));
//        cList.showCarList();
//        cList.listCars();
//        System.out.println(cList.saveToFile("cars.txt"));
    }

}

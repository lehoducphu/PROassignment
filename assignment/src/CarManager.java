
public class CarManager {

    public static void main(String[] args) {
        BrandList s1 = new BrandList();
//        int i = s1.searchID("B7-MS");
//        System.out.println(i);
//        s1.addBrand();
        s1.listBrands();
        s1.updateBrand();
//        s1.listBrands();
//        System.out.println(s1.loadFromFile());
        System.out.println(s1.saveToFile());
        s1.listBrands();
    }

}

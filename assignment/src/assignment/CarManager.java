/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.lang.*;
import java.util.*;
/**
 *
 * @author LENOVO
 */
public class CarManager {

    public static void main(String[] args) {
        
        //ArrayList dùng tạm thời để test chức năng
        Brand br1 = new Brand();
        Brand br2 = new Brand("B7-MS", "BMW 730Li M Sport", "Harman Kardon", 4.319);
        Brand br3 = new Brand("B7-MS20", "BMW 730Li M Sport (2020)", "Harman Kardon", 4.369);
        ArrayList listbr = new ArrayList();
        listbr.add(br1);
        listbr.add(br2);
        listbr.add(br3);
        Car c1 = new Car("C01",br1 , "red", "F12345", "E12345");
        Car c2 = new Car("C02",br1 , "black", "F12346", "E12346");
        Car c3 = new Car("C03",br2 , "orange", "F12347", "E12347");
        Car c4 = new Car("C04",br3 , "white", "F12348", "E12348");
        ArrayList listc = new ArrayList();
        listc.add(c1);
        listc.add(c2);
        listc.add(c3);
        listc.add(c4);
                System.out.println("Before: \n"+ listc);

        BrandList bList = new BrandList(listbr);
        CarList cList = new CarList(listc,bList);
        cList.updateCar();
        System.out.println("After: \n"+ listc);
        
    }
    
}

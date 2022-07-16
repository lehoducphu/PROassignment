/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author LENOVO
 */
import java.io.*;
import java.util.*;

public class BrandList {
                ArrayList <Brand> brandList = new ArrayList();
    public BrandList(ArrayList <Brand> brandList){
        this.brandList = brandList; 
    }
    public boolean loadFromFile(String str){
        File f = new File("brands.txt");
        if (f != null) {
            try {
                FileReader fr = new FileReader("brands.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] st = line.split("[,\\:]");
                    String brandId = st[0];
                    String brandName = st[1];
                    String soundBrand = st[2];
                    double price = Double.parseDouble(st[3]);
                    Brand obj = new Brand(brandId, brandName, soundBrand, price);
                    brandList.add(obj);
                }
                fr.close();
            } catch (Exception e) {
            }
            return true;

        } else {
            return false;
        }
        return true;
    }
    public boolean saveToFile(String str){
        return true;
    }
    public int searchID(String ID){
        int N = brandList.size();
        for(int i = 0; i<N;i++){
            if(brandList.get(i).getBrandID() == ID){
                return i;
            }            
        }
            return -1;
    }
    public Brand getUserChoice(){
        Menu mnu = new Menu();
        return (Brand)mnu.ref_getChoice(this.brandList);
    }
    public void addBrand(){
        
    }
  
    public boolean updateBrand(){
        return true;
    }
    public void listBrands(){
        
    }
   
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hello VIỆT
 */
public class quanLyMayBay {
     static Scanner sc = new Scanner(System.in);
    static void showMenu(){
        System.out.println("1: Nhap thong tin N chuyen bay");
        System.out.println("2: Luu thong tin ");
        System.out.println("3: Doc thong tin tu file va hien thi");
        System.out.println("4: Sap xep theo gia");
        System.out.println("5: In thong tin theo gia");
        System.out.println("choose");
    }
    
    static void input(List<VeMayBay> list) {
        System.out.println("nhap so ve may bay");
        int n = sc.nextInt();
        
        for(int i = 0; i < n ;i++) {
            VeMayBay veMayBay = new VeMayBay();
            veMayBay.input();
            
            list.add(veMayBay);
        }
    }
    
    static void sort(List<VeMayBay> list) {
        Collections.sort(list, (VeMayBay o1, VeMayBay o2) -> {
            if(o1.getPrice() < o2.getPrice() ){
                return -1;
            }
            return 1;           
        });
        
        for(int i = 0;i < list.size();i++) {
            list.get(i).display();
        }
    }
    
    static void save(List<VeMayBay> list,String filename) throws Exception {
        FileOutputStream out = null ;
        ObjectOutputStream os = null   ;
        try {
           out = new FileOutputStream(filename);
            os = new ObjectOutputStream(out);
             os.writeObject(list);
            
        }catch(IOException e){
            System.out.println("co loi phan ghi du lieu");
            Object ex = null;
             Logger.getLogger(quanLyMayBay.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(out != null)  os.close();
            if(os != null)  os.close();
        }
       
       
    }
    
  
     static void saveByAirline(List<VeMayBay> list , String prex) throws Exception{
         List<VeMayBay> vietjetAirList = getAriline(list,"VJ");
         save(vietjetAirList,"vietjet.dat");
         
         List<VeMayBay> vietNamAirlineList = getAriline(list,"VN");
         save(vietNamAirlineList,"vietNamAirline.dat");
         
         List<VeMayBay> jetstarList = getAriline(list,"JET");
         save(jetstarList,"vietjet.dat");
     }
    
    static List<VeMayBay> getAriline(List<VeMayBay> list , String prex) {
        List<VeMayBay> airLinelist = new ArrayList<>();
        list.stream().filter(veMayBay -> (veMayBay.getId().startsWith(prex))).forEach(veMayBay -> {
            airLinelist.add(veMayBay);
         });
//        for(VeMayBay veMayBay : list) {
//            if(veMayBay.getId().startsWith(prex)){
//                airLinelist.add(veMayBay);
//            }
//        }
        return airLinelist;
    }
    
    public static void main(String[] args) throws Exception {
       
         List<VeMayBay> list= new ArrayList<>();
    int choose;
    
    do {
     showMenu();
    choose = sc.nextInt();
    
        switch (choose) {
            case 1:
                input(list);
                break;
            case 2:
                save(list,"duLieuBay.dat");
                break;
            case 3:
                sort(list);
                break;
            case 4:
                System.out.println("nhap prex");
                String prex = sc.nextLine();
                saveByAirline(list,prex);
                break;
            case 5:
                System.out.println("thoat");
                break;
            default:
                System.out.println("nhap sai");
        }
}while(choose != 5);
    }
    
}

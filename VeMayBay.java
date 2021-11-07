/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Hello VIỆT
 */
public class VeMayBay implements Serializable{
    private String id;
    private String name;
    private String date;
    private String bag;
    private int price;

    public VeMayBay() {
    }

    public VeMayBay(String id, String name, String date, String bag, int price) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.bag = bag;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void input() {
        System.out.println("nhap ma ve");
        Scanner sc = new Scanner(System.in);
        this.id = sc.nextLine();
        System.out.println("nhap ten chuyen bay: ");
        name = sc.nextLine();
        System.out.println("nhap ngay bay: ");
        setDate( sc.nextLine());
        System.out.println("nhap hanh ly ki gui: ");
        setBag( sc.nextLine());
        System.out.println("nhap gia ve: ");
        price = sc.nextInt();
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "VeMayBay{" + "id=" + id + ", name=" + name + ", date=" + date + ", bag=" + bag + ", price=" + price + '}';
    }
    
    public void display() {
        System.out.println(toString());
    } 
    
    
    
    
}

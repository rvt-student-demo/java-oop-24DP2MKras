package rvt.OnlineShop;

import java.util.*;
public class Warehouse {
    HashMap<String, Integer> Map = new HashMap<>();
    HashMap<String, Integer> Stock = new HashMap<>();
    
    public void addProduct(String product, int price, int stock){
        Map.put(product, price);
        Stock.put(product, stock);
    }

    public int price(String product) {
        return Map.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return Stock.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        int StockAmount = Stock.getOrDefault(product, 0);
        if(!(StockAmount > 0)) {
            return false;
        } else {
                Stock.put(product, StockAmount - 1);
            return true;
        }
    }

    public Set<String> products() {
        
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
warehouse.addProduct("coffee", 5, 1);

System.out.println("stock:");
System.out.println("coffee:  " + warehouse.stock("coffee"));
System.out.println("sugar: " + warehouse.stock("sugar"));

System.out.println("taking coffee " + warehouse.take("coffee"));
System.out.println("taking coffee " + warehouse.take("coffee"));
System.out.println("taking sugar " + warehouse.take("sugar"));

System.out.println("stock:");
System.out.println("coffee:  " + warehouse.stock("coffee"));
System.out.println("sugar: " + warehouse.stock("sugar"));
    }
}

package rvt.OnlineShop;

import java.util.*;
public class Warehouse {
    HashMap<String, Integer> Map = new HashMap<>();
    HashMap<String, Integer> Stock = new HashMap<>();
    public String product;
    public int price;
    public int stock;
    
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
        return Map.keySet();
    }

    public static void main(String[] args) {
        
    Warehouse warehouse = new Warehouse();
    warehouse.addProduct("milk", 3, 10);
    warehouse.addProduct("coffee", 5, 6);
    warehouse.addProduct("buttermilk", 2, 20);
    warehouse.addProduct("yogurt", 2, 20);

    System.out.println("products:");

for (String product: warehouse.products()) {
    System.out.println(product);
    }

    }
}

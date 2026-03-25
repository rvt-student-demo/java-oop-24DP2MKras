package rvt.OnlineShop;
import java.util.*;
public class ShoppingCart {
    public String product;
    public int price;
    public int TotalPrice;
    Map<String, Item> Shop = new HashMap<>();
    public void add(String product, int price) {
        if(Shop.containsKey(product)) {
            Shop.get(product).increaseQuantity();
        } else {
            Shop.put(product, new Item(product, 1, price));
        }
        TotalPrice += price;
        }
    public int price() {
        return TotalPrice;
    }

    public void print() {
        
        for(String product : Shop.keySet()) {
            System.out.println(Shop.get(product));
        }
    }
    public static void main(String[] args) {
        
    ShoppingCart cart = new ShoppingCart();
cart.add("milk", 3);
cart.print();
System.out.println("cart price: " + cart.price() + "\n");

cart.add("buttermilk", 2);
cart.print();
System.out.println("cart price: " + cart.price() + "\n");

cart.add("milk", 3);
cart.print();
System.out.println("cart price: " + cart.price() + "\n");

cart.add("milk", 3);
cart.print();
System.out.println("cart price: " + cart.price() + "\n");
}
}


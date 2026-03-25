package rvt.OnlineShop;
public class Item {
        public String Product;
        public int qty;
        public int unitPrice;
    public Item(String Product, int qty, int unitPrice) {
        this.Product = Product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int price() {
        int totalPrice = qty * unitPrice;
        return totalPrice;
    }
    public void increaseQuantity() {
        qty = qty + 1;
    }
    public String toString() {
        return Product + ": " + qty;
    }
    public static void main(String[] args) {
        Item item = new Item("milk", 4, 2);
    System.out.println("an item that contains 4 milks has the total price of " + item.price());
    System.out.println(item);
    item.increaseQuantity();
    System.out.println(item);
    }
}


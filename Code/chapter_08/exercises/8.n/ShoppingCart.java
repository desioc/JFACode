package bookstore.data;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static final int ITEMS_MAX_NUMBER = 4;
    private Item[] items;

    public ShoppingCart() {
        items = new Item[ITEMS_MAX_NUMBER];
    }

    public void add(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i]==null) {
                items[i] = item;
                return;
            }
        }
        System.out.println("Cannot add Item: shopping cart full!");
    }

    public boolean isEmpty() {
        return items[0] == null;
    }

    public int calculatePrice() {
        int shoppingCartPrice = 0;
        for (Item item : items) {
            shoppingCartPrice += item.getPrice();
        }
        return shoppingCartPrice;
    }
    
    public String toString() {
        String shoppingCartDescription = "The shopping cart contains the following items:\n";
        for (Item item : items) {
            shoppingCartDescription += item + "\n";
        }
        return shoppingCartDescription;
    }
}
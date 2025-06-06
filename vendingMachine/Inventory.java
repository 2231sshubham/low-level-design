package vendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    Map<Product,Integer> productInventory;
    
    public Inventory(){
        productInventory = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity){
        productInventory.put(product, productInventory.getOrDefault(product, 0)+quantity);
    }

    public synchronized void updateQuantity(Product product, int quantity){
        productInventory.put(product, quantity);
    }

    public int getQuantity(Product product){
        return productInventory.getOrDefault(product,0);
    }

    // public synchronized boolean getProduct(Product product) throws Exception{
    //         if(!productInventory.containsKey(product)) throw new Exception("Prodcut not in inventory");
    //         else{
    //             int productQuantity = productInventory.get(product);
    //             productInventory.remove(product);
    //             if(productQuantity <= 0) throw new Exception("Prodcut out of stock");
    //             else productInventory.put(product, productQuantity-1);
    //             return true;
    //         }
    // }

    public boolean isAvailable(Product product){
        return productInventory.containsKey(product) && productInventory.get(product) > 0;
    }

    public void removeProduct(Product product){
        productInventory.remove(product);
    }
}

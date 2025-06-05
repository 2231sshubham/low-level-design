package vendingMachine;

public class Product {
    String productId;
    int productValue;

    public Product(String id, int val){
        productId=id; productValue=val;
    }

    public String getProductId(){ return productId; }
    public int getProductValue(){ return productValue; }
}

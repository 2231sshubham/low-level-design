package vendingMachine;

public class DispenseState implements VendingMachineState{
    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void chooseProduct(Product product){
        System.out.println("Dispensing Product, wait!");
    }
    @Override
    public void insertCoin(Coin coin){
        System.out.println("Dispensing Product, wait!");
    }
    @Override
    public void insertNote(Note note){
        System.out.println("Dispensing Product, wait!");
    }

    @Override
    public void dispenseProduct(){
        Product product = vendingMachine.getProduct();
        vendingMachine.getInventory().updateQuantity(product,vendingMachine.getInventory().getQuantity(product)-1);
        System.out.println("Product dispensed: "+product.getProductId());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange(){
        System.out.println("Dispensing Product, wait!");
    }
}

package vendingMachine;

public class IdleState implements VendingMachineState {
    VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void chooseProduct(Product product){
        if(vendingMachine.getInventory().isAvailable(product)){
            vendingMachine.setProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState());
            System.out.println("Product chosen to dispense: "+product.getProductId());
        }
        else System.out.println("Product out of stock!");
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("Choose Product first!");
    }
    @Override
    public void insertNote(Note note){
        System.out.println("Choose Product first!");
    }
    @Override
    public void dispenseProduct(){
        System.out.println("Choose Product first!");
    }
    @Override
    public void returnChange(){
        System.out.println("Choose Product first!");
    }
}

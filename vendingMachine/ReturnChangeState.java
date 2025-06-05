package vendingMachine;

public class ReturnChangeState implements VendingMachineState{
    VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void chooseProduct(Product product){
        System.out.println("Product dispensed, returning change. Wait!");
    }
    @Override
    public void insertCoin(Coin coin){
        System.out.println("Product dispensed, returning change. Wait!");
    }
    @Override
    public void insertNote(Note note){
        System.out.println("Product dispensed, returning change. Wait!");
    }
    @Override
    public void dispenseProduct(){
        System.out.println("Product dispensed, returning change. Wait!");
    }

    @Override
    public void returnChange(){
        if(vendingMachine.getProduct().getProductValue() < vendingMachine.getTotalMoney())
            System.out.println("Change returned: "+(vendingMachine.getTotalMoney()-vendingMachine.getProduct().getProductValue())); 
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}

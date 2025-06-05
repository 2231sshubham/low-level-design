package vendingMachine;

public class ReadyState implements VendingMachineState{
    VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void chooseProduct(Product product){
        System.out.println("Product already selected.");
    }

    @Override
    public void insertCoin(Coin coin){
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted!");
        checkPaymentStatus();
    }
    @Override
    public void insertNote(Note note){
        vendingMachine.addNote(note);
        System.out.println("Note inserted!");
        checkPaymentStatus();
    }
    
    @Override
    public void dispenseProduct(){
        System.out.println("Add money first.");
    }
    @Override
    public void returnChange(){
        System.out.println("Add money first.");
    }

    void checkPaymentStatus(){
        if(vendingMachine.getTotalMoney() >= vendingMachine.getProduct().getProductValue()){
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }
}

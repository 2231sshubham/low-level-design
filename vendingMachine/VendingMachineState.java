package vendingMachine;

public interface VendingMachineState {
    void chooseProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
}

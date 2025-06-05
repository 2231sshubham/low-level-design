package vendingMachine;

public class VendingMachineDemo {
    public static void main(String[] args){
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Inventory inventory = vendingMachine.getInventory();
        Product bread = new Product("Bread", 20);
        Product cookies = new Product("Cookies", 30);
        Product milk = new Product("Milk", 40);
        Product eggs = new Product("Eggs", 66);

        inventory.addProduct(bread, 4);
        inventory.addProduct(cookies, 5);
        inventory.addProduct(milk, 10);
        inventory.addProduct(eggs, 1);

        vendingMachine.getCurrentState().chooseProduct(eggs);
        vendingMachine.getCurrentState().insertCoin(Coin.Twenty); vendingMachine.getCurrentState().insertNote(Note.Fifty);
        vendingMachine.getCurrentState().dispenseProduct();
        vendingMachine.getCurrentState().returnChange();

        vendingMachine.getCurrentState().chooseProduct(eggs);
        // vendingMachine.getCurrentState().chooseProduct(eggs);
        // vendingMachine.getCurrentState().insertNote(Note.Hundred);
        // vendingMachine.getCurrentState().insertCoin(Coin.Ten);
        // vendingMachine.getCurrentState().dispenseProduct();
        // vendingMachine.getCurrentState().returnChange();
    }
}

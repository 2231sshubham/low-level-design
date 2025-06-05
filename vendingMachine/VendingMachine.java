package vendingMachine;

public class VendingMachine {
    Inventory inventory;
    static VendingMachine instance;
    Product product;
    private final IdleState idleState;
    private final ReadyState readyState;
    private final DispenseState dispenseState;
    private final ReturnChangeState returnChangeState;
    VendingMachineState currentState;
    double totalPayment;

    private VendingMachine(){
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        totalPayment = 0.0;
        product = null;
    }

    public static synchronized VendingMachine getInstance(){
        if(instance == null)
            instance = new VendingMachine();
        return instance;
    }

    public void setState(VendingMachineState state){
        currentState = state;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public void addCoin(Coin coin){
        totalPayment += coin.value;
    }
    public void addNote(Note note){
        totalPayment += note.value;
    }

    public Inventory getInventory(){ return inventory;}
    public IdleState getIdleState(){ return idleState;}
    public ReadyState getReadyState(){return readyState;}
    public DispenseState getDispenseState(){ return dispenseState;}
    public ReturnChangeState getReturnChangeState(){ return returnChangeState;}
    public VendingMachineState getCurrentState(){ return currentState; }
    public Product getProduct(){ return product;}
    public double getTotalMoney(){ return totalPayment;}
}

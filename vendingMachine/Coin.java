package vendingMachine;

public enum Coin {
    One(1.0),
    Two(2.0),
    Five(5.0),
    Ten(10.0),
    Twenty(20.0);

    double value;
    private Coin(double val){
        value = val;
    }
}

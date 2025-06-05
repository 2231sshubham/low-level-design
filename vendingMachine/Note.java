package vendingMachine;

public enum Note {
    Ten(10.0),
    Twenty(20.0),
    Fifty(50.0),
    Hundred(100.0),
    TwoHundred(200.0),
    FiveHundred(500.0),
    TwoThousand(2000.0);

    double value;
    private Note(double val){
        value = val;
    }
}

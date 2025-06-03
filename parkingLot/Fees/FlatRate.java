package parkingLot.Fees;
import parkingLot.Ticket;

public class FlatRate implements FeeStrategy{
    double rate;

    public FlatRate(double rate){
        this.rate = rate;
    }
    @Override
    public double calculatFees(Ticket ticket){
        return rate;
    }
}

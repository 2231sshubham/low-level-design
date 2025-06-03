package parkingLot.Fees;

import parkingLot.Ticket;

public class TimeBased implements FeeStrategy{
    @Override
    public double calculatFees(Ticket ticket){
        return (ticket.getExitTime()-ticket.getExitTime())*0.05;
    }
}

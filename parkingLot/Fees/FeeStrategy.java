package parkingLot.Fees;

import parkingLot.Ticket;

public interface FeeStrategy {
    double calculatFees(Ticket ticket);
}

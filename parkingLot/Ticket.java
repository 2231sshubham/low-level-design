package parkingLot;

import java.util.Date;
import parkingLot.vehicle.*;

public class Ticket {
    private final String ticketNumber;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long entryTime;
    long exitTime;

    public Ticket(String ticketNumber, Vehicle vehicle, ParkingSpot spot){
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.parkingSpot = spot;
        this.entryTime = new Date().getTime();
    }
    
    public void setExitTime(){
        this.exitTime = new Date().getTime();
    }

    public String getTicketNumber(){ return ticketNumber; }
    public Vehicle getVehicle(){ return vehicle; }
    public ParkingSpot getParkingSpot(){ return parkingSpot; }
    public long getEntryTime(){ return entryTime; }
    public long getExitTime(){ return exitTime; }
}

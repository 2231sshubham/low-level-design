package parkingLot;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import parkingLot.Fees.*;
import parkingLot.vehicle.Vehicle;

public class ParkingLot{
    public static ParkingLot parkingLot;
    List<ParkingFloor> parkingFloors;
    Map<String,Ticket> activeTickets = new ConcurrentHashMap<>();
    FeeStrategy feeStrategy;
     
    private ParkingLot(){
        this.parkingFloors = new ArrayList<>();
        feeStrategy = new FlatRate(20d);
    }

    public static ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
    
    public void addFloor(ParkingFloor floor){
        parkingFloors.add(floor);
    }
    public void setFeeStrategy(FeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
    }

    public synchronized Ticket parkVehicle(Vehicle v) throws Exception{
        for(ParkingFloor parkingFloor:parkingFloors){
            Optional<ParkingSpot> spotOpt = parkingFloor.getParkingSpot(v.getType());
            if(spotOpt.isPresent()){
                ParkingSpot spot = spotOpt.get();
                if(spot.park(v)){
                    Ticket ticket = new Ticket(UUID.randomUUID().toString(), v, spot);
                    activeTickets.put(ticket.getTicketNumber(), ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("Parking Spot unavailable for "+v.getType()+" at the moment");
    }

    public double unParkVehicle(String ticketId) throws Exception{
        Ticket ticket = activeTickets.remove(ticketId);
        if(ticket==null) throw new Exception("Invalid Ticket");

        ParkingSpot spot = ticket.getParkingSpot();
        spot.unPark();
        ticket.setExitTime();
        return feeStrategy.calculatFees(ticket);
    }

    public List<ParkingFloor> getParkingFloors(){ return parkingFloors; }
}
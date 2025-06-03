package parkingLot;
import parkingLot.vehicle.*;

public class ParkingSpot {
    int spotId;
    boolean isAvailable;
    VehicleType vehicleType;
    Vehicle vehicle;

    public ParkingSpot(int id, VehicleType v){
        this.spotId = id;
        this.vehicleType = v;
        this.isAvailable = true;
    }

    // synchronized method to avoid collision while allowing simaltaneous parking
    public synchronized boolean park(Vehicle vehicle){
        if(!isAvailable || vehicleType != vehicle.getType()) return false; 
        this.vehicle = vehicle;
        this.isAvailable = false;
        return true;
    }
    
    public synchronized void unPark(){
        this.vehicle = null;
        this.isAvailable = true;
    }

    //getters
    public boolean isAvailable(){ return this.isAvailable; }
    public int getSpotId(){ return this.spotId; }
    public VehicleType getType(){return this.vehicleType; }
    public Vehicle getVehicle(){ return this.vehicle; }
}

package parkingLot.vehicle;

public abstract class Vehicle {
    String registrationId;
    VehicleType type;

    public Vehicle(String id, VehicleType v){
        registrationId=id; this.type=v;
    }

    public String getVehicleId(){
        return this.registrationId;
    }
    public VehicleType getType(){
        return this.type;
    }
}

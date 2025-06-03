package parkingLot;

import java.util.List;
import java.util.Optional;

import parkingLot.vehicle.*;

public class ParkingFloor {
    List<ParkingSpot> parkingSpots;
    int floorNumber;

    public ParkingFloor(List<ParkingSpot> spots, int floor){
        this.parkingSpots = spots;
        this.floorNumber = floor;
    }

    public Optional<ParkingSpot> getParkingSpot(VehicleType vehicleType){
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getType()==vehicleType)
                .findFirst();
    }

    public List<Integer> getAvailableParkingSpots(VehicleType vehicleType){
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getType()==vehicleType)
                .map(ParkingSpot::getSpotId)
                .toList();
    }
    public List<ParkingSpot> getParkingSpots(){ return parkingSpots; }
    public int getParkingFloorNumber(){ return floorNumber; }
}

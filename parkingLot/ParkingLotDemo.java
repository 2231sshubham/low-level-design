package parkingLot;

import java.util.ArrayList;
import java.util.List;

import parkingLot.Fees.FlatRate;
import parkingLot.vehicle.*;

class ParkingLotDemo{
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();
        List<ParkingSpot> parkingSpots = List.of(
            new ParkingSpot(1, VehicleType.Car), 
            new ParkingSpot(2, VehicleType.Bike)
        );

        ParkingFloor parkingFloor = new ParkingFloor(parkingSpots, 0);
        parkingLot.addFloor(parkingFloor);
        parkingSpots = List.of(
            new ParkingSpot(1, VehicleType.Bike),
            new ParkingSpot(2, VehicleType.Truck)
        );
        parkingFloor = new ParkingFloor(parkingSpots, 1);
        parkingLot.addFloor(parkingFloor);

        parkingLot.setFeeStrategy(new FlatRate(20d));

        Vehicle car1 = new Car("HR-51-0921");
        Vehicle car2 = new Car("PB-01-42R2");
        Vehicle bike1 = new Bike("MP-42-523P");
        Vehicle truck1 = new Truck("KA-51-5214");

        List<String> tickets = new ArrayList<>();

        try {
            Ticket ticket1 = parkingLot.parkVehicle(car1); 
            System.out.println("Car 1 parked: "+ticket1.getTicketNumber());
            tickets.add(ticket1.getTicketNumber());
            
            Ticket ticket3 = parkingLot.parkVehicle(bike1);
            System.out.println("Bike 1 parked: "+ticket3.getTicketNumber());
            tickets.add(ticket3.getTicketNumber());
            
            Ticket ticket4 = parkingLot.parkVehicle(truck1);
            System.out.println("Truck 1 parked: "+ticket4.getTicketNumber());
            tickets.add(ticket4.getTicketNumber());

            
            // parking when spots are full
            Ticket ticket2 = parkingLot.parkVehicle(car2);
            System.out.println("Car 2 parked: "+ticket2.getTicketNumber());
            tickets.add(ticket2.getTicketNumber());
            
        } catch (Exception e) {
            System.out.println("Exception occured: "+e.getMessage());
        }

        //unpark vehicle
        try {
            System.out.println(tickets.getFirst());
            double fee = parkingLot.unParkVehicle(tickets.getFirst());
            System.out.println("Unparked vehicle: "+tickets.getFirst()+", Parking Fee - "+fee);

            fee = parkingLot.unParkVehicle("03"); //invalid ticketId
        } catch (Exception e) {
            System.out.println("Exception during unparking: "+e.getMessage());
        }
    }
}

package elevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    List<Elevator> elevators;

    public ElevatorController(int numberOfElevators, int capacity){
        elevators = new ArrayList<Elevator>();
        for(int i=0;i<numberOfElevators;i++){
            elevators.add(new Elevator(i, capacity));
        }
    }

    public void requestElevator(int source, int dest){
        Elevator elevator = findOptimalElevator(source, dest);
        elevator.addRequest(new Request(source, dest));
        System.out.println("New Request added to elevator: "+elevator.getId());
        new Thread(elevator::run).start();
    }
    
    public Elevator findOptimalElevator(int source, int dest){
        Elevator optimalElevator = null;
        int minDist = Integer.MAX_VALUE;
        Direction userDirection = source - dest > 0 ? Direction.Down : Direction.Up; 
        List<Elevator> optimalElevetors = elevators.stream().anyMatch(e -> e.getDirection()==userDirection) ?
            elevators.stream().filter(e -> e.getDirection() == userDirection).toList() : elevators;

        for(Elevator e:optimalElevetors){
            if(Math.abs(source-e.getFloor()) < minDist){
                optimalElevator = e;
                minDist = Math.abs(dest-e.getFloor());
            }
        }
        return optimalElevator;
    }
}

package TrafficSignal;

public class RedState implements State{
    public String getStateName(){
        return "Red";
    }

    public void update(TrafficLight trafficLight, TrafficService trafficService, Direction direction){
        System.out.println("Direction: "+direction+", state: Red");
        // int duration = trafficService.getSignalDuration(direction, "Yellow");
        // trafficService.scheduleStateChange(trafficLight, direction, new RedState(), duration);
    }
}

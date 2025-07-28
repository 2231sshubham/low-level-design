package TrafficSignal;

public class YellowState implements State{
    public String getStateName() {
        return "Yellow";
    }

    public void update(TrafficLight trafficLight, TrafficService trafficService, Direction direction) {
        System.out.println("Direction: "+direction+", state: Yellow");
        int duration = trafficService.getSignalDuration(direction, "Yellow");
        trafficService.scheduleStateChange(trafficLight, direction, new RedState(), duration);
    }
}

package TrafficSignal;

public class GreenState implements State{
    public String getStateName() {
        return "Green";
    }

    public void update(TrafficLight trafficLight, TrafficService trafficService, Direction direction) {
        System.out.println("Direction: "+direction+", state: Green");
        int duration = trafficService.getSignalDuration(direction, "Green");
        Direction nextDirection = trafficService.getNextDirection(direction);
        TrafficLight nextLight = trafficService.getTrafficLight(nextDirection);
        trafficService.scheduleStateChange(trafficLight, direction, new YellowState(), duration);
        trafficService.scheduleStateChange(nextLight, nextDirection, new GreenState(), duration);
    }

}

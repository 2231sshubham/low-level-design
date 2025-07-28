package TrafficSignal;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficService {
    Map<Direction, TrafficLight> trafficIntersection;
    Map<Direction, Map<String,Integer>> signalStateDurations;
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public TrafficService(Map<Direction, TrafficLight> trafficIntersection, Map<Direction, Map<String,Integer>> signalStateDurations){
        this.signalStateDurations = signalStateDurations;
        this.trafficIntersection = trafficIntersection;
    }

    public void start(Direction direction){
        TrafficLight trafficLight = trafficIntersection.get(direction); 
        trafficLight.setState(new GreenState());
        trafficLight.updateState(this);
    }

    public void scheduleStateChange(TrafficLight light, Direction direction, State state, int duration){
        scheduler.schedule(() -> {
            light.setState(state);
            light.updateState(this);
        }, duration, TimeUnit.SECONDS);
    }

    public Direction getNextDirection(Direction currentDirection){
        Direction[] directions = Direction.values();
        int next = (currentDirection.ordinal()+1)%directions.length;
        return directions[next];
    }

    public TrafficLight getTrafficLight(Direction direction){
        return trafficIntersection.get(direction);
    }

    public int getSignalDuration(Direction direction, String state){
        return signalStateDurations.get(direction).get(state);
    }

    public void manualOverride(Direction direction){
        TrafficLight light = trafficIntersection.get(direction);
        light.setState(new GreenState());
        light.updateState(this);
    }
}

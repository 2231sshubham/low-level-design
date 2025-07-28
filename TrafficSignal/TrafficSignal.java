package TrafficSignal;

import java.util.EnumMap;
import java.util.Map;

public class TrafficSignal {
    public static void main(String[] args){
        Map<Direction, Map<String,Integer>> signalStateDurations = new EnumMap<>(Direction.class);
        signalStateDurations.put(Direction.NORTH, Map.of("Green", 5, "Yellow", 2, "Red", 10));
        signalStateDurations.put(Direction.SOUTH, Map.of("Green", 10, "Yellow", 2, "Red", 10));
        signalStateDurations.put(Direction.EAST, Map.of("Green", 5, "Yellow", 2, "Red", 10));
        signalStateDurations.put(Direction.WEST, Map.of("Green", 10, "Yellow", 2, "Red", 10));

        Map<Direction, TrafficLight> signals = new EnumMap<>(Direction.class);
        for(Direction direction:Direction.values()){
            signals.put(direction, new TrafficLight(direction));
        }
        
        TrafficInterface trafficSignal = new TrafficInterface(signals, signalStateDurations);
        trafficSignal.start(Direction.SOUTH);
    }
}

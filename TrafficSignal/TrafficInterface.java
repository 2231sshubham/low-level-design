package TrafficSignal;

import java.util.Map;

public class TrafficInterface {
    TrafficService trafficSignal;
    Map<Direction, TrafficLight> signals;
    Map<Direction, Map<String,Integer>> signalStateDurations;

    public TrafficInterface(Map<Direction, TrafficLight> signals, Map<Direction, Map<String,Integer>> signalStateDurations){
        this.signalStateDurations = signalStateDurations;
        this.signals = signals;
        this.trafficSignal = new TrafficService(signals, signalStateDurations);
    }

    public void start(Direction direction){
        trafficSignal.start(direction);
    }

    public void manualOverride(Direction direction){
        trafficSignal.manualOverride(direction);
    }

    public TrafficLight getSignal(Direction direction){
        return signals.get(direction);
    }
}

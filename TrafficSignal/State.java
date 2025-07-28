package TrafficSignal;

public interface State {
    String getStateName();
    /**
     * Method to update the state of the traffic light.
     *
     * @param trafficLight The traffic light whose state is to be updated.
     */
    void update(TrafficLight trafficLight, TrafficService trafficService, Direction direction);
}

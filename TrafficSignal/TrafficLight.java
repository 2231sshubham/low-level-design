package TrafficSignal;

public class TrafficLight {
    private State state;
    private final Direction direction;
    public TrafficLight(Direction d){
        this.direction=d;
        state = new RedState();
    }

    public void setState(State state){
        this.state=state;
    }

    public State getState(){ return this.state; }
    public Direction getDirection(){ return this.direction; }

    public void updateState(TrafficService trafficService){
        this.state.update(this, trafficService, direction);
    }
}

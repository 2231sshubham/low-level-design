package elevatorSystem;

public class Request {
    Integer source;
    Integer destination;
    boolean isFinished = false;

    public Request(Integer source, Integer destination){
        this.source = source;
        this.destination = destination;
    }
    
    public Integer getDestination(){ return destination;}
    public Integer getSource(){ return source;}

    public void markFinished(){
        this.isFinished = true;
    }

    public boolean isCompleted(){
        return isFinished;
    }
}

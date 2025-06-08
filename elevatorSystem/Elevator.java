package elevatorSystem;

import java.util.List;
import java.util.ArrayList;

public class Elevator {
    private final int id;
    private final int capacity; 
    int currentFloor;
    Direction dir;
    List<Request> requests;
    
    public Elevator(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        currentFloor = 0;
        dir = Direction.Up;
        requests = new ArrayList<Request>();
    }

    public synchronized void addRequest(Request request){
        if(requests.size() < capacity){
            requests.add(request);
            System.out.println("Request added for source: "+request.getSource()+" destination: "+request.getDestination());
            notifyAll();
        }
    }
    public synchronized Request getNexRequest(){
        while(requests.isEmpty()){
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return requests.removeFirst();
    }

    public synchronized void processRequests(){
        while(true){
            try {
                Request request = getNexRequest();
                processRequest(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void processRequest(Request request){
        int startFloor = currentFloor;
        int endFloor = request.getDestination();
        
        if(endFloor < startFloor){
            dir = Direction.Down;
            for(int i=startFloor;i<=endFloor;i++){
                currentFloor = i;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            dir = Direction.Up;
            for(int i=startFloor;i<=endFloor;i++){
                currentFloor = i;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run(){
        processRequests();
    }
    
    public int getFloor(){ return currentFloor;}
    public Direction getDirection(){ return dir;}
    public int getId(){ return id;}

}

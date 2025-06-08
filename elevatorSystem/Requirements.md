Requirements: 
- The elevator system should consist of multiple elevators serving multiple floors.
- Each elevator should have a capacity limit and should not exceed it.
- Users should be able to request an elevator from any floor and select a destination floor.
- The elevator system should efficiently handle user requests and optimize the movement of elevators to minimize waiting time.
- The system should prioritize requests based on the direction of travel and the proximity of the elevators to the requested floor.
- The elevators should be able to handle multiple requests concurrently and process them in an optimal order.
- The system should ensure thread safety and prevent race conditions when multiple threads interact with the elevators.

Entities:
- Elevator: Move to floors; Enter/Exit user; Have capacity limit
- User request: Source-Destination
- Direction: Up/Down
- Floors: Floor number
- Elevator Controller: Manages & assigns elevator; Serve requests concurrently and optimatlly
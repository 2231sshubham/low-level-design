# Designing a Traffic Signal Control System
## Problem Statement
- Design and implement a Traffic Signal System to manage the traffic lights at an intersection. The system should support configurable signal durations for each direction and state, automatic cycling of signals using the State design pattern, and the ability to manually override signals as needed.

## Requirements
- Multiple Directions: The intersection supports multiple directions (e.g., NORTH, SOUTH, EAST, WEST).
- Traffic Light States: Each direction has a traffic light with states: GREEN, YELLOW, RED.
- Configurable Durations: Each direction and state can have its own configurable duration.
- Automatic Cycling: The system automatically cycles through the states for each direction in a round-robin fashion.
- Manual Override: The system allows manual override to set a specific direction to GREEN at any time.
- Extensibility: Easy to add new directions or states if needed.
- State Pattern: Use the State design pattern to encapsulate state-specific behavior and transitions.

## Entities:
- State: Signal State interface, which defines state behaviour for traffic light states(Green,Red,Yellow).
- StateImplementation: Individual state implementation, GreenState, RedState, YellowState.
- TrafficLight: TrafficLight with each state & their configurable timers,direction,and id.
- TrafficService: Manages intersection, trafficLights, current state of each light, and rotation of light signal states.
- TrafficInterfac: Interface to use TrafficService and trigger manual override.
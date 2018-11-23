# ElevatorProject

The elevator system has a panel outside to input the floor where people can choose which floor they want to go to. 
Description:
                Designing an elevator management system for a building.
                The building will have N floors and M elevators.
                The elevators need to be able to pickup people form their current floor and deliver them to their destination.
                People must enter their destination on a keypad to call an elevator.

Technical Requirments:
                Each elevator is a thread.
                Elevator take time to complete actions:
                                1 second to move between floors
                                1 second to acelerate/decelerate
                                2 seconds to load/offload people
                                
                System follows the MVC design pattern.
                Nothing is printed to standard out, everything is logged.
                The whole system is built using TDD.
                A user is able to create new people, add them to a floor, and set their destination.

Stage 1:
                Simple building with one elevator and a small amount of floors.
                
Stage 2:
                Large building with multiple elevators and a large amount of floors.
                
Final:
                Large building with multiple elevators, a large amount of floors, and a producer that automatically adds people to random floors.
        
        
        The final system is built using MVC for a robust muti-threading applications

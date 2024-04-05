import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    List<Floor> floors;

    int totalSlots;

    int freeSlots;

    public ParkingLot(int floorsCount, int slotsPerFloor, String parkingLotId){
        floors = new ArrayList<>(floorsCount);
        for(int i = 0; i < floorsCount; i++){
            Floor floor = new Floor(slotsPerFloor);
            floors.add(floor);
        }

        this.parkingLotId = "PR1234";
        totalSlots = floorsCount * slotsPerFloor;
        freeSlots = totalSlots;
        System.out.println("Created parkingLot with "+ floorsCount +" floors and "+ slotsPerFloor +" slots per floor");
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public String parkVehicle(Vehicle vehicle){
        String ticketNumber = parkingLotId+"_"+getTicket(vehicle);
        if(ticketNumber.equals(parkingLotId+"_"+"NA"))
            return "PARKING LOT FULL";
        return ticketNumber;
    }

    public String getTicket(Vehicle vehicle){
        int floorId = 1;
        for(Floor floor : floors){
            List<Slot> slots = floor.getSlots();

            if(vehicle.vehicleType.equals(VehicleType.TRUCK)){
                if(!slots.get(0).occupied){
                    slots.get(0).occupied = true;
                    slots.get(0).setVehicle(vehicle);
                    return floorId+"_1";
                }
            } else if(vehicle.vehicleType.equals(VehicleType.BIKE)){
                if(!slots.get(1).occupied){
                    slots.get(1).occupied = true;
                    slots.get(1).setVehicle(vehicle);
                    return floorId+"_2";
                }
                if(!slots.get(2).occupied){
                    slots.get(2).occupied = true;
                    slots.get(2).setVehicle(vehicle);
                    return floorId+"_3";
                }
            }
            for(int i = 3; i< slots.size(); i++){
                if(!slots.get(i).occupied) {
                    if (vehicle.vehicleType.equals(VehicleType.CAR)) {
                        slots.get(i).occupied = true;
                        slots.get(i).setVehicle(vehicle);
                        return floorId + "_" + (i + 1);
                    }
                }
            }
            floorId++;
        }
        return "NA";
    }

    public void unParkVehicle(String ticketId){
        String[] ticket = ticketId.split("_");
        try {
            int floorNum = Integer.parseInt(ticket[1]);
            int slotNum = Integer.parseInt(ticket[2]);
            System.out.println("floor "+floorNum + " slotNum "+slotNum);
            Slot slot = floors.get(floorNum-1).slots.get(slotNum-1);
            if(!slot.occupied){
                System.out.println("Invalid Ticket");
            } else{
                System.out.println("Unparked Vehicle with Registration Number: "+ slot.vehicle.getRegistrationNumber() +" Color: "+slot.vehicle.getColor());
                slot.occupied = false;
                slot.vehicle = null;
            }
        }catch (Exception e){
            System.out.println("Invalid Ticket");
        }
    }

    public void displayFreeCount(VehicleType vehicleType){
        int floorId = 1;
        for(Floor floor: floors){
            int freeSlots = 0;
            List<Slot> slots = floor.getSlots();

            if(vehicleType.equals(VehicleType.TRUCK)){
                if(!slots.get(0).occupied){
                    freeSlots++;
                }
            } else if(vehicleType.equals(VehicleType.BIKE)){
                if(!slots.get(1).occupied){
                    freeSlots++;
                }
                if(!slots.get(2).occupied){
                    freeSlots++;
                }
            }
            for(int i = 3; i< slots.size(); i++){
                if(!slots.get(i).occupied) {
                    if (vehicleType.equals(VehicleType.CAR)) {
                        freeSlots++;
                    }
                }
            }

            System.out.println("Number of free slots for "+ vehicleType + " on floor "+floorId + ": "+freeSlots);
            floorId++;
        }
    }

}

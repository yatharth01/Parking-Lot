import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = null;

        while(true){
            String cmd = sc.nextLine();
            if(cmd.equals("exit")){
                break;
            }
            String[] cmds = cmd.split(" ");
            String command = cmds[0];
            switch (command){
                case "create_parking_lot" :
                    parkingLot = new ParkingLot(Integer.parseInt(cmds[2]),Integer.parseInt(cmds[3]),cmds[1]);
                    continue;
                case "park_vehicle": {
                    VehicleType vehicleType = VehicleType.valueOf(cmds[1]);
                    String regNo = cmds[2];
                    Color color = Color.valueOf(cmds[3]);
                    String ticketNumber = parkingLot.parkVehicle(new Vehicle(vehicleType, regNo, color));
                    if(ticketNumber.equals("PARKING LOT FULL")){
                        System.out.println("PARKING LOT FULL");
                    }else{
                        System.out.println("Parked. TicketNumber: "+ticketNumber);
                    }
                    continue;
                }
                case "unpark_vehicle":
                    parkingLot.unParkVehicle(cmds[1]);
                    continue;
                case "display":
                    if(cmds[1].equals("free_count")){
                        parkingLot.displayFreeCount(VehicleType.valueOf(cmds[2]));
                    }
                    continue;


            }

        }
    }
}
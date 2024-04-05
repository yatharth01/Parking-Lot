public class Vehicle {
    VehicleType vehicleType;
    String registrationNumber;
    Color color;

    public Vehicle(VehicleType vehicleType, String registrationNumber, Color color) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}

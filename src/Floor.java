import java.util.ArrayList;
import java.util.List;

public class Floor {
    List<Slot> slots = new ArrayList<>();

    public Floor(int n){
        for(int i =0 ; i< n;i++){
            Slot slot = new Slot();
            this.slots.add(slot);
        }
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public void addSlot(Slot slot){
        slots.add(slot);
    }
}

package XuatSac.XuatSac2;


import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<Ticket> tickets = new ArrayList<>();

    public Room(String name, int capacity) {

        this.name = name;

        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(name + "-" + i));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public int soldCount() {
        return (int) tickets.stream().filter(Ticket::isSold).count();
    }

    public int total() {
        return tickets.size();
    }

    public String getName() {
        return name;
    }
}


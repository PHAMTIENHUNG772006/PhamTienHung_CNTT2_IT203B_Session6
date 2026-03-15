package kha.Kha2;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;
    private int nextId;

    public TicketPool(String roomName, int numberOfTickets) {
        this.roomName = roomName;
        tickets = new ArrayList<>();
        for (int i = 1; i <= numberOfTickets; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i), roomName, false));
        }
        nextId = numberOfTickets + 1;
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

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", nextId++), roomName, true));
        }
        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);
    }

    public boolean isSoldOut() {
        return tickets.stream().allMatch(Ticket::isSold);
    }

    public int remainingTickets() {
        return (int) tickets.stream().filter(t -> !t.isSold()).count();
    }

    public String getRoomName() {
        return roomName;
    }
}
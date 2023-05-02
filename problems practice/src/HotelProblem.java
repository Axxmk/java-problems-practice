import java.util.ArrayList;
import java.util.Scanner;

public class HotelProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
//        sc.next();

        Hotel hotel = new Hotel("ABC");
//        for (int i = 0; i < n; i++) {
//            String command = sc.nextLine();
//        }

        hotel.creatRoom("Suite");
        hotel.booking(1, 5, 10);
        hotel.booking(1, 2, 4);

        hotel.creatRoom("Suite2");
        hotel.booking(2, 1, 12);
        hotel.booking(2, 4, 15);

        hotel.report();
    }
}

class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;
    private String name;
    private int autoRoomId;
    private int autoBookingId;

    public Hotel(String name) {
        this.name = name;
        this.autoRoomId = 1;
        this.autoBookingId = 1;
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void creatRoom(String name) {
        Room room = new Room(name, autoRoomId);
        this.rooms.add(room);

        autoRoomId++;

        System.out.println("Room: " + room.getName());
    }

    public void booking(int roomId, int checkIn, int checkOut) {
        boolean isIntersect = false;
        Booking[] bookings = this.bookings.stream().filter(booking -> booking.getRoomId() == roomId).toArray(Booking[]::new);

        for (Booking booking: bookings) {
            isIntersect = checkIn > booking.getCheckInDate() && checkIn < booking.getCheckOutDate() ||
                    checkOut > booking.getCheckInDate() && checkOut < booking.getCheckOutDate() ||
                    checkIn < booking.getCheckInDate() && checkOut > booking.getCheckOutDate();

            if (isIntersect) break;
        }

        if (!isIntersect) {
            Booking booking = new Booking(autoBookingId, roomId, checkIn, checkOut);
            this.bookings.add(booking);

            autoBookingId++;

            System.out.println("Booking Id " + booking.getId() + ": " + booking.getCheckInDate() + " -> " + booking.getCheckOutDate());
        } else {
            System.out.println("Cannot booking this room during that days");
        }
    }

    public boolean cancelBooking(int bookingId) {
        return this.bookings.removeIf(o -> o.getId() == bookingId);
    }

    public void report() {
        for (Room room: this.rooms) {
            System.out.println(room.toString());

            for (Booking booking : this.bookings) {
                if (booking.getRoomId() == room.getId()) {
                    System.out.println("  - " + booking.toString());
                }
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}

class Room {
    private final int id;
    private String name;

    public Room(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Room -> " +
                "id: " + id +
                ", name: '" + name + '\'';
    }
}

class Booking {
    private final int id;
    private final int roomId;
    private int checkInDate;
    private int checkOutDate;

    public Booking(int id, int roomId, int checkInDate, int checkOutDate) {
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public int getCheckInDate() {
        return this.checkInDate;
    }

    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    @Override
    public String toString() {
        return "Booking -> " +
                "id: " + id +
                ", room id: '" + this.roomId + '\'' +
                ", check in: '" + this.checkInDate + '\'' +
                ", check out: '" + this.checkOutDate + '\'';
    }
}
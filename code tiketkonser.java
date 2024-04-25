// Base class for all types of tickets
class Ticket {
    private String eventName;
    private String seatNumber;
    private double price;

    public Ticket(String eventName, String seatNumber, double price) {
        this.eventName = eventName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public String getEventName() {
        return eventName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }
}

// Specific type of ticket for concerts
class ConcertTicket extends Ticket {
    private String artist;

    public ConcertTicket(String eventName, String seatNumber, double price, String artist) {
        super(eventName, seatNumber, price);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }
}

// VIP ticket with additional features
class VIPTicket extends ConcertTicket {
    private String vipArea;

    public VIPTicket(String eventName, String seatNumber, double price, String artist, String vipArea) {
        super(eventName, seatNumber, price, artist);
        this.vipArea = vipArea;
    }

    public String getVipArea() {
        return vipArea;
    }
}

// Encapsulates the logic for booking tickets
class TicketBookingSystem {
    public void bookTicket(Ticket ticket, PaymentProcessor paymentProcessor) {
        // Encapsulated booking logic
        System.out.println("Booking ticket for event: " + ticket.getEventName());
        // Process payment
        paymentProcessor.processPayment(ticket.getPrice());
    }
}

// Interface for payment processing
interface PaymentProcessor {
    void processPayment(double amount);
}

// Implementation for credit card payments
class CreditCardPayment implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment for amount: $" + amount);
    }
}

// Implementation for PayPal payments
class PayPalPayment implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment for amount: $" + amount);
    }
}

// Example usage
public class ConcertTicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();
        PaymentProcessor creditCardPayment = new CreditCardPayment();
        PaymentProcessor payPalPayment = new PayPalPayment();

        Ticket generalTicket = new ConcertTicket("Rock Concert", "A12", 50.0, "Rock Band");
        Ticket vipTicket = new VIPTicket("Pop Concert", "VIP1", 150.0, "Pop Star", "Backstage");

        bookingSystem.bookTicket(generalTicket, creditCardPayment);
        bookingSystem.bookTicket(vipTicket, payPalPayment);
    }
}
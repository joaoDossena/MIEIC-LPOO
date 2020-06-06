import java.util.ArrayList;
import java.util.List;

public class BoxOffice {

    public static List<Ticket> buy(Concert concert, int number) throws InvalidTicket
    {
        List<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i < number; i++)
        {
            tickets.add(new Ticket(concert.getId(), concert));
            concert.incrementId();
        }
        return tickets;
    }



}

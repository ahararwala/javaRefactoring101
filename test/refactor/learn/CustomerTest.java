package refactor.learn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    private Movie movieSkyCaptain;
    private Movie movieRevenant;
    private Movie movieSkyfall;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Joe");

        movieSkyCaptain = new Movie("Sky Captain", 1);
        movieRevenant = new Movie("Revenant", 0);
        movieSkyfall = new Movie("Skyfall", 2);
    }

    @Test
    public void printsForNoRental() throws Exception {
        String expectedReport = "Rental Record for Joe\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";


        assertEquals(expectedReport, customer.statement());
    }

    @Test
    public void printsForOneRental() throws Exception {
        String expectedReport = "Rental Record for Joe\n" +
                "\tSky Captain\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points";

        Rental movieRental = new Rental(movieSkyCaptain, 5);
        customer.addRental(movieRental);

        assertEquals(expectedReport, customer.statement());
    }

    @Test
    public void printsForMultipleRental() throws Exception {
        String expectedReport = "Rental Record for Joe\n" +
                "\tSky Captain\t15.0\n" +
                "\tRevenant\t2.0\n" +
                "\tSkyfall\t12.0\n" +
                "Amount owed is 29.0\n" +
                "You earned 4 frequent renter points";

        Rental r1 = new Rental(movieSkyCaptain, 5);
        Rental r2 = new Rental(movieRevenant, 1);
        Rental r3 = new Rental(movieSkyfall, 10);

        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);

        assertEquals(expectedReport, customer.statement());
    }
}
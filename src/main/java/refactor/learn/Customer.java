package refactor.learn;

import java.util.*;

public class Customer {
    private String _name;
    private List<Rental> _rentals;

    public Customer(String name) {
        _name = name;
        _rentals = new ArrayList<Rental>();

    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : _rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();

            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.getCharge()) + "\n";
            totalAmount += rental.getCharge();
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

}

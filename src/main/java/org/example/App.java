package org.example;


import java.sql.*;
import java.sql.SQLException;
import java.util.Random;

public class App {
    public static void main (String[] args) throws SQLException {


        Random rand = new Random();
        int id = rand.nextInt(10000);

        Accommodation accomodation1 = new Accommodation(id, "hotel", "single", 1, "has a nice view");

        Accommodation accomodation2 = new Accommodation(id, "cabin", "double", 2, "has great outdoors");

        AccommodationService service = new AccommodationService();

        service.addAccommodation(accomodation1);

       service.getAccommodations();

    }
}

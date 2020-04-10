package org.example;


import java.sql.*;
import java.util.*;


public class AccommodationService {

   private Connection connection;

   public AccommodationService () {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siit10?user=postgres&password=postgres");
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   public Map<Accommodation, RoomFair> getAccommodationDetails () {

      Map<Accommodation, RoomFair> accommodations = new HashMap<>();

      try {
         Statement ps = connection.createStatement();
         ResultSet rs = ps.executeQuery("SELECT accomodation.id," +
                 "type," +
                 "bed_type," +
                 "max_guests," +
                 "description, " +
                 "season," +
                 "price" +
                 "FROM accomodation, room_fair " +
                 "where accomodation.id = room_fair.id");
         while (rs.next()) {
            accommodations.put(
                    new Accommodation(rs.getInt("id"), rs.getString("type"), rs.getString("bed_type"), rs.getInt("max_guests"), rs.getString("description")),
                    new RoomFair(rs.getInt("id"), rs.getString("season"), rs.getDouble("price")));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return accommodations;

   }

   public void addAccommodation (Accommodation accommodation, RoomFair roomFair) {
      try {
         PreparedStatement ps = connection.prepareStatement("INSERT INTO accomodation (nextval('serial'), type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)");
         ps.setString(2, accommodation.getType());
         ps.setString(3, accommodation.getBedType());
         ps.setInt(4, accommodation.getMaxGuest());
         ps.setString(5, accommodation.getDescription());
         ps.executeUpdate();
         PreparedStatement ps1 = connection.prepareStatement("INSERT INTO room_fair (nextval('serial'), season, price) VALUES (?, ?, ?)");
         ps.setString(2, RoomFair.getSeason());
         ps.setDouble(3, RoomFair.getPrice());
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @Override
   protected void finalize () throws Throwable {
      this.connection.close();
   }
}

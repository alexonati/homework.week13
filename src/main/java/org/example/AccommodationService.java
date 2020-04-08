package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public List<Accommodation> getAccommodations(){
        ArrayList<Accommodation> accommodations =  new ArrayList<>();

        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM accomodation");
            while(rs.next()){
                accommodations.add(new Accommodation(rs.getInt("id"), rs.getString("type"), rs.getString("bed_type"), rs.getInt("max_guests"),rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accommodations;
    }

    public Accommodation getAccommodation(int id){

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM accomodation WHERE id = ?");
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Accommodation(rs.getInt("id"), rs.getString("type"), rs.getString("bed_type"), rs.getInt("max_guests"),rs.getString("description"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAccommodation(Accommodation accommodation){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, accommodation.getId());
            ps.setString(2, accommodation.getType());
            ps.setString(3, accommodation.getBedType());
            ps.setInt(3, accommodation.getMaxGuest());
            ps.setString(3, accommodation.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deletAccommodation(Accommodation accommodation){
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM accomodation WHERE id = ?");
            ps.setObject(1, accommodation.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        this.connection.close();
    }
}

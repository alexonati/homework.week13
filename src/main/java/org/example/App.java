package org.example;


import java.util.Map;


public class App {


   public static void main (String[] args) {


      Accommodation accomodation1 = new Accommodation("hotel", "single", 1, "has a nice view");
      Accommodation accomodation2 = new Accommodation("cabin", "double", 2, "has great outdoors");

      RoomFair roomFair1 = new RoomFair("summer", 65.00);
      RoomFair roomFair2 = new RoomFair("winter", 100.00);

      AccommodationService accommodationService = new AccommodationService();

      accommodationService.addAccommodation(accomodation1, roomFair1);

      accommodationService.addAccommodation(accomodation2, roomFair2);

      Map<Accommodation, RoomFair> accommodations = accommodationService.getAccommodationDetails();


      for (Accommodation key : accommodations.keySet()) {
         RoomFair roomFair = accommodations.get(key);
         System.out.println(roomFair);
         for (RoomFair value : accommodations.values()) {
            Accommodation accommodation = (Accommodation) accommodations.values();
            System.out.println(accommodation);
         }
      }

   }
}

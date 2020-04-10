package org.example;

import java.util.Map;
import java.util.TreeMap;


public class RoomFair {
   private static int id;
   private static String season;
   private static double price;

   public RoomFair (int id, String season, double price) {
      RoomFair.id = id;
      RoomFair.season = season;
      RoomFair.price = price;
   }

   public RoomFair (String season, double price) {
      RoomFair.season = season;
      RoomFair.price = price;
   }

   public static int getId () {
      return id;
   }

   public static String getSeason () {
      return season;
   }

   public void setSeason (String season) {
      RoomFair.season = season;
   }

   public static double getPrice () {
      return price;
   }

   public void setPrice (double price) {
      RoomFair.price = price;
   }
}

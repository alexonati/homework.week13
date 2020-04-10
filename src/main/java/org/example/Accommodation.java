package org.example;

public class Accommodation {
    private int id;
    private String type;
    private String bedType;
    private int maxGuest;
    private String description;

    public Accommodation (int id, String type, String bedType, int maxGuest, String description) {
        this.id = id;
        this.type = type;
        this.bedType = bedType;
        this.maxGuest = maxGuest;
        this.description = description;
    }

    public Accommodation (String type, String bedType, int maxGuest, String description) {
        this.type = type;
        this.bedType = bedType;
        this.maxGuest = maxGuest;
        this.description = description;
    }

    public int getId () {
        return id;
    }


    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getBedType () {
        return bedType;
    }

    public void setBedType (String bedType) {
        this.bedType = bedType;
    }

    public int getMaxGuest () {
        return maxGuest;
    }

    public void setMaxGuest (int maxGuest) {
        this.maxGuest = maxGuest;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }
}


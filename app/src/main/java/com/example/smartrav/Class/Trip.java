package com.example.smartrav.Class;

public class Trip {

    private String tourName;
    private String tourPlace;
    private String startDate;
    private String endDate;
    private String description;
    private String tourId;

    public Trip(String tourName, String tourPlace, String startDate, String endDate, String description) {
        this.tourName = tourName;
        this.tourPlace = tourPlace;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public Trip(String tourName, String tourPlace, String startDate, String endDate, String description, String tourId) {
        this.tourName = tourName;
        this.tourPlace = tourPlace;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public String getTourPlace() {
        return tourPlace;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }
}
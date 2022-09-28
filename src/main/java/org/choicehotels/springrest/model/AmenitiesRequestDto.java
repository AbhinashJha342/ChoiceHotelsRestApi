package org.choicehotels.springrest.model;

import java.util.List;

public class AmenitiesRequestDto {

    private List<String> amenities;

    public AmenitiesRequestDto(List<String> amenities) {
        this.amenities = amenities;
    }

    public AmenitiesRequestDto() {
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}

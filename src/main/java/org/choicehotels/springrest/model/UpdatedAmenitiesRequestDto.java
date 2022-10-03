package org.choicehotels.springrest.model;

import java.util.List;

public class UpdatedAmenitiesRequestDto {

    private List<String> amenities;

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public UpdatedAmenitiesRequestDto() {
    }


}

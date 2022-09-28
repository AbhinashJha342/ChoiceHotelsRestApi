package org.choicehotels.springrest.model;

import java.util.List;
import java.util.Optional;

public class UpdatedAmenitiesRequestDto {

    private Optional<List<String>> amenities;


    public List<String> getAmenities() {

        return amenities.orElse(null);
    }

    public UpdatedAmenitiesRequestDto(Optional<List<String>> amenities) {
        this.amenities = amenities;
    }

    public UpdatedAmenitiesRequestDto() {
    }
}

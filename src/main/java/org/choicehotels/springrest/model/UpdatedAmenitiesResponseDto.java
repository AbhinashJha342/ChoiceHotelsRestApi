package org.choicehotels.springrest.model;

import java.util.List;

public class UpdatedAmenitiesResponseDto {

    private List<String> amenities;

    private String hotelId;

    private UpdatedAmenitiesResponseDto(List<String> amenities, String hotelId) {
        this.amenities = amenities;
        this.hotelId = hotelId;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public String getHotelId() {
        return hotelId;
    }

    public static Builder builder(){
        return new Builder();
    }


    public static class Builder {

        private List<String> amenities;

        private String hotelId;

        public UpdatedAmenitiesResponseDto.Builder setAmenities(List<String> amenities) {
            this.amenities = amenities;
            return this;
        }

        public UpdatedAmenitiesResponseDto.Builder setHotelId(String hotelId) {
            this.hotelId = hotelId;
            return this;
        }

        public UpdatedAmenitiesResponseDto build(){
            return new UpdatedAmenitiesResponseDto(this.amenities, this.hotelId);
        }
    }
}

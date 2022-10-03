package org.choicehotels.springrest.model;

import java.util.List;

public class AmenitiesResponseDto {

    private List<String> amenities;

    private String hotelId;

    private AmenitiesResponseDto(List<String> amenities, String hotelId) {
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

        public Builder setAmenities(List<String> amenities) {
            this.amenities = amenities;
            return this;
        }

        public Builder setHotelId(String hotelId) {
            this.hotelId = hotelId;
            return this;
        }

        public AmenitiesResponseDto build(){
            return new AmenitiesResponseDto(this.amenities, this.hotelId);
        }
    }
}

package org.choicehotels.springrest.model;

import org.choicehotels.springrest.client.gen.AddressDto;

import java.util.List;

public class HotelDetailsResponseDto {


    private String hotelId;

    private String name;

    private String rating;

    private AddressResponseDto address;

    private List<String> amenities;

    private HotelDetailsResponseDto(String hotelId, String name, String rating, AddressResponseDto address, List<String> amenities) {
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.amenities = amenities;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public AddressResponseDto getAddress() {
        return address;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private String hotelId;

        private String name;

        private String rating;

        private AddressResponseDto address;

        private List<String> amenities;

        public Builder setHotelId(String hotelId) {
            this.hotelId = hotelId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRating(String rating) {
            this.rating = rating;
            return this;
        }

        public Builder setAddress(AddressResponseDto address) {
            this.address = address;
            return this;
        }

        public Builder setAmenities(List<String> amenities) {
            this.amenities = amenities;
            return this;
        }

        public HotelDetailsResponseDto build(){
            return new HotelDetailsResponseDto(this.hotelId, this.name, this.rating, this.address, this.amenities);
        }
    }
}

package org.choicehotels.springrest.model;

public class HotelUpdateDetailsResponseDto {

    private String hotelId;
    private String name;
    private String rating;
    private AddressResponseDto address;

    private HotelUpdateDetailsResponseDto(String hotelId, String name, String rating, AddressResponseDto address) {
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.address = address;
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

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private String hotelId;
        private String name;
        private String rating;
        private AddressResponseDto address;

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

        public HotelUpdateDetailsResponseDto build(){
            return new HotelUpdateDetailsResponseDto(this.hotelId, this.name, this.rating, this.address);
        }
    }
}

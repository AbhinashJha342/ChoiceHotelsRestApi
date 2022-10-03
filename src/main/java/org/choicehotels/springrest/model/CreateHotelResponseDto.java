package org.choicehotels.springrest.model;

public class CreateHotelResponseDto {

    private String hotelId;

    private CreateHotelResponseDto(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private String hotelId;

        public Builder setHotelId(String hotelId) {
            this.hotelId = hotelId;
            return this;
        }

        public CreateHotelResponseDto build(){
            return new CreateHotelResponseDto(this.hotelId);
        }
    }
}

/*
 * Amadeus Travel Innovation Sandbox
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Amount;
import io.swagger.client.model.PeriodRate;
import io.swagger.client.model.RoomInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * HotelRoom
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class HotelRoom {
  @SerializedName("booking_code")
  private String bookingCode = null;

  @SerializedName("room_type_code")
  private String roomTypeCode = null;

  @SerializedName("rate_plan_code")
  private String ratePlanCode = null;

  @SerializedName("total_amount")
  private Amount totalAmount = null;

  @SerializedName("rates")
  private List<PeriodRate> rates = null;

  @SerializedName("descriptions")
  private List<String> descriptions = null;

  @SerializedName("room_type_info")
  private RoomInfo roomTypeInfo = null;

  @SerializedName("rate_type_code")
  private String rateTypeCode = null;

  public HotelRoom bookingCode(String bookingCode) {
    this.bookingCode = bookingCode;
    return this;
  }

   /**
   * The booking code identifies a product at the hotel. It can be used to book a room.
   * @return bookingCode
  **/
  @ApiModelProperty(required = true, value = "The booking code identifies a product at the hotel. It can be used to book a room.")
  public String getBookingCode() {
    return bookingCode;
  }

  public void setBookingCode(String bookingCode) {
    this.bookingCode = bookingCode;
  }

  public HotelRoom roomTypeCode(String roomTypeCode) {
    this.roomTypeCode = roomTypeCode;
    return this;
  }

   /**
   * A 3-letter code to identify a specific room type.
   * @return roomTypeCode
  **/
  @ApiModelProperty(value = "A 3-letter code to identify a specific room type.")
  public String getRoomTypeCode() {
    return roomTypeCode;
  }

  public void setRoomTypeCode(String roomTypeCode) {
    this.roomTypeCode = roomTypeCode;
  }

  public HotelRoom ratePlanCode(String ratePlanCode) {
    this.ratePlanCode = ratePlanCode;
    return this;
  }

   /**
   * A 3 letter code to designate different rates base on traveler type.
   * @return ratePlanCode
  **/
  @ApiModelProperty(value = "A 3 letter code to designate different rates base on traveler type.")
  public String getRatePlanCode() {
    return ratePlanCode;
  }

  public void setRatePlanCode(String ratePlanCode) {
    this.ratePlanCode = ratePlanCode;
  }

  public HotelRoom totalAmount(Amount totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

   /**
   * The total price of staying in this room from the given check-in date to the given check-out date
   * @return totalAmount
  **/
  @ApiModelProperty(value = "The total price of staying in this room from the given check-in date to the given check-out date")
  public Amount getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Amount totalAmount) {
    this.totalAmount = totalAmount;
  }

  public HotelRoom rates(List<PeriodRate> rates) {
    this.rates = rates;
    return this;
  }

  public HotelRoom addRatesItem(PeriodRate ratesItem) {
    if (this.rates == null) {
      this.rates = new ArrayList<PeriodRate>();
    }
    this.rates.add(ratesItem);
    return this;
  }

   /**
   * The total price of staying in this room from the given check-in date to the given check-out date
   * @return rates
  **/
  @ApiModelProperty(value = "The total price of staying in this room from the given check-in date to the given check-out date")
  public List<PeriodRate> getRates() {
    return rates;
  }

  public void setRates(List<PeriodRate> rates) {
    this.rates = rates;
  }

  public HotelRoom descriptions(List<String> descriptions) {
    this.descriptions = descriptions;
    return this;
  }

  public HotelRoom addDescriptionsItem(String descriptionsItem) {
    if (this.descriptions == null) {
      this.descriptions = new ArrayList<String>();
    }
    this.descriptions.add(descriptionsItem);
    return this;
  }

   /**
   * An array of description strings describing room and rate types features
   * @return descriptions
  **/
  @ApiModelProperty(value = "An array of description strings describing room and rate types features")
  public List<String> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<String> descriptions) {
    this.descriptions = descriptions;
  }

  public HotelRoom roomTypeInfo(RoomInfo roomTypeInfo) {
    this.roomTypeInfo = roomTypeInfo;
    return this;
  }

   /**
   * Get roomTypeInfo
   * @return roomTypeInfo
  **/
  @ApiModelProperty(value = "")
  public RoomInfo getRoomTypeInfo() {
    return roomTypeInfo;
  }

  public void setRoomTypeInfo(RoomInfo roomTypeInfo) {
    this.roomTypeInfo = roomTypeInfo;
  }

  public HotelRoom rateTypeCode(String rateTypeCode) {
    this.rateTypeCode = rateTypeCode;
    return this;
  }

   /**
   * The unique rate code used by the hotel chain to price this room&#39;s rate
   * @return rateTypeCode
  **/
  @ApiModelProperty(value = "The unique rate code used by the hotel chain to price this room's rate")
  public String getRateTypeCode() {
    return rateTypeCode;
  }

  public void setRateTypeCode(String rateTypeCode) {
    this.rateTypeCode = rateTypeCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HotelRoom hotelRoom = (HotelRoom) o;
    return Objects.equals(this.bookingCode, hotelRoom.bookingCode) &&
        Objects.equals(this.roomTypeCode, hotelRoom.roomTypeCode) &&
        Objects.equals(this.ratePlanCode, hotelRoom.ratePlanCode) &&
        Objects.equals(this.totalAmount, hotelRoom.totalAmount) &&
        Objects.equals(this.rates, hotelRoom.rates) &&
        Objects.equals(this.descriptions, hotelRoom.descriptions) &&
        Objects.equals(this.roomTypeInfo, hotelRoom.roomTypeInfo) &&
        Objects.equals(this.rateTypeCode, hotelRoom.rateTypeCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingCode, roomTypeCode, ratePlanCode, totalAmount, rates, descriptions, roomTypeInfo, rateTypeCode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HotelRoom {\n");
    
    sb.append("    bookingCode: ").append(toIndentedString(bookingCode)).append("\n");
    sb.append("    roomTypeCode: ").append(toIndentedString(roomTypeCode)).append("\n");
    sb.append("    ratePlanCode: ").append(toIndentedString(ratePlanCode)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
    sb.append("    descriptions: ").append(toIndentedString(descriptions)).append("\n");
    sb.append("    roomTypeInfo: ").append(toIndentedString(roomTypeInfo)).append("\n");
    sb.append("    rateTypeCode: ").append(toIndentedString(rateTypeCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

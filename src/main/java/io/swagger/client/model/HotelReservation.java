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
import io.swagger.client.model.HotelReservationBookingInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;

/**
 * HotelReservation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class HotelReservation {
  @SerializedName("id")
  private String id = null;

  @SerializedName("check_in")
  private LocalDate checkIn = null;

  @SerializedName("check_out")
  private LocalDate checkOut = null;

  @SerializedName("property_code")
  private String propertyCode = null;

  @SerializedName("property_name")
  private String propertyName = null;

  @SerializedName("total_price")
  private Amount totalPrice = null;

  @SerializedName("traveler_ids")
  private List<String> travelerIds = new ArrayList<String>();

  @SerializedName("booking_info")
  private HotelReservationBookingInfo bookingInfo = null;

  public HotelReservation id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Uniquely identifies this hotel room reservation in this travel record. This ID is persistent, and remains the same for the lifetime of the travel record.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Uniquely identifies this hotel room reservation in this travel record. This ID is persistent, and remains the same for the lifetime of the travel record.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public HotelReservation checkIn(LocalDate checkIn) {
    this.checkIn = checkIn;
    return this;
  }

   /**
   * Date on which the guest will begin their stay in the hotel, in the &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;&gt;ISO 8601&lt;/a&gt; date format yyyy-MM-dd.
   * @return checkIn
  **/
  @ApiModelProperty(required = true, value = "Date on which the guest will begin their stay in the hotel, in the <a href=\"https://en.wikipedia.org/wiki/ISO_8601\">ISO 8601</a> date format yyyy-MM-dd.")
  public LocalDate getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(LocalDate checkIn) {
    this.checkIn = checkIn;
  }

  public HotelReservation checkOut(LocalDate checkOut) {
    this.checkOut = checkOut;
    return this;
  }

   /**
   * Date on which the guest will end their stay in the hotel, in the &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;&gt;ISO 8601&lt;/a&gt; date format yyyy-MM-dd.
   * @return checkOut
  **/
  @ApiModelProperty(required = true, value = "Date on which the guest will end their stay in the hotel, in the <a href=\"https://en.wikipedia.org/wiki/ISO_8601\">ISO 8601</a> date format yyyy-MM-dd.")
  public LocalDate getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(LocalDate checkOut) {
    this.checkOut = checkOut;
  }

  public HotelReservation propertyCode(String propertyCode) {
    this.propertyCode = propertyCode;
    return this;
  }

   /**
   * The 8 character property code of this given hotel. The first 2 characters of this code are the chain code that can be specified in the input. The remaining elements are proprietary to each hotel chain.
   * @return propertyCode
  **/
  @ApiModelProperty(required = true, value = "The 8 character property code of this given hotel. The first 2 characters of this code are the chain code that can be specified in the input. The remaining elements are proprietary to each hotel chain.")
  public String getPropertyCode() {
    return propertyCode;
  }

  public void setPropertyCode(String propertyCode) {
    this.propertyCode = propertyCode;
  }

  public HotelReservation propertyName(String propertyName) {
    this.propertyName = propertyName;
    return this;
  }

   /**
   * The name of this hotel.
   * @return propertyName
  **/
  @ApiModelProperty(required = true, value = "The name of this hotel.")
  public String getPropertyName() {
    return propertyName;
  }

  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  public HotelReservation totalPrice(Amount totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

   /**
   * The total price of this stay, from the given check in date to the given check out date.
   * @return totalPrice
  **/
  @ApiModelProperty(value = "The total price of this stay, from the given check in date to the given check out date.")
  public Amount getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Amount totalPrice) {
    this.totalPrice = totalPrice;
  }

  public HotelReservation travelerIds(List<String> travelerIds) {
    this.travelerIds = travelerIds;
    return this;
  }

  public HotelReservation addTravelerIdsItem(String travelerIdsItem) {
    this.travelerIds.add(travelerIdsItem);
    return this;
  }

   /**
   * Traveler identifiers to indicate the travelers to whom this hotel room reservation applies. Generally all non-infant room occupants will be marked in this array.
   * @return travelerIds
  **/
  @ApiModelProperty(required = true, value = "Traveler identifiers to indicate the travelers to whom this hotel room reservation applies. Generally all non-infant room occupants will be marked in this array.")
  public List<String> getTravelerIds() {
    return travelerIds;
  }

  public void setTravelerIds(List<String> travelerIds) {
    this.travelerIds = travelerIds;
  }

  public HotelReservation bookingInfo(HotelReservationBookingInfo bookingInfo) {
    this.bookingInfo = bookingInfo;
    return this;
  }

   /**
   * Additional details and status of this hotel room reservation.
   * @return bookingInfo
  **/
  @ApiModelProperty(required = true, value = "Additional details and status of this hotel room reservation.")
  public HotelReservationBookingInfo getBookingInfo() {
    return bookingInfo;
  }

  public void setBookingInfo(HotelReservationBookingInfo bookingInfo) {
    this.bookingInfo = bookingInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HotelReservation hotelReservation = (HotelReservation) o;
    return Objects.equals(this.id, hotelReservation.id) &&
        Objects.equals(this.checkIn, hotelReservation.checkIn) &&
        Objects.equals(this.checkOut, hotelReservation.checkOut) &&
        Objects.equals(this.propertyCode, hotelReservation.propertyCode) &&
        Objects.equals(this.propertyName, hotelReservation.propertyName) &&
        Objects.equals(this.totalPrice, hotelReservation.totalPrice) &&
        Objects.equals(this.travelerIds, hotelReservation.travelerIds) &&
        Objects.equals(this.bookingInfo, hotelReservation.bookingInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, checkIn, checkOut, propertyCode, propertyName, totalPrice, travelerIds, bookingInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HotelReservation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    checkIn: ").append(toIndentedString(checkIn)).append("\n");
    sb.append("    checkOut: ").append(toIndentedString(checkOut)).append("\n");
    sb.append("    propertyCode: ").append(toIndentedString(propertyCode)).append("\n");
    sb.append("    propertyName: ").append(toIndentedString(propertyName)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    travelerIds: ").append(toIndentedString(travelerIds)).append("\n");
    sb.append("    bookingInfo: ").append(toIndentedString(bookingInfo)).append("\n");
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


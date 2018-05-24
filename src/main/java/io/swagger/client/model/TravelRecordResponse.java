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
import io.swagger.client.model.Message;
import io.swagger.client.model.Reservation;
import io.swagger.client.model.TravelRecordHeader;
import io.swagger.client.model.Traveler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TravelRecordResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class TravelRecordResponse {
  @SerializedName("record_locator")
  private String recordLocator = null;

  @SerializedName("header")
  private TravelRecordHeader header = null;

  @SerializedName("messages")
  private List<Message> messages = null;

  @SerializedName("travelers")
  private List<Traveler> travelers = null;

  @SerializedName("reservation")
  private Reservation reservation = null;

  public TravelRecordResponse recordLocator(String recordLocator) {
    this.recordLocator = recordLocator;
    return this;
  }

   /**
   * 6 character identifier of this travel record on the Amadeus system.
   * @return recordLocator
  **/
  @ApiModelProperty(required = true, value = "6 character identifier of this travel record on the Amadeus system.")
  public String getRecordLocator() {
    return recordLocator;
  }

  public void setRecordLocator(String recordLocator) {
    this.recordLocator = recordLocator;
  }

  public TravelRecordResponse header(TravelRecordHeader header) {
    this.header = header;
    return this;
  }

   /**
   * Summarized metadata on the record that has been retrieved.
   * @return header
  **/
  @ApiModelProperty(value = "Summarized metadata on the record that has been retrieved.")
  public TravelRecordHeader getHeader() {
    return header;
  }

  public void setHeader(TravelRecordHeader header) {
    this.header = header;
  }

  public TravelRecordResponse messages(List<Message> messages) {
    this.messages = messages;
    return this;
  }

  public TravelRecordResponse addMessagesItem(Message messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<Message>();
    }
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * Functional or technical messages associated with the retrieval of this travel record.
   * @return messages
  **/
  @ApiModelProperty(value = "Functional or technical messages associated with the retrieval of this travel record.")
  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public TravelRecordResponse travelers(List<Traveler> travelers) {
    this.travelers = travelers;
    return this;
  }

  public TravelRecordResponse addTravelersItem(Traveler travelersItem) {
    if (this.travelers == null) {
      this.travelers = new ArrayList<Traveler>();
    }
    this.travelers.add(travelersItem);
    return this;
  }

   /**
   * Information about each traveler who may be included as part of this travel record.
   * @return travelers
  **/
  @ApiModelProperty(value = "Information about each traveler who may be included as part of this travel record.")
  public List<Traveler> getTravelers() {
    return travelers;
  }

  public void setTravelers(List<Traveler> travelers) {
    this.travelers = travelers;
  }

  public TravelRecordResponse reservation(Reservation reservation) {
    this.reservation = reservation;
    return this;
  }

   /**
   * Details about the itineraries that have been reserved as part of this travel record.
   * @return reservation
  **/
  @ApiModelProperty(value = "Details about the itineraries that have been reserved as part of this travel record.")
  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TravelRecordResponse travelRecordResponse = (TravelRecordResponse) o;
    return Objects.equals(this.recordLocator, travelRecordResponse.recordLocator) &&
        Objects.equals(this.header, travelRecordResponse.header) &&
        Objects.equals(this.messages, travelRecordResponse.messages) &&
        Objects.equals(this.travelers, travelRecordResponse.travelers) &&
        Objects.equals(this.reservation, travelRecordResponse.reservation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recordLocator, header, messages, travelers, reservation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TravelRecordResponse {\n");
    
    sb.append("    recordLocator: ").append(toIndentedString(recordLocator)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    travelers: ").append(toIndentedString(travelers)).append("\n");
    sb.append("    reservation: ").append(toIndentedString(reservation)).append("\n");
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


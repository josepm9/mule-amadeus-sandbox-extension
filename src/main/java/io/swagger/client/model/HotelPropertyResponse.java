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
import io.swagger.client.model.Address;
import io.swagger.client.model.Amenity;
import io.swagger.client.model.Amount;
import io.swagger.client.model.Award;
import io.swagger.client.model.Contact;
import io.swagger.client.model.Geolocation;
import io.swagger.client.model.HotelRoom;
import io.swagger.client.model.Image;
import io.swagger.client.model.Link;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * HotelPropertyResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class HotelPropertyResponse {
  @SerializedName("property_code")
  private String propertyCode = null;

  @SerializedName("property_name")
  private String propertyName = null;

  @SerializedName("location")
  private Geolocation location = null;

  @SerializedName("address")
  private Address address = null;

  @SerializedName("total_price")
  private Amount totalPrice = null;

  @SerializedName("min_daily_rate")
  private Amount minDailyRate = null;

  @SerializedName("contacts")
  private List<Contact> contacts = null;

  @SerializedName("amenities")
  private List<Amenity> amenities = null;

  @SerializedName("awards")
  private List<Award> awards = null;

  @SerializedName("images")
  private List<Image> images = null;

  @SerializedName("rooms")
  private List<HotelRoom> rooms = null;

  @SerializedName("more_rooms_at_this_hotel")
  private Link moreRoomsAtThisHotel = null;

  public HotelPropertyResponse propertyCode(String propertyCode) {
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

  public HotelPropertyResponse propertyName(String propertyName) {
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

  public HotelPropertyResponse location(Geolocation location) {
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(required = true, value = "")
  public Geolocation getLocation() {
    return location;
  }

  public void setLocation(Geolocation location) {
    this.location = location;
  }

  public HotelPropertyResponse address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public HotelPropertyResponse totalPrice(Amount totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

   /**
   * The lowest price of a stay, from the given check in date to the given check out date.
   * @return totalPrice
  **/
  @ApiModelProperty(required = true, value = "The lowest price of a stay, from the given check in date to the given check out date.")
  public Amount getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Amount totalPrice) {
    this.totalPrice = totalPrice;
  }

  public HotelPropertyResponse minDailyRate(Amount minDailyRate) {
    this.minDailyRate = minDailyRate;
    return this;
  }

   /**
   * The lowest price per day that the hotel offers between the given check-in and check-out dates. Extra taxes may apply to this rate.
   * @return minDailyRate
  **/
  @ApiModelProperty(required = true, value = "The lowest price per day that the hotel offers between the given check-in and check-out dates. Extra taxes may apply to this rate.")
  public Amount getMinDailyRate() {
    return minDailyRate;
  }

  public void setMinDailyRate(Amount minDailyRate) {
    this.minDailyRate = minDailyRate;
  }

  public HotelPropertyResponse contacts(List<Contact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public HotelPropertyResponse addContactsItem(Contact contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<Contact>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

   /**
   * An array of contact objects to tell the user how to contact the hotel. Typically includes a phone and fax number
   * @return contacts
  **/
  @ApiModelProperty(value = "An array of contact objects to tell the user how to contact the hotel. Typically includes a phone and fax number")
  public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  public HotelPropertyResponse amenities(List<Amenity> amenities) {
    this.amenities = amenities;
    return this;
  }

  public HotelPropertyResponse addAmenitiesItem(Amenity amenitiesItem) {
    if (this.amenities == null) {
      this.amenities = new ArrayList<Amenity>();
    }
    this.amenities.add(amenitiesItem);
    return this;
  }

   /**
   * An array of amenity objects to the user what facilities this hotel might provide, such as a pool or parking.  If this array is empty, it does not necessarily mean that there are no amenities available at this hotel, it could also mean that the hotel does not list their amenities in our search! 
   * @return amenities
  **/
  @ApiModelProperty(value = "An array of amenity objects to the user what facilities this hotel might provide, such as a pool or parking.  If this array is empty, it does not necessarily mean that there are no amenities available at this hotel, it could also mean that the hotel does not list their amenities in our search! ")
  public List<Amenity> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<Amenity> amenities) {
    this.amenities = amenities;
  }

  public HotelPropertyResponse awards(List<Award> awards) {
    this.awards = awards;
    return this;
  }

  public HotelPropertyResponse addAwardsItem(Award awardsItem) {
    if (this.awards == null) {
      this.awards = new ArrayList<Award>();
    }
    this.awards.add(awardsItem);
    return this;
  }

   /**
   * An array of hotel award objects to give the user an expectation of the service quality at this hotel. This can be used to indicate, for example, the star rating of a hotel. If this array is empty, it does not necessarily mean that the hotel has no awards, it could simply mean that they didn&#39;t tell us about them!
   * @return awards
  **/
  @ApiModelProperty(value = "An array of hotel award objects to give the user an expectation of the service quality at this hotel. This can be used to indicate, for example, the star rating of a hotel. If this array is empty, it does not necessarily mean that the hotel has no awards, it could simply mean that they didn't tell us about them!")
  public List<Award> getAwards() {
    return awards;
  }

  public void setAwards(List<Award> awards) {
    this.awards = awards;
  }

  public HotelPropertyResponse images(List<Image> images) {
    this.images = images;
    return this;
  }

  public HotelPropertyResponse addImagesItem(Image imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<Image>();
    }
    this.images.add(imagesItem);
    return this;
  }

   /**
   * A selection of image objects, showing pictures of the hotel building, the entrance or some rooms, to give an indication of what to expect at this hotel. Note that redistribution of images outside Amadeus products requires licensing from our image providers: Leonardo and Ice Portal. Thus image links are returned for whitelisted Amadeus users only.
   * @return images
  **/
  @ApiModelProperty(value = "A selection of image objects, showing pictures of the hotel building, the entrance or some rooms, to give an indication of what to expect at this hotel. Note that redistribution of images outside Amadeus products requires licensing from our image providers: Leonardo and Ice Portal. Thus image links are returned for whitelisted Amadeus users only.")
  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

  public HotelPropertyResponse rooms(List<HotelRoom> rooms) {
    this.rooms = rooms;
    return this;
  }

  public HotelPropertyResponse addRoomsItem(HotelRoom roomsItem) {
    if (this.rooms == null) {
      this.rooms = new ArrayList<HotelRoom>();
    }
    this.rooms.add(roomsItem);
    return this;
  }

   /**
   * Information on currently available rooms at this hotel.
   * @return rooms
  **/
  @ApiModelProperty(value = "Information on currently available rooms at this hotel.")
  public List<HotelRoom> getRooms() {
    return rooms;
  }

  public void setRooms(List<HotelRoom> rooms) {
    this.rooms = rooms;
  }

  public HotelPropertyResponse moreRoomsAtThisHotel(Link moreRoomsAtThisHotel) {
    this.moreRoomsAtThisHotel = moreRoomsAtThisHotel;
    return this;
  }

   /**
   * Provides a ready-to-use link to make a follow up request to find more available rooms at this hotel
   * @return moreRoomsAtThisHotel
  **/
  @ApiModelProperty(value = "Provides a ready-to-use link to make a follow up request to find more available rooms at this hotel")
  public Link getMoreRoomsAtThisHotel() {
    return moreRoomsAtThisHotel;
  }

  public void setMoreRoomsAtThisHotel(Link moreRoomsAtThisHotel) {
    this.moreRoomsAtThisHotel = moreRoomsAtThisHotel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HotelPropertyResponse hotelPropertyResponse = (HotelPropertyResponse) o;
    return Objects.equals(this.propertyCode, hotelPropertyResponse.propertyCode) &&
        Objects.equals(this.propertyName, hotelPropertyResponse.propertyName) &&
        Objects.equals(this.location, hotelPropertyResponse.location) &&
        Objects.equals(this.address, hotelPropertyResponse.address) &&
        Objects.equals(this.totalPrice, hotelPropertyResponse.totalPrice) &&
        Objects.equals(this.minDailyRate, hotelPropertyResponse.minDailyRate) &&
        Objects.equals(this.contacts, hotelPropertyResponse.contacts) &&
        Objects.equals(this.amenities, hotelPropertyResponse.amenities) &&
        Objects.equals(this.awards, hotelPropertyResponse.awards) &&
        Objects.equals(this.images, hotelPropertyResponse.images) &&
        Objects.equals(this.rooms, hotelPropertyResponse.rooms) &&
        Objects.equals(this.moreRoomsAtThisHotel, hotelPropertyResponse.moreRoomsAtThisHotel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyCode, propertyName, location, address, totalPrice, minDailyRate, contacts, amenities, awards, images, rooms, moreRoomsAtThisHotel);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HotelPropertyResponse {\n");
    
    sb.append("    propertyCode: ").append(toIndentedString(propertyCode)).append("\n");
    sb.append("    propertyName: ").append(toIndentedString(propertyName)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    minDailyRate: ").append(toIndentedString(minDailyRate)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    amenities: ").append(toIndentedString(amenities)).append("\n");
    sb.append("    awards: ").append(toIndentedString(awards)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("    rooms: ").append(toIndentedString(rooms)).append("\n");
    sb.append("    moreRoomsAtThisHotel: ").append(toIndentedString(moreRoomsAtThisHotel)).append("\n");
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

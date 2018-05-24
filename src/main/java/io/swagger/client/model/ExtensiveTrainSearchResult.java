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
import io.swagger.client.model.Station;
import io.swagger.client.model.TrainSearchItinerary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ExtensiveTrainSearchResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class ExtensiveTrainSearchResult {
  @SerializedName("origin")
  private Station origin = null;

  @SerializedName("destination")
  private Station destination = null;

  @SerializedName("itineraries")
  private List<TrainSearchItinerary> itineraries = new ArrayList<TrainSearchItinerary>();

  public ExtensiveTrainSearchResult origin(Station origin) {
    this.origin = origin;
    return this;
  }

   /**
   * Station object with details about the origin station for this search.
   * @return origin
  **/
  @ApiModelProperty(required = true, value = "Station object with details about the origin station for this search.")
  public Station getOrigin() {
    return origin;
  }

  public void setOrigin(Station origin) {
    this.origin = origin;
  }

  public ExtensiveTrainSearchResult destination(Station destination) {
    this.destination = destination;
    return this;
  }

   /**
   * Station object with details about the destination station for this search.
   * @return destination
  **/
  @ApiModelProperty(required = true, value = "Station object with details about the destination station for this search.")
  public Station getDestination() {
    return destination;
  }

  public void setDestination(Station destination) {
    this.destination = destination;
  }

  public ExtensiveTrainSearchResult itineraries(List<TrainSearchItinerary> itineraries) {
    this.itineraries = itineraries;
    return this;
  }

  public ExtensiveTrainSearchResult addItinerariesItem(TrainSearchItinerary itinerariesItem) {
    this.itineraries.add(itinerariesItem);
    return this;
  }

   /**
   * Routes from the origin to the destination.
   * @return itineraries
  **/
  @ApiModelProperty(required = true, value = "Routes from the origin to the destination.")
  public List<TrainSearchItinerary> getItineraries() {
    return itineraries;
  }

  public void setItineraries(List<TrainSearchItinerary> itineraries) {
    this.itineraries = itineraries;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtensiveTrainSearchResult extensiveTrainSearchResult = (ExtensiveTrainSearchResult) o;
    return Objects.equals(this.origin, extensiveTrainSearchResult.origin) &&
        Objects.equals(this.destination, extensiveTrainSearchResult.destination) &&
        Objects.equals(this.itineraries, extensiveTrainSearchResult.itineraries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(origin, destination, itineraries);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtensiveTrainSearchResult {\n");
    
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    itineraries: ").append(toIndentedString(itineraries)).append("\n");
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

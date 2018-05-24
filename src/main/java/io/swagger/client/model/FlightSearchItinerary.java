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
import io.swagger.client.model.FlightSearchBound;
import java.io.IOException;

/**
 * FlightSearchItinerary
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class FlightSearchItinerary {
  @SerializedName("outbound")
  private FlightSearchBound outbound = null;

  @SerializedName("inbound")
  private FlightSearchBound inbound = null;

  public FlightSearchItinerary outbound(FlightSearchBound outbound) {
    this.outbound = outbound;
    return this;
  }

   /**
   * The bound container for the flight information for bringing the traveler from the origin airport to the destination airport
   * @return outbound
  **/
  @ApiModelProperty(required = true, value = "The bound container for the flight information for bringing the traveler from the origin airport to the destination airport")
  public FlightSearchBound getOutbound() {
    return outbound;
  }

  public void setOutbound(FlightSearchBound outbound) {
    this.outbound = outbound;
  }

  public FlightSearchItinerary inbound(FlightSearchBound inbound) {
    this.inbound = inbound;
    return this;
  }

   /**
   * The bound container for the flight information for bringing the traveler from the destination airport to the origin airport
   * @return inbound
  **/
  @ApiModelProperty(value = "The bound container for the flight information for bringing the traveler from the destination airport to the origin airport")
  public FlightSearchBound getInbound() {
    return inbound;
  }

  public void setInbound(FlightSearchBound inbound) {
    this.inbound = inbound;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlightSearchItinerary flightSearchItinerary = (FlightSearchItinerary) o;
    return Objects.equals(this.outbound, flightSearchItinerary.outbound) &&
        Objects.equals(this.inbound, flightSearchItinerary.inbound);
  }

  @Override
  public int hashCode() {
    return Objects.hash(outbound, inbound);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlightSearchItinerary {\n");
    
    sb.append("    outbound: ").append(toIndentedString(outbound)).append("\n");
    sb.append("    inbound: ").append(toIndentedString(inbound)).append("\n");
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


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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RailService
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class RailService {
  @SerializedName("destination_station_id")
  private String destinationStationId = null;

  @SerializedName("services")
  private List<String> services = new ArrayList<String>();

  public RailService destinationStationId(String destinationStationId) {
    this.destinationStationId = destinationStationId;
    return this;
  }

   /**
   * ID of the destination rail station.
   * @return destinationStationId
  **/
  @ApiModelProperty(required = true, value = "ID of the destination rail station.")
  public String getDestinationStationId() {
    return destinationStationId;
  }

  public void setDestinationStationId(String destinationStationId) {
    this.destinationStationId = destinationStationId;
  }

  public RailService services(List<String> services) {
    this.services = services;
    return this;
  }

  public RailService addServicesItem(String servicesItem) {
    this.services.add(servicesItem);
    return this;
  }

   /**
   * An array of departure times at which trains depart from the origin station to this destination station. Times are in the ISO 8601 YYYY-MM-DDTHH:mm format.
   * @return services
  **/
  @ApiModelProperty(required = true, value = "An array of departure times at which trains depart from the origin station to this destination station. Times are in the ISO 8601 YYYY-MM-DDTHH:mm format.")
  public List<String> getServices() {
    return services;
  }

  public void setServices(List<String> services) {
    this.services = services;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RailService railService = (RailService) o;
    return Objects.equals(this.destinationStationId, railService.destinationStationId) &&
        Objects.equals(this.services, railService.services);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationStationId, services);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RailService {\n");
    
    sb.append("    destinationStationId: ").append(toIndentedString(destinationStationId)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
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


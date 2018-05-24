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
import io.swagger.client.model.AirportInformation;
import io.swagger.client.model.CityInformation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * LocationResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class LocationResponse {
  @SerializedName("city")
  private CityInformation city = null;

  @SerializedName("airports")
  private List<AirportInformation> airports = null;

  public LocationResponse city(CityInformation city) {
    this.city = city;
    return this;
  }

   /**
   * Information for any &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city which corresponds to the provided code
   * @return city
  **/
  @ApiModelProperty(value = "Information for any <a href=\"https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\">IATA code</a> of the city which corresponds to the provided code")
  public CityInformation getCity() {
    return city;
  }

  public void setCity(CityInformation city) {
    this.city = city;
  }

  public LocationResponse airports(List<AirportInformation> airports) {
    this.airports = airports;
    return this;
  }

  public LocationResponse addAirportsItem(AirportInformation airportsItem) {
    if (this.airports == null) {
      this.airports = new ArrayList<AirportInformation>();
    }
    this.airports.add(airportsItem);
    return this;
  }

   /**
   * Information for any IATA airport located in the provided &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city or which corresponds to the provided code
   * @return airports
  **/
  @ApiModelProperty(value = "Information for any IATA airport located in the provided <a href=\"https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\">IATA code</a> of the city or which corresponds to the provided code")
  public List<AirportInformation> getAirports() {
    return airports;
  }

  public void setAirports(List<AirportInformation> airports) {
    this.airports = airports;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationResponse locationResponse = (LocationResponse) o;
    return Objects.equals(this.city, locationResponse.city) &&
        Objects.equals(this.airports, locationResponse.airports);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, airports);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationResponse {\n");
    
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    airports: ").append(toIndentedString(airports)).append("\n");
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

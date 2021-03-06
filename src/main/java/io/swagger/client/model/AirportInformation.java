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
import io.swagger.client.model.Geolocation;
import java.io.IOException;

/**
 * AirportInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class AirportInformation {
  @SerializedName("code")
  private String code = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("city_code")
  private String cityCode = null;

  @SerializedName("city_name")
  private String cityName = null;

  @SerializedName("state")
  private String state = null;

  @SerializedName("country")
  private String country = null;

  @SerializedName("location")
  private Geolocation location = null;

  @SerializedName("aircraft_movements")
  private Integer aircraftMovements = null;

  @SerializedName("timezone")
  private String timezone = null;

  public AirportInformation code(String code) {
    this.code = code;
    return this;
  }

   /**
   * The 3 letter IATA airport code of this given airport. You can use this as an input parameter for a low-fare flight search, to get more specific results than the city code, but inspiration search works best using the city code.
   * @return code
  **/
  @ApiModelProperty(required = true, value = "The 3 letter IATA airport code of this given airport. You can use this as an input parameter for a low-fare flight search, to get more specific results than the city code, but inspiration search works best using the city code.")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public AirportInformation name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of this airport, in UTF-8 format
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of this airport, in UTF-8 format")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AirportInformation cityCode(String cityCode) {
    this.cityCode = cityCode;
    return this;
  }

   /**
   * The three letter &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city of the city in which this airport is located.
   * @return cityCode
  **/
  @ApiModelProperty(required = true, value = "The three letter <a href=\"https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\">IATA code</a> of the city of the city in which this airport is located.")
  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public AirportInformation cityName(String cityName) {
    this.cityName = cityName;
    return this;
  }

   /**
   * The English name of the city in which this airport is located
   * @return cityName
  **/
  @ApiModelProperty(required = true, value = "The English name of the city in which this airport is located")
  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public AirportInformation state(String state) {
    this.state = state;
    return this;
  }

   /**
   * The state code of this city, if applicable
   * @return state
  **/
  @ApiModelProperty(value = "The state code of this city, if applicable")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public AirportInformation country(String country) {
    this.country = country;
    return this;
  }

   /**
   * The &lt;a href&#x3D;\&quot;http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2\&quot;&gt;ISO 3166-1 alpha-2 country code&lt;/a&gt; in which this city can be found.
   * @return country
  **/
  @ApiModelProperty(required = true, value = "The <a href=\"http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2\">ISO 3166-1 alpha-2 country code</a> in which this city can be found.")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public AirportInformation location(Geolocation location) {
    this.location = location;
    return this;
  }

   /**
   *   An object containing the longitude and latitude of the given airport.
   * @return location
  **/
  @ApiModelProperty(required = true, value = "  An object containing the longitude and latitude of the given airport.")
  public Geolocation getLocation() {
    return location;
  }

  public void setLocation(Geolocation location) {
    this.location = location;
  }

  public AirportInformation aircraftMovements(Integer aircraftMovements) {
    this.aircraftMovements = aircraftMovements;
    return this;
  }

   /**
   * The annual number of aircraft movements at that airport.
   * @return aircraftMovements
  **/
  @ApiModelProperty(value = "The annual number of aircraft movements at that airport.")
  public Integer getAircraftMovements() {
    return aircraftMovements;
  }

  public void setAircraftMovements(Integer aircraftMovements) {
    this.aircraftMovements = aircraftMovements;
  }

  public AirportInformation timezone(String timezone) {
    this.timezone = timezone;
    return this;
  }

   /**
   * The &lt;a href&#x3D;\&quot;http://en.wikipedia.org/wiki/List_of_tz_database_time_zones\&quot;&gt;Olson format&lt;/a&gt; name of the timezone in which this airport is located
   * @return timezone
  **/
  @ApiModelProperty(required = true, value = "The <a href=\"http://en.wikipedia.org/wiki/List_of_tz_database_time_zones\">Olson format</a> name of the timezone in which this airport is located")
  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AirportInformation airportInformation = (AirportInformation) o;
    return Objects.equals(this.code, airportInformation.code) &&
        Objects.equals(this.name, airportInformation.name) &&
        Objects.equals(this.cityCode, airportInformation.cityCode) &&
        Objects.equals(this.cityName, airportInformation.cityName) &&
        Objects.equals(this.state, airportInformation.state) &&
        Objects.equals(this.country, airportInformation.country) &&
        Objects.equals(this.location, airportInformation.location) &&
        Objects.equals(this.aircraftMovements, airportInformation.aircraftMovements) &&
        Objects.equals(this.timezone, airportInformation.timezone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, cityCode, cityName, state, country, location, aircraftMovements, timezone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AirportInformation {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cityCode: ").append(toIndentedString(cityCode)).append("\n");
    sb.append("    cityName: ").append(toIndentedString(cityName)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    aircraftMovements: ").append(toIndentedString(aircraftMovements)).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
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


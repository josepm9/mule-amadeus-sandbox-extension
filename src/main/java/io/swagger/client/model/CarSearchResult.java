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
import io.swagger.client.model.Company;
import io.swagger.client.model.Geolocation;
import io.swagger.client.model.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CarSearchResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class CarSearchResult {
  @SerializedName("provider")
  private Company provider = null;

  @SerializedName("location")
  private Geolocation location = null;

  @SerializedName("airport")
  private String airport = null;

  @SerializedName("cars")
  private List<Vehicle> cars = null;

  public CarSearchResult provider(Company provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Details of the car company offering this rental.
   * @return provider
  **/
  @ApiModelProperty(required = true, value = "Details of the car company offering this rental.")
  public Company getProvider() {
    return provider;
  }

  public void setProvider(Company provider) {
    this.provider = provider;
  }

  public CarSearchResult location(Geolocation location) {
    this.location = location;
    return this;
  }

   /**
   * This car rental company&#39;s approximate geolocation. The exact quality of this parameter depends on the provider but it&#39;s usually quite accurate.
   * @return location
  **/
  @ApiModelProperty(value = "This car rental company's approximate geolocation. The exact quality of this parameter depends on the provider but it's usually quite accurate.")
  public Geolocation getLocation() {
    return location;
  }

  public void setLocation(Geolocation location) {
    this.location = location;
  }

  public CarSearchResult airport(String airport) {
    this.airport = airport;
    return this;
  }

   /**
   * The exact quality of this parameter depends on the provider but it&#39;s usually quite accurate.
   * @return airport
  **/
  @ApiModelProperty(value = "The exact quality of this parameter depends on the provider but it's usually quite accurate.")
  public String getAirport() {
    return airport;
  }

  public void setAirport(String airport) {
    this.airport = airport;
  }

  public CarSearchResult cars(List<Vehicle> cars) {
    this.cars = cars;
    return this;
  }

  public CarSearchResult addCarsItem(Vehicle carsItem) {
    if (this.cars == null) {
      this.cars = new ArrayList<Vehicle>();
    }
    this.cars.add(carsItem);
    return this;
  }

   /**
   * Further details about each of the vehicles offered by this car rental provider.
   * @return cars
  **/
  @ApiModelProperty(value = "Further details about each of the vehicles offered by this car rental provider.")
  public List<Vehicle> getCars() {
    return cars;
  }

  public void setCars(List<Vehicle> cars) {
    this.cars = cars;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarSearchResult carSearchResult = (CarSearchResult) o;
    return Objects.equals(this.provider, carSearchResult.provider) &&
        Objects.equals(this.location, carSearchResult.location) &&
        Objects.equals(this.airport, carSearchResult.airport) &&
        Objects.equals(this.cars, carSearchResult.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(provider, location, airport, cars);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarSearchResult {\n");
    
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    airport: ").append(toIndentedString(airport)).append("\n");
    sb.append("    cars: ").append(toIndentedString(cars)).append("\n");
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


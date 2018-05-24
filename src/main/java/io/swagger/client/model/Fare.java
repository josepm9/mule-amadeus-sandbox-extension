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

/**
 * Fare
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class Fare {
  @SerializedName("total_fare")
  private String totalFare = null;

  @SerializedName("tax")
  private String tax = null;

  public Fare totalFare(String totalFare) {
    this.totalFare = totalFare;
    return this;
  }

   /**
   * The total price, including taxes per-passenger, for this passenger type, for this itinerary. Always a string, formatted correctly for the given currency
   * @return totalFare
  **/
  @ApiModelProperty(required = true, value = "The total price, including taxes per-passenger, for this passenger type, for this itinerary. Always a string, formatted correctly for the given currency")
  public String getTotalFare() {
    return totalFare;
  }

  public void setTotalFare(String totalFare) {
    this.totalFare = totalFare;
  }

  public Fare tax(String tax) {
    this.tax = tax;
    return this;
  }

   /**
   * The tax applied per-passenger, for this passenger type, for this itinerary. Some of this tax may be refundable in the event of cancellation.
   * @return tax
  **/
  @ApiModelProperty(required = true, value = "The tax applied per-passenger, for this passenger type, for this itinerary. Some of this tax may be refundable in the event of cancellation.")
  public String getTax() {
    return tax;
  }

  public void setTax(String tax) {
    this.tax = tax;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fare fare = (Fare) o;
    return Objects.equals(this.totalFare, fare.totalFare) &&
        Objects.equals(this.tax, fare.tax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalFare, tax);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fare {\n");
    
    sb.append("    totalFare: ").append(toIndentedString(totalFare)).append("\n");
    sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
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


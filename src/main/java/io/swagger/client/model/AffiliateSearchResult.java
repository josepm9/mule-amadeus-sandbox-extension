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
import io.swagger.client.model.AffiliateFlightSearchPrice;
import io.swagger.client.model.AffiliatePayout;
import io.swagger.client.model.FlightSearchBound;
import java.io.IOException;

/**
 * AffiliateSearchResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class AffiliateSearchResult {
  @SerializedName("outbound")
  private FlightSearchBound outbound = null;

  @SerializedName("inbound")
  private FlightSearchBound inbound = null;

  @SerializedName("fare")
  private AffiliateFlightSearchPrice fare = null;

  @SerializedName("payout")
  private AffiliatePayout payout = null;

  @SerializedName("airline")
  private String airline = null;

  @SerializedName("deep_link")
  private String deepLink = null;

  public AffiliateSearchResult outbound(FlightSearchBound outbound) {
    this.outbound = outbound;
    return this;
  }

   /**
   * The flight from the origin to the destination
   * @return outbound
  **/
  @ApiModelProperty(required = true, value = "The flight from the origin to the destination")
  public FlightSearchBound getOutbound() {
    return outbound;
  }

  public void setOutbound(FlightSearchBound outbound) {
    this.outbound = outbound;
  }

  public AffiliateSearchResult inbound(FlightSearchBound inbound) {
    this.inbound = inbound;
    return this;
  }

   /**
   * The return flight from the destination to the origin
   * @return inbound
  **/
  @ApiModelProperty(value = "The return flight from the destination to the origin")
  public FlightSearchBound getInbound() {
    return inbound;
  }

  public void setInbound(FlightSearchBound inbound) {
    this.inbound = inbound;
  }

  public AffiliateSearchResult fare(AffiliateFlightSearchPrice fare) {
    this.fare = fare;
    return this;
  }

   /**
   * The price and fare information which applies to all itineraries in this response
   * @return fare
  **/
  @ApiModelProperty(required = true, value = "The price and fare information which applies to all itineraries in this response")
  public AffiliateFlightSearchPrice getFare() {
    return fare;
  }

  public void setFare(AffiliateFlightSearchPrice fare) {
    this.fare = fare;
  }

  public AffiliateSearchResult payout(AffiliatePayout payout) {
    this.payout = payout;
    return this;
  }

   /**
   * Details of the amount of payout that the affiliate will received per click or if this flight is sold
   * @return payout
  **/
  @ApiModelProperty(required = true, value = "Details of the amount of payout that the affiliate will received per click or if this flight is sold")
  public AffiliatePayout getPayout() {
    return payout;
  }

  public void setPayout(AffiliatePayout payout) {
    this.payout = payout;
  }

  public AffiliateSearchResult airline(String airline) {
    this.airline = airline;
    return this;
  }

   /**
   * The 2 character alphanumeric &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;IATA airline code&lt;/a&gt; of the airline that is selling this result
   * @return airline
  **/
  @ApiModelProperty(required = true, value = "The 2 character alphanumeric <a href=\"https://en.wikipedia.org/wiki/Airline_codes\">IATA airline code</a> of the airline that is selling this result")
  public String getAirline() {
    return airline;
  }

  public void setAirline(String airline) {
    this.airline = airline;
  }

  public AffiliateSearchResult deepLink(String deepLink) {
    this.deepLink = deepLink;
    return this;
  }

   /**
   * A link to the page from which this result can be purchased from the affiliate
   * @return deepLink
  **/
  @ApiModelProperty(required = true, value = "A link to the page from which this result can be purchased from the affiliate")
  public String getDeepLink() {
    return deepLink;
  }

  public void setDeepLink(String deepLink) {
    this.deepLink = deepLink;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AffiliateSearchResult affiliateSearchResult = (AffiliateSearchResult) o;
    return Objects.equals(this.outbound, affiliateSearchResult.outbound) &&
        Objects.equals(this.inbound, affiliateSearchResult.inbound) &&
        Objects.equals(this.fare, affiliateSearchResult.fare) &&
        Objects.equals(this.payout, affiliateSearchResult.payout) &&
        Objects.equals(this.airline, affiliateSearchResult.airline) &&
        Objects.equals(this.deepLink, affiliateSearchResult.deepLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(outbound, inbound, fare, payout, airline, deepLink);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AffiliateSearchResult {\n");
    
    sb.append("    outbound: ").append(toIndentedString(outbound)).append("\n");
    sb.append("    inbound: ").append(toIndentedString(inbound)).append("\n");
    sb.append("    fare: ").append(toIndentedString(fare)).append("\n");
    sb.append("    payout: ").append(toIndentedString(payout)).append("\n");
    sb.append("    airline: ").append(toIndentedString(airline)).append("\n");
    sb.append("    deepLink: ").append(toIndentedString(deepLink)).append("\n");
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


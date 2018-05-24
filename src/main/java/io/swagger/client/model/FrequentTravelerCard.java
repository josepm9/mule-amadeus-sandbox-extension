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
 * FrequentTravelerCard
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class FrequentTravelerCard {
  @SerializedName("issuer_type")
  private String issuerType = null;

  @SerializedName("company_code")
  private String companyCode = null;

  @SerializedName("card_number")
  private String cardNumber = null;

  public FrequentTravelerCard issuerType(String issuerType) {
    this.issuerType = issuerType;
    return this;
  }

   /**
   * The type of organization that issued the card. This is an enumeration, possible values are AIRLINE, HOTEL_CHAIN, RENTAL_CAR_PROVIDER, RAILWAY.
   * @return issuerType
  **/
  @ApiModelProperty(required = true, value = "The type of organization that issued the card. This is an enumeration, possible values are AIRLINE, HOTEL_CHAIN, RENTAL_CAR_PROVIDER, RAILWAY.")
  public String getIssuerType() {
    return issuerType;
  }

  public void setIssuerType(String issuerType) {
    this.issuerType = issuerType;
  }

  public FrequentTravelerCard companyCode(String companyCode) {
    this.companyCode = companyCode;
    return this;
  }

   /**
   * The identifying code of the issuer, within the context of its type. For example&amp;colon; BA (and if the issuer type is AIRLINE, this indicates BA&#x3D;British Airways).
   * @return companyCode
  **/
  @ApiModelProperty(required = true, value = "The identifying code of the issuer, within the context of its type. For example&colon; BA (and if the issuer type is AIRLINE, this indicates BA=British Airways).")
  public String getCompanyCode() {
    return companyCode;
  }

  public void setCompanyCode(String companyCode) {
    this.companyCode = companyCode;
  }

  public FrequentTravelerCard cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

   /**
   * The identifying number (or string) marked on the card. For example&amp;colon; 12345678.
   * @return cardNumber
  **/
  @ApiModelProperty(required = true, value = "The identifying number (or string) marked on the card. For example&colon; 12345678.")
  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FrequentTravelerCard frequentTravelerCard = (FrequentTravelerCard) o;
    return Objects.equals(this.issuerType, frequentTravelerCard.issuerType) &&
        Objects.equals(this.companyCode, frequentTravelerCard.companyCode) &&
        Objects.equals(this.cardNumber, frequentTravelerCard.cardNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issuerType, companyCode, cardNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FrequentTravelerCard {\n");
    
    sb.append("    issuerType: ").append(toIndentedString(issuerType)).append("\n");
    sb.append("    companyCode: ").append(toIndentedString(companyCode)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
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


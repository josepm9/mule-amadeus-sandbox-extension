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
 * RestrictedRate
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class RestrictedRate {
  @SerializedName("rate_code")
  private String rateCode = null;

  @SerializedName("rate_name")
  private String rateName = null;

  @SerializedName("restrictions")
  private String restrictions = null;

  public RestrictedRate rateCode(String rateCode) {
    this.rateCode = rateCode;
    return this;
  }

   /**
   * The unique identifier of this rate.
   * @return rateCode
  **/
  @ApiModelProperty(required = true, value = "The unique identifier of this rate.")
  public String getRateCode() {
    return rateCode;
  }

  public void setRateCode(String rateCode) {
    this.rateCode = rateCode;
  }

  public RestrictedRate rateName(String rateName) {
    this.rateName = rateName;
    return this;
  }

   /**
   * The name used by the company to describe this rate.
   * @return rateName
  **/
  @ApiModelProperty(required = true, value = "The name used by the company to describe this rate.")
  public String getRateName() {
    return rateName;
  }

  public void setRateName(String rateName) {
    this.rateName = rateName;
  }

  public RestrictedRate restrictions(String restrictions) {
    this.restrictions = restrictions;
    return this;
  }

   /**
   * An enumeration of the type of restrictions associated with this rate.
   * @return restrictions
  **/
  @ApiModelProperty(required = true, value = "An enumeration of the type of restrictions associated with this rate.")
  public String getRestrictions() {
    return restrictions;
  }

  public void setRestrictions(String restrictions) {
    this.restrictions = restrictions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestrictedRate restrictedRate = (RestrictedRate) o;
    return Objects.equals(this.rateCode, restrictedRate.rateCode) &&
        Objects.equals(this.rateName, restrictedRate.rateName) &&
        Objects.equals(this.restrictions, restrictedRate.restrictions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rateCode, rateName, restrictions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestrictedRate {\n");
    
    sb.append("    rateCode: ").append(toIndentedString(rateCode)).append("\n");
    sb.append("    rateName: ").append(toIndentedString(rateName)).append("\n");
    sb.append("    restrictions: ").append(toIndentedString(restrictions)).append("\n");
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


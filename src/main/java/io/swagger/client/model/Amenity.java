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
 * Amenity
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class Amenity {
  @SerializedName("amenity")
  private String amenity = null;

  @SerializedName("ota_code")
  private String otaCode = null;

  @SerializedName("description")
  private String description = null;

  public Amenity amenity(String amenity) {
    this.amenity = amenity;
    return this;
  }

   /**
   * &lt;a href&#x3D;\&quot;hotels-api-supported-amenities-filter\&quot;&gt;The amenity code&lt;/a&gt;
   * @return amenity
  **/
  @ApiModelProperty(value = "<a href=\"hotels-api-supported-amenities-filter\">The amenity code</a>")
  public String getAmenity() {
    return amenity;
  }

  public void setAmenity(String amenity) {
    this.amenity = amenity;
  }

  public Amenity otaCode(String otaCode) {
    this.otaCode = otaCode;
    return this;
  }

   /**
   * The &lt;a href&#x3D;\&quot;http://www.opentravel.org/\&quot;&gt;Open Travel Alliance&lt;/a&gt; &lt;a href&#x3D;\&quot;ota-hotel-amenity-code-table\&quot;&gt;Hotel Amenities Code&lt;/a&gt; for this amenity.
   * @return otaCode
  **/
  @ApiModelProperty(value = "The <a href=\"http://www.opentravel.org/\">Open Travel Alliance</a> <a href=\"ota-hotel-amenity-code-table\">Hotel Amenities Code</a> for this amenity.")
  public String getOtaCode() {
    return otaCode;
  }

  public void setOtaCode(String otaCode) {
    this.otaCode = otaCode;
  }

  public Amenity description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The decoded text description for this amenity code, where available.
   * @return description
  **/
  @ApiModelProperty(value = "The decoded text description for this amenity code, where available.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amenity amenity = (Amenity) o;
    return Objects.equals(this.amenity, amenity.amenity) &&
        Objects.equals(this.otaCode, amenity.otaCode) &&
        Objects.equals(this.description, amenity.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amenity, otaCode, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amenity {\n");
    
    sb.append("    amenity: ").append(toIndentedString(amenity)).append("\n");
    sb.append("    otaCode: ").append(toIndentedString(otaCode)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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


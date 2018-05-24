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
 * Logos
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class Logos {
  @SerializedName("small")
  private String small = null;

  @SerializedName("medium")
  private String medium = null;

  public Logos small(String small) {
    this.small = small;
    return this;
  }

   /**
   * URL to logo of resolution 27x27px
   * @return small
  **/
  @ApiModelProperty(value = "URL to logo of resolution 27x27px")
  public String getSmall() {
    return small;
  }

  public void setSmall(String small) {
    this.small = small;
  }

  public Logos medium(String medium) {
    this.medium = medium;
    return this;
  }

   /**
   * URL to logo of resolution 60x60px
   * @return medium
  **/
  @ApiModelProperty(value = "URL to logo of resolution 60x60px")
  public String getMedium() {
    return medium;
  }

  public void setMedium(String medium) {
    this.medium = medium;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Logos logos = (Logos) o;
    return Objects.equals(this.small, logos.small) &&
        Objects.equals(this.medium, logos.medium);
  }

  @Override
  public int hashCode() {
    return Objects.hash(small, medium);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Logos {\n");
    
    sb.append("    small: ").append(toIndentedString(small)).append("\n");
    sb.append("    medium: ").append(toIndentedString(medium)).append("\n");
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


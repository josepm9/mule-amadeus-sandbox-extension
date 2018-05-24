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
 * Award
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class Award {
  @SerializedName("provider")
  private String provider = null;

  @SerializedName("rating")
  private String rating = null;

  public Award provider(String provider) {
    this.provider = provider;
    return this;
  }

   /**
   * The organization that issued the award. For example&amp;colon;. Local Star Rating, AAA.
   * @return provider
  **/
  @ApiModelProperty(required = true, value = "The organization that issued the award. For example&colon;. Local Star Rating, AAA.")
  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public Award rating(String rating) {
    this.rating = rating;
    return this;
  }

   /**
   * The level of the award that was awarded on the provider&#39;s scale. For example&amp;colon; 4 or RECOMMENDED.
   * @return rating
  **/
  @ApiModelProperty(required = true, value = "The level of the award that was awarded on the provider's scale. For example&colon; 4 or RECOMMENDED.")
  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Award award = (Award) o;
    return Objects.equals(this.provider, award.provider) &&
        Objects.equals(this.rating, award.rating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(provider, rating);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Award {\n");
    
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
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


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
 * Contact
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-24T09:42:17.291Z")
public class Contact {
  @SerializedName("type")
  private String type = null;

  @SerializedName("purpose")
  private String purpose = null;

  @SerializedName("detail")
  private String detail = null;

  public Contact type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The method of contact, such as phone or fax.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The method of contact, such as phone or fax.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Contact purpose(String purpose) {
    this.purpose = purpose;
    return this;
  }

   /**
   * The reason or channel of that contact method. For example&amp;colon; HOME, EMERGENCY, MOBILE.
   * @return purpose
  **/
  @ApiModelProperty(value = "The reason or channel of that contact method. For example&colon; HOME, EMERGENCY, MOBILE.")
  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public Contact detail(String detail) {
    this.detail = detail;
    return this;
  }

   /**
   * How that contact should be used, eg. a phone number
   * @return detail
  **/
  @ApiModelProperty(required = true, value = "How that contact should be used, eg. a phone number")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.type, contact.type) &&
        Objects.equals(this.purpose, contact.purpose) &&
        Objects.equals(this.detail, contact.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, purpose, detail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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


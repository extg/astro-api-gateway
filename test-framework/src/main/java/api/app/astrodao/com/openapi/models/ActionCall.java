/*
 * Sputnik v2 API
 * Sputnik v2 API Backend Server
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package api.app.astrodao.com.openapi.models;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ActionCall
 */
@JsonPropertyOrder({
  ActionCall.JSON_PROPERTY_METHOD_NAME,
  ActionCall.JSON_PROPERTY_ARGS,
  ActionCall.JSON_PROPERTY_DEPOSIT,
  ActionCall.JSON_PROPERTY_GAS
})
@JsonTypeName("ActionCall")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-23T12:57:16.263593+02:00[Europe/Kiev]")
public class ActionCall {
  public static final String JSON_PROPERTY_METHOD_NAME = "methodName";
  private BigDecimal methodName;

  public static final String JSON_PROPERTY_ARGS = "args";
  private String args;

  public static final String JSON_PROPERTY_DEPOSIT = "deposit";
  private String deposit;

  public static final String JSON_PROPERTY_GAS = "gas";
  private String gas;

  public ActionCall() { 
  }

  public ActionCall methodName(BigDecimal methodName) {
    
    this.methodName = methodName;
    return this;
  }

   /**
   * Get methodName
   * @return methodName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_METHOD_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getMethodName() {
    return methodName;
  }


  @JsonProperty(JSON_PROPERTY_METHOD_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMethodName(BigDecimal methodName) {
    this.methodName = methodName;
  }


  public ActionCall args(String args) {
    
    this.args = args;
    return this;
  }

   /**
   * Get args
   * @return args
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ARGS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getArgs() {
    return args;
  }


  @JsonProperty(JSON_PROPERTY_ARGS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setArgs(String args) {
    this.args = args;
  }


  public ActionCall deposit(String deposit) {
    
    this.deposit = deposit;
    return this;
  }

   /**
   * Get deposit
   * @return deposit
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DEPOSIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDeposit() {
    return deposit;
  }


  @JsonProperty(JSON_PROPERTY_DEPOSIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDeposit(String deposit) {
    this.deposit = deposit;
  }


  public ActionCall gas(String gas) {
    
    this.gas = gas;
    return this;
  }

   /**
   * Get gas
   * @return gas
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_GAS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGas() {
    return gas;
  }


  @JsonProperty(JSON_PROPERTY_GAS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGas(String gas) {
    this.gas = gas;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActionCall actionCall = (ActionCall) o;
    return Objects.equals(this.methodName, actionCall.methodName) &&
        Objects.equals(this.args, actionCall.args) &&
        Objects.equals(this.deposit, actionCall.deposit) &&
        Objects.equals(this.gas, actionCall.gas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(methodName, args, deposit, gas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionCall {\n");
    sb.append("    methodName: ").append(toIndentedString(methodName)).append("\n");
    sb.append("    args: ").append(toIndentedString(args)).append("\n");
    sb.append("    deposit: ").append(toIndentedString(deposit)).append("\n");
    sb.append("    gas: ").append(toIndentedString(gas)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


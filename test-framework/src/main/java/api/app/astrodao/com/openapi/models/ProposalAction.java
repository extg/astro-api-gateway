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
 * ProposalAction
 */
@JsonPropertyOrder({
  ProposalAction.JSON_PROPERTY_ID,
  ProposalAction.JSON_PROPERTY_PROPOSAL_ID,
  ProposalAction.JSON_PROPERTY_ACCOUNT_ID,
  ProposalAction.JSON_PROPERTY_ACTION,
  ProposalAction.JSON_PROPERTY_TRANSACTION_HASH,
  ProposalAction.JSON_PROPERTY_TIMESTAMP
})
@JsonTypeName("ProposalAction")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-23T12:57:16.263593+02:00[Europe/Kiev]")
public class ProposalAction {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_PROPOSAL_ID = "proposalId";
  private String proposalId;

  public static final String JSON_PROPERTY_ACCOUNT_ID = "accountId";
  private String accountId;

  public static final String JSON_PROPERTY_ACTION = "action";
  private Object action;

  public static final String JSON_PROPERTY_TRANSACTION_HASH = "transactionHash";
  private String transactionHash;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private BigDecimal timestamp;

  public ProposalAction() { 
  }

  public ProposalAction id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public ProposalAction proposalId(String proposalId) {
    
    this.proposalId = proposalId;
    return this;
  }

   /**
   * Get proposalId
   * @return proposalId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PROPOSAL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getProposalId() {
    return proposalId;
  }


  @JsonProperty(JSON_PROPERTY_PROPOSAL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProposalId(String proposalId) {
    this.proposalId = proposalId;
  }


  public ProposalAction accountId(String accountId) {
    
    this.accountId = accountId;
    return this;
  }

   /**
   * Get accountId
   * @return accountId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccountId() {
    return accountId;
  }


  @JsonProperty(JSON_PROPERTY_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }


  public ProposalAction action(Object action) {
    
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getAction() {
    return action;
  }


  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAction(Object action) {
    this.action = action;
  }


  public ProposalAction transactionHash(String transactionHash) {
    
    this.transactionHash = transactionHash;
    return this;
  }

   /**
   * Get transactionHash
   * @return transactionHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TRANSACTION_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTransactionHash() {
    return transactionHash;
  }


  @JsonProperty(JSON_PROPERTY_TRANSACTION_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTransactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
  }


  public ProposalAction timestamp(BigDecimal timestamp) {
    
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getTimestamp() {
    return timestamp;
  }


  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimestamp(BigDecimal timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProposalAction proposalAction = (ProposalAction) o;
    return Objects.equals(this.id, proposalAction.id) &&
        Objects.equals(this.proposalId, proposalAction.proposalId) &&
        Objects.equals(this.accountId, proposalAction.accountId) &&
        Objects.equals(this.action, proposalAction.action) &&
        Objects.equals(this.transactionHash, proposalAction.transactionHash) &&
        Objects.equals(this.timestamp, proposalAction.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, proposalId, accountId, action, transactionHash, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProposalAction {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    proposalId: ").append(toIndentedString(proposalId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    transactionHash: ").append(toIndentedString(transactionHash)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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


package com.techtransformers.lostnfound.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "category", "name", "email", "attachment", "description", "lostRcvDate" })
public class Data {

	@JsonProperty("category")
	private String category;
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("attachment")
	private String attachment;
	@JsonProperty("description")
	private String description;
	@JsonProperty("lostRcvDate")
	private String lostRcvDate;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("attachment")
	public String getAttachment() {
		return attachment;
	}

	@JsonProperty("attachment")
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("lostRcvDate")
	public String getLostRcvDate() {
		return lostRcvDate;
	}

	@JsonProperty("lostRcvDate")
	public void setLostRcvDate(String lostRcvDate) {
		this.lostRcvDate = lostRcvDate;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}

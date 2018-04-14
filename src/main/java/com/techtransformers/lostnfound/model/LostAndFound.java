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
@JsonPropertyOrder({ "createdOn", "data" })
public class LostAndFound {

	@JsonProperty("createdOn")
	private String createdOn;
	@JsonProperty("data")
	private Data data;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("createdOn")
	public String getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("createdOn")
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@JsonProperty("data")
	public Data getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Data data) {
		this.data = data;
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

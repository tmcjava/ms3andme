package com.ms3.ms3andme.response;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonAutoDetect
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ConvertedPair {
	private String key;
	private String value;
	
	public ConvertedPair(String key, String value)
	{
		this.key = key;
		this.value = value;
	}
	
    @JsonProperty
	public String getKey()
	{
		return key;
	}
	
    @JsonProperty
	public String getValue()
	{
		return value;
	}
}

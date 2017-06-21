package com.ms3.ms3andme.response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mule.api.annotations.Transformer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertedPairs {
	
	private List<ConvertedPair> convertedPairs;
	
	public ConvertedPairs()
	{
		this.convertedPairs = new ArrayList<ConvertedPair>();
	}
	
	public List<ConvertedPair> getConvertedPairs()
	{
		return convertedPairs;
	}
	
	public void addConvertedPair(ConvertedPair convertedPair)
	{
		if(!convertedPairs.contains(convertedPair))
			convertedPairs.add(convertedPair);
	}
	
    @Transformer(resultMimeType = "application/json")
    public String toJson(ConvertedPairs convertedPairs) throws IOException 
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(convertedPairs);
    }
}

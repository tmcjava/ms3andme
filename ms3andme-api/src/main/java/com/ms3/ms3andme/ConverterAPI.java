package com.ms3.ms3andme;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.mule.module.apikit.exception.MuleRestException;

import com.ms3.ms3andme.response.ConvertedPair;
import com.ms3.ms3andme.response.ConvertedPairs;


public class ConverterAPI 
{
    private static final Logger LOGGER = Logger.getLogger(ConverterAPI.class);

	public void initialize()
	{
		// Nothing to do here, just had this in just in case something came up.
	}
	
	public ConvertedPairs getConvertedPairs(int lower, int upper) throws MuleRestException
	{
		LOGGER.debug("Conversion Requested: " + getCurrentDate() + " for range: " + lower + "-" + upper);
		ConvertedPairs convertedPairs = new ConvertedPairs();

		// iterate from lower to upper finding muliples of 7, 3 and 7 and 3
		// leave other numbers untouched as there was no requirement to change or remove them from the list
		// will return empty set if lower is greater than upper
		for(int i = lower; i <= upper; ++i)
		{
			String value = "";

			if (i % 7 == 0)
				value = "MS3";
			
			if (i % 3 == 0)
				value += (value.isEmpty() ? "ME" : " and ME");
			
			if(value.isEmpty())
				value = i + "";
			
			convertedPairs.addConvertedPair(new ConvertedPair(i + "", value));
		}
		
		LOGGER.debug("...and the results are: " + convertedPairs.getConvertedPairs().size());
		return convertedPairs;
	}
	
	// Helper function to add date info to some logging/monitoring.
	private String getCurrentDate()
	{
       DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
       Calendar calobj = Calendar.getInstance();
       return df.format(calobj.getTime());		
	}
}

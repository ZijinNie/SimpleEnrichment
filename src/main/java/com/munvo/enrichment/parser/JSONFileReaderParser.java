package com.munvo.enrichment.parser;

import org.json.JSONObject;

import com.munvo.enrichment.model.Subscriber;

public class JSONFileReaderParser implements FileReaderParser{
	@Override
	public Subscriber parseSubscriber(String subLine) {
    	JSONObject obj = new JSONObject(subLine);
    	int id = obj.getInt("id");
    	String name = obj.getString("name");
    	String phone = obj.getString("phone");
    	Subscriber sub = new Subscriber(id, name, phone);
    	return sub;
    }
}

package com.munvo.enrichment.parser;

import com.munvo.enrichment.model.Subscriber;

public class CSVFileReaderParser implements FileReaderParser{
	@Override
	public Subscriber parseSubscriber(String subLine) {
		String cvsSplitBy = ",";
		String[] info = subLine.split(cvsSplitBy);
		int id = Integer.parseInt(info[0]);
		String name = info[1];
		String phone = info[2];
		Subscriber sub = new Subscriber(id, name, phone);
		return sub;
		
	}
}

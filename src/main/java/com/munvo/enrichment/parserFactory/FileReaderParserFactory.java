package com.munvo.enrichment.parserFactory;

import com.munvo.enrichment.parser.CSVFileReaderParser;
import com.munvo.enrichment.parser.FileReaderParser;
import com.munvo.enrichment.parser.JSONFileReaderParser;

public class FileReaderParserFactory {
	
	public FileReaderParser createFileReader(String type) {
		if(type.equals("JSON")){
			return new JSONFileReaderParser();
		}else if (type.equals("CSV")) {
			return new CSVFileReaderParser();
		}else return null;
	}
}

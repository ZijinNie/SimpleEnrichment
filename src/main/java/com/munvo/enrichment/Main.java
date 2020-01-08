package com.munvo.enrichment;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.munvo.enrichment.configuration.Configuration;
import com.munvo.enrichment.input.InputSource;
import com.munvo.enrichment.model.Call;
import com.munvo.enrichment.model.EnrichedCall;
import com.munvo.enrichment.parser.FileReaderParser;
import com.munvo.enrichment.parserFactory.FileReaderParserFactory;

public class Main {
	
    private static List<Call> calls = new ArrayList<Call>(Arrays.asList(
            new Call(1, "2018-07-12", 1),
            new Call(2, "2018-07-12", 3),
            new Call(3, "2018-07-13", 2),
            new Call(4, "2018-07-13", 3)
    ));
    
    public static void main(String[] args) {
        // Get an instance of Configuration using Singleton pattern
        Configuration configuration = Configuration.INSTANCE;
        String type = configuration.getType();
        // Instantiate an input stream converter
        FileReaderParserFactory fileReaderParserFactory = new FileReaderParserFactory ();
        FileReaderParser fileReaderParser = fileReaderParserFactory.createFileReader(type);

        // Inject the file reader parser
		try {
			InputSource inputSource = new InputSource(fileReaderParser, configuration.getFileName());
			
	        calls.stream()
            .map(c -> new EnrichedCall(c, inputSource.query(c.getSubscriberId())))
            .forEach(EnrichedCall::toString);
	        
	        
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		
		for(Call c: calls) {
			System.out.println(c.toString());
		}
		System.out.print("Job finished");

    }

}

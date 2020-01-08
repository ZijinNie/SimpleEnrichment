package com.munvo.enrichment.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
	public static final Configuration INSTANCE;
	private String studentName;
	private String type;
	private String fileName; 
	
	private Configuration () {};
	
    private Configuration(String studentName, String type, String fileName) {
    	this.studentName = studentName;
        this.type= type;
        this.fileName =fileName;
    }
    
    //instantiate singleton instance and initialize parameters
    static {
    	Config config = ConfigFactory.load();
    	String studentName = config.getString("name");
        String type= config.getString("type");
        String fileName =config.getString("fileName");
        INSTANCE = new Configuration(studentName, type, fileName);
    }
    public String getStudentName() {
        return studentName;
    }

    public String getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }
}
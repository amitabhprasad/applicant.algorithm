package com.bg.engine.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;
import org.json.XML;

public class TestAlgorithm {

	public static void main(String[] args) throws Exception{
		getJSONObjForResume();
		
	}

	public static void getJSONObjForResume()throws Exception{
		String path = "\\src\\com\\bg\\engine\\test\\Amit XML.xml";
		String property = System.getProperty("user.dir");
		
		
		InputStream in = new FileInputStream(property+path);
	    InputStreamReader reader = new InputStreamReader(in);
	    BufferedReader br = new BufferedReader(reader);
	    String line = null;
	    String response = "";
	    StringBuilder sb = new StringBuilder();
	    while ((line=br.readLine()) != null){
	    	sb.append(line).append("\n");
	    }
	    br.close();
	    reader.close();
	    in.close();
	    response = sb.toString().trim();
	    JSONObject jsonObject = XML.toJSONObject(response);
	    JSONObject resume = (JSONObject)jsonObject.get("Resume");
	    JSONObject jsonStruturedResume = (JSONObject)resume.get("StructuredXMLResume");
	    System.out.println("Structured resume "+jsonStruturedResume);
	    
	}
}

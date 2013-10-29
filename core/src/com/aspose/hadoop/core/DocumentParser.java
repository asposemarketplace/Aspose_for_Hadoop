package com.aspose.hadoop.core;

import com.aspose.words.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;



public class DocumentParser {
	
	private static Document doc;
	private static License lic;
	
	public DocumentParser(InputStream input)
	{
		lic = new License();
		try {
			lic.setLicense(System.getProperty("user.home") + "/lic/Aspose.Total.Java.lic");
		} catch (AsposeLicenseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			doc = new Document(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getParsedDocument()
	{
		StringBuilder sb=new StringBuilder();		
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			doc.save(os,SaveFormat.TEXT);
		//os.
	    InputStream input = new ByteArrayInputStream(os.toByteArray());
		InputStreamReader is = new InputStreamReader(input);
		
		BufferedReader br = new BufferedReader(is);
		String read = br.readLine();

		while(read != null) {
		    //System.out.println(read);
		    sb.append("\n"+read);
		    read =br.readLine();
		}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}

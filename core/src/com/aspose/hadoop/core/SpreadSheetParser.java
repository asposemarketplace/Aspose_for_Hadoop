package com.aspose.hadoop.core;

import com.aspose.cells.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SpreadSheetParser {
	
    private static Workbook wb;
    private static License lic;
    
	public SpreadSheetParser(InputStream input)
	{
		lic = new License();
		try {
			lic.setLicense(System.getProperty("user.home") + "/lic/Aspose.Total.Java.lic");
		} catch (AsposeLicenseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			wb = new Workbook(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getParsedSpreadSheet()
	{
	    
		byte[] workbookData = new byte[0];
		StringBuilder sb=new StringBuilder();
		
		try {
		

		//Text save options. You can use any type of separator
		TxtSaveOptions opts = new TxtSaveOptions();
		opts.setSeparator('\t');		

		//Copy each worksheet data in text format inside workbook data array
		for (int idx = 0; idx < wb.getWorksheets().getCount(); idx++)
		{
		    //Save the active worksheet into text format
		    ByteArrayOutputStream bout = new ByteArrayOutputStream();
		    wb.getWorksheets().setActiveSheetIndex(idx);

				wb.save(bout, opts);

		    //Save the worksheet data into sheet data array
		    byte[] sheetData = bout.toByteArray();

		    //Combine this worksheet data into workbook data array
		    byte[] combinedArray = new byte[workbookData.length + sheetData.length];
		    System.arraycopy(workbookData, 0, combinedArray, 0, workbookData.length);
		    System.arraycopy(sheetData, 0, combinedArray, workbookData.length, sheetData.length);

		    workbookData = combinedArray;
		}
	    InputStream input = new ByteArrayInputStream(workbookData);
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

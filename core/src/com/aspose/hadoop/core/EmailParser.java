package com.aspose.hadoop.core;

import com.aspose.email.*;

import java.io.*;

public class EmailParser {

	//private static InputStream ins;
	private static MailMessage msg;
	private static License lic;
	
	public EmailParser(InputStream input)
	{
		lic = new License();
		try {
			lic.setLicense(System.getProperty("user.home") + "/lic/Aspose.Total.Java.lic");
		} catch (AsposeLicenseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		msg = MailMessage.load(input);
	}
	
	public String getParsedEmail(String KeyValueSeparator,String MultipleValuesSeparator,String MRRecordSeparator)
	{
		String strParsedEmail = "";
		try
		{
			strParsedEmail = strParsedEmail + "To" + KeyValueSeparator;
		
			for (int i=0;i<msg.getTo().size();i++)
				strParsedEmail = strParsedEmail + msg.getTo().get(i) + MultipleValuesSeparator;

			strParsedEmail = strParsedEmail + MRRecordSeparator;
		
			strParsedEmail = strParsedEmail + "Subject" + KeyValueSeparator + msg.getSubject() + MRRecordSeparator;
			strParsedEmail = strParsedEmail + "Body" + KeyValueSeparator + msg.getBody() + MRRecordSeparator;
		} catch(Exception ex)
		{
			return ex.getMessage();
		}
		return strParsedEmail;
	}
}

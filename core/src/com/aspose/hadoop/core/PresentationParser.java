package com.aspose.hadoop.core;

import java.io.InputStream;

import com.aspose.slides.*;

public class PresentationParser {

	private static PresentationEx pres;
	private static License lic;
	
	public PresentationParser(InputStream input)
	{
		lic = new License();
		try {
			lic.setLicense(System.getProperty("user.home") + "/lic/Aspose.Total.Java.lic");
		} catch (AsposeLicenseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pres = new PresentationEx(input);
		
	}
	public String getParsedPresentation()
	{

		String presText="";
		try{
			SlideEx slide;
			ShapesEx shps;
	   		
			for (int index=0;index<pres.getSlides().getCount();index++)
	       	{
	       	   //Accessing Slides
				slide = pres.getSlides().get_Item(index);
				//Accessing all shapes in slide
				shps=slide.getShapes();
				ShapeEx shape;	
				//Traversing through all shapes
				for (int shpCount = 0; shpCount < shps.getCount(); shpCount++) 
	            {
					shape= shps.get_Item(shpCount);
	                if(shape.getPlaceholder() != null)
	                {
	                	//Getting AutoShape from group shapes set
	                	AutoShapeEx aShape = (AutoShapeEx)shape;
	                	if (aShape.getTextFrame() != null)
	                	{
	                		//Accessing the text frame of shape
	                		TextFrameEx tfText=aShape.getTextFrame();
	                		presText = presText + ReadText(tfText);
	                	}//End Text Frame IF
	                }//End AutoShape Check
	                else if(shape instanceof AutoShapeEx )
	                {
	                	//Getting AutoShape from group shapes set
	                	AutoShapeEx aShp = (AutoShapeEx)shape;
	                	if (aShp.getTextFrame() != null)
	                	{
	                		//Accessing the text frame of shape
	                		TextFrameEx tfText=aShp.getTextFrame();
	                		presText = presText + ReadText(tfText);
	                	}//End Text Frame IF
	                                                               
	                }//End AutoShape Check

	                //If shape is a group shape
	                else if(shape instanceof GroupShapeEx)
	                {
	                	//Type casting shape to group shape
	                	GroupShapeEx gShape = (GroupShapeEx)shape;
	                	//Traversing through all shapes in group shape
	                	for (int iCount=0;iCount< gShape.getShapes().getCount();iCount++)
	                	{
	                		if(gShape.getShapes().get_Item(iCount) instanceof AutoShapeEx)
	                		{
	                			//Getting AutoShape from group shapes set
	                			AutoShapeEx aShp = (AutoShapeEx)gShape.getShapes().get_Item(iCount);
	                			if (aShp.getTextFrame() != null)
	                			{
	                				TextFrameEx tfText=aShp.getTextFrame();
	                				presText = presText + ReadText(tfText);
	                			}//End Text Frame IF
	                		}
	                	}
	                }
	                //If shape is instance of Table
	                else if(shape instanceof TableEx)
	                {	 
	                	TableEx tTable=(TableEx)shape;
	                	for(int iCol=0;iCol<tTable.getColumns().size();iCol++)
	                	{
	                		for(int iRow=0;iRow<tTable.getRows().size();iRow++)
	                		{
	                			TextFrameEx tfText=tTable.get_Item(iCol,iRow).getTextFrame();
	                			if(tfText!=null)
	                				presText = presText + ReadText(tfText);
	                		}//End Row Loop
	                	}//End Col Loop
	                }//End Group Shape IF
	   					
	               }//End Shape Loop
	                           
	            }//End Slide Traversal
	   	}
	   	catch(Exception e)
	   	{
	   		e.printStackTrace();
	   	}
	   	return presText;
	}
	  private String ReadText(TextFrameEx TxtFrame)
	  {
	    String prText="";
	    for(int pgCount=0;pgCount<TxtFrame.getParagraphs().getCount();pgCount++)
	    {
	    	ParagraphEx Paragraph=TxtFrame.getParagraphs().get_Item(pgCount);
	    	for(int prCount=0;prCount<Paragraph.getPortions().size();prCount++)
	        {
	    		prText=prText+Paragraph.getPortions().get_Item(prCount).getText();
	        }//End Portion Loop                                                                            
	    }//End Paragraphs Loop
	    return prText+"\n";
	  }
}

package com.saudia.qa.FunctionalTestcase;

import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test1 {
	
public static void main1(String[] args) {
	 Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
	 System.out.println(currentTimestamp.toString());
	 
	 long ts = System.currentTimeMillis();
	 System.out.println(String.valueOf(ts));
	
	 
	
	 
  //   System.out.println("Current Timestamp: " + currentTimestamp.getTime() + " milliseconds");
    // System.out.println("Formatted Timestamp: " + currentTimestamp.toString());
	 String pattern = "MM/dd/yyyy,HH:mm:ss";
	 DateFormat df = new SimpleDateFormat(pattern);
	Date today = Calendar.getInstance().getTime();        
	String todayAsString = df.format(today);

	// Print the result!
	System.out.println("Today is: " + todayAsString);
     
     
}

public static void main2(String[] args) {
	
    //  System.out.println(builder.toString());  
	String str ="--- TST RLR SFP ---\r\n"
			+ "RP/JEDSV08AA/JEDSV08AA            TT/SU   3AUG23/1104Z   S527EA\r\n"
			+ "  1.TEST/DIVYAES MS\r\n"
			+ "  2  SV1095 Y 15AUG 2 RUHJED HK1       5  0130 0320   *1A/E*\r\n"
			+ "  3 AP +918072158274-M\r\n"
			+ "  4 APE BANUMATHIS@HEXAWARE.COM\r\n"
			+ "  5 TK OK03AUG/JEDSV08AA//ETSV\r\n"
			+ "  6 SSR DOCS SV HK1 I/SA/1234567890/SA/22JAN80/M/22JAN25/TEST/DI\r\n"
			+ "       VYAES\r\n"
			+ "  7 SSR DOCS SV HK1 I/SA/1234567890/SA/22JAN80/M/22JAN25/TEST/TA\r\n"
			+ "       RIOQ\r\n"
			+ "  8 SSR CTCE SV HK1 BANUMATHIS//HEXAWARE.COM\r\n"
			+ "  9 FA PAX 065-2153829091/ETSV/SAR1348.95/03AUG23/JEDSV08AA/7149\r\n"
			+ "       3730/S2\r\n"
			+ " 10 FB PAX 0000000000 TTP/RT OK ETICKET WELL ISSUED/S2\r\n"
			+ " 11 FE PAX TKT VALD 1Y FRM ISSUE DATE/S2\r\n"
			+ " 12 MEP TYP-CARD/VCD-VI/NUM-XXXXXXXXXXXX1019/EXP-0925\r\n"
			+ " 13 FP PAX CCVIXXXXXXXXXXXX1019/0925*CV/A116158/S2\r\n"
			+ " 14 FV PAX SV/S2\r\n"
			+ "2023-08-03 16:34:32 INFO  Log:30 - Before Trying to find the element By:::By.xpath: //*[@class='speedModePanel']\r\n"
			+ "2023-08-03 16:34:32 INFO  Log:30 - After Trying to find the element By:::By.xpath: //*[@class='speedModePanel']";
	
	  StringBuilder stringBuilder =  
              new StringBuilder(str.trim());  
      StringBuilder builder = stringBuilder.delete(85, str.length());  
      String numbers = builder.substring (builder.length () - 8, builder.length ());
System.out.println(numbers);
	
	
}
public static void main5(String[] args) {
	
	        try {
	        	String ExcelPath = "PNR.xlsx";
	        	FileInputStream fis = new FileInputStream(ExcelPath);
	           XSSFWorkbook wb = new XSSFWorkbook(fis);
	           int numberOfSheets = wb.getNumberOfSheets();
	           
	           for (int i = 0; i < numberOfSheets; i++) {
				if (wb.getSheetName(i).equals("PNR")) {
					XSSFSheet sheet = wb.getSheetAt(i);
					Iterator<Row> rows = sheet.iterator();
					Row firstRow = rows.next();
					Iterator<Cell> cells = firstRow.iterator();
					int k = 0;
					int column = 0;
					while (cells.hasNext()) {
						Cell cellValue = cells.next();
					//	if (cellValue.getStringCellValue().equals("PNRnumbers")) {
							
							column = k;
							int rowCount=0;
							Row header = sheet.createRow(rowCount++);
							
				            header.createCell(0).setCellValue("Student Name");
				            header.createCell(1).setCellValue("Address");
				            header.createCell(2).setCellValue("Email ID");
				            header.createCell(3).setCellValue("Age");
				            
				      //      Row row = sheet.createRow(rowCount++);
				            
			                int columnCount = 0;
			 
			                 // Creating new cell and setting the value
			                    Cell cell = firstRow.createCell(columnCount++);
			                    cell.setCellValue("Vinoth");
			                   
						
						k++;
						
					
				//	}
					System.out.println(column); // this will print the index of the Column name which we gave
				
					
					/*
					 * while (rows.hasNext()) { //Cell nextCell = cells.next(); Row r = rows.next();
					 * Cell ceValue = r.getCell(column); String text =
					 * NumberToTextConverter.toText(ceValue.getNumericCellValue());
					 * 
					 * if (text == null) {
					 * 
					 * ceValue.setCellValue("kjjjhgh"); // setCellValue("SWUUHB2");
					 * 
					 * } else { System.out.println(text); //ceValue.set
					 * ceValue.setCellValue("Banu"); } }
					 */
					
					
				}
				
				
			}
	           FileOutputStream fos = new FileOutputStream(ExcelPath);
				wb.write(fos);
				fos.close();
	 
	           }    } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	    }
public static void main(String[] args) {

	String str = "Welcome to java";
	String x = "";
	String newword = "";
	String newword1 = "";
	String rev ="";
	String[] strarray = str.split("\\s");
	for(String ab : strarray)
	{
		newword = String.valueOf(Character.toUpperCase(ab.charAt(0))) +
				ab.substring(1,ab.length()-1) + 
				String.valueOf(Character.toUpperCase(ab.charAt(ab.length()-1))) ;
		System.out.println(newword); // first and last words alone caps
		newword1 = String.valueOf(Character.toUpperCase(ab.charAt(0))) +
				ab.substring(1,ab.length()) ; // first word lone caps
		System.out.println(newword1);
	}
	
	 rev = rev+newword+"";
	 System.out.println("rr   "+rev);
	 if (strarray.length > 0) {
		String lastword = strarray[strarray.length-1].toUpperCase();
		strarray[strarray.length-1] = lastword;
		 
         String modifiedSentence = String.join(" ", strarray);
         System.out.println("Modified sentence: " + modifiedSentence);
     } else {
         System.out.println("No words in the sentence.");
     }
	//**************** reverese each character**************
	 for (int i=0;i<str.length();i++)
	 {
		 char ch = str.charAt(i);
		 rev = ch+rev;
	 }
	 System.out.println(rev);
	 
	// **************** Reverse the words alone ******************
	 String str1 = "Welcome java";
		String[] strarray1 = str.split("\\s");

		// Reversing the Second word
		String ar1 = strarray[strarray.length-1];
		String rev1 ="";
		for (int i = 0; i < ar1.length(); i++) {
		char	ch = ar1.charAt(i);
		rev = ch+rev;
		
		}
		strarray[strarray.length-1] = rev;
		 StringBuilder sb = new StringBuilder();
		 for (int i = strarray.length-1 ; i >=0 ; i--) {
			 sb.append(strarray[i]);
			 if (i>0) {
				 sb.append(" ");
				}
		 }
		 System.out.println("final rev:" +sb.toString());
		 
	 
	 
	 
}

public static void main3(String[] args) {
	
	
	
	try {
		
		List<String> values = new ArrayList<>();
		values.add("test1");
		values.add("test2");
		values.add("test3");
		values.add("test4");
		values.add("test5");
		System.out.println(values);
		String value = "abc";
		String ExcelPath = "PNR.xlsx";
    	FileInputStream fis = new FileInputStream(ExcelPath);
    	
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
       int numberOfSheets = wb.getNumberOfSheets();
       
       // will write data at 0,0
       XSSFSheet sheetAt = wb.getSheetAt(0);
       
  //     XSSFCell createCell = createRow.createCell(0);
    //   createCell.setCellValue("Banu");
       
       // write array list data
       //int rowid = 0;
       
           int cellid = 0;
           int rowID = 0;
           for (Object obj : values) {
        	   XSSFRow createRow = sheetAt.createRow(rowID++);
               Cell cell = createRow.createCell(cellid);
                 cell.setCellValue((String)obj);
           }
       
       
       //String stringCellValue = createCell.getStringCellValue();
       //System.out.println(stringCellValue);
       
       //if null set  value
		/*
		 * if (condition) {
		 * 
		 * } else {
		 * 
		 * } createCell.setCellValue("Banu");
		 */
       
      
       FileOutputStream fos = new FileOutputStream(ExcelPath);
		wb.write(fos);
		fos.close();
    	
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("ddi");
	}
}

private static boolean getStringCellValue(int i) {
	// TODO Auto-generated method stub
	return false;
}
		
}

























package com.saudia.qa.FunctionalTestcase;

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

public class Test2 {
	

public static void main(String[] args) {

	String str = "Rajesh hello";
	String[] strarray = str.split("\\s");

	// Reversing the Second word
	String ar1 = strarray[strarray.length-1];
	String rev ="";
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
	 	}}
























package excelSheet;

import java.io.FileInputStream;
import java.nio.file.Path;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_File {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static void setExcelFile(String excel_Path, String SheetName) throws Exception
	{
		try
		{
			FileInputStream ExcelFile = new FileInputStream(excel_Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		}
		catch(Exception e)
		{
			throw (e);
		}
	}
	
	public static String getCellData( int RowNum, int ColNum) throws Exception
	{
		try
		{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}
		catch(Exception e)
		{
			return " ";
		}
	}
	

}

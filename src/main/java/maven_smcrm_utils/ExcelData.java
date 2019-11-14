package maven_smcrm_utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	/***
	 * 
	 * @param file_name
	 * @param sheet_name
	 * @param rn
	 * @param cn
	 * @return
	 */
	public static String getData(String file_name,String sheet_name,int rn,int cn)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(file_name));
			String data = WorkbookFactory.create(file).getSheet(sheet_name).getRow(rn).getCell(cn).toString();
			return data;
		}
		catch (Exception e)
		{
			return"";
		}
	}
	/***
	 * 
	 * @param file_name
	 * @param sheet_name
	 * @return
	 */
	public static int getRowCount(String file_name,String sheet_name)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(file_name));
			int rc = WorkbookFactory.create(file).getSheet(sheet_name).getLastRowNum();
			return rc;
		} 
		catch (Exception e)
		{
			return 0;
		}
	}
	/***
	 * 
	 * @param file_name
	 * @param sheet_name
	 * @param rn
	 * @return
	 */
	public static int getCellCount(String file_name,String sheet_name,int rn)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(file_name));
			int cc = WorkbookFactory.create(file).getSheet(sheet_name).getRow(rn).getLastCellNum();
			return cc;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
	/***
	 * 
	 * @param file_name
	 * @param sheet_name
	 * @param rn
	 * @param cn
	 * @return
	 */
	public static String getNumberDataFromCell(String file_name,String sheet_name,int rn,int cn)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(file_name));
			 Cell c = WorkbookFactory.create(file).getSheet(sheet_name).getRow(rn).getCell(cn);
			 DataFormatter d = new DataFormatter();
			 String data=d.formatCellValue(c);
			 return data;
		}
		catch (Exception e)
		{
			return"";
		}
	}
}

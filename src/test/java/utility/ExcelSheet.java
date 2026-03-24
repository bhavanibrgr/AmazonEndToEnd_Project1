package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelSheet {
	
	@DataProvider(name="loginData")
	public Object[][] fetchingData() throws Exception {

	    String path = System.getProperty("user.dir") 
	    		+ "/src/test/resources/ExcelSheet/Test.xlsx";

	    FileInputStream fileinputstream = new FileInputStream(path);
	    Workbook wb = WorkbookFactory.create(fileinputstream);
	    
	    Sheet sheet = wb.getSheet("login");
	    
        int rowCount=sheet.getPhysicalNumberOfRows();
        int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
       
        Object[][] data=new Object[rowCount-1][cellCount];
	   
        for (int i=1; i<rowCount; i++) {
        	for (int j=0; j<cellCount; j++) {
        		DataFormatter df=new DataFormatter();
        		data[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
        	}
        }
	    
	    wb.close();
	    fileinputstream.close();
	    return data;

	}
	
//	@DataProvider(name="productsdata")
//	public Object[][] productdata() throws Exception{
//		return fetchingData("products");
//	}
	}


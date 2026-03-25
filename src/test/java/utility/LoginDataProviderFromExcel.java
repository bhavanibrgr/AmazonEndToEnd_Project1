package utility;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class LoginDataProviderFromExcel {

	@DataProvider(name="loginDataprovider")
	public Object[][] fetchingData(Method method) throws Exception {
		//Locate excel file
		String path = System.getProperty("user.dir") 
				+ "/src/test/resources/ExcelSheet/LoginDataAmazon.xlsx";

		//Open excel file
		FileInputStream fileinputstream = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fileinputstream);
        //Select "login" sheet
		Sheet sheet = wb.getSheet("login");
		
		//get row and column count
		//Rows = number of records
		//Columns = username, password, comments
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
        
		//Converts Excel values into String format
		//Works for numbers, text, anything
		DataFormatter df = new DataFormatter();

		//Use List to filter only required data(Temporary storage)
		//Only valid rows will be stored here
		List<Object[]> filteredData = new ArrayList<>();
		 String testName = method.getName(); //getting method name from tests
		//Loop Through Excel Rows
		//Starts from 1 (skips header row)
		for (int i = 1; i < rowCount; i++) {
			
            //Read Each Row, Stores one full row (username, password, comments)
			Object[] rowData = new Object[cellCount];

			for (int j = 0; j < cellCount; j++) {
				//Read Each Cell
				//Reads each column value & Stores inside rowData
				rowData[j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
			// FILTER CONDITION
			//Apply Filter Logic, Check 3rd column (comments)
			//Only if value = "valid-valid, invali-valid, edge case anything" add to list otherwise ignore
			String type = rowData[2].toString();
            //TC1
		    if (testName.equals("withValidCredentials") && type.equalsIgnoreCase("valid-valid")) {
		            filteredData.add(rowData);
		        }
		  //TC2
			else if (testName.equals("loginWithInvalidCred") && type.equalsIgnoreCase("valid-invalid")) {
	            filteredData.add(rowData);
	        }
		  //TC3
			else if (testName.equals("editMyProfile") && type.equalsIgnoreCase("valid-valid")) {
	            filteredData.add(rowData);
	        }
		  //TC4
			else if (testName.equals("searchingTheProduct") && type.equalsIgnoreCase("valid-valid")) {
	            filteredData.add(rowData);
	        }
		  //TC5
			else if (testName.equals("verifyProductDetails") && type.equalsIgnoreCase("valid-valid")) {
	            filteredData.add(rowData);
	        }
		}

		wb.close();
		fileinputstream.close();

		// Convert List → Object[][]
		//Convert List → 2D Array, TestNG requires Object[][], So we convert List → array
		return filteredData.toArray(new Object[0][]);

	}
}


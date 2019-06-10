package wtaoweixin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	//读取excel表格中的数据，path代表excel路径
	  public static void readExecl(String path) {
	    try {
	      //读取的时候可以使用流，也可以直接使用文件名
	      XSSFWorkbook xwb = new XSSFWorkbook(path);
	      //循环工作表sheet
	      for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
	        XSSFSheet xSheet = xwb.getSheetAt(numSheet);
	        if (xSheet == null) {
	          continue;
	        }
	        //循环行row
	        for (int numRow = 0; numRow <= xSheet.getLastRowNum(); numRow++) {
	          XSSFRow xRow = xSheet.getRow(numRow);
	          if (xRow == null) {
	            continue;
	          }
	          //循环列cell
	          for (int numCell = 0; numCell <= xRow.getLastCellNum(); numCell++) {
	            XSSFCell xCell = xRow.getCell(numCell);
	            if (xCell == null) {
	              continue;
	            }
	            //输出值
	            System.out.println("excel表格中取出的数据" + getValue(xCell));
	          }
	        }

	      }

	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

	  /**
	   * 取出每列的值
	   *
	   * @param xCell 列
	   * @return
	   */
	  private static String getValue(XSSFCell xCell) {
	    if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
	      return String.valueOf(xCell.getBooleanCellValue());
	    } else if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
	      return String.valueOf(xCell.getNumericCellValue());
	    } else {
	      return String.valueOf(xCell.getStringCellValue());
	    }
	  }
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		readExecl("C:\\Users\\wtao\\Desktop\\wtao.xlsx");
	}
		
}


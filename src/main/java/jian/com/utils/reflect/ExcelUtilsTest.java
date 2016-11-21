package jian.com.utils.reflect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtilsTest {

    public static <T> void setValue(HSSFWorkbook hssfWorkbook, List<T> list, Class<T> clazz) throws IllegalArgumentException, IllegalAccessException {

        if (list == null || list.size() == 0) {
            return;
        }

        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);

        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < list.size(); i++) {

            List<String> fieldValueList = new ArrayList<String>();
            for (Field field : fields) {
                if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
                    Object object = field.get(list.get(i));
                    fieldValueList.add(object != null ? object.toString() : "");
                }
            }
            for (int j = 0; j < fieldValueList.size(); j++) {
                HSSFCell cellTemp = sheet.createRow(i + 1).createCell(j);
                cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTemp.setCellValue(fieldValueList.get(j));
            }

        }
    }

    public static <T> void export(HttpServletResponse response, String xlsName, String[] arr, List<T> list, Class<T> clazz) throws IllegalArgumentException,
            IllegalAccessException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet();
        for (int i = 0; i < arr.length; i++) {
            HSSFCell cell = sheet.createRow(0).createCell(i);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(arr[i]);
        }
        setValue(hssfWorkbook, list, clazz);
        responseXLS("export", response, hssfWorkbook);
    }

    public static void responseXLS(String xlsName, HttpServletResponse response, HSSFWorkbook workbook) {
        OutputStream os = null;
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("content-disposition", "attachment;filename=" + xlsName + ".xls");
            // 写入到 客户端response
            os = response.getOutputStream();
            workbook.write(os);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        String[] arr = { "a", "b", "c" };
        List<String> list = new ArrayList<String>();
        list.add("11");
        list.add("12");
        list.add("13");
    }
}

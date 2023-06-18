package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class LinearRegression {


    /**
     *
     * @param workbook
     * @param columnIndex
     * @return
     */


    public static double[][] getDataSimpleRegression(XSSFWorkbook workbook, int columnIndex) {
        double[][] data = new double[getCellsCountInColumn(workbook)][2];
        XSSFSheet sheet = workbook.getSheetAt(0);
        int x = 0;
        for (Row row : sheet) {
            Cell cellIndependentVariable = row.getCell(columnIndex);
            Cell cellDependentVariable = row.getCell(5);
            double independentVariable = cellIndependentVariable.getNumericCellValue();
            double dependentVariable = cellDependentVariable.getNumericCellValue();
            data[x][0] = independentVariable;
            data[x][1] = dependentVariable;
            x++;
        }
        return data;
    }

    public static int getCellsCountInColumn(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        int cellCount = 0;
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                // Process the numeric cell
                cellCount++;
            }
        }
        return cellCount;
    }

    public static double[][] getIndependentVariables(XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
        int rowCount = sheet.getLastRowNum() + 1;
        int columnCount = 5; // Assuming 5 independent variables

        double[][] independentVariables = new double[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            Row currentRow = sheet.getRow(row);
            for (int col = 0; col < columnCount; col++) {
                Cell cell = currentRow.getCell(col);
                double value = cell.getNumericCellValue();
                independentVariables[row][col] = value;
            }
        }

        return independentVariables;
    }

    public static double[] getDependentVariable(XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
        int rowCount = sheet.getLastRowNum() + 1;
        int columnCount = 6; // Assuming 6 columns with the last one being the dependent variable

        double[] dependentVariable = new double[rowCount];

        for (int row = 0; row < rowCount; row++) {
            Row currentRow = sheet.getRow(row);
            Cell cell = currentRow.getCell(columnCount - 1); // Last column
            double value = cell.getNumericCellValue();
            dependentVariable[row] = value;
        }

        return dependentVariable;
    }
}
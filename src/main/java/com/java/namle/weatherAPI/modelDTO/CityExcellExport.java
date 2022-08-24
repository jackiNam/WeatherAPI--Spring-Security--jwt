package com.java.namle.weatherAPI.modelDTO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CityExcellExport {

	private XSSFWorkbook xSSFWorkbook;
	private XSSFSheet xssfSheet;

	private List<CityDTO> citys;

	public CityExcellExport(List<CityDTO> citys) {
		this.citys = citys;

		xSSFWorkbook = new XSSFWorkbook();
		xssfSheet = xSSFWorkbook.createSheet("Citys");
	}

	private void writeHeaderRow() {

		CellStyle cellStyle = xSSFWorkbook.createCellStyle();
		XSSFFont font = xSSFWorkbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		cellStyle.setFont(font);

		Row row = xssfSheet.createRow(0);

		Cell cell = row.createCell(0);
		cell.setCellValue("City ID");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(1);
		cell.setCellValue("Name City");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(2);
		cell.setCellValue("City Cod");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(3);
		cell.setCellValue("Visibility");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(4);
		cell.setCellValue("Base");
		cell.setCellStyle(cellStyle);

	}

	private void writeDataRow() {

		int rowCount = 1;

		for (CityDTO cityDTO : citys) {

			Row row = xssfSheet.createRow(rowCount++);
			Cell cell = row.createCell(0);

			cell.setCellValue(String.valueOf(cityDTO.getIdCity()));
			xssfSheet.autoSizeColumn(0);

			cell = row.createCell(1);
			cell.setCellValue(cityDTO.getName());
			xssfSheet.autoSizeColumn(1);

			cell = row.createCell(2);
			cell.setCellValue(String.valueOf(cityDTO.getCod()));
			xssfSheet.autoSizeColumn(2);

			cell = row.createCell(3);
			cell.setCellValue(String.valueOf(cityDTO.getVisibility()));
			xssfSheet.autoSizeColumn(3);

			cell = row.createCell(4);
			cell.setCellValue(cityDTO.getBase());
			xssfSheet.autoSizeColumn(4);

		}

	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRow();

		ServletOutputStream outputStream = response.getOutputStream();
		xSSFWorkbook.write(outputStream);
		xSSFWorkbook.close();
		outputStream.close();

	}

}

package com.java.namle.weatherAPI.modelDTO;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CityPdfExport {

	private List<CityDTO> citys;

	
	//tạo hàm khởi tạo để khi khởi tạo phải chuyền vào list cityDTO
	public CityPdfExport(List<CityDTO> citys) {
		this.citys = citys;
	}

	
	//Viết header tiêu đề,tên cột,... cho bảng
	private void writeTableHeader(PdfPTable table) {
		//set màu cho bacgroud tên cột
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.CYAN);
		cell.setPadding(5);

		
		//set màu cho text tên cột
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.BLACK);

		//đặt tên cột và gắn font màu
		cell.setPhrase(new Phrase("Id City", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Name City", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Cod", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Visibility", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Base", font));
		table.addCell(cell);
	}

	//Viết cấu hình data body cho bảng
	private void writeTableData(PdfPTable table) {
		for (CityDTO cityDTO : citys) {
			table.addCell(String.valueOf(cityDTO.getIdCity()));
			table.addCell(cityDTO.getName());
			table.addCell(String.valueOf(cityDTO.getCod()));
			table.addCell(String.valueOf(cityDTO.getVisibility()));
			table.addCell(cityDTO.getBase());
			

		}

	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		
		Paragraph paragraph = new Paragraph("Dữ Liệu Thời Tiết Thành Phố ");
		
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
table.setWidths(new float[] {1.5f,3f,1f,1.5f,2f});
		
		
		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();
	}

}

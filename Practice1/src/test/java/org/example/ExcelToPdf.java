package org.example;

import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;

public  class ExcelToPdf {
    public static void run() throws Exception {
        // Create Workbook to load Excel file
        Workbook workbook = new Workbook("E:\\SeleniumPractice\\dev\\Practice1\\src\\Resources\\RandomNumberFile\\RandomNumberGenerator50Docs.xlsx");

        // Create PDF options
        PdfSaveOptions options = new PdfSaveOptions();
        //options.setPageIndex(0);
        options.setOnePagePerSheet(true);

        // Save the document in PDF format
        workbook.save("Excel-to-PDF.pdf", options);

    }

}

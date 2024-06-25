package com.wingman.clothingshopmanagement.util;

import com.wingman.clothingshopmanagement.model.order.Order;
import com.wingman.clothingshopmanagement.model.order.OrderDetail;
import com.wingman.clothingshopmanagement.model.product.Product;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtil {
    public static Workbook convertOrderToExcel(Order order, List<OrderDetail> orderDetails) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("OrderInfo");

        // Create a font for headers
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.WHITE.getIndex());

        // Create a cell style for headers
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        
        // Create a cell style for total
        CellStyle totalCellStyle = workbook.createCellStyle();
        totalCellStyle.setFont(headerFont);
        totalCellStyle.setFillForegroundColor(IndexedColors.BLUE1.getIndex());
        totalCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        totalCellStyle.setAlignment(HorizontalAlignment.RIGHT);

        // Create order info title
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Order Info");
        titleCell.setCellStyle(headerCellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
        
        // Create cells for customer info
        CellStyle infoCellStyle = workbook.createCellStyle();
        infoCellStyle.setAlignment(HorizontalAlignment.LEFT);

        Cell customerNameCell = sheet.createRow(1).createCell(0);
        customerNameCell.setCellValue("Customer Name: " + order.getName());
        customerNameCell.setCellStyle(infoCellStyle);

        Cell customerPhoneCell = sheet.createRow(2).createCell(0);
        customerPhoneCell.setCellValue("Customer Phone: " + order.getPhone());
        customerPhoneCell.setCellStyle(infoCellStyle);
        
        // Create header row
        Row headerRow = sheet.createRow(3);
        String[] columns = {"No", "ID", "Name", "Size", "Color", "Price", "Quantity", "Total"};
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Fill in order details
        double total = 0;
        int rowNum = 4;
        int count = 1;
        for (OrderDetail od: orderDetails) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(count++);
            Object[] arr = convertOrderDetailToArray(od);
            int colNum = 1;
            for (Object field: arr) {
                Cell cell = row.createCell(colNum++);
                
                if (field instanceof Number) {
                    cell.setCellValue(Double.parseDouble(String.valueOf(field)));
                } else {
                    cell.setCellValue(String.valueOf(field));
                }
            }
            total += od.getQuantity() * od.getUnitPrice();
        }

        // Add total row
        Row totalRow = sheet.createRow(rowNum);
        Cell labelCell = totalRow.createCell(6);
        labelCell.setCellValue("Total:");
        labelCell.setCellStyle(totalCellStyle);

        Cell totalCell = totalRow.createCell(7);
        totalCell.setCellValue(total);
        totalCell.setCellStyle(totalCellStyle);

        // Auto-size all the columns
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return workbook;
    }

    private static Object[] convertOrderDetailToArray(OrderDetail od) {
        Product product = od.getProduct();
        return new Object[] {
            product.getProductId(), 
            product.getName(), 
            product.getSize(), 
            product.getColor(), 
            product.getPrice(), 
            od.getQuantity(),
            od.getQuantity() * od.getUnitPrice()
        };
    }
}

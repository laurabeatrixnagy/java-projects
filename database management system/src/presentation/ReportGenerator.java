package presentation;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dataAccessLayer.ConnectionFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Laura Nagy
 *
 * ReportGenerator - class for generating reports
 */

public class ReportGenerator {

    private static int billCount = 1;
    private static int clientCount = 1;
    private static int orderCount = 1;
    private static int productCount = 1;

    String fileName = "D:\\PT2020_30422_Nagy_LauraBeatrix_Assignment_3\\bill1.pdf";
    Document document;

    public void generateBill(String name, float totalPrice) {

        fileName = "D:\\PT2020_30422_Nagy_LauraBeatrix_Assignment_3\\bill" + billCount + ".pdf";
        document = new Document();
        try {
            PdfWriter.getInstance(document , new FileOutputStream(fileName));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        try {
            document.add(new Paragraph("Order placed by : " + name + "\nTotal price : " + totalPrice));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.close();
        billCount++;
    }

    public void generateUnderStock(String name) {
        fileName = "D:\\PT2020_30422_Nagy_LauraBeatrix_Assignment_3\\bill" + billCount + ".pdf";
        document = new Document();
        try {
            PdfWriter.getInstance(document , new FileOutputStream(fileName));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        try {
            document.add(new Paragraph("Order placed by : " + name + "\nBill could not be generated\nUNDER STOCK - not enough products"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.close();
        billCount++;
    }

    public void generateClientReport() {
        fileName = "D:\\PT2020_30422_Nagy_LauraBeatrix_Assignment_3\\clientReport" + clientCount + ".pdf";
        document = new Document();
        try {
            PdfWriter.getInstance(document , new FileOutputStream(fileName));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = null;
            ResultSet result = null;
            String query = "select * from `client`";

            stmt = connection.createStatement();
            result = stmt.executeQuery(query);

            document.add(new Paragraph("Client Table \n"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("clientID"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("name"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("email"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("address"));
            table.addCell(c1);
            table.setHeaderRows(1);

            while (result.next()) {
                table.addCell(result.getString("clientID"));
                table.addCell(result.getString("name"));
                table.addCell(result.getString("email"));
                table.addCell(result.getString("address"));
            }
            document.add(table);

        } catch (DocumentException | SQLException e) {
            e.printStackTrace();
        }

        document.close();
        clientCount++;
    }

    public void generateProductReport() {
        fileName = "D:\\PT2020_30422_Nagy_LauraBeatrix_Assignment_3\\productReport" + productCount + ".pdf";
        document = new Document();
        try {
            PdfWriter.getInstance(document , new FileOutputStream(fileName));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = null;
            ResultSet result = null;
            String query = "select * from `product`";

            stmt = connection.createStatement();
            result = stmt.executeQuery(query);

            document.add(new Paragraph("Product Table \n"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("productID"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("name"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("quantity"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("price"));
            table.addCell(c1);
            table.setHeaderRows(1);

            while (result.next()) {
                table.addCell(result.getString("productID"));
                table.addCell(result.getString("productname"));
                table.addCell(result.getString("quantity"));
                table.addCell(result.getString("price"));
            }
            document.add(table);

        } catch (DocumentException | SQLException e) {
            e.printStackTrace();
        }

        document.close();
        productCount++;
    }

    public void generateOrderReport() {
        fileName = "D:\\PT2020_30422_Nagy_LauraBeatrix_Assignment_3\\orderReport" + orderCount + ".pdf";
        document = new Document();
        try {
            PdfWriter.getInstance(document , new FileOutputStream(fileName));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = null;
            ResultSet result = null;
            String query = "select * from `order`";

            stmt = connection.createStatement();
            result = stmt.executeQuery(query);

            document.add(new Paragraph("Order Table \n"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("orderID"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("clientID"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("productID"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("quantity"));
            table.addCell(c1);
            table.setHeaderRows(1);

            while (result.next()) {
                table.addCell(result.getString("orderID"));
                table.addCell(result.getString("clientID"));
                table.addCell(result.getString("productID"));
                table.addCell(result.getString("quantity"));
            }
            document.add(table);

        } catch (DocumentException | SQLException e) {
            e.printStackTrace();
        }

        document.close();
        orderCount++;
    }

}



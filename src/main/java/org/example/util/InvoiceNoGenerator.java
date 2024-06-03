package org.example.util;

public class InvoiceNoGenerator {

    public static String generateInvoiceNo(){
        int randomInt = (int) (Math.random() * 90000) + 10000;
        String invoiceNo = String.format("%05d", randomInt);
        return invoiceNo;
    }
}
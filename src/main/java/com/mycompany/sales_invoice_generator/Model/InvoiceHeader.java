/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales_invoice_generator.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ahmed
 */
public class InvoiceHeader {
    private short invoiceNumber;
    private Date  invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> items;

    public short getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(short invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getItems() {
        return items;
    }

    public void setItems(ArrayList<InvoiceLine> items) {
        this.items = items;
    }
    
}

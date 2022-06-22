/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales_invoice_generator.Model;

import com.mycompany.sales_invoice_generator.Controller.controller;
import  com.mycompany.sales_invoice_generator.Sales_invoice_generator;
import java.util.ArrayList;
import com.mycompany.sales_invoice_generator.Model.InvoiceHeader;

import com.mycompany.sales_invoice_generator.View.mainFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmed
 */
public class FileOperations {

    private static ArrayList<InvoiceHeader> invoices;

    /**
     *
     */
    public FileOperations(){
        this.invoices = new ArrayList<InvoiceHeader>();
    }

    /**
     *
     * @return
     */
    public static ArrayList<InvoiceHeader> getInvoices(){
        return invoices;
    }

    /**
     *
     * @param invoices
     */
    public void setInvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    /**
     *
     * @return
     */
    public InvoiceHeader createInvoice(){
        int i = this.invoices.size();
        InvoiceHeader invoice = new InvoiceHeader();
        this.invoices.add((i), invoice);
        invoice.setInvoiceNumber(i+1);

        int index = this.invoices.size()-1;
        return this.invoices.get(index);

    }

    /**
     *
     * @param index
     */
    public void deleteInvoice(int index){
        this.invoices.remove(index);
    }

    /**
     *
     * @return
     */
    public short getInvoicesSize(){
        return (short)this.invoices.size();
    }


    /**
     *
     * @param headerFile
     * @param lineFile
     * @param table
     */
    public  void readFile(File headerFile,File lineFile,JTable table) {

        try {
            FileReader hfr = new FileReader(headerFile);
            BufferedReader hbr = new BufferedReader(hfr);
            FileReader lfr = new FileReader(lineFile);
            BufferedReader lbr = new BufferedReader(lfr);
            // read the first line from the text file
            String headerLine = hbr.readLine();
            String lineLine = lbr.readLine();
            // loop until all lines are read
            while (headerLine != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] headerAttributes = headerLine.split(",");
                InvoiceHeader invoice=this.createInvoice();
                invoice.setInvoiceNumber(Integer.parseInt(headerAttributes[0]));
                if(headerAttributes[1].matches("\\d{2}/\\d{2}/\\d{4}")){
                    invoice.setInvoiceDate(headerAttributes[1]);
                }
                else{System.err.println("Wrong Date Format");}
                invoice.setCustomerName(headerAttributes[2]);
                // read next line before looping
                // if end of file reached, line would be null
                headerLine = hbr.readLine();
            }
            while (lineLine != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] lineAttributes = lineLine.split(",");
                InvoiceLine line=this.getInvoices().get(Integer.parseInt(lineAttributes[0])-1).createLine();
                line.setItemName(lineAttributes[1]);
                line.setItemPrice(Float.parseFloat(lineAttributes[2]));
                line.setCount(Short.parseShort(lineAttributes[3]));
                // read next line before looping
                // if end of file reached, line would be null
                lineLine = lbr.readLine();



            }

        } catch (FileNotFoundException ioe) {System.err.println("File Not Found");}
        catch (IOException ex) {
            System.err.println("wrong file format");
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }




        controller.setTableData(table);
    }

    /**
     *
     * @param headerFile
     * @param lineFile
     * @param headerTable
     * @param lineTable
     */
    public void writeFile(File headerFile,File lineFile,JTable headerTable,JTable lineTable){
        controller.getTableData(headerTable);
        this.getInvoices().get((int)lineTable.getValueAt(0, 0)-1).getTableData(lineTable);
        try {
            FileWriter hfw = new FileWriter(headerFile);
            BufferedWriter hbw = new BufferedWriter(hfw);
            FileWriter lfw = new FileWriter(lineFile);
            BufferedWriter lbw = new BufferedWriter(lfw);
            for(int i=0;i<this.getInvoicesSize();i++){
                hbw.write((this.invoices.get(i).getInvoiceNumber())+",");
                hbw.write(this.invoices.get(i).getInvoiceDate()+",");
                hbw.write(this.invoices.get(i).getCustomerName()+",");
                hbw.newLine();
            }

            for(int i=0;i<this.getInvoicesSize();i++){
                for(int j=0;j<this.getInvoices().get(i).getItemsSize();j++){
                    lbw.write((this.invoices.get(i).getInvoiceNumber())+",");
                    lbw.write( this.getInvoices().get(i).getItems().get(j).getItemName()+",");
                    lbw.write( this.getInvoices().get(i).getItems().get(j).getItemPrice()+",");
                    lbw.write( this.getInvoices().get(i).getItems().get(j).getCount()+",");
                    lbw.newLine();
                }
            }

            hbw.close();
            lbw.close();
        } catch (FileNotFoundException ioe) {System.err.println("File Not Found");}
        catch (IOException ex) {
            System.err.println("wrong file format");
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    /*public void getTableData(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        for(int i =0;i<model.getRowCount();i++){
                this.invoices.get(i).setInvoiceNumber((int) model.getValueAt(i, 0));
        }
        for(int i =0;i<model.getRowCount();i++){
                this.invoices.get(i).setInvoiceDate( model.getValueAt(i, 1).toString());
        }
        for(int i =0;i<model.getRowCount();i++){
                this.invoices.get(i).setCustomerName(model.getValueAt(i, 2).toString());
        }

    }
    public void setTableData(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(this.invoices.size());
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(this.invoices.get(i).getInvoiceNumber(), i, 0);
        }
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(this.invoices.get(i).getInvoiceDate(), i, 1);
        }
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(this.invoices.get(i).getCustomerName(), i, 2);
        }
    }
    */

}

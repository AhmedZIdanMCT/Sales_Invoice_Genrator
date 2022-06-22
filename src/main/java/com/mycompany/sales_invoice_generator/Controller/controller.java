/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales_invoice_generator.Controller;

import com.mycompany.sales_invoice_generator.Model.FileOperations;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmed
 */
public class controller {
    public static void getTableData(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        for(int i =0;i<model.getRowCount();i++){

            FileOperations.getInvoices().get(i).setInvoiceNumber((int) model.getValueAt(i, 0));
        }
        for(int i =0;i<model.getRowCount();i++){
            FileOperations.getInvoices().get(i).setInvoiceDate( model.getValueAt(i, 1).toString());
        }
        for(int i =0;i<model.getRowCount();i++){
            FileOperations.getInvoices().get(i).setCustomerName(model.getValueAt(i, 2).toString());
        }

    }
    public static void setTableData(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(FileOperations.getInvoices().size());
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(FileOperations.getInvoices().get(i).getInvoiceNumber(), i, 0);
        }
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(FileOperations.getInvoices().get(i).getInvoiceDate(), i, 1);
        }
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(FileOperations.getInvoices().get(i).getCustomerName(), i, 2);
        }
    }
}

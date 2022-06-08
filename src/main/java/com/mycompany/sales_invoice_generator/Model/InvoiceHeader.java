/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales_invoice_generator.Model;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmed
 */
public class InvoiceHeader {
    private int invoiceNumber;
    private String  invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> items;
    
    public InvoiceHeader(){
        this.items=new ArrayList<InvoiceLine>();
    }
    
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
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
    
    /**
     *
     * @return
     */
    public InvoiceLine createLine(){
        int i = this.items.size();
        this.items.add((i),  new InvoiceLine());
        int index = this.items.size();
        return this.items.get(index-1);
        
    }
    
    /**
     *
     * @param index
     */
    public void deleteLine(int index){
    this.items.remove(index);
    }
     
    /**
     *
     * @return
     */
    public short getItemsSize(){
    return (short)this.items.size();
    }
    
    public void getTableData(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        for(int i =0;i<model.getRowCount();i++){ 
            if(model.getValueAt(i, 1)!=null){
                this.items.get(i).setItemName( model.getValueAt(i, 1).toString());
            }
        }
        for(int i =0;i<model.getRowCount();i++){ 
         if(model.getValueAt(i, 2)!=null){
            this.items.get(i).setItemPrice((float) model.getValueAt(i, 2));
         }
        }
        for(int i =0;i<model.getRowCount();i++){ 
         if(model.getValueAt(i, 3)!=null){
            this.items.get(i).setCount((short)model.getValueAt(i, 3));
         }
        }
       
    }
    public void setTableData(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(this.items.size());
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(this.getInvoiceNumber(), i, 0);
        }
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(this.items.get(i).getItemName(), i, 1);
        }
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(this.items.get(i).getItemPrice(), i, 2);
        }
        for(int i=0;i<model.getRowCount();i++){
            model.setValueAt(this.items.get(i).getCount(), i, 3);
        }
    }
}

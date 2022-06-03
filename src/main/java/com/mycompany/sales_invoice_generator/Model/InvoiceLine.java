/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales_invoice_generator.Model;

/**
 *
 * @author ahmed
 */
public class InvoiceLine {
    private String itemName;
    private float itemPrice;
    private short Count;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public short getCount() {
        return Count;
    }

    public void setCount(short Count) {
        this.Count = Count;
    }
    
}

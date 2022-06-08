/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sales_invoice_generator;
import com.mycompany.sales_invoice_generator.Model.InvoiceHeader;
import com.mycompany.sales_invoice_generator.Model.FileOperations;
import com.mycompany.sales_invoice_generator.View.mainFrame;
import static java.sql.DriverManager.println;

/**
 *
 * @author ahmed
 */
public class Sales_invoice_generator {
        
       public static FileOperations inOut;
       public static mainFrame mainframe;

    public static void main(String[] args) {
       inOut = new FileOperations();
        mainframe = new mainFrame();
       mainframe.setVisible(true);
  
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sales_invoice_generator;
import com.mycompany.sales_invoice_generator.Model.FileOperations;
import com.mycompany.sales_invoice_generator.View.mainFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        
       
        String headerName="\\InvoiceHeader.csv";
        String path=System. getProperty("user.dir");
        
       String lineName="\\InvoiceLine.csv";
        String headerFileName=path+headerName;
        String lineFileName=path+lineName;
        File headerFile=new File(headerFileName);
        File lineFile=new File(lineFileName);
        
      try {
            FileReader hfr = new FileReader(headerFile);
            BufferedReader hbr = new BufferedReader(hfr);
            FileInputStream lfr = new FileInputStream(lineFile) ;
            BufferedReader lbr = new BufferedReader(new InputStreamReader(lfr));
           // read the first line from the text file 
           String headerLine = hbr.readLine(); 
           
           // loop until all lines are read 
            while (headerLine != null) { 
                    // use string.split to load a string array with the values from 
                    // each line of 
                    // the file, using a comma as the delimiter 
                    String[] headerAttributes = headerLine.split(","); 
                    System.out.println("invoice Num "+headerAttributes[0]);
                    System.out.println("{");
                    System.out.println(headerAttributes[1]+","+headerAttributes[2]);
                    int currentInvoice =Integer.parseInt(headerAttributes[0]);
                    String lineLine = lbr.readLine();
                     while (lineLine != null) { 
                            // use string.split to load a string array with the values from 
                            // each line of 
                            // the file, using a comma as the delimiter 
                            String[] lineAttributes = lineLine.split(","); 
                            if(Integer.parseInt(lineAttributes[0])==currentInvoice){
                                    System.out.println(lineAttributes[1]+" "+lineAttributes[2]+" "+lineAttributes[3]);
                            }
                            // read next line before looping 
                            // if end of file reached, line would be null 
                            lineLine = lbr.readLine();
                    
                        }
                    System.out.println("}");
                    
                    lfr.getChannel().position(0);
                    lbr = new BufferedReader(new InputStreamReader(lfr));

                    // read next line before looping 
                    // if end of file reached, line would be null 
                    headerLine = hbr.readLine(); 
                    
            }
           
            hbr.close();
            lbr.close();
            } catch (IOException ioe) {}
  
    }
}

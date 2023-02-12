
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vusumuzi
 */
public class ViewStockPage extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewStockPage
     */   String[] productArray=new String[8];
       String[] requidArray=new String[8];
       String[] availableArray=new String[8];
       String[] dateArray=new String[8];
       String[] statusArray=new String[8];
      int count=0; 
    public ViewStockPage() {
  
        
        initComponents();
       
      
       try
        {
            File file=new File("StockData - Copy.txt");
            Scanner scan=new Scanner(file);
            scan.useDelimiter("\\s+");
            while(scan.hasNextLine())
            {
                String line1=scan.next();
                String line2=scan.next();
                String line3=scan.next();
                String line4=scan.next();
                String line5=scan.next();
               
                productArray[count]=line1;
                requidArray[count]=line2;
                availableArray[count]=line3;
                dateArray[count]=line4;
                statusArray[count]=line5;

                count++;     
            }
           scan.close();
        }
        catch (Exception e)
        {}
        for(int i=0;i<count;i++)
        {
            String[] data={productArray[i+1],requidArray[i+1],availableArray[i+1],dateArray[i+1],statusArray[i+1]};
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            model.addRow(data);
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        excelButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("View Stock Page");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT", "REQUIRED", "AVAILABLE", "DATE", "STATUS"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stock on Hand");

        excelButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        excelButton.setForeground(new java.awt.Color(0, 0, 255));
        excelButton.setText("EXPORT TO EXCEL");
        excelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(excelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(excelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void excelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelButtonActionPerformed

      

        try
        {
           FileWriter fWriter=new FileWriter("StockToExcel.csv");
           BufferedWriter bWriter=new BufferedWriter(fWriter);
           PrintWriter printer=new PrintWriter(bWriter);
           
           printer.println("sep=,");
           for (int i=0;i<8;i++)
          {
               
              printer.println(productArray[i]+","+requidArray[i]+","+availableArray[i]+","+dateArray[i]+","+statusArray[i]);
           }
           
           
           printer.close();
           printer.close();
         
             Desktop.getDesktop().open(new java.io.File("StockToExcel.csv"));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"error occured");
        }

    
    }//GEN-LAST:event_excelButtonActionPerformed
 
              
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton excelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
         }

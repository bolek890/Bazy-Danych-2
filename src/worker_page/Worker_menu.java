/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package worker_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login_page.DataBaseConnector;

/**
 *
 * @author Bolek
 */
public class Worker_menu extends javax.swing.JFrame {

    DataBaseConnector worker_data_connection = new DataBaseConnector();
    int selected;
    int selected_deliverer;
    
    
    public void setWorker_connection(DataBaseConnector worker_data_connection) {
        this.worker_data_connection = worker_data_connection;
       // System.out.println(worker_data_connection.getURL());
    }
    
    // Odczyt danych z bazy do tabeli
    public ArrayList<worker_product> productList(){
        ArrayList<worker_product> productList = new ArrayList<>();
         try{
             Class.forName(worker_data_connection.getClassName());
             Connection con = DriverManager.getConnection(worker_data_connection.getURL(), worker_data_connection.getUser(), worker_data_connection.getPassword());
             String query1="Select * from produkty_w_magazynach_view";
             
             Statement st= con.createStatement();
             ResultSet rs= st.executeQuery(query1);
             worker_product product;
             while(rs.next()){
                 product= new worker_product(rs.getInt("id"), rs.getString("nazwa"), rs.getFloat("cena"), rs.getInt("ilosc"), rs.getInt("magazyn_id"));
                 productList.add(product);
                }
             } 
         catch(Exception e){
                        System.out.println(e.getMessage()); 
          }
         return productList;
    }
    
    // Wyświetlanie w tabeli
    public void show_product(){
    ArrayList<worker_product> list = productList();
    DefaultTableModel model= (DefaultTableModel)productTable.getModel();
    model.setRowCount(0);
    Object[] row= new Object[5];
    for(int i=0; i<list.size(); i++){
        row[0]= list.get(i).getId();
        row[1]= list.get(i).getNazwa();
        row[2]= list.get(i).getCena();
        row[3]= list.get(i).getIlosc();
        row[4]= list.get(i).getMagazyn();
        model.addRow(row);
        }
     list.clear();
    }
        // Odczyt danych z bazy do tabeli
    public ArrayList<worker_deliverer> delivererList(){
        ArrayList<worker_deliverer> productList = new ArrayList<>();
         try{
             Class.forName(worker_data_connection.getClassName());
             Connection con = DriverManager.getConnection(worker_data_connection.getURL(), worker_data_connection.getUser(), worker_data_connection.getPassword());
             String query1="Select * from dostawca";
             
             Statement st= con.createStatement();
             ResultSet rs= st.executeQuery(query1);
             worker_deliverer deliverer;
             while(rs.next()){
                 deliverer= new worker_deliverer(rs.getString("nazwa"), rs.getInt("id"), rs.getFloat("cena"), rs.getInt("czas_oczekiwania_dni"));
                 productList.add(deliverer);
                }
             } 
         catch(Exception e){
                        System.out.println(e.getMessage()); 
          }
         return productList;
    }
    
    // Wyświetlanie w tabeli
    public  void show_deliverer(){
    
    ArrayList<worker_deliverer> list = delivererList();
    DefaultTableModel model= (DefaultTableModel)delivererTable.getModel();
    model.setRowCount(0);
    Object[] row= new Object[4];
    for(int i=0; i<list.size(); i++){
        row[0]= list.get(i).getId();
        row[1]= list.get(i).getNazwa();
        row[2]= list.get(i).getCena();
        row[3]= list.get(i).getCzas_oczekiwania();
        model.addRow(row);
        }
    list.clear();
    }
    

    /**
     * Creates new form Worker_menu
     */
    public Worker_menu() {
        
        initComponents();
        show_product();
        show_deliverer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        editProductbtn = new javax.swing.JButton();
        newProductbtn = new javax.swing.JButton();
        deleteProductbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        delivererTable = new javax.swing.JTable();
        newDelivererbtn = new javax.swing.JButton();
        editDelivererbtn = new javax.swing.JButton();
        deleteDelivererbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nazwa", "Cena", "Ilość", "Magazyn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        editProductbtn.setText("Edytuj produkt");
        editProductbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductbtnActionPerformed(evt);
            }
        });

        newProductbtn.setText("Nowy produkt");
        newProductbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductbtnActionPerformed(evt);
            }
        });

        deleteProductbtn.setText("Usuń produkt");
        deleteProductbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductbtnActionPerformed(evt);
            }
        });

        delivererTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nazwa", "Cena", "Czas oczekiwania"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        delivererTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delivererTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(delivererTable);

        newDelivererbtn.setText("Dodaj dostawcę");
        newDelivererbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDelivererbtnActionPerformed(evt);
            }
        });

        editDelivererbtn.setText("Edytuj dostawcę");
        editDelivererbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDelivererbtnActionPerformed(evt);
            }
        });

        deleteDelivererbtn.setText("Usuń dostawcę");
        deleteDelivererbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDelivererbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Zalogowano jako pracownik sklepu");

        refreshBtn.setText("Odśwież");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newProductbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(editProductbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteProductbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newDelivererbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editDelivererbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteDelivererbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newProductbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editProductbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteProductbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newDelivererbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editDelivererbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteDelivererbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Zrobione
    private void editProductbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductbtnActionPerformed
        // TODO add your handling code here:
        Edit_product_panel panel= new Edit_product_panel();
        panel.idProductEdt.setText(productTable.getValueAt(selected, 0).toString());
        panel.nameEdt.setText(productTable.getValueAt(selected, 1).toString());
        panel.priceEdt.setText(productTable.getValueAt(selected, 2).toString());
        panel.numberEdt.setText(productTable.getValueAt(selected, 3).toString());
        setVisible(true);
        panel.setVisible(true);
    }//GEN-LAST:event_editProductbtnActionPerformed

    // Zrobione
    private void newProductbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductbtnActionPerformed
        // TODO add your handling code here:
        New_product_panel panel= new New_product_panel();
        setVisible(true);
        panel.setVisible(true);
    }//GEN-LAST:event_newProductbtnActionPerformed

    
    private void newDelivererbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDelivererbtnActionPerformed
        // TODO add your handling code here:
        New_deliverer_panel panel= new New_deliverer_panel();
        setVisible(true);
        panel.setVisible(true);
    }//GEN-LAST:event_newDelivererbtnActionPerformed

    // Zrobione
    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        show_product();
        show_deliverer();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        // TODO add your handling code here:
        selected = productTable.getSelectedRow();
    }//GEN-LAST:event_productTableMouseClicked

    private void deleteProductbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductbtnActionPerformed
        // TODO add your handling code here:
        try{
                        
            int dialogResult = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć ten produkt?", "Uwaga", JOptionPane.YES_NO_OPTION);
            
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                        Class.forName(worker_data_connection.getClassName());
                        Connection con = DriverManager.getConnection(worker_data_connection.getURL(), worker_data_connection.getUser(), worker_data_connection.getPassword());

                        String insert1 = "DELETE FROM produkt WHERE id=?";
                        PreparedStatement pst = con.prepareStatement(insert1);
                        pst.setString(1, productTable.getValueAt(selected, 0).toString());
                        pst.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Usunięcie powiodło się!");
            }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage()); 
                        JOptionPane.showMessageDialog(null, "Błąd!");
                    }
    }//GEN-LAST:event_deleteProductbtnActionPerformed

    private void editDelivererbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDelivererbtnActionPerformed
        // TODO add your handling code here:
        Edit_deliverer_panel panel= new Edit_deliverer_panel();
        panel.delivererIdEdt.setText(delivererTable.getValueAt(selected_deliverer, 0).toString());
        panel.nameEdt.setText(delivererTable.getValueAt(selected_deliverer, 1).toString());
        panel.priceEdt.setText(delivererTable.getValueAt(selected_deliverer, 2).toString());
        panel.waitTimeEdt.setText(delivererTable.getValueAt(selected_deliverer, 3).toString());
        setVisible(true);
        panel.setVisible(true);
    }//GEN-LAST:event_editDelivererbtnActionPerformed

    private void delivererTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delivererTableMouseClicked
        // TODO add your handling code here:
        selected_deliverer = delivererTable.getSelectedRow();
    }//GEN-LAST:event_delivererTableMouseClicked

    private void deleteDelivererbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDelivererbtnActionPerformed
        // TODO add your handling code here:
        try{
                        
            int dialogResult = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć tego dostawcę?", "Uwaga", JOptionPane.YES_NO_OPTION);
            
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                        Class.forName(worker_data_connection.getClassName());
                        Connection con = DriverManager.getConnection(worker_data_connection.getURL(), worker_data_connection.getUser(), worker_data_connection.getPassword());

                        String insert1 = "DELETE FROM dostawca WHERE id=?";
                        PreparedStatement pst = con.prepareStatement(insert1);
                        pst.setString(1, delivererTable.getValueAt(selected_deliverer, 0).toString());
                        pst.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Usunięcie powiodło się!");
            }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage()); 
                        JOptionPane.showMessageDialog(null, "Błąd!");
                    }
    }//GEN-LAST:event_deleteDelivererbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Worker_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Worker_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Worker_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Worker_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Worker_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteDelivererbtn;
    private javax.swing.JButton deleteProductbtn;
    private javax.swing.JTable delivererTable;
    private javax.swing.JButton editDelivererbtn;
    private javax.swing.JButton editProductbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newDelivererbtn;
    private javax.swing.JButton newProductbtn;
    private javax.swing.JTable productTable;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}

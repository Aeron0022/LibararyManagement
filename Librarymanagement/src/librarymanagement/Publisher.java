/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Publisher extends javax.swing.JFrame {

    
    public Publisher() {
        initComponents();
        
        Connect();
        Publisher_Load();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Ptxtname = new javax.swing.JTextField();
        Ptxtaddress = new javax.swing.JTextField();
        PtxtPhone = new javax.swing.JTextField();
        Padd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        Pupdate = new javax.swing.JButton();
        Pdelete = new javax.swing.JButton();
        PBackl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Publisher");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Phone number");

        Padd.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Padd.setText("Add");
        Padd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaddActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address", "Phone"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable3);

        Pupdate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Pupdate.setText("Update");
        Pupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PupdateActionPerformed(evt);
            }
        });

        Pdelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Pdelete.setText("Delete");
        Pdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PdeleteActionPerformed(evt);
            }
        });

        PBackl.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        PBackl.setText("Back");
        PBackl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PBacklActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Ptxtname, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(PtxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ptxtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Padd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PBackl, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(Ptxtname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PtxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ptxtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Padd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PBackl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaddActionPerformed

        DefaultTableModel d = (DefaultTableModel)jTable3.getModel();
        d.setRowCount(0);

        String pubName = Ptxtname.getText();
        String PubAddress = Ptxtaddress.getText();
        String Phone = PtxtPhone.getText();

        try {
            pst = con.prepareStatement("insert into publisher(pubName,PubAddress,Phone)values(?,?,?)");

            pst.setString(1, pubName);
            pst.setString(2 , PubAddress);
            pst.setString(3 , Phone);

            int k = pst.executeUpdate();

            if(k == 1)
            {
                JOptionPane.showMessageDialog(this,"Publisher Created");
                Ptxtname.setText("");
                Ptxtaddress.setText("");
                PtxtPhone.setText("");
                Ptxtname.requestFocus();
                Publisher_Load();
            }

            else
            {
                JOptionPane.showMessageDialog(this,"Error!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PaddActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable3.getModel();
        int selectIndex = jTable3.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());

        Ptxtname.setText(d1.getValueAt(selectIndex,1).toString());
        Ptxtaddress.setText(d1.getValueAt(selectIndex,2).toString());
        PtxtPhone.setText(d1.getValueAt(selectIndex,3).toString());

        Padd.setEnabled(false);
    }//GEN-LAST:event_jTable3MouseClicked

    private void PupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PupdateActionPerformed

        DefaultTableModel d1 = (DefaultTableModel)jTable3.getModel();
        int selectIndex = jTable3.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());

        String pubName = Ptxtname.getText();
        String PubAddress = Ptxtaddress.getText();
        String Phone = PtxtPhone.getText();

        try {
            pst = con.prepareStatement("Update publisher set pubName = ? ,PubAddress = ?, Phone = ? where Id = ?");

            pst.setString(1, pubName);
            pst.setString(2 , PubAddress);
            pst.setString(3 , Phone);
            pst.setInt(4 , id);

            int k = pst.executeUpdate();

            if(k == 1)
            {
                JOptionPane.showMessageDialog(this,"Publisher Updated");
                Ptxtname.setText("");
                Ptxtaddress.setText("");
                PtxtPhone.setText("");
                Ptxtname.requestFocus();
                Padd.setEnabled(true);
                Publisher_Load();
            }

            else
            {
                JOptionPane.showMessageDialog(this,"Error!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PupdateActionPerformed

    private void PdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PdeleteActionPerformed

        DefaultTableModel d1 = (DefaultTableModel)jTable3.getModel();
        int selectIndex = jTable3.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());

        try {
            pst = con.prepareStatement("delete from publisher where id = ?");

            pst.setInt(1 , id);
            int k = pst.executeUpdate();

            if(k == 1)
            {
                JOptionPane.showMessageDialog(this,"Publisher Deleted");
                Ptxtname.setText("");
                Ptxtaddress.setText("");
                PtxtPhone.setText("");
                Ptxtname.requestFocus();
                Padd.setEnabled(true);
                Publisher_Load();
            }

            else
            {
                JOptionPane.showMessageDialog(this,"Error!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PdeleteActionPerformed

    private void PBacklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PBacklActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_PBacklActionPerformed

   public void Connect()
            
    {
          try {
            Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/librarymanagement","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

  
    public void Publisher_Load()
    {
        int c;
        try {
            pst = con.prepareStatement("select * from publisher");
            
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable3.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1; i<=c; i++)
                {
                v2.add(rs.getString("Id"));
                v2.add(rs.getString("pubname"));
                v2.add(rs.getString("PubAddress"));
                v2.add(rs.getString("Phone"));
                }
                
                d.addRow(v2);
            }
            
            
         } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void AdeleteActionPerformed(java.awt.event.ActionEvent evt) {                                        

        DefaultTableModel d1 = (DefaultTableModel)jTable3.getModel();
        int selectIndex = jTable3.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());

        try {
            pst = con.prepareStatement("delete from publisher where id = ?");

            pst.setInt(1 , id);
            int k = pst.executeUpdate();

            if(k == 1)
            {
                JOptionPane.showMessageDialog(this,"Publisher Deleted");
                Ptxtname.setText("");
                Ptxtaddress.setText("");
                PtxtPhone.setText("");
                Ptxtname.requestFocus();
                Padd.setEnabled(true);
                Publisher_Load();
            }

            else
            {
                JOptionPane.showMessageDialog(this,"Error!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                       

    private void AupdateActionPerformed(java.awt.event.ActionEvent evt) {                                        

        DefaultTableModel d1 = (DefaultTableModel)jTable3.getModel();
        int selectIndex = jTable3.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());

        String pubName = Ptxtname.getText();
        String PubAddress = Ptxtaddress.getText();
        String Phone = PtxtPhone.getText();

        try {
            pst = con.prepareStatement("Update publisher set pubName = ? ,PubAddress = ?, Phone = ? where Id = ?");

            pst.setString(1, pubName);
            pst.setString(2 , PubAddress);
            pst.setString(3 , Phone);
            pst.setInt(4 , id);

            int k = pst.executeUpdate();

            if(k == 1)
            {
                JOptionPane.showMessageDialog(this,"Publisher Updated");
                Ptxtname.setText("");
                Ptxtaddress.setText("");
                PtxtPhone.setText("");
                Ptxtname.requestFocus();
                Padd.setEnabled(true);
                Publisher_Load();
            }

            else
            {
                JOptionPane.showMessageDialog(this,"Error!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                       

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable3.getModel();
        int selectIndex = jTable3.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());

        Ptxtname.setText(d1.getValueAt(selectIndex,1).toString());
        Ptxtaddress.setText(d1.getValueAt(selectIndex,2).toString());
        PtxtPhone.setText(d1.getValueAt(selectIndex,3).toString());

        Padd.setEnabled(false);
    }                                    

    private void AaddActionPerformed(java.awt.event.ActionEvent evt) {                                     

        DefaultTableModel d = (DefaultTableModel)jTable3.getModel();
        d.setRowCount(0);

        String pubName = Ptxtname.getText();
        String PubAddress = Ptxtaddress.getText();
        String Phone = PtxtPhone.getText();

        try {
            pst = con.prepareStatement("insert into publisher(pubName,PubAddress,Phone)values(?,?,?)");

             pst.setString(1, pubName);
             pst.setString(2 , PubAddress);
             pst.setString(3 , Phone);
            
            int k = pst.executeUpdate();

            if(k == 1)
            {
                JOptionPane.showMessageDialog(this,"Publisher Created");
                Ptxtname.setText("");
                Ptxtaddress.setText("");
                PtxtPhone.setText("");
                Ptxtname.requestFocus();
                Padd.setEnabled(true);
                 Publisher_Load();
            }

            else
            {
                JOptionPane.showMessageDialog(this,"Error!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                    

    private void CcancelActionPerformed(java.awt.event.ActionEvent evt) {                                        

        this.setVisible(false);
    }     
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
            java.util.logging.Logger.getLogger(Publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Publisher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PBackl;
    private javax.swing.JButton Padd;
    private javax.swing.JButton Pdelete;
    private javax.swing.JTextField PtxtPhone;
    private javax.swing.JTextField Ptxtaddress;
    private javax.swing.JTextField Ptxtname;
    private javax.swing.JButton Pupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}

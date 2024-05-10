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


public final class Book extends javax.swing.JFrame {

    private int selectIndex;

    /**
     * Creates new form Book
     */
    public Book() {
        initComponents();
        
        Connect();
        Book_Load();
        Category();
        Author();
        Publisher();
    }  
    public class CategoryItem
    {
    int id;
    String name;
    
    public CategoryItem(int id,String name)
    { 
    this.id = id;
    this.name = name;
    }
    public String toString()
    {
    return name;
    }  
    }
public class AuthorItem
    {
    int id;
    String name;
    
    public AuthorItem(int id,String name)
    { 
    this.id = id;
    this.name = name;
    }
    public String toString()
    {
    return name;
    }  
    }

public class PublisherItem
    {
    int id;
    String name;
    
    public PublisherItem(int id,String name)
    { 
    this.id = id;
    this.name = name;
    }
    public String toString()
    {
    return name;
    }  
    }
    
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
 

     public void Book_Load(){
        int c;
        try {
            pst = con.prepareStatement("select b.id, b.Name,c.catname,a.Author_name,p.pubName,b.Content,b.Page,b.edition from book b JOIN category c On b.Catname = c.id "
                    + " JOIN author a On b.Author = a.id JOIN publisher p On b.Publisher = p.id ");
            
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jBookTable.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1; i<=c; i++)
                {
                v2.add(rs.getString("b.id"));
                v2.add(rs.getString("b.Name"));
                v2.add(rs.getString("c.catname"));
                v2.add(rs.getString("a.Author_name"));
                v2.add(rs.getString("p.pubName"));
                v2.add(rs.getString("b.Content"));
                v2.add(rs.getString("b.Page"));
                v2.add(rs.getString("b.edition"));
                
                }
                
                d.addRow(v2);
            }
             
         } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void Connect()        
    {
          try {
            Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/librarymanagement","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
      
     public void Category(){
     
        try {
            pst = con.prepareStatement("select * from category");
            rs = pst.executeQuery();
            
            Btxtcategory.removeAllItems();
            
            while(rs.next())
            {
                 Btxtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
     }
      public void Author(){
     
        try {
            pst = con.prepareStatement("select * from author");
            rs = pst.executeQuery();
            
            BtxtAuthor.removeAllItems();
            
            while(rs.next())
            {
                 BtxtAuthor.addItem(new AuthorItem(rs.getInt(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
     }
      
       public void Publisher(){
     
        try {
            pst = con.prepareStatement("select * from publisher");
            rs = pst.executeQuery();
            
            Btxtpublisher.removeAllItems();
            
            while(rs.next())
            {
                 Btxtpublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
     }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Btxtcategory = new javax.swing.JComboBox();
        Btxtpublisher = new javax.swing.JComboBox();
        BtxtAuthor = new javax.swing.JComboBox();
        BtxtnoOfPage = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Btxtname = new javax.swing.JTextField();
        Btxtcontent = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Btxtedition = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBookTable = new javax.swing.JTable();
        Badd = new javax.swing.JButton();
        BDelete = new javax.swing.JButton();
        Bupdate = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Book");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Category");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Book Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Publisher");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Author");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Edition");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Contents");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("No of Page");

        jBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Name", "Category", "Author Name", "Publisher Name", "Contents", "No of Pages", "Edition"
            }
        ));
        jBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jBookTable);

        Badd.setText("ADD");
        Badd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaddActionPerformed(evt);
            }
        });

        BDelete.setText("Delete");
        BDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeleteActionPerformed(evt);
            }
        });

        Bupdate.setText("Update");
        Bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BupdateActionPerformed(evt);
            }
        });

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btxtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btxtname))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtxtAuthor, 0, 152, Short.MAX_VALUE)
                                    .addComponent(Btxtpublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtxtnoOfPage, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btxtcontent, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(Btxtedition, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(427, 427, 427))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Badd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(BDelete)
                        .addGap(118, 118, 118)
                        .addComponent(Bupdate)
                        .addGap(107, 107, 107)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(BtxtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(Btxtcontent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btxtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Btxtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtxtnoOfPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btxtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Btxtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Badd)
                    .addComponent(BDelete)
                    .addComponent(Bupdate)
                    .addComponent(jButton4))
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void BaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaddActionPerformed
      
        DefaultTableModel d1 = (DefaultTableModel)jBookTable.getModel();
        d1.setRowCount(0);
        
      String Name = Btxtname.getText();
      CategoryItem Catname = (CategoryItem)  Btxtcategory.getSelectedItem();
      AuthorItem Author = (AuthorItem)  BtxtAuthor.getSelectedItem();
      PublisherItem Publisher = (PublisherItem)  Btxtpublisher.getSelectedItem();
      String Content = Btxtcontent.getText();
      String Page = BtxtnoOfPage.getText();
      String edition = Btxtedition.getText();
      
      try {
            pst = con.prepareStatement("insert into book(Name,Catname,Author,Publisher,Content,Page,edition)values(?,?,?,?,?,?,?)");
            
            pst.setString(1,   Name );
            pst.setInt(2 , Catname.id);
            pst.setInt(3 , Author.id);
            pst.setInt(4 ,Publisher.id);
            pst.setString(5,  Content );
            pst.setString(6,  Page );
            pst.setString(7, edition);
             

            int k = pst.executeUpdate();

            if(k == 1)
            {
                JOptionPane.showMessageDialog(this,"Book Created");
                Btxtname.setText("");
                Btxtcategory.setSelectedItem("");
                BtxtAuthor.setSelectedItem("");
                Btxtpublisher.setSelectedItem("");
                Btxtcontent.setText("");
                BtxtnoOfPage.setText("");
                Btxtedition.setText("");
                Book_Load();
            }

            else
            {
                JOptionPane.showMessageDialog(this,"Error!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            
    }//GEN-LAST:event_BaddActionPerformed

    private void jBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBookTableMouseClicked
       DefaultTableModel d1 = (DefaultTableModel)jBookTable.getModel();
        int selectIndex = jBookTable.getSelectedRow();
        
         int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
         Btxtname.setText(d1.getValueAt(selectIndex,1).toString());
         Btxtcategory.setSelectedItem(d1.getValueAt(selectIndex,2).toString());
         BtxtAuthor.setSelectedItem(d1.getValueAt(selectIndex,3).toString());
         Btxtpublisher.setSelectedItem(d1.getValueAt(selectIndex,4).toString());
         Btxtcontent.setText(d1.getValueAt(selectIndex,5).toString());
         BtxtnoOfPage.setText(d1.getValueAt(selectIndex,6).toString());
         Btxtedition.setText(d1.getValueAt(selectIndex,7).toString());
    }//GEN-LAST:event_jBookTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeleteActionPerformed
         DefaultTableModel d1 = (DefaultTableModel)jBookTable.getModel();
        int selectIndex = jBookTable.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());

        try {
            pst = con.prepareStatement("delete from book where id = ?");

            pst.setInt(1 , id);
            int k = pst.executeUpdate();

            if(k == 1)
            {
                JOptionPane.showMessageDialog(this,"Book Deleted");
                Btxtname.setText("");
                Btxtcategory.setSelectedItem("");
                BtxtAuthor.setSelectedItem("");
                Btxtpublisher.setSelectedItem("");
                Btxtcontent.setText("");
                BtxtnoOfPage.setText("");
                Btxtedition.setText("");
                 Book_Load();
            }

            else
            {
                JOptionPane.showMessageDialog(this,"Error!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BDeleteActionPerformed

    private void BupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BupdateActionPerformed
        
    DefaultTableModel d1 = (DefaultTableModel) jBookTable.getModel();
    int selectIndex = jBookTable.getSelectedRow();
    int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

    String Name = Btxtname.getText();
    CategoryItem Catname = (CategoryItem) Btxtcategory.getSelectedItem();
    AuthorItem Author = (AuthorItem) BtxtAuthor.getSelectedItem();
    PublisherItem Publisher = (PublisherItem) Btxtpublisher.getSelectedItem();
    String Content = Btxtcontent.getText();
    String Page = BtxtnoOfPage.getText();
    String edition = Btxtedition.getText();

         try {
        pst = con.prepareStatement("UPDATE book SET Name=?, Catname=?, Author=?, Publisher=?, Content=?, Page=?, edition=? WHERE Id=?");

        pst.setString(1, Name);
        pst.setInt(2, Catname.id);
        pst.setInt(3, Author.id);
        pst.setInt(4, Publisher.id);
        pst.setString(5, Content);
        pst.setString(6, Page);
        pst.setString(7, edition);
        pst.setInt(8, id);

        int k = pst.executeUpdate();

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Book Updated");
            Btxtname.setText("");
            Btxtcategory.setSelectedIndex(-1); // Clear selection
            BtxtAuthor.setSelectedIndex(-1); // Clear selection
            Btxtpublisher.setSelectedIndex(-1); // Clear selection
            Btxtcontent.setText("");
            BtxtnoOfPage.setText("");
            Btxtedition.setText("");
            Book_Load();
        } else {
            JOptionPane.showMessageDialog(this, "Error!");
        }

    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }     

    }//GEN-LAST:event_BupdateActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BDelete;
    private javax.swing.JButton Badd;
    private javax.swing.JComboBox BtxtAuthor;
    private javax.swing.JComboBox Btxtcategory;
    private javax.swing.JTextField Btxtcontent;
    private javax.swing.JTextField Btxtedition;
    private javax.swing.JTextField Btxtname;
    private javax.swing.JTextField BtxtnoOfPage;
    private javax.swing.JComboBox Btxtpublisher;
    private javax.swing.JButton Bupdate;
    private javax.swing.JTable jBookTable;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

   
}

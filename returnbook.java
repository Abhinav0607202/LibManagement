/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagemnetsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class returnbook extends javax.swing.JFrame {

    /**
     * Creates new form returnbook
     */
    public returnbook() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Book Id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 60, 83, 27));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Student Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 116, 83, 31));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Issue Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 210, 83, 26));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Due Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 268, 83, 31));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 62, 127, -1));
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 116, 127, -1));
        getContentPane().add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 214, 127, -1));
        getContentPane().add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 272, 127, -1));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive - jecrc.ac.in\\Desktop\\Images\\Icon 1\\search.png")); // NOI18N
        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 163, 103, -1));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive - jecrc.ac.in\\Desktop\\Images\\Icon 1\\return book png.png")); // NOI18N
        jButton2.setText("Return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 332, 112, -1));

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive - jecrc.ac.in\\Desktop\\Images\\Icon 1\\red-x-mark-transparent-background-3.png")); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 110, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive - jecrc.ac.in\\Desktop\\Images\\Icon 1\\123456.png")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String Bookid=t1.getText();
        String studentId=t2.getText();  
if(t1.getText().equals("")||t2.getText().equals(""))
{
JOptionPane.showMessageDialog(null,"Please Enter details");
}

else
{
    
    try {
        Connection con=conn.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from issuebook where Bookid='"+Bookid+"' and studentId='"+studentId+"'");
        if(rs.next())
        {
        t3.setText(rs.getString(3));
        t4.setText(rs.getString(4));
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        
        }
        
        else
        {
        JOptionPane.showMessageDialog(null,"Book is not issued to this student");
            setVisible(false);
            new returnbook().setVisible(true);
        
        }
    } catch (Exception e) {
        
         JOptionPane.showMessageDialog(null,"Connection error");
        
    }
    }




        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.dispose();
new home().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String Bookid=t1.getText();
        String studentId=t2.getText();  
if(t1.getText().equals("")||t2.getText().equals(""))
{
JOptionPane.showMessageDialog(null,"Please Enter details");
}

else
{
    
    try {
        Connection con=conn.getCon();
            Statement st=con.createStatement();
            st.executeUpdate("update issuebook set returnbook='Yes' where studentId='"+studentId+"' and Bookid='"+Bookid+"'");
            JOptionPane.showMessageDialog(null,"Returned Successfully");
            setVisible(false);
            new returnbook().setVisible(true);
            
    }
    catch(Exception e)
    {
        
        JOptionPane.showMessageDialog(null,"Connection Error");
        
    }}



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    // End of variables declaration//GEN-END:variables
}

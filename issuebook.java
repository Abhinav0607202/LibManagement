/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagemnetsystem;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import librarymanagemnetsystem.conn;
/**
 *
 * @author admin
 */
public class issuebook extends javax.swing.JFrame {

    /**
     * Creates new form issuebook
     */
    public issuebook() {
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

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jSpinField1 = new com.toedter.components.JSpinField();
        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ds1 = new com.toedter.calendar.JDateChooser();
        ds2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Book id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 91, 30));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 133, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Student id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 91, 34));
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 125, 133, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Issue Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 83, 42));
        getContentPane().add(ds1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 133, 32));
        getContentPane().add(ds2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 133, 34));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Return Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 34));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive - jecrc.ac.in\\Desktop\\Images\\Icon 1\\issue book.png")); // NOI18N
        jButton1.setText("Issue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 103, 39));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive - jecrc.ac.in\\Desktop\\Images\\Icon 1\\red-x-mark-transparent-background-3.png")); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 97, 39));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive - jecrc.ac.in\\Desktop\\Images\\Icon 1\\123456.png")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 460, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");       
String Bookid=t1.getText();
String studentId=t2.getText();
String issuedate=dFormat.format(ds1.getDate());
String duedate=dFormat.format(ds2.getDate());
String returnbook="No";

if(t1.getText().equals("")||t2.getText().equals("")||ds1.getDate().equals("")||ds2.getDate().equals(""))
{
JOptionPane.showMessageDialog(null,"Please Enter details");
}

else
{
    
    try {
        
          Connection con=conn.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from book where Bookid='"+Bookid+"'");
            if(rs.next())
            {
                ResultSet rs1=st.executeQuery("select * from student where Studentid='"+studentId+"'");
            if(rs1.next())
            {
            st.executeUpdate("insert into issuebook values('"+Bookid+"','"+studentId+"','"+issuedate+"','"+duedate+"','"+returnbook+"')");
            JOptionPane.showMessageDialog(null,"Issued Successfully");
            this.dispose();
            new issuebook().setVisible(true);
            }    
        else
                JOptionPane.showMessageDialog(null,"StudentId not in database");
                }
            else
                    
        JOptionPane.showMessageDialog(null,"Incorrect BookId");
        
        
        
    } catch (Exception e) {
        
   JOptionPane.showMessageDialog(null,"Connection error");
        
    }
    
    
    
    
    
    
    
    
}

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

this.dispose();
new home().setVisible(true);
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
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new issuebook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ds1;
    private com.toedter.calendar.JDateChooser ds2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}

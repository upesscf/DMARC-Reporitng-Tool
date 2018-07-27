package dmarc;
import java.sql.Connection;
import java.io.File;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
public class Welcome extends javax.swing.JFrame {
public Connection conn;
public Statement stmt;  
 static String filename=null,filename1=null,testfolder="",output="",test="",out="",pass1;
 static char[] pass = new char[20];
	static int count=0,i=0,j=10;
    
    public Welcome() 
    {
        initComponents();
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
      
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        panel1.setBackground(new java.awt.Color(2, 166, 116));
        panel1.setPreferredSize(new java.awt.Dimension(1070, 203));

        panel2.setBackground(new java.awt.Color(21, 25, 34));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Welcome To The DMARC Tool");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));

        label2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(240, 240, 240));
        label2.setText("An Email Authentication , Policy and Reporting Tool");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setText("Parse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Set path of folder which has raw data");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Set path of folder where files will be unzipped");
        jLabel3.setToolTipText("");

        button1.setLabel("button1");

        button2.setForeground(new java.awt.Color(21, 25, 34));
        button2.setLabel("BROWSE");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        button3.setLabel("button3");

        button4.setLabel("BROWSE");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        
        JLabel lblEnterPasswordOf = new JLabel();
        lblEnterPasswordOf.setToolTipText("");
        lblEnterPasswordOf.setText("Enter Password of Mysql Database");
        lblEnterPasswordOf.setForeground(SystemColor.menu);
        lblEnterPasswordOf.setFont(new Font("Calibri", Font.BOLD, 24));
        
        passwordField = new JPasswordField();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1Layout.setHorizontalGroup(
        	panel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
        		.addGroup(panel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(panel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        				.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        				.addComponent(lblEnterPasswordOf, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(panel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panel1Layout.createSequentialGroup()
        					.addComponent(button2, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
        				.addGroup(panel1Layout.createSequentialGroup()
        					.addGroup(panel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(passwordField, Alignment.LEADING)
        						.addComponent(button4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        		.addGroup(panel1Layout.createSequentialGroup()
        			.addContainerGap(382, Short.MAX_VALUE)
        			.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
        			.addGap(270))
        );
        panel1Layout.setVerticalGroup(
        	panel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panel1Layout.createSequentialGroup()
        			.addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(35)
        			.addGroup(panel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(button2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
        			.addGroup(panel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3)
        				.addComponent(button4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        			.addGap(14)
        			.addGroup(panel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEnterPasswordOf, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(65)
        			.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        panel1.setLayout(panel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        test=jTextField1.getText();
        out=jTextField2.getText();
        pass=passwordField.getPassword();
        pass1=new String(pass);
        testfolder=test.replace("\\","/");
        output=out.replace("\\","/");        
        try
        {         
            jButton4.setEnabled(false);
            unz o=new unz();
            o.func(testfolder,output);
	    o.unzip();
	    Class.forName("com.mysql.jdbc.Driver"); 
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", pass1); 
	    java.sql.Statement stmt=con.createStatement();
	    stmt.executeUpdate("Create database if not exists DMARC");
	    Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/DMARC", "root", pass1);
	    Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/DMARC", "root", pass1);
	    delete d=new delete(count,con2);
	    for(String ob:(o.list))
	    {
	      	filename=output+"/"+ob;
	      	File inputFile = new File(filename);
	      	SAXParserFactory factory = SAXParserFactory.newInstance();
	      	SAXParser saxParser = factory.newSAXParser();
	      	UserHandler userhandler = new UserHandler(filename,con,con1);
	      	saxParser.parse(inputFile, userhandler); 
	      	count++;
	      	
	    }
	    d.deleteFiles(new File(output));
	    d.deleteFiles(new File(testfolder));
	    delete d1=new delete(count,con2);
	    d1.count();
	    con.close();
	    con1.close();
	    con2.close();    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(chooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        jTextField1.setText(filename);    }//GEN-LAST:event_button2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(chooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        jTextField2.setText(filename);   // TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private java.awt.Label label2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private JPasswordField passwordField;
}

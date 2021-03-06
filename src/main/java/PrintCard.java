import ij.IJ;
import ij.ImagePlus;
import ij.macro.Interpreter;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chris
 */
public class PrintCard extends javax.swing.JFrame {

    /**
     * Creates new form PrintCard
     */
    public PrintCard() {
        
        initComponents();

        printNumber = ((Integer) printNumberSpinner.getValue()).intValue();
        Clipboard systemClipboard = null;
        try {
            systemClipboard = getToolkit().getSystemClipboard();
        } catch (Exception e) {
            systemClipboard = null;
        }
        if (systemClipboard == null) {
            IJ.error("Unable to copy to Clipboard.");
            return;
        }

        String text = Integer.toString(printNumber);
        StringSelection contents = new StringSelection(text);
        systemClipboard.setContents(contents, contents);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        doneLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        printNumberSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(31, 73, 125));

        doneLabel.setBackground(new java.awt.Color(79, 129, 189));
        doneLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        doneLabel.setForeground(new java.awt.Color(230, 224, 236));
        doneLabel.setText("Your postcard is done!");

        printButton.setBackground(new java.awt.Color(79, 129, 189));
        printButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        printNumberSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        printNumberSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel1.setBackground(new java.awt.Color(31, 73, 125));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 224, 236));
        jLabel1.setText("How many copies?");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(41, 41, 41)
                .add(doneLabel)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 161, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(43, 43, 43))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(printNumberSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(printButton))
                        .add(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(doneLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 42, Short.MAX_VALUE)
                .add(jLabel1)
                .add(18, 18, 18)
                .add(printNumberSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(78, 78, 78)
                .add(printButton)
                .add(18, 18, 18))
        );

        pack();
    }// </editor-fold>                        

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        String cmd = "PrintingPostcard.exe";
        try {
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            Logger.getLogger(PrintCard.class.getName()).log(Level.SEVERE, null, ex);
        }

//        ImagePlus imp = IJ.getImage();
//        IJ.run(imp, "Print...", "");

    }                                           

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
            java.util.logging.Logger.getLogger(PrintCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintCard().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel doneLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton printButton;
    private javax.swing.JSpinner printNumberSpinner;
    // End of variables declaration                   
    // global variables
    int printNumber;
    Interpreter interp;
}

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.io.Opener;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * YourImage.java
 *
 * Created on Jul 3, 2012, 7:45:53 PM
 */
/**
 * Copyright Jun 7, 2012 The GAIA Group http://gaiag.net
 *
 * @author chris
 */
public class YourImage extends javax.swing.JFrame {

    /**
     * Creates new form YourImage
     */
    public YourImage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        yourImagePanel = new javax.swing.JPanel();
        chooseBackgroundLabel = new javax.swing.JLabel();
        localLabel = new javax.swing.JLabel();
        generalLabel = new javax.swing.JLabel();
        localPic1Label = new javax.swing.JLabel();
        generalPic2Label = new javax.swing.JLabel();
        generalPic1Label = new javax.swing.JLabel();
        localLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(31, 73, 125));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        yourImagePanel.setBackground(new java.awt.Color(51, 51, 255));

        chooseBackgroundLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        chooseBackgroundLabel.setForeground(new java.awt.Color(255, 255, 255));
        chooseBackgroundLabel.setText("Please choose a background:");

        localLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        localLabel.setForeground(new java.awt.Color(255, 255, 255));
        localLabel.setText("Local");

        generalLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        generalLabel.setForeground(new java.awt.Color(255, 255, 255));
        generalLabel.setText("General");

        localPic1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_sequoia.jpg"))); // NOI18N
        localPic1Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                localPic1Clicked(evt);
            }
        });

        generalPic2Label.setBackground(new java.awt.Color(31, 73, 125));
        generalPic2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_Argonauti.jpg"))); // NOI18N
        generalPic2Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generalPic2Clicked(evt);
            }
        });

        generalPic1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_Ostuni.jpg"))); // NOI18N
        generalPic1Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generalPic1Clicked(evt);
            }
        });

        localLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_KolnCathedral.jpg"))); // NOI18N
        localLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                localLabel2Clicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout yourImagePanelLayout = new org.jdesktop.layout.GroupLayout(yourImagePanel);
        yourImagePanel.setLayout(yourImagePanelLayout);
        yourImagePanelLayout.setHorizontalGroup(
            yourImagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(yourImagePanelLayout.createSequentialGroup()
                .add(14, 14, 14)
                .add(chooseBackgroundLabel)
                .addContainerGap(30, Short.MAX_VALUE))
            .add(yourImagePanelLayout.createSequentialGroup()
                .add(28, 28, 28)
                .add(yourImagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(localPic1Label)
                    .add(localLabel2)
                    .add(generalLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(yourImagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(generalPic1Label)
                    .add(generalPic2Label)
                    .add(localLabel))
                .add(45, 45, 45))
        );
        yourImagePanelLayout.setVerticalGroup(
            yourImagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(yourImagePanelLayout.createSequentialGroup()
                .add(5, 5, 5)
                .add(chooseBackgroundLabel)
                .add(yourImagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(yourImagePanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(generalLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, yourImagePanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(localLabel)
                        .add(18, 18, 18)))
                .add(yourImagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, localPic1Label)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, generalPic1Label))
                .add(18, 18, 18)
                .add(yourImagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, localLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, generalPic2Label))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(yourImagePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(yourImagePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void localPic1Clicked(java.awt.event.MouseEvent evt) {                                  

        String title = "Sequoia Park";
        displayImage("/sequoiaPark.jpg", title, 0);

    }                                 

    private void generalPic1Clicked(java.awt.event.MouseEvent evt) {                                    

        String title = "Ostuni, Italy";
        displayImage("/Ostuni.jpg", title, 0);

    }                                   

    private void generalPic2Clicked(java.awt.event.MouseEvent evt) {                                    

        String title = "Argonauti, Italy";
        displayImage("/Argonauti.tif", title, 1);

    }                                   

    private void localLabel2Clicked(java.awt.event.MouseEvent evt) {                                    

        String title = "Koln Cathedral";
        displayImage("/KolnCathedral.tif", title, 1);

    }                                   

    private void displayImage(String im, String t, int type) {

        if (type == 0) {
            java.net.URL url;
            url = getClass().getResource(im);
            java.awt.Image image = Toolkit.getDefaultToolkit().getImage(url);
            imp = new ImagePlus(t, image);
            if (imp != null) {
                imp.show();
                moveWindow(imp, 400, 0);
            }
        } else {
            InputStream is = getClass().getResourceAsStream(im);
            if (is != null) {
                Opener opener = new Opener();
                imp = opener.openTiff(is, t);
                if (imp != null) {
                    imp.show();
                    moveWindow(imp, 400, 0);
                }
            }
        }

        PickSubject ps = new PickSubject();
        AAPC_Var.putPickSubject(ps);

        AAPC_Var.hideYourImage();
        AAPC_Var.showPicSubject();

        AAPC_Var.putImage(imp);

    }

    private void moveWindow(ImagePlus impl, int x, int y) {

        impl.getWindow().setLocation(x, y);

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
            java.util.logging.Logger.getLogger(YourImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YourImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YourImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YourImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new YourImage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel chooseBackgroundLabel;
    private javax.swing.JLabel generalLabel;
    private javax.swing.JLabel generalPic1Label;
    private javax.swing.JLabel generalPic2Label;
    private javax.swing.JLabel localLabel;
    private javax.swing.JLabel localLabel2;
    private javax.swing.JLabel localPic1Label;
    private javax.swing.JPanel yourImagePanel;
    // End of variables declaration
    // global variables
    ImagePlus imp, img;
}
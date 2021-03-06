import ij.IJ;
import ij.ImagePlus;
import ij.gui.ImageCanvas;
import ij.gui.ImageWindow;
import ij.gui.Overlay;
import ij.gui.Roi;
import ij.plugin.frame.RoiManager;
import ij.process.ImageProcessor;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
 * WandFrame.java
 *
 * Created on May 14, 2012, 5:06:16 PM
 */
/**
 * Copyright Jun 7, 2012 The GAIA Group
 * http://gaiag.net
 *
 * @author chris
 */
public final class WandFrame extends javax.swing.JFrame
        implements MouseListener, MouseMotionListener {

    /** Creates new form WandFrame */
    public WandFrame() {

        initComponents();

        start = true;

        language = AAPC_Var.getLanguage();

        setLanguage();

        img = IJ.getImage();

        IJ.run("Colors...", "foreground=white background=black selection=red");

        if (start) {
            setupListener();

            start = false;
        }
        
//        IJ.setTool("freehand");
//        IJ.run(img, "Select None", "");
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        wandFramePanel = new javax.swing.JPanel();
        ToleranceSlider = new javax.swing.JSlider();
        SetToBackgroundButton = new javax.swing.JButton();
        KillSelectionButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InstructionTextArea = new javax.swing.JTextArea();
        toPostCardButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        ColorSlider = new javax.swing.JSlider();
        GradientSlider = new javax.swing.JSlider();

        setBackground(new java.awt.Color(0, 0, 255));

        wandFramePanel.setBackground(new java.awt.Color(51, 51, 255));

        ToleranceSlider.setForeground(new java.awt.Color(255, 255, 255));
        ToleranceSlider.setMajorTickSpacing(10);
        ToleranceSlider.setMinorTickSpacing(1);
        ToleranceSlider.setPaintLabels(true);
        ToleranceSlider.setPaintTicks(true);
        ToleranceSlider.setSnapToTicks(true);
        ToleranceSlider.setValue(90);
        ToleranceSlider.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tolerance Adjustment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        ToleranceSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                WandStateChanged(evt);
            }
        });

        SetToBackgroundButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        SetToBackgroundButton.setText("Set To Background");
        SetToBackgroundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetToBackgroundButtonActionPerformed(evt);
            }
        });

        KillSelectionButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        KillSelectionButton.setText("Kill Selection");
        KillSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KillSelectionButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(50, 150, 255));

        InstructionTextArea.setEditable(false);
        InstructionTextArea.setBackground(new java.awt.Color(50, 150, 255));
        InstructionTextArea.setColumns(20);
        InstructionTextArea.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        InstructionTextArea.setForeground(new java.awt.Color(255, 255, 255));
        InstructionTextArea.setLineWrap(true);
        InstructionTextArea.setRows(5);
        InstructionTextArea.setText("1. Drag the slider back or forth until the background is subtracted \n    without any subject.\n2. Click the 'Set To Background' button.\n3. Repeat for all remaining background areas.\n4. To complete the postcard, click the 'To Postcard' button.");
        InstructionTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jScrollPane1.setViewportView(InstructionTextArea);

        toPostCardButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        toPostCardButton.setText("To Postcard");
        toPostCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toPostCardButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        homeButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        ColorSlider.setForeground(new java.awt.Color(255, 255, 255));
        ColorSlider.setMajorTickSpacing(10);
        ColorSlider.setMinorTickSpacing(1);
        ColorSlider.setPaintLabels(true);
        ColorSlider.setPaintTicks(true);
        ColorSlider.setSnapToTicks(true);
        ColorSlider.setValue(75);
        ColorSlider.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color Adjustment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        ColorSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ColorSliderWandStateChanged(evt);
            }
        });

        GradientSlider.setForeground(new java.awt.Color(255, 255, 255));
        GradientSlider.setMajorTickSpacing(10);
        GradientSlider.setMinorTickSpacing(1);
        GradientSlider.setPaintLabels(true);
        GradientSlider.setPaintTicks(true);
        GradientSlider.setSnapToTicks(true);
        GradientSlider.setValue(10);
        GradientSlider.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gradient Adjustment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        GradientSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GradientSliderWandStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout wandFramePanelLayout = new org.jdesktop.layout.GroupLayout(wandFramePanel);
        wandFramePanel.setLayout(wandFramePanelLayout);
        wandFramePanelLayout.setHorizontalGroup(
            wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(wandFramePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(wandFramePanelLayout.createSequentialGroup()
                            .add(backButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 243, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(homeButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(toPostCardButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 497, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, wandFramePanelLayout.createSequentialGroup()
                            .add(SetToBackgroundButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 241, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(KillSelectionButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, GradientSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 495, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(ToleranceSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 495, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ColorSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 495, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(wandFramePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 495, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(8, Short.MAX_VALUE)))
        );
        wandFramePanelLayout.setVerticalGroup(
            wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(wandFramePanelLayout.createSequentialGroup()
                .add(133, 133, 133)
                .add(ColorSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ToleranceSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(GradientSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12)
                .add(wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(SetToBackgroundButton)
                    .add(KillSelectionButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(toPostCardButton)
                .add(4, 4, 4)
                .add(wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(backButton)
                    .add(homeButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(wandFramePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(wandFramePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(380, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(wandFramePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(wandFramePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void WandStateChanged(javax.swing.event.ChangeEvent evt) {                                  

        if (img.getRoi() != null) {
            Roi roi = img.getRoi();

            int type = roi.getType();

            if (type == 10) {

                Rectangle rec = roi.getBounds();

                x0 = rec.x;
                y0 = rec.y;
            }

            setROI(roi, x0, y0);

        } 
    }                                 

    private void setROI(Roi roi, int x1, int y1) {

        int tolerance = ToleranceSlider.getValue();
        int colorAdj = ColorSlider.getValue();
        int gradient = GradientSlider.getValue();

        IJ.run(img, "Select None", "");

        IJ.run(img, "Versatile Wand",
                "value=" + tolerance
                + " color=" + colorAdj
                + " gradient=" + gradient + " "
                + "connectedness=8-connected "
                + "x=" + x1 + " y=" + y1 + " do");
        if (start) {
            roi = img.getRoi();
        }
        
        showFill(roi);

    }

    private void SetToBackgroundButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      

        noOutline = true;

//        IJ.run("Colors...", "foreground=white background=black selection=red");
        IJ.run("Colors...", "foreground=white background=black selection=red");

        if (noOutline) {
            IJ.run(img, "Enlarge...", "enlarge=1");
        }

        IJ.run(img, "Clear", "slice");

    }                                                     

    private void KillSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    

        IJ.run(img, "Select None", "");

    }                                                   

    private void toPostCardButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        IJ.run(img, "Versatile Wand",
                "value=0 color=0 gradient=0 "
                + "connectedness=8-connected x=0 y=0 do");
        IJ.run("Make Inverse", "");

        Cut_Paste cp = new Cut_Paste();
        cp.setVisible(true);

        AAPC_Var.putSubject(img);

        AAPC_Var.putCutPaste(cp);

        AAPC_Var.hideWandFrame();

    }                                                

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           

        AAPC_Var.hideWandFrame();
        AAPC_Var.showPicSubject();
        
        img.hide();

    }                                          

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
// put in a close all images here  &&&
        AAPC_Var.hideWandFrame();
        AAPC_Var.showPostCard();

    }                                          

    private void ColorSliderWandStateChanged(javax.swing.event.ChangeEvent evt) {                                             

        if (img.getRoi() != null) {
            Roi roi = img.getRoi();

            int type = roi.getType();

            if (type == 10) {

                Rectangle rec = roi.getBounds();

                x0 = rec.x;
                y0 = rec.y;
            }

            int tolerance = ToleranceSlider.getValue();
            int colorAdj = ColorSlider.getValue();
            int gradient = GradientSlider.getValue();

            IJ.run(img, "Select None", "");

            //IJ.doWand(x0, y0, tolerance, "8-connected");
            IJ.run(img, "Versatile Wand",
                    "value=" + tolerance
                    + " color=" + colorAdj
                    + " gradient=" + gradient + " "
                    + "connectedness=8-connected "
                    + "x=" + x0 + " y=" + y0 + " do");

            showFill(roi);

        }
    }                                            

    private void GradientSliderWandStateChanged(javax.swing.event.ChangeEvent evt) {                                                

        if (img.getRoi() != null) {
            Roi roi = img.getRoi();

            int type = roi.getType();

            if (type == 10) {

                Rectangle rec = roi.getBounds();

                x0 = rec.x;
                y0 = rec.y;
            }

            int tolerance = ToleranceSlider.getValue();
            int colorAdj = ColorSlider.getValue();
            int gradient = GradientSlider.getValue();

            IJ.run(img, "Select None", "");

            //IJ.doWand(x0, y0, tolerance, "8-connected");
            IJ.run(img, "Versatile Wand",
                    "value=" + tolerance
                    + " color=" + colorAdj
                    + " gradient=" + gradient + " "
                    + "connectedness=8-connected "
                    + "x=" + x0 + " y=" + y0 + " do");

            showFill(roi);

        } 
    }                                               

    /**
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {

        int x = me.getX();
        int y = me.getY();

        int tolerance = ToleranceSlider.getValue();
        int colorAdj = ColorSlider.getValue();
        int gradient = GradientSlider.getValue();

        x0 = canvas.offScreenX(x);
        y0 = canvas.offScreenY(y);

        IJ.run(img, "Select None", "");

        //IJ.doWand(x0, y0, tolerance, "8-connected");
        IJ.run(img, "Versatile Wand",
                "value=" + tolerance
                + " color=" + colorAdj
                + " gradient=" + gradient
                + " connectedness=8-connected "
                + "x=" + x0 + " y=" + y0 + " do");


        Roi roi = img.getRoi();

        showFill(roi);

    }

    /**
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseDragged(MouseEvent me) {
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseMoved(MouseEvent me) {
    }

    public void setupListener() {

        img = IJ.getImage();
        ImageWindow win = img.getWindow();
        canvas = win.getCanvas();
        canvas.addMouseListener(this);

        int mode = img.getStatistics().mode;

        ImageProcessor ip = img.getProcessor();

        int w = img.getWidth();
        int h = img.getHeight();

        Boolean stop = true;

        int tolerance = ToleranceSlider.getValue();
        int colorAdj = ColorSlider.getValue();
        int gradient = GradientSlider.getValue();

        //IJ.run("Wand Tool...", "mode=8-connected tolerance=55");
        //IJ.run(img, "Versatile Wand", "value=70 color=70 gradient=0 connectedness=8-connected x=118 y=226 do");

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (stop && ip.getPixelValue(x, y) == mode) {
                    //IJ.doWand(x, y);
                    IJ.run(img, "Versatile Wand", "value=" + tolerance
                            + " color=" + colorAdj
                            + " gradient=" + gradient + " "
                            + "connectedness=8-connected "
                            + "x=" + x + " y=" + y + " do");

                    stop = false;

                }
            }
        }
    }

    private void setLanguage() {

        String s;

        switch (language) {

            case 0:

                s = "1. Drag the slider back or forth until the background is subtracted"
                        + "\n   without any subject."
                        + "\n2. Click the 'Set To Background' button."
                        + "\n3. Repeat for all remaining background areas."
                        + "\n4. To complete the postcard, click the 'To Postcard' button.";

                toInstructionWidow(s, false);
                SetToBackgroundButton.setText("Set To Background");
                break;

            case 1:

                s = "1. Ziehen Sie den Schieberegler vor oder zurück, bis der Hintergrund ohne Subjekt subtrahiert wird."
                + "2. Klicken Sie auf die 'Set To Background'"
                + "3. Wiederholen Sie dies für alle übrigen Bereiche Hintergrund."
                + "4. Um die Postkarte abzuschließen, klicken Sie auf die 'To-Postkarte'";
                
                toInstructionWidow(s, false);
                SetToBackgroundButton.setText("Hintergrund");
                break;

            case 2:

                s = "Frencais parle vouis?";
                toInstructionWidow(s, false);
                SetToBackgroundButton.setText("mis à fond");
                break;

            case 3:

                s = "istruzioni italiani";
                toInstructionWidow(s, false);
                SetToBackgroundButton.setText("impostato su sfondo");
                break;

            case 4:

                s = "Kiswahili Inastrucions";
                toInstructionWidow(s, false);
                SetToBackgroundButton.setText("kuweka background");
                break;

        }

    }

    private void showFill(Roi roi) {

        float r = 150 / 255, g = 0 / 255, b = 150 / 255, alpha = (float) 0.5;

        roi.setFillColor(new Color(r, g, b, alpha));
        img.setOverlay(new Overlay(roi));

        img.updateAndDraw();
    }

    private void toInstructionWidow(String s, Boolean go) {
        if (go) {
            String s1 = InstructionTextArea.getText();
            String s2 = "\n*******************\n";
            InstructionTextArea.setText(s1 + s2 + s);
        } else {
            InstructionTextArea.setText(s);
        }
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
            java.util.logging.Logger.getLogger(WandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new WandFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JSlider ColorSlider;
    private javax.swing.JSlider GradientSlider;
    private javax.swing.JTextArea InstructionTextArea;
    private javax.swing.JButton KillSelectionButton;
    private javax.swing.JButton SetToBackgroundButton;
    private javax.swing.JSlider ToleranceSlider;
    private javax.swing.JButton backButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton toPostCardButton;
    private javax.swing.JPanel wandFramePanel;
    // End of variables declaration                   
    // Global Variables
    ImagePlus img;
    ImageProcessor crop;
    int language;
    int x0, y0, pcX, pcY,
            outX, outY,
            iter, rotate,
            dimOutline,
            outW, outH;
    int[][] allOutlines, borders;
    double[] borderValues;
    boolean noOutline, redo = false,
            resize = false, refresh = false,
            text = false, start = false,
            isolate = false;
    ImageCanvas canvas;
    Roi outline;
    RoiManager roiman;
}
import ij.IJ;
import ij.ImagePlus;
import ij.WindowManager;
import ij.gui.ImageCanvas;
import ij.gui.ImageRoi;
import ij.gui.ImageWindow;
import ij.gui.Overlay;
import ij.gui.Roi;
import ij.plugin.Duplicator;
import ij.plugin.frame.RoiManager;
import ij.process.ImageProcessor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Cut_Paste.java
 *
 * Created on Oct 16, 2012, 1:14:44 PM
 */
/**
 *
 * @author chris
 */

public class Cut_Paste extends javax.swing.JFrame
        implements MouseListener, MouseMotionListener {

    /**
     * Creates new form Cut_Paste
     */
    public Cut_Paste() {
        initComponents();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = screen.height;
        screenWidth = screen.width;

        setUp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        cutPastePanel = new javax.swing.JPanel();
        InfoScrollPane = new javax.swing.JScrollPane();
        InfoTextArea = new javax.swing.JTextArea();
        ScalePanel = new javax.swing.JPanel();
        LargerButton = new javax.swing.JButton();
        SmallerButton = new javax.swing.JButton();
        RotatePanel = new javax.swing.JPanel();
        ClockwiseButton = new javax.swing.JButton();
        CounterclockwiseButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        imaToggleButton = new javax.swing.JToggleButton();
        floatButton = new javax.swing.JButton();
        finalizeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Set Subject");
        setBackground(new java.awt.Color(51, 51, 255));

        cutPastePanel.setBackground(new java.awt.Color(51, 51, 255));

        InfoScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Image Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 13))); // NOI18N

        InfoTextArea.setBackground(new java.awt.Color(50, 150, 255));
        InfoTextArea.setColumns(20);
        InfoTextArea.setEditable(false);
        InfoTextArea.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        InfoTextArea.setRows(5);
        InfoScrollPane.setViewportView(InfoTextArea);

        ScalePanel.setBackground(new java.awt.Color(50, 150, 255));
        ScalePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Scale", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 13))); // NOI18N

        LargerButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        LargerButton.setText("Larger");
        LargerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                largerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                largerMouseReleased(evt);
            }
        });
        LargerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LargerButtonActionPerformed(evt);
            }
        });

        SmallerButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        SmallerButton.setText("Smaller");
        SmallerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                smallerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                smallerMouseReleased(evt);
            }
        });
        SmallerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmallerButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout ScalePanelLayout = new org.jdesktop.layout.GroupLayout(ScalePanel);
        ScalePanel.setLayout(ScalePanelLayout);
        ScalePanelLayout.setHorizontalGroup(
            ScalePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, ScalePanelLayout.createSequentialGroup()
                .add(LargerButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 153, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                .add(SmallerButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ScalePanelLayout.linkSize(new java.awt.Component[] {LargerButton, SmallerButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        ScalePanelLayout.setVerticalGroup(
            ScalePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ScalePanelLayout.createSequentialGroup()
                .add(ScalePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(LargerButton)
                    .add(SmallerButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RotatePanel.setBackground(new java.awt.Color(50, 150, 255));
        RotatePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rotate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 13))); // NOI18N

        ClockwiseButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        ClockwiseButton.setText("Clockwise");
        ClockwiseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clockwiseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clockwiseMouseReleased(evt);
            }
        });
        ClockwiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClockwiseButtonActionPerformed(evt);
            }
        });

        CounterclockwiseButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        CounterclockwiseButton.setText("Counterclockwise");
        CounterclockwiseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                counterclockwiseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                counterclockiwseMouseReleased(evt);
            }
        });
        CounterclockwiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CounterclockwiseButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout RotatePanelLayout = new org.jdesktop.layout.GroupLayout(RotatePanel);
        RotatePanel.setLayout(RotatePanelLayout);
        RotatePanelLayout.setHorizontalGroup(
            RotatePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, RotatePanelLayout.createSequentialGroup()
                .add(ClockwiseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(CounterclockwiseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 162, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        RotatePanelLayout.linkSize(new java.awt.Component[] {ClockwiseButton, CounterclockwiseButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        RotatePanelLayout.setVerticalGroup(
            RotatePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(RotatePanelLayout.createSequentialGroup()
                .add(RotatePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ClockwiseButton)
                    .add(CounterclockwiseButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(50, 150, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Developer Area"));

        imaToggleButton.setText("Toggle ima");
        imaToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imaToggleButtonActionPerformed(evt);
            }
        });

        floatButton.setText("float");
        floatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floatButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(imaToggleButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 158, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(floatButton)
                .add(0, 85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(imaToggleButton)
                    .add(floatButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        finalizeButton.setText("Finalize");
        finalizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizeButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout cutPastePanelLayout = new org.jdesktop.layout.GroupLayout(cutPastePanel);
        cutPastePanel.setLayout(cutPastePanelLayout);
        cutPastePanelLayout.setHorizontalGroup(
            cutPastePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 360, Short.MAX_VALUE)
            .add(cutPastePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(cutPastePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(cutPastePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(InfoScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 348, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(cutPastePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(RotatePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(ScalePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cutPastePanelLayout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(finalizeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 159, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        cutPastePanelLayout.setVerticalGroup(
            cutPastePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 398, Short.MAX_VALUE)
            .add(cutPastePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(cutPastePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(InfoScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 144, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(RotatePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(6, 6, 6)
                    .add(ScalePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(12, 12, 12)
                    .add(finalizeButton)
                    .add(6, 6, 6)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cutPastePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cutPastePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void LargerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             

    }                                            

    private void SmallerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              

    }                                             

    private void ClockwiseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                

    }                                               

    private void CounterclockwiseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       

    }                                                      

    private void imaToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                

        JToggleButton btn = (JToggleButton) evt.getSource();
        if (btn.isSelected()) {

            ips.show();

            moveWindow(ips, 400, 60);

            ImageWindow iw = new ImageWindow(ips);

            iw.maximize();

        } else {

            ips.hide();

        }

    }                                               

    private void clockwiseMousePressed(java.awt.event.MouseEvent evt) {                                       

        angle++;
        changeSubject(); //rotateSubject();

        repeatTimer = new Timer(100, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                angle++;
                changeSubject(); //rotateSubject();
            }
        });
        repeatTimer.setInitialDelay(100); // start repeating only after 1 second
        repeatTimer.start();

    }                                      

    private void clockwiseMouseReleased(java.awt.event.MouseEvent evt) {                                        

        repeatTimer.stop();

    }                                       

    private void counterclockwiseMousePressed(java.awt.event.MouseEvent evt) {                                              

        angle--;
        changeSubject(); //rotateSubject();

        repeatTimer = new Timer(100, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                angle--;
                changeSubject(); //rotateSubject();
            }
        });
        repeatTimer.setInitialDelay(10); // start repeating only after 1 second
        repeatTimer.start();

    }                                             

    private void counterclockiwseMouseReleased(java.awt.event.MouseEvent evt) {                                               

        repeatTimer.stop();

    }                                              

    private void largerMousePressed(java.awt.event.MouseEvent evt) {                                    

        size+=10;
        changeSubject(); //changeSize();

        repeatTimer = new Timer(100, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                size+=10;
                changeSubject(); //changeSize();
            }
        });
        repeatTimer.setInitialDelay(10); // start repeating only after 1 second
        repeatTimer.start();
        
    }                                   

    private void largerMouseReleased(java.awt.event.MouseEvent evt) {                                     

        repeatTimer.stop();

    }                                    

    private void smallerMousePressed(java.awt.event.MouseEvent evt) {                                     

        size-=10;
        changeSubject(); //changeSize();

        repeatTimer = new Timer(100, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                size-=10;
                changeSubject(); //changeSize();
            }
        });
        repeatTimer.setInitialDelay(10); // start repeating only after 1 second
        repeatTimer.start();
        
    }                                    

    private void smallerMouseReleased(java.awt.event.MouseEvent evt) {                                      

        repeatTimer.stop();

    }                                     

    private void finalizeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               

        ipp.hide();
        
        FinalizePC fpc = new FinalizePC();
        AAPC_Var.putFinalizePC(fpc);

        AAPC_Var.hideCutPaste();
        
        AAPC_Var.showFinalize();

    }                                              

    private void floatButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        cutPaste();
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
            java.util.logging.Logger.getLogger(Cut_Paste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cut_Paste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cut_Paste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cut_Paste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                new Cut_Paste().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton ClockwiseButton;
    private javax.swing.JButton CounterclockwiseButton;
    private javax.swing.JScrollPane InfoScrollPane;
    private javax.swing.JTextArea InfoTextArea;
    private javax.swing.JButton LargerButton;
    private javax.swing.JPanel RotatePanel;
    private javax.swing.JPanel ScalePanel;
    private javax.swing.JButton SmallerButton;
    private javax.swing.JPanel cutPastePanel;
    private javax.swing.JButton finalizeButton;
    private javax.swing.JButton floatButton;
    private javax.swing.JToggleButton imaToggleButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   

    // Global variables
    
    Timer repeatTimer;
    
    ImageCanvas canvas;
    Boolean firstrun = true,
            stack = false,
            tocard = false,
            toPc = false,
            setup = false;
    
    Boolean logWin = false;
    ImagePlus ipp, ipt, ips;
    ImagePlus pcTemplate, pclayer;
    ImageProcessor ipsub;
    ImageRoi imageRoi;
    RoiManager roiman;
    Overlay overlay;
    
    int pcX, pcY, angle = 0;
    int sublen, subject;
    int step = 10,
            xcen, ycen, angleIndex;
    int postcard, screenHeight, screenWidth;
    int progressCount = 0;
    
    double size = 0;

    private void setUp() {

        ipp = AAPC_Var.getImage();
        postcard = ipp.getID();

        ipt = AAPC_Var.getSubject();

        ImagePlus temp = WindowManager.getCurrentImage();
        if (WindowManager.getImageCount() > 1 && temp.getStackSize() > 1) {
            WindowManager.putBehind();
        }

        ipt = IJ.getImage();
        ipt.hide();

        int slices = ipp.getNSlices();

        if (slices > 1) {
            stack = true;
            ipp.setSlice(2);

            IJ.setTool("rectangle");
        }
// put all relevant under if slices
        setup = true;

        resizeSubject();

        changeSubject();

        smallStack();

        IJ.run(ipp, "Layers ", "");

        pclayer = IJ.getImage();

        moveWindow(pclayer, 400, 0);

        ipp.setSlice(2);

        setupListener();
                
        IJ.selectWindow(postcard);
        cutPaste();
        
    }

    private void cutPaste() {

        ImagePlus temp = WindowManager.getCurrentImage();
        temp.setSlice(2);
        
        temp.copy(true); 
        temp.paste();

    }

    private void clearPC() {

        IJ.selectWindow(postcard);
        IJ.run(ipp, "Select All", "");
        IJ.run(ipp, "Clear", "slice");
        IJ.run(ipp, "Select None", "");

    }

    private void resizeSubject() {

        int pch = ipp.getHeight();

        double w = ipt.getWidth();
        double h = ipt.getHeight();

        double maxD;

        if (w >= h) {
            maxD = w;
        } else {
            maxD = h;
        }

        IJ.run(ipt, "Enlarge...", "enlarge=-1");

        IJ.run(ipt, "Clear Outside", "");

        ips = IJ.createImage("Subject", "RGB Black", (int) maxD, (int) maxD, 1);

        ipt.copy(false);
        ips.paste();
        IJ.run(ips, "Select None", "");

        IJ.run(ipt, "Canvas Size...", "width=" + maxD + " height=" + maxD + " position=Center zero");

    }

    private void changeSubject() {

        ImageProcessor ip = ipt.getProcessor();
        ip = ip.duplicate();
        ip = ip.crop();

        double width = ip.getWidth();
        double height = ip.getHeight();

        int new_width = (int) (width + size);
        int new_height = (int) (height + size);

        if (new_width != 0 || new_height != 0) {
            ip.setInterpolate(true);
            ip = ip.resize(new_width, new_height);
        }

        ip.setBackgroundValue(0.0);
        ip.rotate(angle);
 
        ips.setProcessor("Subject", ip);
        ips.updateAndDraw();
        
        resetCard();       

        updatePostcard();

        String s0 = "changeSubject: pcX = " + pcX + " pcY = " + pcY
                + "\nsize = " + size + "\nangle = " + angle;

//        toInstructionWidow(s0, true);

    }

    private void smallStack() {

        int w1 = ipp.getWidth();
        int h1 = ipp.getHeight();
        int w2 = (int) ((int) screenWidth - ((int) w1 * .25));

        ipp.show();
        IJ.selectWindow(postcard);
        IJ.run("Set... ", "zoom=25 x=" + (w1 / 2) + " y=" + (h1 / 2));

        moveWindow(ipp, w2 - 20, 0);

    }

    private void resetCard() {

        ipp.setSlice(2);
        IJ.run(ipp, "Select All", "");
        IJ.run(ipp, "Clear", "slice");
        IJ.run(ipp, "Select None", "");

    }

    private void updatePostcard() {

        ips.copy(false);

        ipp.setSlice(2);

        ipp.paste();
        
        ips.hide();

        Roi roi = ipp.getRoi();

        Rectangle rec = roi.getBounds();

        int w0 = rec.width;
        int h0 = rec.height;

        if (setup) {
            pcX = 0;
            pcY = 0;
            xcen = (int) pcX + w0 / 2;
            ycen = (int) pcY + h0 / 2;

        } else {
            pcX = (int) xcen - w0 / 2;
            pcY = (int) ycen - h0 / 2;
        }

        setup = false;

        ipp.setRoi(pcX, pcY, w0, h0);
        ipp.setSlice(2);

        ipp.paste();
//        ipp.updateAndDraw();
        
        IJ.selectWindow(postcard);

        String s = "updatePostcard:\npcX = " + pcX + " pcY = " + pcY
                + "\nsize = " + size + "\nangle = " + angle
                + "\nxcen = " + xcen + "\nycen = " + ycen;

//        toInstructionWidow(s, true);

    }

    public void rotateSubject() {

//        IJ.run("Rotate...", "angle=" + a);
        IJ.run(ipp, "Rotate... ", "angle=" + angle
                + " grid=1 interpolation=Bilinear");
 
    }

    public void changeSize() {

        ImageProcessor ip = ipt.getProcessor();
        ip = ip.duplicate();
        ip = ip.crop();

        double width = ip.getWidth();
        double height = ip.getHeight();

        int new_width = 0;
        int new_height = 0;
        
        new_width = (int) (width + size);
        new_height = (int) (height + size);
        
        if (new_width != 0 || new_height != 0) {
            ip.setInterpolate(true);
            ip = ip.resize(new_width, new_height);
        }

        ips.setProcessor("Subject", ip);
        ips.updateAndDraw();
        
        resetCard();       

        updatePostcard();
        
    }
    
    private void setupListener() {

        ImageWindow win = ipp.getWindow();
        canvas = win.getCanvas();
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
//        IJ.log("mouse clicked");
    }

    /**
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
//        sublen += 10;
//        
//        IJ.log("mouse pressed: sublen = " + sublen);
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {
//        IJ.log("mouse released");

//        Rectangle rec = imageRoi.getBounds();
//        int rw = rec.width;
//        int rh = rec.height;
//        int rx = rec.x + rw / 2;
//        int ry = rec.y + rh / 2;
//
//        if (logWin) {
//            progressCount++;
//            IJ.log(progressCount + ": mouseReleased\nrec.width = "
//                    + rec.width
//                    + "\nrec.height = " + rec.height
//                    + "\nrec.x = " + rec.x
//                    + "\nrec.y = " + rec.y
//                    + "\nrec.x + rw / 2 = " + rx
//                    + "\nrec.y + rh / 2 = " + ry);
//        }
//        pcX = rx;
//        pcY = ry;
//
//        if (logWin) {
//            progressCount++;
//            IJ.log(progressCount + ": mouseReleased\nsublen = " + sublen
//                    + "\nstep = " + step
//                    + "\npcX = " + pcX
//                    + "\npcY = " + pcY
//                    + "\nangle = " + angle);
//        }
//
//        String s = "mouseReleased: " + "\nimageRoi width = " + rw + ", imageRoi height = " + rh
//                + "\nrec.x = " + rec.x + ",  rec.y = " + rec.y
//                + "\nrec.width = " + rec.width
//                + "\ncenter x = " + pcX
//                + "\ncenter y = " + pcY;
//
//        toInstructionWidow(s, true);

    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {
//        IJ.log("mouse entered");
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {

        Roi roi = ipp.getRoi();
        Rectangle rec = roi.getBounds();
        pcX = rec.x;
        pcY = rec.y;
        int wid = rec.width;
        int hit = rec.height;

        xcen = (int) pcX + wid / 2;
        ycen = (int) pcY + hit / 2;

        String s = "mouseExited:\npcX = " + pcX
                + "\npcY = " + pcY
                + "\nxcen = " + xcen + "\nycen = " + ycen
                + "\nROI width = " + wid;

        toInstructionWidow(s, true);

    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseDragged(MouseEvent me) {
//        IJ.log("mouse dragged");
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseMoved(MouseEvent me) {
//        IJ.log("mouse moved");
    }

    private void toInstructionWidow(String s, Boolean go) {
        if (go) {
            String s1 = InfoTextArea.getText();
            String s2 = "\n*******************\n";
            InfoTextArea.setText(s1 + s2 + s);
        } else {
            InfoTextArea.setText(s);
        }
    }

    private void moveWindow(ImagePlus impl, int x, int y) {

        impl.getWindow().setLocation(x, y);

    }
}
import ij.ImagePlus;
import ij.gui.Roi;


/**
 * Copyright Jun 30, 2012 The GAIA Group
 * http://gaiag.net
 */
public class AAPC_Var {

    private static PostCard pc;
    private static ChooseCardTemplate cc;
    private static YourImage yi;
    private static FinalizePC fpc;
    private static PickSubject ps;
    private static WandFrame wf;
    private static FinishingTouches ft;
    private static Cut_Paste cp;
    private static OutlineSubject os;

    
    private static ImagePlus imp, img;
    
    private static Roi roi;
    
    private static int language,
            pcX, pcY,
            backKey;
    private static double pcW, pcH;
    
    private static String path;
    private static Boolean horizontal;

    static void putChooseCardTemplate(ChooseCardTemplate c) {
        cc = c;
    }

    static void putYourImage(YourImage y) {
        yi = y;
    }

    static void putFinalizePC(FinalizePC f) {
        fpc = f;
    }

    static void putCutPaste(Cut_Paste c) {
        cp = c;
    }

    static void putPickSubject(PickSubject p) {
        ps = p;
    }

    static void setBackKey(int bk) {
        backKey = bk;
    }

    static int getBackKey() {
        return backKey;
    }

    AAPC_Var(PostCard p) {

        pc = p;

    }

    public static PostCard getPostCard() {
        return pc;
    }

    public static void showPostCard() {
        pc.setVisible(true);
    }

    public static void hidePostCard() {
        pc.setVisible(false);
    }

    public static void showChooseCard() {
        cc.setVisible(true);
    }

    public static void hideChooseCard() {
        cc.setVisible(false);
    }

    public static void showYourImage() {
        yi.setVisible(true);
    }

    public static void hideYourImage() {
        yi.setVisible(false);
    }

    public static void showCutPaste() {
        cp.setVisible(true);
    }

    public static void hideCutPaste() {
        cp.setVisible(false);
    }

    static void showFinalize() {
        fpc.setVisible(true);
    }

    static void hideFinalize() {
        fpc.setVisible(false);
    }

    static void showPicSubject() {
        ps.setVisible(true);
    }

    static void hidePicSubject() {
        ps.setVisible(false);
    }

    static void setOutlineSubject(OutlineSubject o) {
        os = o;
    }

    static void showOutlineSubject() {
        os.setVisible(true);
    }

    static void hideOutlineSubject() {
        os.setVisible(false);
    }

    static void setWandFrame(WandFrame w) {
        wf = w;
    }

    static void showWandFrame() {
        wf.setVisible(true);
    }

    static void hideWandFrame() {
        wf.setVisible(false);
    }

    static void setFinishingTouches(FinishingTouches f) {
        ft = f;
    }

    static void showFinishingTouches() {
        ft.setVisible(true);
    }

    static void hideFinishingTouches() {
        ft.setVisible(false);
    }
    
    static void putImage(ImagePlus ip) {
        imp = ip;
    }
    
    static ImagePlus getImage() {        
        return imp;        
    }
    
    static void putSubject(ImagePlus s) {
        img = s;
    }
    
    static ImagePlus getSubject() {        
        return img;        
    }

    static void setROI(Roi r) {
        roi = r;
    }

    static Roi getROI() {
        return roi;
    }

    static void setLanguage(int lang) {
        language = lang;
    }

    static int getLanguage() {
        return language;
    }

    public static void setPath(String p) {
        path = p;
    }

    public static String getPath() {
        return path;
    }

    public static void setOrientation(Boolean orien) {
        horizontal = orien;
    }

    public static Boolean getOrientation() {
        return horizontal;
    }
    
    public static void setPCX(int x) {
        pcX = x;
    }
    
    public static int getPCX() {
        return pcX;
    }
    
    public static void setPCY(int y) {
        pcY = y;
    }
    
    public static int getPCY() {
        return pcY;
    }

    static void setPCW(double pW) {
        pcW = pW;
    }
    
    public static double getPCW() {
        return pcW;
    }

    static void setPCH(double pH) {
        pcH = pH;
    }
    
    public static double getPCH() {
        return pcH;
    }
    
}

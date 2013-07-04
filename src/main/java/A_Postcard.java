
import ij.IJ;
import ij.plugin.PlugIn;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chris
 */
public class A_Postcard implements PlugIn {

    @Override
    public void run(String s) {

        s = "process";
//        s = "aaa";
//        s = "iroi";

        if (s.equals("process")) {

            PostCard pc = new PostCard();

            AAPC_Var aapc = new AAPC_Var(pc);
            
            aapc.showPostCard();
        }
    }
    
    public static void main(final String... args ) {
        new ij.ImageJ();
        new A_Postcard().run("");
    }
}

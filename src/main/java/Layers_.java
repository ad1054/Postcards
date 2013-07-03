import ij.*;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import java.util.*;

/** Bob Dougherty.
	Plugin to combine the slices of a stack from back to front.
	Version 0 3/12/2004. */
/*	License:
	Copyright (c) 2004, 2005, OptiNav, Inc.
	All rights reserved.

	Redistribution and use in source and binary forms, with or without
	modification, are permitted provided that the following conditions
	are met:

		Redistributions of source code must retain the above copyright
	notice, this list of conditions and the following disclaimer.
		Redistributions in binary form must reproduce the above copyright
	notice, this list of conditions and the following disclaimer in the
	documentation and/or other materials provided with the distribution.
		Neither the name of OptiNav, Inc. nor the names of its contributors
	may be used to endorse or promote products derived from this software
	without specific prior written permission.

	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
	"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
	LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
	A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
	CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
	EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
	PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
	PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
	LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
	NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
	SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

public class Layers_ implements PlugInFilter, Runnable {
	ImagePlus impStack;
	ImageProcessor ipStack;
	ImageStack stack;
	ImageCanvas icStack;
	static int napTime = 100;
	boolean done = false;
	ImagePlus imp;
	ImageCanvas ic;
	protected Thread thread;
	ImageProcessor ip;

	public int setup(String arg, ImagePlus imp) {
		impStack = imp;
		return DOES_ALL;
	}

	public void run(ImageProcessor ip) {
		icStack = impStack.getWindow().getCanvas();
		ipStack = ip;
		stack = impStack.getStack();
		createImage();
		thread = new Thread(this, "Layers");
		thread.start();
	}
	public void run() {
		int i = 0;
		while (!done) {
			try {Thread.sleep(napTime);}
			catch(InterruptedException e) {
				break;
			}
			if ((icStack==null)||(ic==null)){
				break;
			}
			if ((!icStack.isValid())||(!ic.isValid())){
				break;
			}
			combine();
		}
	}
	void combine(){
		int n = impStack.getStackSize();
		ImageProcessor ipStack = stack.getProcessor(1);
		ip = ipStack.duplicate();
		//double min = ipStack.getMin();
		//double max = ipStack.getMax();
		if (ip instanceof ColorProcessor){
			ColorBlitter cb = new ColorBlitter((ColorProcessor)ip);
			cb.setTransparentColor(Toolbar.getBackgroundColor());
			for (int slice = 2; slice <= n; slice++)
				cb.copyBits(stack.getProcessor(slice),0,0,Blitter.COPY_TRANSPARENT);
		} else 	if (ip instanceof FloatProcessor){
			FloatBlitter fb = new FloatBlitter((FloatProcessor)ip);
			fb.setTransparentColor(Toolbar.getBackgroundColor());
			for (int slice = 2; slice <= n; slice++)
				fb.copyBits(stack.getProcessor(slice),0,0,Blitter.COPY_TRANSPARENT);
		} else 	if (ip instanceof ByteProcessor){
			ByteBlitter bb = new ByteBlitter((ByteProcessor)ip);
			bb.setTransparentColor(Toolbar.getBackgroundColor());
			for (int slice = 2; slice <= n; slice++)
				bb.copyBits(stack.getProcessor(slice),0,0,Blitter.COPY_TRANSPARENT);
		} else 	if (ip instanceof ShortProcessor){
			ShortBlitter sb = new ShortBlitter((ShortProcessor)ip);
			sb.setTransparentColor(Toolbar.getBackgroundColor());
			for (int slice = 2; slice <= n; slice++)
				sb.copyBits(stack.getProcessor(slice),0,0,Blitter.COPY_TRANSPARENT);
		}
		imp.setProcessor(null,ip);
		imp.updateAndDraw();
	}


	void createImage(){
		String title = impStack.getShortTitle();
		ImageProcessor ipStack = impStack.getProcessor();
		imp = new ImagePlus("From_"+title,ipStack.duplicate());
		imp.show();
		ic = imp.getWindow().getCanvas();
	}

}

import java.awt.*;
import java.util.*;

import com.baselet.control.constants.Constants;
import com.baselet.control.util.Utils;
import com.baselet.element.old.custom.CustomElement;

@SuppressWarnings("serial")
public class <!CLASSNAME!> extends CustomElement {
	static boolean changed;
	public CustomElementImpl() {
		
	}
	
	@Override
	public void paint() {
		Vector<String> textlines = Utils.decomposeStrings(this.getPanelAttributes());
		/****CUSTOM_CODE START****/
//Modify the code below to define the element's behavior.
//
//Example:  Change the line
//  y += printCenter(textline,y);
//to
//  y += 2*printCenter(textline,y);
//and observe the element preview.

int y=textHeight();
	if (!changed) {
		width = 100;
		height = 50;
		changed = true;
	}
drawRectangle(0,0,width,height);

for(String textline : textlines) {
	y += printCenter(textline,y);
}
		/****CUSTOM_CODE END****/
	}
	void DrawDashedLine(int x1, int y1, int x2, int y2){
        Graphics graphics = getGraphics();
        graphics.setColor(Color.black);

        int dashLength = 5;
        int loopend =(int) Math.sqrt((x1 - x2) * (x1 - x2) + (y2 - y1) * (y2 - y1));
          if (y1 == y2)
        {
            for (int i = x1; i < x2; i+=10) {
                drawLine(i,y1, i+5,y2);
            }
            return;
        }
        for (int x = 0, j = y1; x < loopend/dashLength  ;x++, j+= dashLength * (y2-y1)/Math.abs(y2-y1))
        {
            int i = getX3(x1,y1,x2,y2,j);
            if (x%2 == 1)
            drawLine(i,j,getX3(x1,y1,x2,y2,j +dashLength)  , j + dashLength);
        }
    }
     int getX3(int x1, int y1, int x2, int y2, int y3)
     {
         return  x1 + ((y3 - y1) * (x2-x1) / (y2-y1));
     }
}
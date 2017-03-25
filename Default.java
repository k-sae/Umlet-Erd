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
		Vector<String> textlines = getAttributes();
		/****CUSTOM_CODE START****/

    drawRectangle(0,0,width,height);
    printInTheMiddle(textlines);
		/****CUSTOM_CODE END****/
	}
	void DrawDashedLine(int x1, int y1, int x2, int y2){
        int dashLength = 5;
        int loopend =(int) Math.sqrt((x1 - x2) * (x1 - x2) + (y2 - y1) * (y2 - y1));
          if (y1 == y2)
        {
            for (int i = x1; i < x2; i+=10) {
                drawLine(i,y1, i+5,y2);
            }
        }
        else{
        for (int x = 0, j = y1; x < loopend/dashLength  ;x++, j+= dashLength * (y2-y1)/Math.abs(y2-y1))
        {
            int i = getX3(x1,y1,x2,y2,j);
            if (x%2 == 1)
            drawLine(i,j,getX3(x1,y1,x2,y2,j +dashLength)  , j + dashLength);
        }
      }
    }
     int getX3(int x1, int y1, int x2, int y2, int y3)
     {
         return  x1 + ((y3 - y1) * (x2-x1) / (y2-y1));
     }
      void printInTheMiddle(Vector<String> strings){
        int y=(height/2 - textHeight() + 5) * 1 * 1/2;
        for (String s: strings
             ) {
            if(!s.startsWith("width=") && !s.startsWith("height="))
            {
                y += y + textHeight();
                printCenter(s,y);
            }
        }
       
     }
     Vector<String> getAttributes(){
      boolean widthFound = false;
      boolean heightFound = false;
      Vector<String> textlines = Utils.decomposeStrings(this.getPanelAttributes());
          for (String s: textlines)
            {
              if(s.startsWith("width="))
              {
                  width=Integer.parseInt(s.substring("width=".length()));
                  widthFound = true;
              }
              else if (s.startsWith("height="))
              {
                  height=Integer.parseInt(s.substring("height=".length()));
                  heightFound = true;
              }
            }
      return textlines;
  }
}
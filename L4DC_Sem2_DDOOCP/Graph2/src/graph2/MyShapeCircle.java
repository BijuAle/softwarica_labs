
package graph2;

import java.awt.geom.Ellipse2D;


     public class MyShapeCircle{
         
         int x,y,h,w;
         int scheme;
         
         Ellipse2D ellipse;
         
         public MyShapeCircle(int x,int y,int h,int w,int scheme){
             this.x=x;
             this.y=y;
             this.h=h;
             this.w=w;
             this.scheme=scheme;
             
             ellipse= new Ellipse2D.Double(x, y, w, h);
         }
         
        public void move(){
             switch (scheme) {
                 case 0:
                     x+=5;
                     break;
                 case 1:
                     y+=5;
                     break;
                 case 2:
                     x+=5;
                     y+=5;
                     break;
                 default: x+=5;
                     break;
             }
        } 
        
        public Ellipse2D getShape(){
            return ellipse;
        }
         
     }

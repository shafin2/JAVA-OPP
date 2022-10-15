import java.util.Random;
import javax.swing.JPanel;
import java.awt.*;
public class MyPanel extends JPanel
{
     public void paintComponent(Graphics g)
	{
		Random numbers = new Random();  // Random Class Object .
		int face1 =0;
		int face2 =0;
		int face3 =0;                  
		int face4 =0;                              // ints Declaration..
		int face5 =0;
		int face6 =0;
		float per1,per2,per3,per4,per5,per6;      //floats Declaration..
		for (int i=1;i<=1000;i++)                 // Dice Frequency Loop..
		{
		    int r = (1+numbers.nextInt(6));
		    //System.out.println(r);
		    switch (r)                        //Decision-Statement..
		       {
			     case 1 : face1++;
	                      break;
                 case 2 : face2++;
                          break;
                 case 3 : face3++;
                          break;
                 case 4 : face4++;
                          break;
                 case 5 : face5++;
                          break;
                 case 6 : face6++;
               }                                //Switch End..
		}                                       //for end..
    System.out.println("Face 1 : "+face1);
	
	per1 =  face1/1000f*100;
	int per10 = (int) per1;
	
	System.out.println("Face 2 : "+face2);
	
	per2 = face2/1000f*100;
	int per20 = (int) per2;
	
	System.out.println("Face 3 : "+face3);
	
	per3 = face3/1000f*100;
	int per30 = (int) per3;
	
	System.out.println("Face 4 : "+face4);
	
	per4 = face4/1000f*100;
	int per40 = (int) per4;
	
	System.out.println("Face 5 : "+face5);
	
	per5 = face5/1000f*100;
    int per50 = (int) per5;
    
	System.out.println("Face 6 : "+face6);    
	
	per6 = face6/1000f*100;
	int per60 = (int) per6;	 
		
	//System.out.printf("\nPer 1 :"+per1+"\nPer 2 :"+per2+"\nPer 3 :"+per3+"\nPer 4: "+per4+"\nPer 5: "+per5+"\nPer 6: "+per6);
	 
	 int y = 39;
	 int w=0;
	 g.setColor(Color.MAGENTA);
	 g.drawString("FREQUENCY",440,20);
	 for (int i=1;i<=6;i++)                          // Frequency Bars Horizontally..
	  {
	        if (i==1)
	               {
	        	        w = face1;
	        			g.setColor(Color.MAGENTA);
	        			g.fillRect(100,y,w,8);
	               }
                else if (i==2)
                    {
             	       w = face2;
             	       g.fillRect(100,y,w,8);
                    }      	
                else if (i==3)
             	    {
             		   w = face3;
             		   g.fillRect(100,y,w,8);
             	    }
             	else if (i==4)
             	    {
             		   w = face4;
             		   g.fillRect(100,y,w,8);
             	    }
             	else if (i==5)
             	    {
             		   w = face5;
             		   g.fillRect(100,y,w,8);
             	    }
             	else if (i==6)
             	{
             		w = face6;
             		g.fillRect(100,y,w,8);
             	}
            y=y+19;
	  }  
	y = 42;
	for(int j = 1;j<=6;j++)                          // Faces Values/Frequencies Mathematics fOrm.
	{
	   if (j==1)
	    g.drawString(""+face1,460,y);
	   
	      else if (j==2)
	   	    g.drawString(""+face2,460,y);
	   
	      else if (j==3)
	   	    g.drawString(""+face3,460,y);
	   
	      else if (j==4)
	   	    g.drawString(""+face4,460,y);
	   
	      else if (j==5)
	   	    g.drawString(""+face5,460,y);
	   
	      else if (j==6)
	   	    g.drawString(""+face6,460,y);
	   y = y+19;
  }
   	
   	int e = 70;
	int f = 70;
	g.setColor(Color.BLACK);
	g.drawLine(50,200,280,200);                    //1st Horizontal Line..
	g.drawLine(50,400,50,200);                     //1st Vertical Line..
	g.drawLine(480,400,630,400);                   // 2nd Horizontal Line..
	g.drawLine(480,400,480,200);                   // 2nd Vertical Line..
	
	for (int c =0;c<6;c++)                          // Points On FREQUENCY Graph..
	    {
	       g.drawLine(e,200,f,190); 
	       e = e+35;
	       f = f+35;
	    }
	int z = 66;
	int l =0;
	for (int k = 1;k<=6;k++)                          //Bars Vertically For Frequency..
	{
	    g.setColor(Color.MAGENTA);
	    if (k==1)
	        {
	          l = face1;
	          g.drawRect(z,200,8,l);
	        }
	        else if (k==2)
	            {
	    	       l= face2;
	    	       g.drawRect(z,200,8,l);
	            }
	        else if (k==3)
	            {
	    	       l = face3;
	    	       g.drawRect(z,200,8,l);
	             }
	        else if (k==4)
	             {
	    	       l = face4;
	    	       g.drawRect(z,200,8,l);
	             }
	        else if (k==5)
	             {
	    	       l = face5;
	    	       g.drawRect(z,200,8,l);
	             }
	        else if (k==6)
	             {
	    	        l = face6;
	    	        g.drawRect(z,200,8,l);
	             }
	     z = z+35;
	}
	
	int o = 220;
	int p = 220;
	
	for (int i=0;i<6;i++)                           // Points On the Graph Percentages Points..
	    {
	      g.setColor(Color.BLACK);
	      g.drawLine(470,o,480,p);
	      o=o+30;
	      p = p+30;
	    }
	
	int q = 216;
	int u =0;
	for(int i=1;i<=6;i++)                         // Horizontal Bars For Percentage Graph.
	     {
           if (i==1)
           {
           u = per10;
           g.setColor(Color.blue);
           g.drawRect(480,q,u,8);
           }
           else if (i==2)
           {
           	u = per20;
           	g.drawRect(480,q,u,8);
           }
           else if (i==3)
           {
           	u = per30;
           	g.drawRect(480,q,u,8);
           }
           else if (i ==4)
           {
           	u = per40;
           	g.drawRect(480,q,u,8);
           }
           else if (i ==5)
           {
           	u = per50;
           	g.drawRect(480,q,u,8);
           }
           else if (i ==6)
           {
           	u = per60;
           	g.drawRect(480,q,u,8);
           }
	  q=q+30;
	     }
	     {
	g.setColor(Color.MAGENTA);
	g.drawString("FREQUENCY",120,430);
	     }
	g.setColor(Color.BLUE);
	g.drawString("PERCENTAGE",550,430);
	
    g.drawString("PERCENTAGE",595,20);
    int m =42;
    
    for (int i=1;i<=6;i++)                               //Percentage String..
         {
          if (i==1)
            g.drawString(""+per1,610,m);
          
              else if (i==2)
      	         g.drawString(""+per2,610,m);
    
              else if (i==3)
    	         g.drawString(""+per3,610,m);
    
              else if (i==4)
    	         g.drawString(""+per4,610,m);
    
              else if (i==5)
    	         g.drawString(""+per5,610,m);
     
              else if (i==6)
    	         g.drawString(""+per6,610,m);
          m=m+19;
         }
    
    g.setColor(Color.BLACK);
    g.drawString("FACE",30,20);
    int b = 28;
    
    for (int i=0;i<=6;i++)                                // Face Serial..
        {
         g.setColor(Color.RED);
         if (i==1)
    	     g.drawString("1",40,b);
    
           else if (i==2)
    	      g.drawString("2",40,b);
    
           else if (i==3)
    	      g.drawString("3",40,b);
    
           else if (i==4)
    	      g.drawString("4",40,b);
    
           else if (i==5)
    	      g.drawString("5",40,b);
    
           else if (i==6)
    	      g.drawString("6",40,b);			
        b=b+20;
       }
	
	//for (int i=0;i<6;i++)                           // Points On the Graph Percentages Points..
	    //{
	      g.setColor(Color.BLACK);
	      g.drawLine(350,0,350,465);
	      g.drawLine(0,170,760,170);
	    int dis=223;
	     for (int i=1;i<=6;i++)
	     {
	      g.setColor(Color.RED);
	      g.drawString(""+i,450,dis);
	     dis = dis+30;
	     }
	int dis2 = 67;
	for (int i=1;i<=6;i++)
	     {
	      g.setColor(Color.RED);
	      g.drawString(""+i,dis2,188);
	      dis2 = dis2+35;
	     }
	int dis12 =220, dis23=220;
	for (int i=0;i<7;i++)                           // Points On the Graph Percentages Points..
	    {
	      g.setColor(Color.BLACK);
	      g.drawLine(40,dis12,50,dis23);
	      dis12=dis12+30;
	      dis23 = dis23+30;
	    }
	int dis45=223,ma=30,na=30;
	for (int i =1;i<=7;i++)
	{
	g.drawString(""+(ma+na),18,dis45);
	dis45 = dis45+30;
	ma+=10;
	na+=10;
	}
	}                                        //paintComponent Method end..
}                                               // Class end..
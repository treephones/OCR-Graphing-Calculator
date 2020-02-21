//Moez B. 2/16/2020

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class graph extends JComponent {
	private int length= Toolkit.getDefaultToolkit().getScreenSize().width;
	private int width= Toolkit.getDefaultToolkit().getScreenSize().height;
	private interp aasc; //analysis and scanner class
	private int deg;
	private int[] coes;
	int[] xpts = new int[this.length];
	int[] ypts = new int[this.length];
	public graph() {
		super();
		this.setPreferredSize(new Dimension(length,width));
		/*this.pack();
		this.setVisible(true);
		this.setTitle("graph");*/
	}
	public void fileInit(File img) {
		this.aasc = new interp(img);
		System.out.println(aasc.eqtn);
		this.deg = aasc.getDeg();
		this.coes = aasc.getCoes();
	}
	public void inputInit(String equation) {
		this.aasc=new interp(equation);
		System.out.println(equation);
		this.deg=aasc.getDeg();
		this.coes=aasc.getCoes();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		for(int i = 0;i < length;i+=10) {
			if(i == length/2) {
				g.setColor(Color.RED);
			}
			g.drawLine(i, 0, i, width);
			g.setColor(Color.BLACK);
		}
		for(int j = 0;j < width;j+=10) {
			if(j == width/2) {
				g.setColor(Color.RED);
			}
			g.drawLine(0,j,length,j);
			g.setColor(Color.BLACK);
		}
		int deg = this.deg;  //largest degree of func		
		int[] coes = this.coes; //length of this arr should never be shorter than deg+1; will cause ArrOOB exception

		g.translate(length/2,width/2);
		if(deg > 0) {
			for(int i = -this.length/2;i < this.length/2;++i) {
				//System.out.println(i);
				xpts[i+this.length/2] = i*10;
				if(i == 0) {
					ypts[this.length/2] = -coes[coes.length-1]*10;
				}
				else {
					for(int j = deg;j >= 0;--j) {
						ypts[i+this.length/2] += ((-i * Math.pow(i,j-1))*coes[coes.length-1-j])*10;
					}
				}				
			}
		}
		else if(deg < 0) {
			rFunc();
			g.drawLine(-1, -430, -1, -99);

		}
		g.drawPolyline(xpts,ypts,this.length);		
	}
	
	public void rFunc() {
	    xpts[0] = -720;
	    ypts[0] = 1;
		int num=1;
		for(double i=-15;i<15;i+=0.1) {
			if (i!=0){
				xpts[num]=(int) ((i)*10);
				ypts[num]=(int) ((-(1/(i)))*10);
				num++;
			}
			if(num==150) {
				xpts[num]=-1;
				ypts[num]=430;
				num++;
			}//if
			if(num==299) {
				xpts[num]=720;
				ypts[num]=1;
				num++;
			}//if
		}//for 
		
	}//rFunc method
	
}
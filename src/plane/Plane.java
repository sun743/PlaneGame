package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;



public class Plane {
	double x,y;
	Image img;
	boolean up,down,left,right;
	int speed=10;
	int width,height;
	//��ȡ����
	public Rectangle getRec(){
		Rectangle r=new Rectangle((int)x,(int)y,width,height);
		return r;
	}
	public void draw(Graphics g){
		g.drawImage(img, (int)x, (int)y, null);
		move();
	}
	public void move(){
		//38 40 37 39:up down left right
		if(left) x-=speed;
		if(right) x+=speed;
		if(up)   y-=speed;
		if(down) y+=speed;
		
	}
	public void direction(int e,boolean add){
		switch(e){
		case KeyEvent.VK_RIGHT:	right=add;break;
		case KeyEvent.VK_LEFT:	left=add;break;
		case KeyEvent.VK_UP:	up=add;break;
		case KeyEvent.VK_DOWN:	down=add;break;
		}
	}
	public Plane(String path,double x,double y){
		this.img=util.GameUtil.getImage(path);
		this.x=x;
		this.y=y;
	}
	public Plane(){
		width=img.getWidth(null);
		height=img.getHeight(null);
	}
}
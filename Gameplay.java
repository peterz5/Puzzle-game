import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.BasicStroke;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

//Is the editing option working? 

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	private boolean play = false; 
	private Timer timer; 
	// timer delay should be 0 as it should update immidiately 
	private int delay = 1; 
	private int moves = 0; 
	static int width = 600; 
	static int height = 600; 
	static int min = Math.min(width, height);
	private int xprevious = 305; 
	private int yprevious = 305; 
	private int xblank = 305;
	private int yblank = 305; 
	private int xone = 5;
	private int yone = 5; 
	private int xtwo = 155;
	private int ytwo = 5; 
	private int xthree = 305;
	private int ythree = 5; 
	private int xfour = 5; 
	private int yfour = 155; 
	private int xfive = 155; 
	private int yfive = 155; 
	private int xsix = 305;
	private int ysix = 155; 
	private int xseven = 5; 
	private int yseven = 305; 
	private int xeight = 155; 
	private int yeight = 305; 
	private BufferedImage one, two ,three, four, five, six, seven ,eight; 

	public Gameplay(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		imageCut(); 
		timer = new Timer(0, this);
		timer.start();
	}
	public void imageCut(){
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("Duck.jpg"));
		} catch (IOException e){}
		double width = 450/((double) image.getWidth());
		double height = 450/((double) image.getHeight());
		
		AffineTransform tx = new AffineTransform();
		tx.scale(width, height);
	    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
	    image = op.filter(image, null);
	    
		one = image.getSubimage(0,  0, 150, 150);
		two = image.getSubimage(150, 0, 150, 150);
		three = image.getSubimage(300, 0, 150, 150);
		four = image.getSubimage(0, 150, 150, 150);
		five = image.getSubimage(150, 150, 150, 150);
		six = image.getSubimage(300, 150, 150, 150);
		seven = image.getSubimage(0, 300, 150, 150);
		eight = image.getSubimage(150, 300, 150, 150);
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g; 
		g.setColor(Color.white);
		g.fillRect(1, 1, 500, 500);
		
		

		
		if(xone == xblank && yone == yblank){
			xone = xprevious; 
			yone = yprevious; 
		} else if(xtwo == xblank && ytwo == yblank){
			xtwo = xprevious; 
			ytwo = yprevious;
		} else if(xthree == xblank && ythree == yblank){
			xthree = xprevious; 
			ythree = yprevious;
		} else if(xfour == xblank && yfour == yblank){
			xfour = xprevious; 
			yfour = yprevious;
		} else if(xfive == xblank && yfive == yblank){
			xfive = xprevious; 
			yfive = yprevious;
		} else if(xsix == xblank && ysix == yblank){
			xsix = xprevious; 
			ysix = yprevious;
		} else if(xseven == xblank && yseven == yblank){
			xseven = xprevious; 
			yseven = yprevious;
		} else if(xeight == xblank && yeight == yblank){
			xeight = xprevious; 
			yeight = yprevious;
		}
		
		g.drawImage(one, xone, yone, null);
		g.drawImage(two, xtwo, ytwo, null);
		g.drawImage(three, xthree, ythree, null);
		g.drawImage(four, xfour, yfour, null);
		g.drawImage(five, xfive, yfive, null);
		g.drawImage(six, xsix, ysix, null);
		g.drawImage(seven, xseven, yseven, null);
		g.drawImage(eight, xeight, yeight, null);


		g2.setStroke(new BasicStroke(3));
		g.setColor(Color.black);
		g.drawRect(5, 5, 450, 450);
		g.fillRect(xblank, yblank, 150, 150);
		g.drawRect(305, 305, 150, 150);
		g.drawRect(5, 305, 150, 150);
		g.drawRect(5, 5, 150, 150);
		g.drawRect(305, 5, 150, 150);
		g.drawRect(155, 155, 150, 150);
		

	}
	
	private int getWdith(BufferedImage one) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void actionPerformed(ActionEvent e){
		//timer.start();
		repaint();
	}
	
	public void moveRight(){
		play = true; 
		xblank-=150;
	}
	
	public void moveLeft(){
		play = true; 
		xblank+=150;
	}
	
	public void moveDown(){
		play = true; 
		yblank-=150; 
	}
	
	public void moveUp(){
		play = true; 
		yblank+=150;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			if(xblank >= 305){
				xblank=305;
			} else {
				xprevious = xblank;
				yprevious = yblank; 
				moveLeft();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(xblank <= 5){
				xblank=5;
			} else {
				xprevious = xblank;
				yprevious = yblank; 
				moveRight();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			if(yblank >= 305){
				yblank=305;
			} else {
				xprevious = xblank;
				yprevious = yblank; 
				moveUp();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			if(yblank <= 5){
				yblank=5;
			} else {
				xprevious = xblank;
				yprevious = yblank; 
				moveDown();
			}
		}
		
	}
	
	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
}

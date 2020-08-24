import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private Color pointerColor = Color.red;
	private String pointerType = "CIRCLE";
	
	private int posX = -10, oldX = -10;
	private int posY = -10, oldY = -10;
	
	private boolean erasing = true;
	
	private int pointerSize = 15;
	
	private ArrayList<Point> points = new ArrayList<Point>();
  
	public DrawPanel() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				points.add(new Point(e.getX() - (pointerSize / 2),e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
				repaint();
				}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				points.add(new Point(e.getX() - (pointerSize / 2),e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
				repaint();
				}
			public void mouseMoved(MouseEvent e) {
				
			}
		});
	
	}

  public void paintComponent(Graphics g){
    g.setColor(Color.white);
    g.fillRect(0, 0,this.getWidth() , this.getHeight());
    if(this.erasing) {
    	this.erasing = false;
    }
    else {
    	for(Point p: this.points) {
    		g.setColor(p.getColor());
    		
    		if(p.getType().equals("SQUARE")) {
    		g.fillRect(p.getX(),p.getY(),p.getSize(),p.getSize());
    	}
    		else {
    			g.fillOval(p.getX(),p.getY(),p.getSize(),p.getSize());
    		}
    	}
    }
  }


  
  public void erase(){
	    this.erasing = true;
	    this.points = new ArrayList<Point>();
	    repaint();
	  }
  //Définit la couleur du pointeur
  public void setPointerColor(Color c){
    this.pointerColor = c;
  }

  //Définit la forme du pointeur
  public void setPointerType(String str){
    this.pointerType = str;
  }   
  
}
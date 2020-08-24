import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
 
public class Fenetre extends JFrame{
  private DrawPanel pan = new DrawPanel();
  private JMenuBar menuBar = new JMenuBar();
  private JMenu fichier = new JMenu("Fichier"),
		  edition = new JMenu("Edition"),
		  forme =  new JMenu("Forme du pointeur"),
		  color = new JMenu("Couleur du pointeur");
  
  private JMenuItem effacer = new JMenuItem("Effacer"),
		  quitter = new JMenuItem("Quitter"),
		  rond = new JMenuItem("Rond"),
		  carre = new JMenuItem("Carré"),
		  rouge = new JMenuItem("Rouge"),
		  vert = new JMenuItem("Vert"),
		  bleu = new JMenuItem("Bleu");
  
private JToolBar toolBar = new JToolBar();

private JButton squareBouton = new JButton(new ImageIcon("images/carré.jpg")),
		circleBouton = new JButton(new ImageIcon("images/rond.jpg")),
		redBouton = new JButton(new ImageIcon("images/rouge.jpg")),
		greenBouton = new JButton(new ImageIcon("images/vert.jpg")),
		blueBouton = new JButton(new ImageIcon("images/bleu.jpg"));

  

  public Fenetre(){        

    this.setSize(640, 480);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    initMenu();
    initToolBar();
    
    this.getContentPane().add(pan,BorderLayout.CENTER);
    this.setVisible(true);
  }
  
  private void initToolBar() {
	  squareBouton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerType("SQUARE");
		  }
	  });
	  toolBar.add(squareBouton);
	  circleBouton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerType("CIRCLE");
		  }
	  });
	  
	  toolBar.add(circleBouton);
	  toolBar.addSeparator();
	  
	  redBouton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerColor(Color.red);
		  }
	  });
			  
	  toolBar.add(redBouton);
	  greenBouton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerColor(Color.green);
		  }
	  });
			  
	  toolBar.add(greenBouton);
	  blueBouton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerColor(Color.blue);
		  }
	  });
	  
	  toolBar.add(blueBouton);
	  getContentPane().add(toolBar, BorderLayout.NORTH);
	
}

public void initMenu () {
	  effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
	  effacer.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.erase();
		  }
	  });
	  
	  fichier.add(effacer);
	  fichier.addSeparator();
	  
	  quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
	  quitter.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        System.exit(0);
	      }        
	    });
	  
	  fichier.add(quitter);
	  

	  rond.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerType("CIRCLE");
		  }
	  });
	  forme.add(rond);
	  
	  carre.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerType("SQUARE");
		  }
	  });
	  forme.add(carre);
	  
	  rouge.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerColor(Color.RED);
		  }
	  });
	  color.add(rouge);
	  vert.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerColor(Color.green);
		  }
	  });
	  color.add(vert);
	  bleu.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			  pan.setPointerColor(Color.blue);
		  }
	  });
	  color.add(bleu);

	  edition.add(forme);
	  edition.addSeparator();
	  edition.add(color);
	  
	  
	  
	  
	  
	  menuBar.add(fichier);
	  menuBar.add(edition);
	  setJMenuBar(menuBar);
  }

      
}
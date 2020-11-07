package flappybird;  

import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel {    // creating renderer class 

	
	private static final long serialVersionUID = -4571292323099438650L;   //generating Version id 
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		FlappyBird.flappyBird.repaint(g);  //using these graphics into class.
		
	}

}

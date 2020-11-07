package flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import java.awt.Color;

import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.event.*;

public class FlappyBird implements ActionListener, MouseListener, KeyListener {
	
	public static FlappyBird flappyBird;    // creating variable/instance 
    
	                                                                      
	 public static final Color purplecolor = new Color(102,0,153);  //columns color
	 public static final Color birdcolor = new Color(51,204,255);   //bird color
	 public static final Color greycolor = new Color(204,204,204); //grey color import.
	public final int WIDTH=1300, HEIGHT=710;  // as it is one time assignment so we use final
	
	public Renderer renderer;   // creating IV, further usage for graphics rederering of UI components
 
	public Rectangle bird;  //creating   IV, bird seting it to variable
	
	public int taps,birdMotion;  // creating variables for per tick by user, bird upper motion
	
	public boolean gameOver, gamestarted;          //boolean for game start and ending
	 
	public ArrayList<Rectangle> columns;   // creating arraylist 
	
	public Random randcolumn;    
	
	
	
	public FlappyBird ()
	{
		JFrame jframe = new JFrame();             //creating obj of jframe 
		
		renderer= new Renderer();  // creating variable renderer to call and use renderer 
		Timer timer = new Timer(20, this); // adding timer
		randcolumn = new Random () ;  // creating random for columns 
		
		
		jframe.add(renderer);  // adding renderer class into jframe final output
		jframe.setTitle("Flappy Bird- Semester Project- Shoaib Qadeer (FA19-BCS-076)"); //Title set
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close function 
		jframe.setResizable(false); // setting false so that no one can resize it
		jframe.setSize(WIDTH, HEIGHT); // getting value from final 
		jframe.addKeyListener(this);
		jframe.addMouseListener(this);  //adding mouse listener, 
		jframe.setVisible(true); // set screen visible
		
		bird = new Rectangle(WIDTH/2 -10, HEIGHT/2 -10, 20,20);  // creating a bird like a round square  with x and y cordinates to be appear
		columns = new ArrayList<Rectangle>();  //column arraylist of rectangles
		
		
		addColumn(true);
		addColumn(true);
		addColumn(true); 
		addColumn(true);
		
		timer.start(); //time starts
		
	}
	
	public  void addColumn(boolean addcolumn) {
		int space= 300;       // space b/w columns
		int width= 100;      // column width
		int height = 50+ randcolumn.nextInt(250);   // creating random height of column
		
		if (addcolumn) {
			columns.add(new Rectangle(WIDTH+ width+ columns.size()*300, HEIGHT - height -120 ,width , height)); //columns is added. Width is shown to take it to left.
			columns.add ( new Rectangle(WIDTH+ width+ (columns.size()-1)*300, 0,width, HEIGHT-height-space));} //columns logic -lower  to produce variety of 
	
		else { 
			columns.add(new Rectangle(columns.get(columns.size()-1).x+600 , HEIGHT - height -120 ,width , height)); //upper column
			columns.add( new Rectangle(columns.get(columns.size()-1).x, 0,width, HEIGHT-height-space));} //columns logic to advanc	e 
		}
		
		
		
		  
	
	public void paintColumn(Graphics g, Rectangle Column) {    // creating columns as hindrance/obstacles
		
		g.setColor(purplecolor);   //setting columns color to green
		g.fillRect(Column.x, Column.y, Column.width, Column.height);
	}
	

      
      public  void jump() {
    	  if(gameOver) {
    		  bird = new Rectangle(WIDTH/2 -10, HEIGHT/2 -10, 20,20);  // after game is over, bird postion
    		  columns.clear();  //removing elements from list   -game over user has tor restart with space
    			birdMotion=0;
    			addColumn(true);
    			addColumn(true);
    			addColumn(true);
    			addColumn(true);
    		  gameOver= false;
    	  }
    	  
    	  if(!gamestarted) {    //if game is not started
    		  gamestarted=true;   //set game to true
    	  }
    	  
    	  else if (!gameOver) {  
    		  
    		  if(birdMotion>0) {
    			  birdMotion=0;
    		  }
    		  
    		  birdMotion-=10;
    		  }
    	  
    	  
    	  
      }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		int speed=10;
		
		taps++;
		if (gamestarted) { 
			
			for (int i=0;  i<columns.size(); i++) {  // creating a loop to display columns
			Rectangle column  = columns.get(i);
			column.x -=speed;  }
		
		
		if (taps%2==0 && birdMotion<15) {         // condition for per tap of user so that it increase motion of bird
			birdMotion+=2;	 }
		
		bird.y+= birdMotion; //adding motion to bird
		
		for (int i=0;  i<columns.size(); i++) {  
			Rectangle column  = columns.get(i);
			if (column.width+column.x <0) {
				columns.remove(column);                //to avoid any mistake mean complete blockage 
				
				if (column.y==0) {                       // condition if columns height is 0,then  
				addColumn(false);}  
				                    }
			
		for (Rectangle  columns: columns) {
			
			               
			
			
			if(column.intersects(bird)) {
				gameOver= true;  // game over condition
				
				if (gameOver) {
					
					if (bird.x <= column.x) {   // when bird collides with column
						
						bird.x= column.x- bird.width; // bird placments after that intersected pillar
						
					}
					
					else {
						
						if (column.y!=0) {
							bird.y= column.y - bird.height;      // if it falls on top of bottom - game over condition
						}
						
						else if (bird.y<column.height) {
							bird.y=column.height;
						}
						}
				} 
			}
		}
		
		if ( bird.y<=0  || bird.y> HEIGHT-150  ) {  //upper end and lower end game over condition
			gameOver=true;
			
		}
		
		
		
		
		
		if (bird.y+ birdMotion >= HEIGHT-120 ) {
			bird.y= HEIGHT-120- bird.height;    // setting bird to a fix location after game is over.	
		}
		
		}
		
         }
		
		
		
		renderer.repaint();
		
	}
	
	
	
	public void repaint(Graphics g) {
		
		g.setColor(Color.white);   // giving screen color
		g.fillRect(0, 0, WIDTH, HEIGHT);    //filling  screen via dimensions

		
		g.setColor(greycolor);
		g.fillRect(0, HEIGHT- 120, WIDTH, 150);        //for bottom end givng other color
		
		
		g.setColor(Color.pink);            // setting border line color to green above orange
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);        //for bottom end another  color 
		
		
		
		g.setColor(birdcolor);
		g.fillRect(bird.x, bird.y, bird.width, bird.height); // selecting bird through dimensions.
	
		
		for (Rectangle column: columns) {  //painting each column 
		paintColumn(g, column);	
		}
		
		g.setColor(Color.black);
		g.setFont(new Font( "Arial",1,75));
		
		if (!gamestarted) {
			g.drawString("Click To Start! ", 250, HEIGHT/2-50);     //start display statement 
			                                                       
		}
		g.setColor(Color.black);
		g.setFont(new Font( "Arial",1,60));
		
		if (gameOver) {                   //condition if game is over
			g.drawString(" GAME OVER!", 300,HEIGHT/2-50);
			
		}
		g.setColor(Color.black);
		g.setFont(new Font( "Arial",1,25));
		
		if (gameOver) {                   //condition if game is over
			g.drawString("  Click or Press SPACE to Restart", 310,HEIGHT/2+10);
			
		}
		g.setColor(Color.white);
		g.setFont(new Font( "Lucida Calligraphy",1,75));   // adding font
		
		
	}
	



	
	
	
	
	public static void  main(String[] args) {
		
		flappyBird = new FlappyBird(); // setting variable flappy bird to new flappy bird
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		jump();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()== KeyEvent.VK_SPACE) {        // if space key is pressed
			jump();       // do jump / tick
			
		}
		
	}


}

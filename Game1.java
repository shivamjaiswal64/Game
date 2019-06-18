import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Game1 implements ActionListener{
	int count1=6,count2=6;
	Frame f;
	TextField tf,tf1,tf2;
	Button P1,P2;
	int t1,t2,tt1,tt2;
	String s1,s2;
	Game1(String s){
		f=new Frame(s);
		tf=new TextField();
		tf.setBounds(150,50,50,50);
		f.add(tf);
		
    P1=new Button("Player 1");
		P1.setBounds(50,150,100,50);
		f.add(P1);
		
    P2=new Button("Player 2");
		P2.setBounds(200,150,100,50);
		f.add(P2);
		
    P1.addActionListener(this);
		P2.addActionListener(this);
		
    tf1=new TextField();
		tf1.setBounds(50,300,50,50);
		f.add(tf1);
		
    tf2=new TextField();
		tf2.setBounds(200,300,50,50);
		f.add(tf2);
		
    f.addWindowListener(new WindowEventListener());
		f.setLayout(null);
		f.setBackground(Color.PINK);
		f.setSize(450,450);
		f.setVisible(true);
	}
  
  
	public void actionPerformed(ActionEvent e){
			if(e.getSource()==P1&&(count1!=0)){
			  count1--;
			  t1=randomInt(1,6);
			  tf.setText(String.valueOf(t1)); tt1=tt1+t1;
			  System.out.println("Player 1 generates:"+t1+"	Chance left:"+count1);
			  tf1.setText(String.valueOf(tt1));
			}
		  else if(e.getSource()==P2&& (count2!=0)){
			        count2--;
			        t2=randomInt(1,6);
			        tf.setText(String.valueOf(t2)); tt2=tt2+t2;
			        System.out.println("Player 2 generates:"+t2+"	Chance left:"+count2);
			        tf2.setText(String.valueOf(tt2));
		  }
		else{
			  if(tt2>tt1&&count1==0&&count2==0){
			  System.out.println("Player 2 won");
			  }
			  if(tt2<tt1&&count1==0&&count2==0){
			  System.out.println("Player 1 won");
			  }
		}	
	}
  
	public static void main(String[] args) {
		new Game1("Random Dice");
  }
	public int randomInt(int low,int high){
		int result=(int)(Math.random() * (high -low+1))+low;// Random number will be generated between 1 and 6
		return result;
	}
}
class WindowEventListener extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.out.println("Window Closed");
		System.exit(0);		// To enable close button in Java AWT
	}
}

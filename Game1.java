import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Game1 implements ActionListener{
	int count1=6,count2=6;
	Frame f;
	TextField tf,tf1,tf2;
	Label l1,l2,l3,l4;
	Button P1,P2;
	int t1,t2,tt1,tt2;
	String s1,s2;
	
	Game1(String s){

		f=new Frame(s); 
	//	MyCanvas c=new MyCanvas();
	//	f.add(c);
	//	f.setSize(150,150);//f.setLayout(null);
	//	f.setVisible(true);
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
		l1=new Label("Sum of Player1");
		l1.setBounds(50,350,100,30);
		l2=new Label("Sum of Player2");
		l2.setBounds(200,350,100,30);
		l3 = new Label("Player 1");	l3.setBounds(10,400,190,30);
		l4 = new Label("Player 2");	l4.setBounds(200,400,200,30);
		f.add(l1);	f.add(l2);	f.add(l3);	f.add(l4);
		f.addWindowListener(new WindowEventListener());
		f.setLayout(null);
		f.setBackground(Color.PINK);
		f.setSize(450,450);
		f.setVisible(true);


	}
	public void actionPerformed(ActionEvent e){ 
		String st3 = "";
		String st4 = "";
	
		if(e.getSource()==P1&&(count1!=0)){
			count1--;
			t1=randomInt(1,6);
			tf.setText(String.valueOf(t1)); tt1=tt1+t1;
			st3="Player 1 generates:"+t1+"	Chance left:"+count1;
			//System.out.println("Player 1 generates:"+t1+"	Chance left:"+count1);
			System.out.println(st3);
			l3.setText(st3);
			tf1.setText(String.valueOf(tt1));
			
			
		}
		else if(e.getSource()==P2&& (count2!=0)){
			count2--;
			t2=randomInt(1,6);
			tf.setText(String.valueOf(t2)); tt2=tt2+t2;
			st4="Player 2 generates:"+t2+"	Chance left:"+count2;
			//System.out.println("Player 2 generates:"+t2+"	Chance left:"+count2);
			System.out.println(st4);
			l4.setText("Player 2 generates:"+t2+"	Chance left:"+count2);
			tf2.setText(String.valueOf(tt2));
			
		}
		else{
			if(tt2>tt1&&count1==0&&count2==0){
			System.out.println("Player 2 won");
			l4.setText("Player 2 won");
			l3.setText(null);
			}
			if(tt2<tt1&&count1==0&&count2==0){
			System.out.println("Player 1 won");
			l3.setText("Player 1 won");
			l4.setText(null);
			}
		}	
	}
	public static void main(String[] args) {
		new Game1("Random Dice");
	
	}
	public int randomInt(int low,int high){
		int result=(int)(Math.random() * (high -low+1))+low;
		return result;
	}
}
class WindowEventListener extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.out.println("Window Closed");
		System.exit(0);		
	}
}

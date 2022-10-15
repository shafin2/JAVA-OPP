import javax.swing.JFrame;
public class MyFrame 
{
	int length , width;
	public MyFrame (int length , int width)
	{
		this.length = length;
		this.width = width;
	JFrame frame = new JFrame ("DICE SIMULATION..");
	frame.setSize(770,500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	MyPanel panel = new MyPanel();
	frame.add(panel);
	frame.setVisible(true);
	
	
	}
	
}
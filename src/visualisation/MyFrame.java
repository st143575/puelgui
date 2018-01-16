package visualisation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class MyFrame extends JFrame {
	// variables for window construction
	private JButton jb1, jb2, jb3, jb4, jb5;
	private JPanel jp1, jp2, jp3;
	private JComboBox<String> jcb1;
	private JLabel jlb1, jlb2, jlb3, jlb4, jlb5, jlb6, jlb7, jlb8, jlb9, jlb10, jlb11;
	private JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9, jtf10;
	private JList jlist;
	private JTextArea jta;
	private JScrollPane jsp;
	private JLabel jlb_map;
	
	// variables for ActionListener of Buttons
	private int startX, startY, destX, destY;
	private int robotAngle, opponentRobotAngle;
	
	// main method
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
	
	public MyFrame() {		// Constructur
		init();
		this.setTitle("MyFrame");
		this.setSize(1290, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void init() {
		jb1 = new JButton("Connect/Diconnect");
		jb1.addActionListener(new ALButtons(this));	// ActionListener for jb1
		jb2 = new JButton("Start");
		jb2.addActionListener(new ALButtons(this));	// ActionListener for jb2
		jb3 = new JButton("Reset");
		jb3.addActionListener(new ALButtons(this));	// ActionListener for jb3
		
		
		jp1 = new JPanel();	// includes "Start Point","x: ","y: ","Angle: ","Destination","x: ","y: ".
		jlb1 = new JLabel("Start Point");
		jlb2 = new JLabel("x:");		
		jlb3 = new JLabel("y:");
		jlb4 = new JLabel("Angle:");
		jtf1 = new JTextField(4);	// "x: " of own robot
		jtf2 = new JTextField(4);	// "y: " of own robot
		jtf3 = new JTextField(4);	// "Angle: " angle of own robot
		jlb5 = new JLabel("Destination");
		jlb6 = new JLabel("x:");		
		jlb7 = new JLabel("y:");
		jtf4 = new JTextField(4);	// "x: " of destination
		jtf5 = new JTextField(4);	// "y: " of destination
		jlb8 = new JLabel("OpponentRobot");
		jlb9 = new JLabel("x: ");
		jtf6 = new JTextField(4);	// "x: " of opponent robot
		jlb10 = new JLabel("y: ");	
		jtf7 = new JTextField(4);	// "y: " of opponent robot
		jlb11 = new JLabel("Angle: ");
		jtf8 = new JTextField(4);	// "Angle: " angle of opponent robot
		
		
		jp2 = new JPanel();	// includes "Type of competition", "Robotnumber" and "Information"
		jp2.setBorder(BorderFactory.createTitledBorder("Options"));
		jp2.setBackground(getBackground());
		jp2.setLayout(new BorderLayout());
		String[] str = { "Zeitrennen", "Wegerennen", "Konterrennen" };
		jcb1 = new JComboBox<String>(str);	// 下拉菜单(ComboBox)
		jcb1.addActionListener(new AL());	// ActionListener for jcb1
		jcb1.setBorder(BorderFactory.createTitledBorder("Type of Compitition"));
		
		
		String[] robotnumber = {"Robot1","Robot2","Robot3"};
		jlist = new JList(robotnumber); 
		jlist.addListSelectionListener(selectRobotNumber);	// ListSelectionListener for jlist(with Robot1, Robot2, Robot3")
		jlist.setBorder(BorderFactory.createTitledBorder("Robotnumber"));
		jlist.setBackground(Color.WHITE);
		
		jta = new JTextArea();
		jta.setBorder(BorderFactory.createTitledBorder("Information"));
		jta.setBackground(Color.WHITE);
		
		jsp = new JScrollPane(jta);	// jta("Information")中的滚动条
		
		jp3 = new JPanel();		// includes jlb_map, jb4, jb5
		jp3.setBackground(getBackground());
		jp3.setLayout(new BorderLayout());
		
		jlb_map = new JLabel();		// JLabel jlp_map
		jlb_map.setBorder(BorderFactory.createTitledBorder("Preview"));
		jlb_map.setBackground(Color.WHITE);
		
		
		
		jb4 = new JButton("Import Map");
		jb4.addActionListener(new ALButtons(this));	// ActionListener for jb4
		jtf9 = new JTextField(6);
		jb5 = new JButton("Save Map");
		jb5.addActionListener(new ALButtons(this));	// ActionListener for jb5
		jtf10 = new JTextField(6);
		
		GridBagLayout gbl = new GridBagLayout();  // GridBagLayout gbl
		this.setLayout(gbl);
		// jb1
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		// jp1
		this.add(jp1);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jtf1);
		jp1.add(jlb3);
		jp1.add(jtf2);
		jp1.add(jlb4);
		jp1.add(jtf3);
		jp1.add(jlb5);
		jp1.add(jlb6);
		jp1.add(jtf4);
		jp1.add(jlb7);
		jp1.add(jtf5);
		jp1.add(jlb8);
		jp1.add(jlb9);
		jp1.add(jtf6);
		jp1.add(jlb10);
		jp1.add(jtf7);
		jp1.add(jlb11);
		jp1.add(jtf8);
		// jp2
		this.add(jp2);
		jp2.add(jcb1,BorderLayout.NORTH);
		jp2.add(jlist,BorderLayout.CENTER);
		jsp.setPreferredSize(new Dimension(0,200));
		jp2.add(jsp,BorderLayout.SOUTH);
		// jp3
		this.add(jp3);
		GridBagLayout gbl_jp3 = new GridBagLayout();  // GridBagLayout gbl_jp3
		jp3.setLayout(gbl_jp3);
		jp3.add(jlb_map);
		jlb_map.setPreferredSize(new Dimension(0,450));
		jp3.add(jtf9);
		jp3.add(jb4);
		
		jp3.add(jtf10);
		jp3.add(jb5);
		
		/**
		jp3.add(jlb_map,BorderLayout.NORTH);
		jlb_map.setPreferredSize(new Dimension(0,450));
		jp3.add(jb4,BorderLayout.CENTER);
		jb4.setPreferredSize(new Dimension(0,45));
		jp3.add(jtf9);
		jp3.add(jb5,BorderLayout.SOUTH);
		jb5.setPreferredSize(new Dimension(0,45));
		jp3.add(jtf10);
		**/
		GridBagConstraints gbc_jp3 = new GridBagConstraints();  // GridBagConstraints gbc_jp3
		gbc_jp3.fill = GridBagConstraints.BOTH;
		gbc_jp3.gridwidth = 0;
		gbc_jp3.weightx = 1;
		gbc_jp3.weighty = 1;
		gbl_jp3.setConstraints(jlb_map,gbc_jp3);
		gbc_jp3.gridwidth = 1;
		gbc_jp3.weightx = 1;
		gbc_jp3.weighty = 0;
		gbl_jp3.setConstraints(jtf9,gbc_jp3);
		gbc_jp3.gridwidth = 0;
		gbc_jp3.weightx = 0;
		gbc_jp3.weighty = 0;
		gbl_jp3.setConstraints(jb4,gbc_jp3);
		gbc_jp3.gridwidth = 1;
		gbc_jp3.weightx = 1;
		gbc_jp3.weighty = 0;
		gbl_jp3.setConstraints(jtf10,gbc_jp3);
		gbc_jp3.gridwidth = 0;
		gbc_jp3.weightx = 0;
		gbc_jp3.weighty = 0;
		gbl_jp3.setConstraints(jb5,gbc_jp3);
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();	// GridBagConstraints(Attributesmanager) gbc
		gbc.fill = GridBagConstraints.BOTH;		// 设置如果组件所在的区域比组件本身要大,使组件完全填满其显示区域
		
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbl.setConstraints(jb1, gbc);//设置组件:按钮connect/disconnect
		
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbl.setConstraints(jb2, gbc);//设置组件:按钮Start
		
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbl.setConstraints(jb3, gbc);//设置组件:按钮Reset
		
		gbc.gridwidth = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbl.setConstraints(jp1, gbc);//设置组件:JPanel1,包含坐标和角度
		
		gbc.gridwidth = 4;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbl.setConstraints(jp2, gbc);//设置组件:JPanel2，包含下拉菜单，机器人列表，Meldung显示区域
				
		gbc.gridwidth = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbl.setConstraints(jp3, gbc);//设置组件:JTextArea,用于绘制实时地图
		
		
	}

	
	public int getStartX()
	{
		return startX;
	}
	
	public int getStartY()
	{
		return startY;
	}
	
	public int getRobotAngle()
	{
		return robotAngle;
	}
	
	public int getDestX()
	{
		return destX;
	}
	
	public int getDestY()
	{
		return destY;
	}
	
	public int getOpponentRobotAngle()
	{
		return opponentRobotAngle;
	}
	
	public void setStartX(int startX)
	{
		this.startX = startX;
	}
	
	public void setStartY(int startY)
	{
		this.startY = startY;
	}
	
	public void setRobotAngle(int robotAngle)
	{
		this.robotAngle = robotAngle;
	}
	
	public void setDestX(int destX)
	{
		this.destX = destX;
	}
	
	public void setDestY(int destY)
	{
		this.destY = destY;
	}
	
	public void setOpponentRobotAngle(int opponentRobotAngle)
	{
		this.opponentRobotAngle = opponentRobotAngle;
	}
	
	
	private class SelecTry implements ListSelectionListener {		// for JTextField
		public void valueChanged(ListSelectionEvent e){
			
		}
	}
	private SelecTry selectRobotNumber = new SelecTry();
	
	
	private class ALButtons implements ActionListener {
		private MyFrame mf;
		public ALButtons(MyFrame mf)
		{
			this.mf = mf;
		}

		@Override
		public void actionPerformed(ActionEvent buttonevent) {
			boolean readyToConnect = false;
			if(buttonevent.getSource() == jb1)	// If jb1(Connect/Disconnect) is pressed
			{
//				if()
				readyToConnect = true;
				startX = mf.getStartX();	// set startX to 0 and read new values out of xStartPoint
				startY = mf.getStartY();
				robotAngle = mf.getRobotAngle();
				
			}
			
			else if(buttonevent.getSource() == jb2)	// If jb2(Start) is pressed
			{
				boolean readyToStart = true;
				destX = mf.getDestX();
				destY = mf.getDestY();
				
			}
			
			else if(buttonevent.getSource() == jb3)	// If jb3(Reset) is pressed
			{
				
			}
			
			else if(buttonevent.getSource() == jb4)	// If jb4(Import Map) is pressed
			{
				
			}
			
			else if(buttonevent.getSource() == jb5)	// If jb5(Save Map) is pressed
			{
				
			}
			
		}
		
	}
	
	
	
	private class AL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

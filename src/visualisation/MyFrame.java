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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	// variables for window construction
	private JButton jb1, jb2, jb3, jb4, jb5;
	private JPanel jp1, jp2, jp3;
	private JComboBox<String> jcb1;
	private JLabel jlb1, jlb2, jlb3, jlb4, jlb5, jlb6, jlb7, jlb8, jlb9, jlb10, jlb11;
	private JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9, jtf10;
	private JList jlist;
	private JTextArea jta;
	private JLabel jlb_map;
	
	// variables for ActionListener of Buttons
	private int startX, startY, destX, destY;
	
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
	
	public MyFrame() {
		// TODO Auto-generated constructor stub
		init();
		this.setTitle("MyFrame");
		this.setSize(1290, 600);
//		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new MyWindowListener());
		this.setVisible(true);
	}
	
	public void init() {
		jb1 = new JButton("Connect/Diconnect");
		jb2 = new JButton("Start");
		jb3 = new JButton("Reset");
		
		jp1 = new JPanel();	// includes "Start Point","x: ","y: ","Angle: ","Destination","x: ","y: ".
		jlb1 = new JLabel("Start Point");
		jlb2 = new JLabel("x:");		
		jlb3 = new JLabel("y:");
		jlb4 = new JLabel("Angle:");
		jtf1 = new JTextField(4);
		jtf2 = new JTextField(4);
		jtf3 = new JTextField(4);
		jlb5 = new JLabel("Destination");
		jlb6 = new JLabel("x:");		
		jlb7 = new JLabel("y:");
		jtf4 = new JTextField(4);
		jtf5 = new JTextField(4);
		jlb8 = new JLabel("OpponentRobot");
		jlb9 = new JLabel("x: ");
		jtf6 = new JTextField(4);
		jlb10 = new JLabel("y: ");
		jtf7 = new JTextField(4);
		jlb11 = new JLabel("Angle: ");
		jtf8 = new JTextField(4);
		
		
		jp2 = new JPanel();	// includes "Options", "Robotnumber" and "Information"
		jp2.setBorder(BorderFactory.createTitledBorder("Options"));
		jp2.setBackground(getBackground());
		jp2.setLayout(new BorderLayout());
		String[] str = { "Zeitrennen", "Wegerennen", "Konterrennen" };
		jcb1 = new JComboBox<>(str);	// 下拉菜单
		jcb1.setBorder(BorderFactory.createTitledBorder("Type of Compitition"));
		
		
		String[] robotnumber = {"Robot1","Robot2","Robot3"};
		jlist = new JList(robotnumber); 
		jlist.setBorder(BorderFactory.createTitledBorder("Robotnumber"));
		jlist.setBackground(Color.WHITE);
		
		jta = new JTextArea();
		jta.setBorder(BorderFactory.createTitledBorder("Information"));
		jta.setBackground(Color.WHITE);
		
		jp3 = new JPanel();		// 包含jlb_map, jb4, jb5
		jp3.setBackground(getBackground());
		jp3.setLayout(new BorderLayout());
		
		jlb_map = new JLabel();		//绘图mapping
		jlb_map.setBorder(BorderFactory.createTitledBorder("Map Settings"));
		jlb_map.setBackground(Color.WHITE);
		
		
		
		jb4 = new JButton("Import Map");
		jtf9 = new JTextField(6);
		jb5 = new JButton("Save Map");
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
		jta.setPreferredSize(new Dimension(0,200));
		jp2.add(jta,BorderLayout.SOUTH);
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

	private class MyWindowListener extends WindowAdapter {	// 窗口监听器，监听窗口事件

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
			System.out.println("Window is closing.");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ALButtons implements ActionListener {
		private MyFrame mf;
		public ALButtons(MyFrame mf)
		{
			this.mf = mf;
		}

		@Override
		public void actionPerformed(ActionEvent buttonevent) {
			// TODO Auto-generated method stub
			if(buttonevent.getSource() == jb1)	// If jb1(Connect/Disconnect) is pressed
			{
				boolean readToConnect = true;
				startX = 0;	// set startX to 0 and read new values out of xStartPoint
				startY = 0;
				
				{	// check if x, y and angle Textfields are filled correctly
					try {
						startX = Integer.parseInt(jtf1.getText());
					} catch (NumberFormatException nfe) {
						readToConnect = false;
					}
					try {
						startY = Integer.parseInt(jtf2.getText());
					} catch (NumberFormatException nfe) {
						readToConnect = false;
					}
				}
				
				if(readToConnect)	// If all Textfields are filled correctly
				{
					
				}
			}
		}
		
	}
}

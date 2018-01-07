package visualisation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

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
	private JButton jb1, jb2, jb3, jb4, jb5;
	private JPanel jp1, jp2, jp3;
	private JComboBox<String> jcb1;
	private JLabel jlb1, jlb2, jlb3, jlb4, jlb5, jlb6, jlb7;
	private JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
	private JList jlist;
	private JTextArea jta;
	private JLabel jlb_map;
	
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
	
	public MyFrame() {
		// TODO Auto-generated constructor stub
		init();
		this.setTitle("MyFrame");
		this.setSize(900, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void init() {
		jb1 = new JButton("Connect/Diconnect");
		jb2 = new JButton("Start");
		jb3 = new JButton("Reset");
		jp1 = new JPanel();
		
		jlb1 = new JLabel("Location");
		jlb2 = new JLabel("x:");		jlb3 = new JLabel("y:");		jlb4 = new JLabel("Angle:");
		jtf1 = new JTextField(4);
		jtf2 = new JTextField(4);
		jtf3 = new JTextField(4);
		jlb5 = new JLabel("Destination");
		jlb6 = new JLabel("x:");		jlb7 = new JLabel("y:");
		jtf4 = new JTextField(4);
		jtf5 = new JTextField(4);
		jp2 = new JPanel();
		jp2.setBorder(BorderFactory.createTitledBorder("Options"));
		jp2.setBackground(getBackground());
		jp2.setLayout(new BorderLayout());
		String[] str = { "Zeitrennen", "Wegerennen", "Konterrennen" };
		jcb1 = new JComboBox<>(str);	// 下拉菜单
		jcb1.setBorder(BorderFactory.createTitledBorder("Type of Compitition"));
		
		
		String[] robotnumber = {"Robot1","Robot2"};
		jlist = new JList(robotnumber); 
		jlist.setBorder(BorderFactory.createTitledBorder("Robotnumber"));
		jlist.setBackground(Color.WHITE);
		
		jta = new JTextArea();
		jta.setBorder(BorderFactory.createTitledBorder("Meldungen"));
		jta.setBackground(Color.WHITE);
		
		jp3 = new JPanel();		// 包含jlb_map, jb4, jb5
		jp3.setBackground(getBackground());
		jp3.setLayout(new BorderLayout());
		
		jlb_map = new JLabel();		//绘图mapping
		jlb_map.setBorder(BorderFactory.createTitledBorder("Mapping"));
		jlb_map.setBackground(Color.WHITE);
		
		jb4 = new JButton("Generate Map");
		jb5 = new JButton("Save Map");
		
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
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
		this.add(jp2);
		jp2.add(jcb1,BorderLayout.NORTH);
		jp2.add(jlist,BorderLayout.CENTER);
		jta.setPreferredSize(new Dimension(0,200));
		jp2.add(jta,BorderLayout.SOUTH);
		this.add(jp3);
		jp3.add(jlb_map,BorderLayout.NORTH);
		jlb_map.setPreferredSize(new Dimension(0,450));
		jp3.add(jb4,BorderLayout.CENTER);
		jb4.setPreferredSize(new Dimension(0,45));
		jp3.add(jb5,BorderLayout.SOUTH);
		jb5.setPreferredSize(new Dimension(0,45));
		
		
		GridBagConstraints gbc = new GridBagConstraints();	// Attributesmanager
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

}

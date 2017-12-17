package gui;


	import java.awt.*;
	import javax.swing.*;

	public class RobotWindow extends JFrame {
		 private JButton j1;
		 private JButton j2;
		 private  JButton j3;
		 private JPanel j4;
		 private JComboBox j5;
		 private JTextField j6;
		 private JButton j7;
		 private JList j8;
		 private JTextArea j9;
		
	    public static void main(String args[]) {
	        RobotWindow rw = new RobotWindow();
	    }

	    public RobotWindow() {
	        init();
	        this.setTitle("Robot Window");
	        this.setLocation(200, 200);
	        this.setSize(650,500);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setResizable(false);
	        this.setVisible(true);
	    }
	    public void init() {
	        j1 = new JButton("connect");
	        j2 = new JButton("Run");
	        j3 = new JButton("Stop");
	        j4 = new JPanel();
	        String[] str = { "Robot1", "Robot2"};
	        j5 = new JComboBox(str);
	        j6 = new JTextField();
	        j7 = new JButton("Reset");
	        j8 = new JList(str);
	        j8.setBorder(BorderFactory.createTitledBorder("Status"));
	        j8.setBackground(getBackground());;
	        j9 = new JTextArea();
	        j9.setBackground(Color.WHITE);  // Set background color of the TextArea white
	        GridBagLayout layout = new GridBagLayout();
	        this.setLayout(layout);
	        /* Add components into JFrame */
	        this.add(j1);
	        this.add(j2);
	        this.add(j3);
	        this.add(j4);
	        this.add(j5);
	        this.add(j6);
	        this.add(j7);
	        this.add(j8);
	        this.add(j9);
	        GridBagConstraints s= new GridBagConstraints();//Define a GridBagConstraints
	        s.fill = GridBagConstraints.BOTH;
	        s.gridwidth=1;  // Set the number of grids, which the component occupies
	        s.weightx = 0;  // Set horizontal stretching range of the component
	        s.weighty=0;    // Set vertical stretching range of the component
	        layout.setConstraints(j1, s);  // Set the component
	        s.gridwidth=1;
	        s.weightx = 0;
	        s.weighty=0;
	        layout.setConstraints(j2, s);
	        s.gridwidth=1;
	        s.weightx = 0;
	        s.weighty=0;
	        layout.setConstraints(j3, s);
	        s.gridwidth=0;  // Set this component as the latest component of this row
	        s.weightx = 0;
	        s.weighty=0;
	        layout.setConstraints(j4, s)
	        ;s.gridwidth=2;
	        s.weightx = 0;
	        s.weighty=0;
	        layout.setConstraints(j5, s);
	        ;s.gridwidth=4;
	        s.weightx = 1;
	        s.weighty=0;
	        layout.setConstraints(j6, s);
	        ;s.gridwidth=0;
	        s.weightx = 0;
	        s.weighty=0;
	        layout.setConstraints(j7, s);
	        ;s.gridwidth=2;
	        s.weightx = 0;
	        s.weighty=1;
	        layout.setConstraints(j8, s);
	        ;s.gridwidth=5;
	        s.weightx = 0;
	        s.weighty=1;
	        layout.setConstraints(j9, s);
	    }
	   
	}



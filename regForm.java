import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class regForm extends JFrame implements ActionListener, ItemListener
 {

    private JLabel l1, l2, l3, l4, l5;
    private JTextField t1, t2;
    private JPanel p[];
    private Container c = null;
    private JRadioButton r1, r2, r3;
    private JComboBox cb1, cb2,cb3;
    private JCheckBox ck1,ck2,ck3,ck4;
    private JButton b1,b2,b3;
    private String s1,s2,s3,s4,s5;
    private ButtonGroup bg;
  
    public regForm()
    	 {

        super("REGISTRATION FORM");
        s1 = "";
        s2 = "";
        s3 = "";
        s4 = "";

        l1 = new JLabel("NAME");
        l2 = new JLabel("EMAIL");
        l3 = new JLabel("SEX");
        l4 = new JLabel("SKILLS");
        l5 = new JLabel("DOB");

        t1 = new JTextField(20);
        t2 = new JTextField(20);

        b1 = new JButton("SUBMIT");
        b2 = new JButton("RESET");
        b3 = new JButton("CLOSE");

        r1 = new JRadioButton("MALE");
        r2 = new JRadioButton("FEMALE");
        r3 = new JRadioButton("OTHER");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        ck1 = new JCheckBox("c");
        ck2 = new JCheckBox("c++");
        ck3 = new JCheckBox("python");
        ck4 = new JCheckBox("java");
	
        cb1 = new JComboBox();
        for(int i=1;i<=31;i++){
        	cb1.addItem(i);
        }
        	
		
       String[] str = {" ","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec" };
        cb2 = new JComboBox(str);
        cb3 = new JComboBox();
        for(int j=1924;j<=2024;j++){
			cb3.addItem(j);
        	
        }
        	        p = new JPanel[6];
        for (int i = 0; i < p.length; i++)
        {
            p[i] = new JPanel();
        }

        p[0].setLayout(new GridLayout(1, 2, 20, 20));
        p[0].add(l1);
        p[0].add(t1);

        p[1].setLayout(new GridLayout(1, 2, 20, 20));
        p[1].add(l2);
        p[1].add(t2);

        p[2].setLayout(new GridLayout(1, 4, 20, 20));
        p[2].add(l3);
        p[2].add(r1);
        p[2].add(r2);
        p[2].add(r3);

        p[3].setLayout(new GridLayout(1, 5, 20, 20));
        p[3].add(l4);
        p[3].add(ck1);
        p[3].add(ck2);
        p[3].add(ck3);
        p[3].add(ck4);

        p[4].setLayout(new GridLayout(1, 4, 20, 20));
        p[4].add(l5);
        p[4].add(cb1);
        p[4].add(cb2);
        p[4].add(cb3);

        p[5].setLayout(new GridLayout(1, 3, 20, 20));
        p[5].add(b1);
        p[5].add(b2);
        p[5].add(b3);

        c = getContentPane();
        c.setLayout(new GridLayout(6, 5, 10, 10));
        for (int i = 0; i < p.length; i++) 
        {
            c.add(p[i]);
        }
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        r1.addItemListener(this);
        r2.addItemListener(this);
        r3.addItemListener(this);

        ck1.addItemListener(this);
        ck2.addItemListener(this);
        ck3.addItemListener(this);
        ck4.addItemListener(this);

        setResizable(false);
        setSize(570, 350);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
    	
    	if(e.getItem()==r1 || e.getItem()==r2 || e.getItem()==r3)
    	{
    		s5=((JRadioButton)e.getItem()).getText();
    	}
		else
		{
		
        if (e.getSource() == ck1) {
            if (e.getStateChange() == 1) {
                s1 = "c";
            } else {
                s1 = "";
            }
        }
        if (e.getSource() == ck2) {
            if (e.getStateChange() == 1) {
                s2 = "c++";
            } else {
                s2 = "";
            }
        }
        if (e.getSource() == ck3) {
            if (e.getStateChange() == 1) {
                s3 = "python";
            } else {
                s3 = "";
            }
        }
        if (e.getSource() == ck4) {
            if (e.getStateChange() == 1) {
                s4 = "java";
            } else {
                s4 = "";
            }
        }
	  }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            
            String nm = t1.getText();
            String em = t2.getText();
            JOptionPane.showMessageDialog(null,"Name: "+nm+"\n"+"Email_id: "+em+"\n"+"Sex: "+s5+"\n"
            	+"Skill: "+s1+" "+s2+" "+s3+" "+s4+"\n"
            	+"DOB: "+cb1.getSelectedItem()+"/"+cb2.getSelectedItem()+"/"+cb3.getSelectedItem());
            
        }
        if (e.getSource() == b2) {

            t1.setText("");
            t2.setText("");
            cb1.setSelectedItem("");
            cb2.setSelectedItem("");
            cb3.setSelectedItem("");
            r1.setSelected(true);
            ck1.setSelected(false);
            ck2.setSelected(false);
            ck3.setSelected(false);
            
        }
        if(e.getSource() == b3) {
        	
        	setVisible(false);
        }
    }
    public static void main(String[] args)
    {
    	new regForm();
    }
}
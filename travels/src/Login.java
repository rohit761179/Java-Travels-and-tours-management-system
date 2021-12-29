import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class InvalidException extends Exception
{
}

class Login extends JFrame implements ActionListener
{
	JFrame jf;
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2;
	JPasswordField p1;
        ResultSet rs,rs1;
        PreparedStatement ps,ps1;
        Connection con;
	Font f;
	int cnt=0,cnt1=0;

	Login()
	{
            
           
            //setVisible(true);
            
            
            
            
            
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
		jf.setLayout(new BorderLayout());
                jf.setTitle("Login");
		jf.setLocation(20,20);
		jf.setSize(800,600);
		jf.setResizable(true);
                jf.setLayout(new FlowLayout());
                jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\log.jpg")));
             
           

        l5 = new JLabel("ADMINISTRATOR");l5.setFont(new Font("Times New Roman",Font.BOLD,30));
        l5.setBounds(300,100,300,40);
		jf.add(l5);
                     
		l3 = new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\users.png"));
		l3.setBounds(150,250,50,25);
		jf.add(l3);

		l1 = new JLabel("User Name : "); l1.setFont(f);
		l1.setBounds(200,250,200,25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(350,250,200,25);
		t1.setToolTipText("Enter Username");
		jf.add(t1);

        l4 = new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\pass.png"));
		l4.setBounds(150,300,50,25);
		jf.add(l4);

		l2 = new JLabel("Password  : "); l2.setFont(f);
		l2.setBounds(200,300,200,25);
		jf.add(l2);

		p1 = new JPasswordField(20);
		p1.setBounds(350,300,200,25);
		p1.setToolTipText("Enter Password");
		jf.add(p1);

		b1 = new JButton("Login",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\Login.png"));
		b1.setBounds(200,400,100,35);
		jf.add(b1);b1.addActionListener(this);

		b2 = new JButton("Clear",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\clear.png"));
		b2.setBounds(320,400,100,35);
		jf.add(b2);b2.addActionListener(this);

		b3 = new JButton("Exit",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\exit.png"));
		b3.setBounds(440,400,100,35);
		jf.add(b3);b3.addActionListener(this);
                
              
                
		
                //background
                
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
                            
                            String uname=t1.getText();
				String pass=new String(p1.getPassword());
                             Class.forName("com.mysql.jdbc.Driver");
                          
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
      System.out.println("Connected to database.");

		  ps1=con.prepareStatement("select * from login where uname=? and pass=?");
                    ps1.setString(1,uname);
                    ps1.setString(2,pass);
		  rs1=ps1.executeQuery();

                            
				if(rs1.next())
				{
                                  
			JOptionPane.showMessageDialog(null," Welcome "+uname+"..","WELCOME",JOptionPane.INFORMATION_MESSAGE);
			   	    jf.setVisible(false);
                                    new MainMenu();
				}
				else
				{
					throw new InvalidException();
				}
                                
                              
			}
			catch(Exception e1)
			{
			    cnt++;
			    JOptionPane.showMessageDialog(null," Sorry !!! You are not valid user ...!!!","WARNING",JOptionPane.ERROR_MESSAGE);
			    t1.setText("");
			    p1.setText("");
			    if(cnt==3)
			    {
			         JOptionPane.showMessageDialog(null,"Sorry !!! Your 3 attempts are over ...!!!","WARNING",JOptionPane.ERROR_MESSAGE);
			         System.exit(0);
			    }
            }

		}

		else if(ae.getSource()==b2)
		{
			t1.setText("");
			p1.setText("");

		}

		else if(ae.getSource()==b3)
		{
		    System.exit(0);
		}
	}

	public static void main(String args[])
	{
		new Login();

	}

}
 
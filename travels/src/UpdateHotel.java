import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateHotel extends JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel l1,l2,l3,l4,l5,l6,ln;
    JButton b0,b1,b2,b3;
    JComboBox tabtype;
    String s,sid1,tabt;
	Font f;
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	UpdateHotel()
	{
		jf=new JFrame();
		f = new Font("Times New Roman",Font.BOLD,20);
		jf.setLayout(null);

	    ln=new JLabel("Update Hotel");
	    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
	    ln.setForeground(Color.white);
	    ln.setBounds(300,30,300,40);
             jf.setResizable(true);
                jf.setLayout(new FlowLayout());
                jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\updh.jpg")));
	   
	    jf.add(ln);

		l1 = new JLabel("Hotel name*");
		 l1.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l1.setForeground(Color.white);
    l1.setBounds(50,100,200,25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(250,100,100,25);t1.setToolTipText("Enter hotel name");
		jf.add(t1);

		l2 = new JLabel("Ratings*");
		 l2.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l2.setForeground(Color.white);
    l2.setBounds(50,140,200,25);
		jf.add(l2);

    	t2 = new JTextField(20);
		t2.setBounds(250,140,200,25);t2.setToolTipText("Enter ratings");
		jf.add(t2);

		l3 = new JLabel("Location");
		 l3.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l3.setForeground(Color.white);
  
		
  l3.setBounds(50,180,200,25);
		jf.add(l3);

     	t3 = new JTextField(20);
		t3.setBounds(250,180,200,25);t3.setToolTipText("Enter Location");
		jf.add(t3);
                
               l4 = new JLabel("Type");
		 l4.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l4.setForeground(Color.white);
  l4.setBounds(50,220,200,25);
		jf.add(l4);

     	t4 = new JTextField(20);
		t4.setBounds(250,220,200,25);t4.setToolTipText("Enter Type");
		jf.add(t4);


		l5 = new JLabel("Per Day Charges");
		 l5.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l5.setForeground(Color.white);
   l5.setBounds(50,260,250,25);
    	jf.add(l5);

        t5= new JTextField(20);
		t5.setBounds(250,260,100,25);t5.setToolTipText("Enter charges per day");
		jf.add(t5);
                
                l6 = new JLabel("Availability of rooms");
		
   l6.setBounds(50,300,200,25);
    l6.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l6.setForeground(Color.white); 	
   jf.add(l6);

        t6= new JTextField(20);
		t6.setBounds(250,300,100,25);t6.setToolTipText("Enter no. of rooms available");
		jf.add(t6);

	   
        b0 = new JButton("Open",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\open.png"));
        b0.setBounds(150,330,110,35);b0.setToolTipText("click to open hotel details");
		jf.add(b0);b0.addActionListener(this);

		b1 = new JButton("Update",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\update.png"));
		b1.setBounds(300,330,110,35);b1.setToolTipText("click to delete hotel details");
	    jf.add(b1); b1.addActionListener(this);

        b2= new JButton("Clear",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\clear.png"));
		b2.setBounds(450,330,110,35);b2.setToolTipText("click to clear all textfields");
		jf.add(b2); b2.addActionListener(this);

    	b3 = new JButton("All",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\all.png"));
		b3.setBounds(600,330,110,35);b3.setToolTipText("click to view all hotel details");
		jf.add(b3); b3.addActionListener(this);

	    scrlPane.setBounds(0,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

      model.addColumn("H_Name");
        model.addColumn("H_Ratings");
        model.addColumn("H_Location");
        model.addColumn("H_Type");
        model.addColumn("H_Charges");
        model.addColumn("H_Rooms");
       

	     jf.setTitle("Update Hotel");
	     jf.setSize(900,700);
		 jf.setLocation(20,20);
		 jf.setResizable(false);
		 jf.getContentPane().setBackground(Color.cyan);
	     jf.setVisible(true);
 }

 public void actionPerformed(ActionEvent ae)
  {
      
      
   
  	if(ae.getSource()==b0)
	  {
              
                
              
	  	 	 if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"Please enter hotel name or rating!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else
	        {

	      try
	       {//fetch
	      int foundrec = 0;
	    Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
		System.out.println("Connected to database.");
			ps=con.prepareStatement("Select hrating from hotel where hname='"+s+"'");
    		  rs=ps.executeQuery();
    		  while(rs.next())
    		  {
    		  	
	    	  
    	      }

		  ps=con.prepareStatement("select * from hotel where hname='"+t1.getText()+"' or hrating='"+t2.getText()+"' ");
		  rs=ps.executeQuery();
		  while(rs.next())
	      {
		    t1.setText(rs.getString(1));
	        t2.setText(rs.getString(2));
	        t3.setText(rs.getString(3));
	        t4.setText(rs.getString(4));
		    t5.setText(rs.getString(5));
                    t6.setText(rs.getString(6));
		    
		     foundrec = 1;
	       }
	       if (foundrec == 0)
                {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialogs",JOptionPane.WARNING_MESSAGE);
                }

	         con.close();
         }
         catch(SQLException se)
          {
             System.out.println(se);
           JOptionPane.showMessageDialog(null,"SQL Error:"+se);
          }
   	    catch(Exception e)
	     {
            System.out.println(e);
		 JOptionPane.showMessageDialog(null,"Error:"+e);
	     }
       }
  }
  else if(ae.getSource()==b1)
	   {
	   try
	    {
                /*String Pri=t2.getText();
	       	Pattern p4=Pattern.compile("[0-9]");
	       	Matcher m4=p4.matcher(Pri);
	        boolean matchFoundd=m4.matches();
              
                String Prices=t5.getText();
	       	Pattern p=Pattern.compile("[0-9]");
	       	Matcher m=p.matcher(Prices);
	        boolean matchFounda=m.matches();
                 String Price=t6.getText();
	       	Pattern p1=Pattern.compile("[0-9]");
	       	Matcher m2=p1.matcher(Price);
	        boolean matchFound=m2.matches();
                if(((t2.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else if(!matchFound)
	        {
	       	  JOptionPane.showMessageDialog(this,"No. of Rooms should be in Integer!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	}
                      else if(!matchFounda)
	        {
	       	  JOptionPane.showMessageDialog(this,"Price should be in Integer!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	}
                  else if(!matchFoundd)
	        {
	       	  JOptionPane.showMessageDialog(this,"Ratings should be in Integer!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	}
                */
                
	    	if(((t1.getText()).equals(""))||((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else
	        {
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
			System.out.println("Connected to database.");
			stmt=con.createStatement();
        String str1="UPDATE hotel SET hname='"+t1.getText()+"',hrating='"+t2.getText()+"',hloc='"+t3.getText()
        +"',htype='"+t4.getText()+"',"+ "hcharge='"+t5.getText()+"',hroom='"+t6.getText()
        +"' where hname='"+t1.getText()+"'or hrating='"+t2.getText()+"'";
    	stmt.executeUpdate(str1);
    	JOptionPane.showMessageDialog(null, "Record is updated");
    	t1.setText("");
	    t2.setText("");
		t3.setText("");
	    t4.setText("");
    	t5.setText("");
        t6.setText("");
    	
    	con.close();
       }
   }
   catch(SQLException se)
   {
     System.out.println(se);
     JOptionPane.showMessageDialog(null,"SQL Error:"+se);
   }
   catch(Exception e)
   {
    System.out.println(e);
     JOptionPane.showMessageDialog(null,"Error:"+e);
   }
 }
  else if(ae.getSource()==b2)
      {    t1.setText("");
           t2.setText("");
           t3.setText("");
           t4.setText("");
           t5.setText("");
           t6.setText("");
          
      }
 else if(ae.getSource()==b3)
    {//list
  	int r = 0;
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * from hotel" );
          while(rs.next())
            {
model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
             con.close();
       }
      catch(SQLException se)
       {
        System.out.println(se);
         JOptionPane.showMessageDialog(null,"SQL Error:"+se);
       }
      catch(Exception e)
       {
       	   System.out.println(e);
          JOptionPane.showMessageDialog(null,"Error:"+e);
       }
	}
 }
 public static void main(String args[])
 {
  new UpdateHotel();
 }
}



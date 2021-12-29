import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class RemoveStaff extends JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,ln;
    JButton b0,b1,b2,b3;
    JComboBox tabtype,tabtype1;
    String s,sid1,tabt;
	Font f;
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	RemoveStaff()
	{
		jf=new JFrame();
		f = new Font("Times New Roman",Font.BOLD,20);
		jf.setLayout(null);

	    ln=new JLabel("Remove Staff");
	    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
	    ln.setForeground(Color.blue);
	    ln.setBounds(300,30,300,40);
            ln.setBounds(300,30,300,40);
              jf.setResizable(true);
                jf.setLayout(new FlowLayout());
                jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\remove.jpg")));
	   
	    jf.add(ln);

		l1 = new JLabel("ID");
		l1.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l1.setForeground(Color.white);
    l1.setBounds(50,100,200,25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(250,100,100,25);t1.setToolTipText("Enter staff id");
		jf.add(t1);

		l2 = new JLabel("Name");
		l2.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l2.setForeground(Color.white);
    l2.setBounds(50,140,200,25);
		jf.add(l2);
    	t2 = new JTextField(20);
		t2.setBounds(250,140,200,25);t2.setToolTipText("Enter Name");
		jf.add(t2);

		l3 = new JLabel("Gender");
		l3.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l3.setForeground(Color.white);
   l3.setBounds(50,180,200,25);
    	jf.add(l3);
         t3= new JTextField(20);
		t3.setBounds(250,180,200,25);
                t3.setToolTipText("Enter Phone Number");
		jf.add(t3);

               
                l4 = new JLabel("Phone Number");
		l4.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l4.setForeground(Color.white);
   l4.setBounds(50,220,200,25);
    	jf.add(l4);
         t4= new JTextField(20);
		t4.setBounds(250,220,200,25);
                t4.setToolTipText("Enter Phone Number");
		jf.add(t4);

             
        
		  
                

                     
		l5 = new JLabel("Age");
		l5.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l5.setForeground(Color.white);
                l5.setBounds(50,260,250,25);
                    jf.add(l5);

                t5= new JTextField(20);
		t5.setBounds(250,260,100,25);t5.setToolTipText("Enter Age");
		jf.add(t5);
                
                l6 = new JLabel("Date Of Birth");
		l6.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l6.setForeground(Color.white);
                l6.setBounds(50,300,200,25);
                jf.add(l6);

                t6= new JTextField(20);
		t6.setBounds(250,300,100,25);t6.setToolTipText("Enter Date of Birth");
		jf.add(t6);

	   l7 = new JLabel("Email ID");
		l7.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l7.setForeground(Color.white);
                l7.setBounds(470,100,200,25);
                jf.add(l7);

                t7= new JTextField(20);
		t7.setBounds(720,100,100,25);
                t7.setToolTipText("Enter Email ID");
		jf.add(t7);

                 l8 = new JLabel("Address");
		l8.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l8.setForeground(Color.white);
                l8.setBounds(470,140,200,25);
                jf.add(l8);

                t8= new JTextField(20);
		t8.setBounds(720,140,100,25);
                t8.setToolTipText("Enter Address");
		jf.add(t8);

                 l9 = new JLabel("Post");
		 l9.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l9.setForeground(Color.white);
	   
                l9.setBounds(470,180,200,25);
                jf.add(l9);

                t9= new JTextField(20);
		t9.setBounds(720,180,100,25);
                t9.setToolTipText("Enter Address");
		jf.add(t9);
                b0 = new JButton("Open",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\open.png"));
                b0.setBounds(150,330,110,35);b0.setToolTipText("click to open staff details");
		jf.add(b0);b0.addActionListener(this);

		

                b1= new JButton("Remove",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\clear.png"));
		b1.setBounds(300,330,110,35);b1.setToolTipText("click to remove all textfields");
		jf.add(b1); b1.addActionListener(this);

    	b2 = new JButton("Clear",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\all.png"));
        b2.setBounds(450,330,110,35);b2.setToolTipText("click to clear all staff details");
	jf.add(b2); b2.addActionListener(this);

        b3 = new JButton("All",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\all.png"));
        b3.setBounds(600,330,110,35);b3.setToolTipText("click to view all staff details");
	jf.add(b3); b3.addActionListener(this);

        
	scrlPane.setBounds(0,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("GENDER");
        model.addColumn("PHONENO");
        model.addColumn("AGE");
        model.addColumn("DOB");
        model.addColumn("EMAIL_ID");
        model.addColumn("ADDRESS");
          model.addColumn("POST");
       

	     jf.setTitle("Remove Staff");
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
		    JOptionPane.showMessageDialog(this,"Please enter staff id or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }  
            
	  	 	
	        else
	        {

	      try
	       {//fetch
	      int foundrec = 0;
	    Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
		System.out.println("Connected to database.");
			ps=con.prepareStatement("Select id from staff where name='"+s+"'");
    		  rs=ps.executeQuery();
    		  while(rs.next())
    		  {
    		  	
	    	  
    	      }

		  ps=con.prepareStatement("select * from staff where name='"+t2.getText()+"' or id='"+t1.getText()+"' ");
		  rs=ps.executeQuery();
		  while(rs.next())
	      {
		    t1.setText(rs.getString(1));
	        t2.setText(rs.getString(2));
	        t3.setText(rs.getString(3));
	        t4.setText(rs.getString(4));
		    t5.setText(rs.getString(5));
                    t6.setText(rs.getString(6));
		    t7.setText(rs.getString(7));
                    t8.setText(rs.getString(8));
                    t9.setText(rs.getString(9));
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
//delete
               
	 	if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
	     {
		  JOptionPane.showMessageDialog(this,"Please enter bus bid or bname !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	      }
	      else
	      {
	      try
	       {
	    Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
		System.out.println("Connected to database.");
	    ps=con.prepareStatement("delete from staff where id='"+t1.getText()+"' or name='"+t2.getText()+"'");
	    ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Record is deleted.");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
       t7.setText("");
       t8.setText("");
        t9.setText("");
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
  else if(ae.getSource()==b2)
      {    t1.setText("");
           t2.setText("");
           //t3.setText("");
           t4.setText("");
           t5.setText("");
           t6.setText("");
          t7.setText("");
          t8.setText("");
           t9.setText("");
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
        rs = stmt.executeQuery("SELECT * from staff" );
          
        while(rs.next())
            {
model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
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
  new RemoveStaff();
 }
}



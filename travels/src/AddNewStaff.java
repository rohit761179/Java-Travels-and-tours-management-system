import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewStaff extends JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,ln;
    JButton b0,b1,b2,b3;
    JComboBox tabtype;
    String s,sid1,tabt;
	Font f;
        java.util.Date date1;
    GregorianCalendar calendar;
    String strDate;
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	AddNewStaff()
	{
		jf=new JFrame();
		f = new Font("Times New Roman",Font.BOLD,20);
		jf.setLayout(null);
                        // jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\staff.png")));

	    ln=new JLabel("Add New Staff");
	    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
	    ln.setForeground(Color.white);
	    ln.setBounds(300,30,300,40);
              jf.setResizable(true);
                jf.setLayout(new FlowLayout());
                jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\staff.jpg")));
	   
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

                tabtype=new JComboBox();
                tabtype.addItem("--gender--");
		tabtype.addItem("MALE");
		tabtype.addItem("FEMALE");
		
		tabtype.setBounds(250,180,200,25);
                tabtype.setToolTipText("Select Gender");
		jf.add(tabtype);
		tabtype.addActionListener(new ActionListener()
                {
		   public void actionPerformed(ActionEvent ae0)
		   {
		    tabt =(String)tabtype.getSelectedItem();
		   }
          });
                
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
                
               
                    
                     
                     
              date1= new java.util.Date();
     	calendar=new GregorianCalendar();
	    calendar.setTime(date1);
        strDate =calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
	    t6.setText(strDate);
                 
           
            
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
                t8.setToolTipText("Post");
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
                
                b0 = new JButton("Save",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\open.png"));
                b0.setBounds(150,330,110,35);b0.setToolTipText("click to save staff details");
		jf.add(b0);b0.addActionListener(this);

		

                b1= new JButton("Clear",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\clear.png"));
		b1.setBounds(300,330,110,35);b1.setToolTipText("click to clear all textfields");
		jf.add(b1); b1.addActionListener(this);

    	b2 = new JButton("All",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\all.png"));
        b2.setBounds(450,330,110,35);b2.setToolTipText("click to view all staff details");
	jf.add(b2); b2.addActionListener(this);

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
        
       

	     jf.setTitle("Add New Staff");
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
                String Date=t6.getText();
	       	Pattern p1=Pattern.compile("[0-9_/]+[0-9_/]+[0-9]");
	       	Matcher m2=p1.matcher(Date);
	        boolean matchFoundb=m2.matches();
                     
        
                String email=t7.getText();
	       	Pattern p=Pattern.compile("[_a-z_A-Z_0-9]+[0-9]*@[a-zA-Z0-9]+.[a-zA-Z0-9]+");
	       	Matcher m=p.matcher(email);
	        boolean matchFound=m.matches();
                
                String phoneno = t4.getText();
                Pattern pattern = Pattern.compile("\\d{10}");
                Matcher matcher=pattern.matcher(phoneno);
                boolean matchFounda=matcher.matches();
                   
                if(((t2.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals(""))||((t7.getText()).equals(""))||((t8.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
                else if(!matchFoundb)
	        {
	       	  JOptionPane.showMessageDialog(this,"Invalid Date use format [1/1/2019]","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	}
                  else if(!matchFounda)
	        {
	       	  JOptionPane.showMessageDialog(this,"Invalid phone no!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	}
                  else if(!matchFound)
	        {
                    JOptionPane.showMessageDialog(this,"Invalid email id!","Warning!!!",JOptionPane.WARNING_MESSAGE);
                }  
                  
                  
                  else{
                      
               try
        {
             Connection conn = null;
   Statement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
      
      stmt = conn.createStatement();
      String sql;
      sql = "insert into staff values(?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,t1.getText());
      pstmt.setString(2,t2.getText());
      pstmt.setString(3,tabt);
      pstmt.setString(4,t4.getText());
      pstmt.setString(5,t5.getText());
      pstmt.setString(6,t6.getText());
      pstmt.setString(7,t7.getText());
      pstmt.setString(8,t8.getText());
       pstmt.setString(9,t9.getText());
 
  pstmt.executeUpdate();
 
      JOptionPane.showMessageDialog(null, "Insertion Successfull!");  
      conn.close();
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e);
        }
                  }
        }
  
  else if(ae.getSource()==b1)
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
 else if(ae.getSource()==b2)
    {//All
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
model.insertRow(r++, 
        new Object[]
                    {
            rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
            rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
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
  new AddNewStaff();
 }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewHotel extends JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel l1,l2,l3,l4,l5,l6,ln;
    JButton b0,b1,b2,b3;
    JComboBox tabtype,tabtype1;
    String s,sid1,tabt,tabt1;
	Font f;
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	AddNewHotel()
	{
		jf=new JFrame();
		f = new Font("Times New Roman",Font.BOLD,20);
		jf.setLayout(null);

	    ln=new JLabel("Add New Hotel");
	    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
	    ln.setForeground(Color.blue);
	    ln.setBounds(300,30,300,40);
              jf.setResizable(true);
                jf.setLayout(new FlowLayout());
                jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\updatehotel.jpg")));
	   
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

                tabtype=new JComboBox();
                tabtype.addItem("--location--");
		tabtype.addItem("mumbai");
		tabtype.addItem("pune");
		tabtype.addItem("nagpur");
		tabtype.addItem("chennai");
		tabtype.addItem("goa");
		tabtype.addItem("rajasthan");
		tabtype.addItem("matheran");
		tabtype.addItem("mahabaleshwar");
		tabtype.addItem("kolkata");
		tabtype.addItem("banglore");
                tabtype.addItem("delhi");
                
		tabtype.setBounds(250,180,200,25);tabtype.setToolTipText("Select location");
		jf.add(tabtype);
		tabtype.addActionListener(new ActionListener()
                {
		   public void actionPerformed(ActionEvent ae0)
		   {
		    tabt =(String)tabtype.getSelectedItem();
		   }
          });
                l4 = new JLabel("Hotel type*");
		 l4.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l4.setForeground(Color.white);
   l4.setBounds(50,220,200,25);
    	jf.add(l4);

        tabtype1=new JComboBox();
        tabtype1.addItem("--type--");
		tabtype1.addItem("Standard");
		tabtype1.addItem("Classic");
		tabtype1.addItem("Premium");
		tabtype1.addItem("Superior");
		tabtype1.addItem("Royal Suite");
		tabtype1.addItem("President Suite");
		tabtype1.addItem("Junior Suite");
		tabtype1.addItem("Real Suite");
		
		tabtype1.setBounds(250,220,100,25);
                tabtype1.setToolTipText("Select hotel type");
		jf.add(tabtype1);
		tabtype1.addActionListener(new ActionListener()
	     {
		   public void actionPerformed(ActionEvent ae0)
		   {
		    tabt1 =(String)tabtype1.getSelectedItem();
		   }
          });
                l5 = new JLabel("Per Day Charges");
		 l5.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l5.setForeground(Color.black);
                l5.setBounds(50,260,250,25);
                    jf.add(l5);

                t5= new JTextField(20);
		t5.setBounds(250,260,100,25);t5.setToolTipText("Enter charges per day");
		jf.add(t5);
                l6 = new JLabel("Availability of rooms");
		 l6.setFont(new Font("Times New Roman",Font.BOLD,18));
	   l6.setForeground(Color.black);
                l6.setBounds(50,300,200,25);
                jf.add(l6);

                t6= new JTextField(20);
		t6.setBounds(250,300,100,25);t6.setToolTipText("Enter no. of rooms available");
		jf.add(t6);

	   
                b0 = new JButton("Save",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\open.png"));
                b0.setBounds(150,330,110,35);b0.setToolTipText("click to save hotel details");
		jf.add(b0);b0.addActionListener(this);

		

                b1= new JButton("Clear",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\clear.png"));
		b1.setBounds(300,330,110,35);b1.setToolTipText("click to clear all textfields");
		jf.add(b1); b1.addActionListener(this);

    	b2 = new JButton("All",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\all.png"));
        b2.setBounds(450,330,110,35);b2.setToolTipText("click to view all hotel details");
	jf.add(b2); b2.addActionListener(this);

	scrlPane.setBounds(0,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("H_Name");
        model.addColumn("H_Ratings");
        model.addColumn("H_Location");
        model.addColumn("H_Type");
        model.addColumn("H_Charges");
        model.addColumn("H_Rooms");
       

	     jf.setTitle("Add New Hotel");
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
           /* String Charges=t5.getText();
                Pattern p=Pattern.compile("[0-9]");
	       	Matcher m=p.matcher(Charges);
	        boolean matchFound=m.matches();
               */
                if(((t1.getText()).equals(""))||((t2.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals("")))
                    {
		    JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
   
         /* else if(!matchFound)
	        {
	  JOptionPane.showMessageDialog(this,"Charges should be in Integer!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	}*/
             else
          {
            Connection conn = null;
   Statement stmt = null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
      
      stmt = conn.createStatement();
      String sql;
      sql = "insert into hotel values(?,?,?,?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,t1.getText());
      pstmt.setString(2,t2.getText());
      pstmt.setString(3,tabt);
 pstmt.setString(4,tabt1);
 pstmt.setString(5,t5.getText());
 pstmt.setString(6,t6.getText());
 
  pstmt.executeUpdate();
 
      JOptionPane.showMessageDialog(null, "Insertion Successfull!!!!!!!!!!!!!!");  
      conn.close();
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
      {    t1.setText("");
           t2.setText("");
           //t3.setText("");
           //t4.setText("");
           t5.setText("");
           t6.setText("");
          
      }
 else if(ae.getSource()==b2)
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
  new AddNewHotel();
 }
}



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;


public class AddNewBus extends JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel l1,l2,l3,l4,l5,l6,ln;
    JButton b0,b1,b2;
  String tabt;
	Font f;
   
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	AddNewBus()
	{
		jf=new JFrame();
		f = new Font("Times New Roman",Font.BOLD,15);
		jf.setLayout(null);

	    ln=new JLabel("New Bus details");
	    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
	   ln.setForeground(Color.white);
	    ln.setBounds(300,30,400,40);
             jf.setResizable(true);
                jf.setLayout(new FlowLayout());
                jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\bus.jpg")));
	   
	    jf.add(ln);

		l1 = new JLabel("Bus ID*");
		 l1.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l1.setForeground(Color.white);
    l1.setBounds(50,100,200,25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(250,100,100,25);t1.setToolTipText("Enter bus id");
		jf.add(t1);

		l2 = new JLabel("Bus name*");
		 l2.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l2.setForeground(Color.white);
    l2.setBounds(50,140,200,25);
		jf.add(l2);

    	t2 = new JTextField(20);
		t2.setBounds(250,140,200,25);t2.setToolTipText("Enter Bus name");
		jf.add(t2);

		l3 = new JLabel("From");
		 l3.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l3.setForeground(Color.white);
    l3.setBounds(50,180,200,25);
		jf.add(l3);

    	t3 = new JTextField(20);
		t3.setBounds(250,180,200,25);t3.setToolTipText("From");
		jf.add(t3);


		l4 = new JLabel("Destination");
		 l4.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l4.setForeground(Color.white);
   l4.setBounds(50,220,200,25);
    	jf.add(l4);

        t4= new JTextField(20);
		t4.setBounds(250,220,100,25);
                t4.setToolTipText("Destination");
		jf.add(t4);

		l5= new JLabel("No. of seats");
		 l5.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l5.setForeground(Color.white);
                l5.setBounds(50,260,250,25);
		jf.add(l5);

                t5= new JTextField(20);
		t5.setBounds(250,260,100,25);
                t5.setToolTipText("Enter no. of seats");
		jf.add(t5);
                
                l6= new JLabel("Ticket price");
		 l6.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l6.setForeground(Color.white);
                l6.setBounds(50,300,250,25);
		jf.add(l6);

                t6= new JTextField(20);
		t6.setBounds(250,300,100,25);
                t6.setToolTipText("Enter price");
		jf.add(t6);

        b0 = new JButton("Save",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\save.png"));
        b0.setBounds(150,330,110,35);
        b0.setToolTipText("click to save bus details");
		jf.add(b0);
        b0.addActionListener(this);

		b1 = new JButton("Clear",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\clear.png"));
		b1.setBounds(300,330,110,35);
                b1.setToolTipText("click to clear all textfields");
	    jf.add(b1);
            b1.addActionListener(this);

        b2= new JButton("All",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\all.png"));
		b2.setBounds(450,330,110,35);
                b2.setToolTipText("click to view all bus details");
		jf.add(b2); 
        b2.addActionListener(this);

	    scrlPane.setBounds(0,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("B_ID");
        model.addColumn("B_NAME");
        model.addColumn("B_From");
         model.addColumn("B_Destination");
        model.addColumn("B_Seats");
        model.addColumn("B_Price");
       

	     jf.setTitle("Add New Bus");
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
                //String Prices=t6.getText();
                //Pattern p=Pattern.compile("[0-9]");
	       	//Matcher m=p.matcher(Prices);
	        //boolean matchFound=m.matches();

                if(((t1.getText()).equals(""))||((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals("")))
                    {
		    JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
   		//	    else if(!matchFound)
	        //{
	       	  //JOptionPane.showMessageDialog(this,"Price should be in Integer!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	//}

             else
              {
        try
        {
            Connection conn = null;
   Statement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
      
      stmt = conn.createStatement();
      String sql;
      sql = "insert into bus values(?,?,?,?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,t1.getText());
      pstmt.setString(2,t2.getText());
     pstmt.setString(3,t3.getText());
     pstmt.setString(4,t4.getText());
           pstmt.setString(5,t5.getText());
            pstmt.setString(6,t6.getText());
 
  pstmt.executeUpdate();
    
      JOptionPane.showMessageDialog(null, "Insertion Successfull!!!");  
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
           t3.setText("");
           t4.setText("");
           t5.setText("");
           t6.setText("");
      }

    else if(ae.getSource()==b2)
    {
  	int r = 0;
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * from bus" );
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
	      new AddNewBus();
	}
        
}


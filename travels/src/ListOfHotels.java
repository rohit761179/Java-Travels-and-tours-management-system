import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class ListOfHotels extends JFrame
 {
    JFrame jf=new JFrame();
    JLabel ln;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
 	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

  public ListOfHotels()
  {
    jf.setLayout(null);
  	ln = new JLabel("List of Hotels");
    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
    ln.setForeground(Color.blue);
    ln.setBounds(300,30,300,25);
    jf.add(ln);

    scrlPane.setBounds(0,80,900,600);
    jf.add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));

    model.addColumn("H_Name");model.addColumn("H_Ratings");model.addColumn("H_Location");model.addColumn("H_Type");
  	model.addColumn("H_Charges");model.addColumn("H_Rooms");
  		int r = 0;
     try
     {

     	Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("select * from hotel");
          while(rs.next())
            {
            	model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});

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


    jf.setTitle("List Of Hotels");
    jf.setSize(900,700);
	jf.setLocation(20,20);
	jf.setResizable(false);
    jf.getContentPane().setBackground(Color.cyan);
    jf.setVisible(true);
  }


  public static void main(String args[])
    {
    	new ListOfHotels();
    }
}

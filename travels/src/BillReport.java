import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillReport extends javax.swing.JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ln;
    JButton b0,b1,b2,b3;
    
    JComboBox bloc,hloc,bloc1;
    String s;
	Font f;
    Connection con;
	PreparedStatement ps,ps1,ps2,pst2;
	Statement stmt,stmt1;
	ResultSet rs,rs1;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	BillReport()
	{
		jf=new JFrame();
		f = new Font("Times New Roman",Font.BOLD,20);
		jf.setLayout(null);

	    ln=new JLabel("Bill Report");
	    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
	    ln.setForeground(Color.blue);
	    ln.setBounds(300,30,300,40);
             jf.setResizable(true);
                jf.setLayout(new FlowLayout());
                jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\bill.jpg")));
	    jf.add(ln);
            
            l1 = new JLabel("Bill no");
		 l1.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l1.setForeground(Color.white);
   l1.setBounds(50,100,200,25);
		jf.add(l1);

     	t1 = new JTextField(20);
		t1.setBounds(250,100,100,25);
		jf.add(t1);

		l2 = new JLabel("Customer Name*");
		 l2.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l2.setForeground(Color.white);
  l2.setBounds(50,140,200,25);
		jf.add(l2);

		t2 = new JTextField(20);
		t2.setBounds(250,140,100,25);t2.setToolTipText("Enter customer name");
		jf.add(t2);

		l3 = new JLabel("Bus From");
		 l3.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l3.setForeground(Color.white);
   l3.setBounds(50,180,200,25);
		jf.add(l3);

    	t3 = new JTextField(20);
		t3.setBounds(250,180,200,25);t3.setToolTipText("Enter from location");
		jf.add(t3);

		

		l4 = new JLabel("Bus Destination");
		 l4.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l4.setForeground(Color.white);
   l4.setBounds(50,220,200,25);
		jf.add(l4);

    	t4 = new JTextField(20);
		t4.setBounds(250,220,200,25);
                t4.setToolTipText("Enter Bus destination");
		jf.add(t4);

		l5= new JLabel("Hotel Location");
		l5.setBounds(50,260,200,25);
                 l5.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l5.setForeground(Color.white);
    	jf.add(l5);
        t5 = new JTextField(20);
		t5.setBounds(250,260,200,25);t5.setToolTipText("Enter hotel location");
		jf.add(t5);


       


		l6 = new JLabel("Hotel name");
	 l6.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l6.setForeground(Color.white);
   l6.setBounds(50,300,200,25);
		jf.add(l6);

    	t6 = new JTextField(20);
		t6.setBounds(250,300,200,25);t6.setToolTipText("Enter hotel name");
		jf.add(t6);

		l7 = new JLabel("Hotel Rooms");
		 l7.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l7.setForeground(Color.white);
    l7.setBounds(470,100,200,25);
    	jf.add(l7);

        t7 = new JTextField(20);
		t7.setBounds(720,100,100,25);
		jf.add(t7);
                
                 l8 = new JLabel("No. of seats");
		 l8.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l8.setForeground(Color.white);
    l8.setBounds(470,140,200,25);
    	jf.add(l8);

        t8 = new JTextField(20);
		t8.setBounds(720,140,100,25);
		jf.add(t8);
                
                
                l9 = new JLabel("Hotel Price");
	 l9.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l9.setForeground(Color.white);
    l9.setBounds(470,180,200,25);
    	jf.add(l9);

        t9 = new JTextField(20);
		t9.setBounds(720,180,100,25);
		jf.add(t9);

                l10 = new JLabel("Bus Price");
 l10.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l10.setForeground(Color.white);
    l10.setBounds(470,220,200,25);
    	jf.add(l10);

        t10 = new JTextField(20);
		t10.setBounds(720,220,100,25);
		jf.add(t10);
                
                
                 l11 = new JLabel("Tax");
		 l11.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l11.setForeground(Color.white);
    l11.setBounds(470,260,200,25);
    	jf.add(l11);

        t11 = new JTextField(20);
		t11.setBounds(720,260,100,25);
		jf.add(t11);
                
                
                 l12 = new JLabel("Total Price");
		 l12.setFont(new Font("Times New Roman",Font.BOLD,18));
	    l12.setForeground(Color.white);
    l12.setBounds(470,300,200,25);
    	jf.add(l12);

        t12 = new JTextField(20);
		t12.setBounds(720,300,100,25);
		jf.add(t12);

		

        b0 = new JButton("Total",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\search.png"));
        b0.setBounds(150,330,110,35);
        b0.setToolTipText("click to search Product details");
		jf.add(b0);
                b0.addActionListener(this);

		b1 = new JButton("Print");
		b1.setBounds(300,330,110,35);b1.setToolTipText("click to clear all textfields");
	    jf.add(b1);
            b1.addActionListener(this);

        b2= new JButton("Save",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\save.png"));
		b2.setBounds(450,330,110,35);b2.setToolTipText("click to view all Product details");
		jf.add(b2); b2.addActionListener(this);
                
                 b3= new JButton("All",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\all.png"));
		b3.setBounds(600,330,110,35);b3.setToolTipText("click to view all Product details");
		jf.add(b3); b3.addActionListener(this);

	    scrlPane.setBounds(0,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("Bill_No");
        model.addColumn("Customer_name");
        model.addColumn("from");
        model.addColumn("Bus_Destination");
        model.addColumn("Hotel_Location");
        model.addColumn("Hotel_Name");
        model.addColumn("Hotel_rooms");
        model.addColumn("Bus_seats");
        model.addColumn("Hotel_Price");
        model.addColumn("Bus_Price");
        model.addColumn("Tax");
        model.addColumn("Total_Price");
        

	     jf.setTitle("Bill Report ");
	     jf.setSize(900,700);
		 jf.setLocation(20,20);
		 jf.setResizable(false);
		 jf.getContentPane().setBackground(Color.pink);
	     jf.setVisible(true);
	}
        
	public void actionPerformed(ActionEvent ae){
	{
            Connection con = null;
   Statement stmt = null;
        
	 if(ae.getSource()==b0)
	  {//total
              
	     try
	      {
	      	 if(((t4.getText()).equals(""))&&((t8.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"Please enter bus id or bus location!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else
	        {
	         int foundrec = 0;

	    Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
		System.out.println("Connected to database.");
                    stmt = con.createStatement();
               ps1=con.prepareStatement("select bno from bill");
		  rs1=ps1.executeQuery();
                  
		  while(rs1.next())
                  {
                        
                      t1.setText(rs1.getString(1));
                      int c =Integer.parseInt(t1.getText());
                      
                  }
		  ps=con.prepareStatement("select * from bus where start='"+t3.getText()+"'"+"And destination='"+t4.getText()+"'");
		  rs=ps.executeQuery();
                  ps2=con.prepareStatement("select * from hotel where hname='"+t6.getText()+"'");
		  rs=ps2.executeQuery();
		  while(rs.next())
                      
                  
	      {
                    t10.setText(rs.getString(6));
                    t9.setText(rs.getString(5));
		    double a=Double.parseDouble(t9.getText());
                    double x=Double.parseDouble(t7.getText());
                    double total1=a*x;
                  double b=Double.parseDouble(t10.getText());
                 double z=Double.parseDouble(t8.getText());
                 double total=b*z;
                 double amount=total+total1;
                   double tax=amount*0.10;
                    double net_amount=amount+tax;
                    
                    t12.setText(""+net_amount);
                    t11.setText(""+tax);
		     
                    foundrec = 1;
	       }
	        if (foundrec == 0)
                {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                }
	         }
	         con.close();
        }
      catch(SQLException se)
		{
	      //System.out.println(se);
	     //JOptionPane.showMessageDialog(null,"SQL Error."+se);
        }
	    catch(Exception e)
	     {
	     System.out.println(e);
		 //JOptionPane.showMessageDialog(null,"Error."+e);
	     }
    }
	   else if(ae.getSource()==b1)
           {
                {
                  Document doc=new Document();
                    try {
                      try {
                          PdfWriter.getInstance(doc, new FileOutputStream("Bill.pdf"));
                      } catch (DocumentException ex) {
                          Logger.getLogger(BillReport.class.getName()).log(Level.SEVERE, null, ex);
                      }
                    
                    }
                    catch (FileNotFoundException ex) {
                        Logger.getLogger(BillReport.class.getName()).log(Level.SEVERE, null, ex);
                     }
                  doc.open();
                  
                  Paragraph p=new Paragraph(""
                          +"************************************************************\n"
                          
                          +"*********************Tours And Travels**********************\n"
                          
                          +"************************************************************\n"
                          
                          + "Bill no:  "+t1.getText()+"\n"         
                          
                         
                          
                          +"Customer Name:  "+t2.getText()+"\n"
                          
                         
                          
                          +"Bus From :"+t3.getText()+"\n"
                          
                         
                          
                          +"Bus Destination:  "+t4.getText()+"\n"
                          
                         
                          
                          +"Hotel Location:  "+t5.getText()+"\n"
                          
                         
                          
                          +"Hotel Name:"+t6.getText()+"\n"
                          
                          
                           +"Hotel rooms:  "+t7.getText()+"\n"
                          
                          
                           +"Bus seats:  "+t8.getText()+"\n"
                          
                          
                          
                          +"Hotel Price:  "+t9.getText()+"\n"
                          
                          
                           +"Bus Price:  "+t10.getText()+"\n"
                          
                          
                           +"Tax:  "+t11.getText()+"\n"
                          
                          
                           +"Total Price:  "+t12.getText()+"\n"
                          
                         
                          
                          +"************************************************************\n");
                         
              
                    try {
                        doc.add(p);
                    } catch (DocumentException ex) {
                        Logger.getLogger(BillReport.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    doc.close();
                  
	     t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
                t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
         t11.setText("");
        t12.setText("");

        
        JOptionPane.showMessageDialog(null,"Bill Printed Successfully");
        try{
            
            PreparedStatement st=(PreparedStatement)con.prepareStatement("INSERT INTO `Bill`.`transaction`(`t12`) VALUES (?);");
            st.setString(1,t12.getText());
            st.executeUpdate();
            st.close();
     
            
        } catch (SQLException ex) {
            //Logger.getLogger(PrintBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
               
               
               
               
               
           }        
             
         
           
	    
 if(ae.getSource()==b2)
	 {//save
	 	    
	    	if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals(""))||((t7.getText()).equals(""))||((t8.getText()).equals(""))||((t9.getText()).equals(""))||((t10.getText()).equals(""))||((t11.getText()).equals(""))||((t12.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	       
			else
			{
			  try
			  	 {
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
			System.out.println("Connected to database.");
            ps=con.prepareStatement("insert into bill (bno,cname,bfrom,bdest,hloc,hname,rooms,seats,hprice,bprice,btax,total)values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,t1.getText());
		    ps.setString(2,t2.getText());
		  ps.setString(3,t3.getText());
			ps.setString(4,t4.getText());
                        ps.setString(5,t5.getText());
                        ps.setString(6,t6.getText());
                        ps.setString(7,t7.getText());
                         ps.setString(8,t8.getText());
                          ps.setString(9,t9.getText());
                           ps.setString(10,t10.getText());
                            ps.setString(11,t11.getText());
                           ps.setString(12,t12.getText());
		  	ps.executeUpdate();
                        
                        
                        
                       String sql1="update bus set bseats=bseats-? where start=? And destination=?";
PreparedStatement pst=con.prepareStatement(sql1);
pst.setDouble(1,Double.parseDouble(t8.getText()));
pst.setString(2,t3.getText());
pst.setString(3,t4.getText());

pst.executeUpdate();

String sql2="update hotel set hroom=hroom-? where hname=?";
PreparedStatement pst2=con.prepareStatement(sql2);
pst2.setDouble(1,Double.parseDouble(t7.getText()));
pst2.setString(2,t6.getText());


pst2.executeUpdate();
  int reply=JOptionPane.showConfirmDialog(null,"data saved successfully, Do you want to add more?");

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

        else if(ae.getSource()==b3)
    {//list
  	int r = 0;
              
              
             
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tours","root","root123");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("select * from bill" );
          while(rs.next())
            {
model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});
            
            
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
        }
       
           
         
    public static void main(String args[])
 {
  new BillReport();
 }
}




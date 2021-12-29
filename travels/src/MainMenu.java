import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener
{   JFrame jf;
	JMenuBar mbar;
        JMenuItem add;
	JMenu m1,m2,m3,m4,m5,m6,m7;
	JMenuItem m1_1,m1_2,m1_3,m2_1,m2_2,m2_3,m2_4,m3_1,m3_2,m3_3,m3_4,m4_1,m4_2,m5_1,m6_1,m7_1;
	JLabel l1,LogoColl;
	GridBagLayout gbl;
    
    

	public MainMenu()
	{
        jf=new JFrame();
        jf.setLayout(new BorderLayout());
                jf.setTitle("main menu");
		jf.setLocation(20,20);
		jf.setSize(800,556);
		jf.setResizable(true);
                jf.setLayout(new FlowLayout());
                jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\mainmenu.jpg")));
             
		gbl=new GridBagLayout();
		jf.setLayout(gbl);

		l1=new JLabel("WELCOME TO TOURS AND TRAVELS MANAGEMENT SYSTEM");
		l1.setFont(new Font("Times New Roman",Font.BOLD,26));
                		l1.setForeground(Color.white);

		jf.add(l1);

		mbar = new JMenuBar();
		jf.setJMenuBar(mbar);

		

		m1=new JMenu("Availability");
		mbar.add(m1);
		m1_1 = new JMenuItem("List of Buses",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\addnew.png"));
		m1.add(m1_1);
		m1_2 = new JMenuItem("List of Hotels",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\search.png"));
		m1.add(m1_2);
		m1_3 = new JMenuItem("List of Staff Members",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\update.png"));
		m1.add(m1_3);
		
		

		m2=new JMenu("Bus");
                JMenu add1 = mbar.add(m2);
		m2_1 = new JMenuItem("Add new Bus",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m2.add(m2_1);

		m2_2 = new JMenuItem("Update Bus",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m2.add(m2_2);
                m2_3 = new JMenuItem("Delete Bus",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m2.add(m2_3);
                m2_4 = new JMenuItem("Search Bus",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m2.add(m2_4);
                
                m3=new JMenu("Hotel");
                JMenu add = mbar.add(m3);
		m3_1 = new JMenuItem("Add new Hotel",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m3.add(m3_1);

		m3_2 = new JMenuItem("Update Hotel",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m3.add(m3_2);
                m3_3 = new JMenuItem("Delete Hotel",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m3.add(m3_3);
                m3_4 = new JMenuItem("Search Hotel",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m3.add(m3_4);
                
                
                
               m4=new JMenu("HR");
               mbar.add(m4);
               m4_1 = new JMenuItem("Add New Staff",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
	       m4.add(m4_1);
                
                mbar.add(m4);
                m4_2 = new JMenuItem("Remove Staff",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\report.png"));
		m4.add(m4_2);
        
            
               m5=new JMenu("Report");
		mbar.add(m5);
		m5_1 = new JMenuItem("Bill Report",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\help.png"));
                m5.add(m5_1);
               

                m6=new JMenu("About");
		mbar.add(m6);
		m6_1 = new JMenuItem("About",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\exit.png"));
		m6.add(m6_1);

                
		m7=new JMenu("Exit");
		mbar.add(m7);
		m7_1 = new JMenuItem("Exit",new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\travels\\src\\travels\\exit.png"));
		m7.add(m7_1);

     
                m1_1.addActionListener(this);
		m1_2.addActionListener(this);
		m1_3.addActionListener(this);
		
		m2_1.addActionListener(this);
		m2_2.addActionListener(this);
                m2_3.addActionListener(this);
                m2_4.addActionListener(this);
                
                
                m3_1.addActionListener(this);
		m3_2.addActionListener(this);
                m3_3.addActionListener(this);
                m3_4.addActionListener(this);
                                

                m4_1.addActionListener(this);
                m4_2.addActionListener(this);
	
              
                m5_1.addActionListener(this);
                
                
                m6_1.addActionListener(this);
                m7_1.addActionListener(this);

		
		jf.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae)
	{

		 if(ae.getSource()==m1_1)
		{
                     ListOfBuses addNewBooking = new ListOfBuses();
                     addNewBooking.setVisible(true);
                     this.dispose();
		}
		else if(ae.getSource()==m1_2)
		{
                     ListOfHotels cancelBooking = new ListOfHotels();
                     cancelBooking.setVisible(true);
                     this.dispose();
		}
		else if(ae.getSource()==m1_3)
		{
                     ListOfStaff updateBooking = new ListOfStaff();
                             updateBooking.setVisible(true);
                     this.dispose();
		}
               

                else if(ae.getSource()==m2_1)
		 {
                     AddNewBus addnewbus = new AddNewBus();
                     addnewbus.setVisible(true);
                     this.dispose();
		 }

		  else if(ae.getSource()==m2_2)
		 {
                     UpdateBus updatebus = new UpdateBus();
                     updatebus.setVisible(true);
                     this.dispose();
		 }
                  else if(ae.getSource()==m2_3)
		{
                     DeleteBus deletebus = new DeleteBus();
                     deletebus.setVisible(true);
                     this.dispose();
		}
                   else if(ae.getSource()==m2_4)
		{
                     SearchBus searchbus = new SearchBus();
                     searchbus.setVisible(true);
                     this.dispose();
		}
                      
                   
                    else if(ae.getSource()==m3_1)
		 {
                     AddNewHotel addnewhotel = new AddNewHotel();
                     addnewhotel.setVisible(true);
                     this.dispose();
		 }

		  else if(ae.getSource()==m3_2)
		 {
                     UpdateHotel updatehotel = new UpdateHotel();
                     updatehotel.setVisible(true);
                     this.dispose();
		 }
                  else if(ae.getSource()==m3_3)
		{
                     DeleteHotel deletehotel = new DeleteHotel();
                     deletehotel.setVisible(true);
                     this.dispose();
		}
                   else if(ae.getSource()==m3_4)
		{
                     SearchHotel searchhotel = new SearchHotel();
                     searchhotel.setVisible(true);
                     this.dispose();
		}
                   

		else if(ae.getSource()==m4_1)
		{
                     AddNewStaff addStaff = new AddNewStaff();
                addStaff.setVisible(true);
                     this.dispose();
		}
                else if(ae.getSource()==m4_2)
		{
                     RemoveStaff removeStaff = new RemoveStaff();
               removeStaff.setVisible(true);
                     this.dispose();
		}
           
               else if(ae.getSource()==m5_1)
		{
                     BillReport customerDetails = new BillReport(); 
                 customerDetails.setVisible(true);
                     this.dispose();
		}
                  
        

		else if(ae.getSource()==m6_1)
		{
                     About about = new About();
		}
                 else if(ae.getSource()==m7_1)
		{
		  System.exit(0);
		}

  }

	public static void main(String args[])
	{
    
            MainMenu mainMenu = new MainMenu();
     
        }
}

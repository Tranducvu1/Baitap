package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Model.ConnectDB1;
import Model.ConnectDB3;


public class informationhouse extends JFrame{
	JFrame lb = new JFrame("Information House");
	JLabel IDHouse = new JLabel("ID House");
	JTextField tfIDHouse = new JTextField(15);
	JLabel lbaddress = new JLabel("Address House");
	JTextField tfaddress = new JTextField(15);
	JLabel lbarea = new JLabel("House Area");
	JTextField tfarea = new JTextField(15);
	JLabel lbdeposits = new JLabel("Deposits");
	JTextField tfdeposits = new JTextField(15);
	JButton btnadd = new JButton ("Add");
	JButton btndelete = new JButton ("Delete");
	JButton btnnew = new JButton ("New");
	JButton btnupdate = new JButton ("Update");
	JButton btnsearch = new JButton ("Find");
	JButton btnSee = new JButton ("See");
	JButton btncancel = new JButton ("Cancel");
	JButton btnback = new JButton("Back");

	JButton btnexit = new JButton("Exit");
	JTextField tfsearch = new JTextField(10);
	JLabel lbtools = new JLabel("Tools");
	JLabel btnMenu = new JLabel("Meuu");
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbhouse = new JTable();
	JScrollPane sp = new JScrollPane(tbhouse);
	public informationhouse() {
		jframehouse();
		buttonhouse();
		tbhouse.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int row = tbhouse.getSelectedRow();
				IDHouse.setText((String)tbhouse.getValueAt(row, 0));
				tfaddress.setText((String)tbhouse.getValueAt(row, 1));
				tfarea.setText((String)tbhouse.getValueAt(row, 2));
				tfdeposits.setText((String)tbhouse.getValueAt(row, 3));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	public void DisplayHouse() {
		ConnectDB1 conn = new ConnectDB1();
	// trong sql thì phải dùng DefaultTableModel nếu k sẽ bị trùng dữ liệu
		rs=conn.ListHouse("Select * from informationhouse1");
		String column[] = {"ID House", "Address House","House Area","Deposits"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
       
		
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("IDHouse"), rs.getString("AddressHouse"),rs.getString("HouseArea"),rs.getString("Deposits")};    
				
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}
	
	public void HouseFind() {
		ConnectDB1 conn = new ConnectDB1();
		rs=conn.ListHouse("Select * from informationhouse1 where IDHouse = '"+tfIDHouse.getText()+"' or AddressHouse = '"+tfaddress.getText()+ "or HouseArea = '"+tfarea.getText()+"' or Deposits = '"+tfdeposits.getText());
		String column[] = {"IDHouse", "Address House","HouseArea","Deposits"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("IDHouse"), rs.getString("AddressHouse"),rs.getString("HouseArea"),rs.getString("Deposits"),rs.getString("CMNDland")};    
				
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}
	public void jframehouse() {
		JPanel pnid = new JPanel();
		pnid.add(IDHouse);
		pnid.add(tfIDHouse);
		pnid.add(lbaddress);
		pnid.add(tfaddress);
		pnid.add(lbarea);
		pnid.add(tfarea);
		pnid.add(lbdeposits);
		pnid.add(tfdeposits);

		pnid.setLayout(new GridLayout(5,2));
		IDHouse.setForeground(Color.BLUE);
		lbaddress.setForeground(Color.BLUE);
		lbarea.setForeground(Color.BLUE);
		lbdeposits.setForeground(Color.BLUE);
		Border bd = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdhouse= BorderFactory.createTitledBorder(bd, "Database");
		pnid.setBorder(tbdhouse);
		pnid.setBackground(Color.WHITE);
		
		JPanel pnbt = new JPanel();
		pnbt.add(btnadd);
		pnbt.add(btnupdate);
		pnbt.add(btndelete);
		pnbt.add(btnsearch);
		pnbt.add(btnnew);
		pnbt.add(btnSee);
		pnbt.add(btncancel);
		pnbt.add(btnback);
		pnbt.setLayout(new GridLayout(2,4));
		btncancel.setBackground(Color.YELLOW);
		btnback.setBackground(Color.YELLOW);
		btnsearch.setBackground(Color.YELLOW);
		btnupdate.setBackground(Color.YELLOW);
		btnnew.setBackground(Color.YELLOW);
		btndelete.setBackground(Color.YELLOW);
		btnadd.setBackground(Color.YELLOW);
		btnSee.setBackground(Color.YELLOW);
		JPanel pninfor = new JPanel();
		Border bdhouse = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdcus= BorderFactory.createTitledBorder(bdhouse, "Information House");
		pninfor.setBorder(tbdcus);
		pninfor.add(sp);
		pninfor.setBackground(Color.WHITE);
		lb.setLocation(200,100);
		
		Container cont5 = lb.getContentPane();
		cont5.add(pnid,BorderLayout.CENTER);
		cont5.add(pninfor,BorderLayout.EAST);
		cont5.add(pnbt,BorderLayout.SOUTH);
		DisplayHouse();
		lb.pack();
		lb.setSize(950,550);
		lb.setVisible(true);

		btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new choose();
				lb.dispose();
			}
		});
		btncancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			lb.dispose();
			}
		});
		ConnectDB1 con = new ConnectDB1();
		// trong sql thì phải dùng DefaultTableModel nếu k sẽ bị trùng dữ liệu
			rs=con.ListHouse("Select * from informationhouse1");
			String column[] = {"ID House", "Address House","House Area","Deposits"};
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	       
			
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("IDHouse"), rs.getString("AddressHouse"),rs.getString("HouseArea"),rs.getString("Deposits")};    
					
					
					tm.addRow(data);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tbhouse.setModel(tm);
		
	}
	


	public void buttonhouse() {
		btnnew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new informationhouse();
				lb.dispose();
			}
		});
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//thêm dữ liệu
				ConnectDB1 cn = new ConnectDB1();
				try {
					int record1 = cn.executeDB1("Insert into informationhouse1 values('"+tfIDHouse.getText()+"','"+tfaddress.getText()+"','"+tfarea.getText()+"','"+tfdeposits.getText()+"')");
					if (record1>0) JOptionPane.showMessageDialog(null, "Insert Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DisplayHouse();
			}
		});
		btndelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB1 cn = new ConnectDB1();
				try {
					int record1 = cn.executeDB1("Delete from informationhouse1 where IDHouse = '"+tfIDHouse.getText()+"'");
					if (record1>0) JOptionPane.showMessageDialog(null, "Delete Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DisplayHouse();
			}
		});
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB1 cn = new ConnectDB1();
				try {
					if(tfaddress.getText().length() !=0) {
						int record1 = cn.executeDB1("Update informationhouse1 set AddressHouse = '"+tfaddress.getText()+"' where IDHouse = '"+tfIDHouse.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfarea.getText().length()!=0) {
						int record1 = cn.executeDB1("Update informationhouse1 set HouseArea = '"+tfarea.getText()+"' where IDHouse = '"+tfIDHouse.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfdeposits.getText().length()!=0) {
						int record1 = cn.executeDB1("Update informationhouse1 set Deposits = '"+tfdeposits.getText()+"' where IDHouse = '"+tfIDHouse.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				DisplayHouse();
			}
		});
		
		btnsearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				HouseFind();
			}
		});
	
		
		btnSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jtable2();
				lb.dispose();
			}
		});
	
		
	}
public void jtable2() {
	JFrame ftb = new JFrame();
	JTable tbhouse = new JTable();
	JScrollPane ctrl = new JScrollPane(tbhouse);
	JButton btnback = new JButton("Back");
	JButton btncancel = new JButton("Cancel");
	ftb.setLocation(200,100);
	
	JPanel pntb = new JPanel();
	ctrl.setPreferredSize(new Dimension(850, 450));
	Border bd2 = BorderFactory.createLineBorder(Color.CYAN);
	TitledBorder tbdll= BorderFactory.createTitledBorder(bd2, "Informationhouse");
	pntb.setBorder(tbdll);
	pntb.add(ctrl);
	
	btnback.setForeground(Color.RED);
	btncancel.setForeground(Color.RED);
	btnback.setBackground(Color.YELLOW);
	btncancel.setBackground(Color.YELLOW);
	JPanel pnbt = new JPanel();
	pnbt.add(btnback);
	pnbt.add(btncancel);
	Container conttb = ftb.getContentPane();
	conttb.add(pntb);
	conttb.add(pnbt, BorderLayout.SOUTH);
	ftb.setSize(900,500);
	ftb.setVisible(true);
	btncancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
				
			lb.dispose();
			}
	});
	btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			new informationhouse();
				lb.dispose();
			}
		});
ConnectDB1 con = new ConnectDB1();
// trong sql thì phải dùng DefaultTableModel nếu k sẽ bị trùng dữ liệu
	rs=con.ListHouse("Select * from informationhouse1");
	String column[] = {"IDHouse", "Address House","House Area","Deposits"};
    DefaultTableModel tm = new DefaultTableModel (column, 0);
    try {
		while (rs.next()) {
			Object data[]= {rs.getString("IDHouse"), rs.getString("AddressHouse"),rs.getString("HouseArea"),rs.getString("Deposits")};    
			
			
			tm.addRow(data);
		
		}
		tbhouse.setModel(tm);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
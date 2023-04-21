package KBN.Module.Warehouse;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JTextField;

import KBN.views.WarehouseModule;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddItemWarehouse extends JDialog implements ActionListener{
	
	//Class
	private AddDataWarehouse adw;
	private WarehouseModule wm;
	
	private ArrayList arrData;
	
	private JLabel lblNewLabel;
	private JTextField txtCodename;
	private JTextField txtMaterialname;
	private JTextField txtSupplier;
	private JTextField txtControlno;
	private JTextField txtPrice;
	private JTextField txtDate;
	private JTextField txtReceive;
	private JButton btnCancel;
	private JButton btnAdd;
	private JComboBox txtAppearance;

	public AddItemWarehouse() {
		setBounds(100, 100, 500, 500);
		this.setUndecorated(true);
		
		this.setModal(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 31);
		panel.setBackground(SystemColor.controlHighlight);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Raw Materials");
		lblNewLabel.setBounds(10, 0, 158, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Code Name:");
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(25, 65, 170, 31);
		getContentPane().add(lblNewLabel_1);
		
		txtCodename = new JTextField();
		txtCodename.setBounds(200, 65, 257, 31);
		getContentPane().add(txtCodename);
		txtCodename.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Material Name:");
		lblNewLabel_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(25, 107, 170, 31);
		getContentPane().add(lblNewLabel_1_1);
		
		txtMaterialname = new JTextField();
		txtMaterialname.setColumns(10);
		txtMaterialname.setBounds(200, 107, 257, 31);
		getContentPane().add(txtMaterialname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Supplier:");
		lblNewLabel_1_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(25, 191, 170, 31);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtSupplier = new JTextField();
		txtSupplier.setColumns(10);
		txtSupplier.setBounds(200, 191, 257, 31);
		getContentPane().add(txtSupplier);
		
		JLabel lblNewLabel_1_2 = new JLabel("Control No. :");
		lblNewLabel_1_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(25, 149, 170, 31);
		getContentPane().add(lblNewLabel_1_2);
		
		txtControlno = new JTextField();
		txtControlno.setColumns(10);
		txtControlno.setBounds(200, 149, 257, 31);
		getContentPane().add(txtControlno);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price:");
		lblNewLabel_1_1_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(25, 359, 170, 31);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(200, 359, 257, 31);
		getContentPane().add(txtPrice);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Date:");
		lblNewLabel_1_2_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(25, 317, 170, 31);
		getContentPane().add(lblNewLabel_1_2_1);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(200, 317, 257, 31);
		getContentPane().add(txtDate);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Receive:");
		lblNewLabel_1_1_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(25, 275, 170, 31);
		getContentPane().add(lblNewLabel_1_1_2);
		
		txtReceive = new JTextField();
		txtReceive.setColumns(10);
		txtReceive.setBounds(200, 275, 257, 31);
		getContentPane().add(txtReceive);
		
		JLabel lblNewLabel_1_3 = new JLabel("Appearance:");
		lblNewLabel_1_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(25, 233, 170, 31);
		getContentPane().add(lblNewLabel_1_3);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCancel.setFocusable(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(200, 427, 117, 46);
		getContentPane().add(btnCancel);
		
		btnAdd = new JButton("Add Item");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAdd.setFocusable(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(339, 427, 117, 46);
		getContentPane().add(btnAdd);
		
		String []appearance = {"LIQUID", "POWDER", "BEADS", "WHITE CRYSTALLINE SOLID", "FLAKES", "SOLID", "GEL", "CRYSTAL", "BUTTER"};
		txtAppearance = new JComboBox(appearance);
		txtAppearance.setBounds(200, 233, 257, 31);
		getContentPane().add(txtAppearance);
	}
	
	private void addFunction() {
		arrData = new ArrayList<>();
		adw = new AddDataWarehouse();
		arrData.add(txtMaterialname.getText());//MaterialName
		arrData.add(txtCodename.getText());//CodeName
		arrData.add(txtControlno.getText());//ControlNo
		arrData.add(txtSupplier.getText());//Supplier
		arrData.add(txtReceive.getText());//Receive
		arrData.add(txtAppearance.getSelectedItem());//Appearance
		arrData.add("NONE");//Released
		arrData.add("NONE");//Reject
		arrData.add("NONE");//Hold
		arrData.add("NONE");//Prod RETURN
		arrData.add(txtDate.getText());//Date
		arrData.add("NONE");//Categories
		adw.addArrayList(arrData);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCancel) {
			this.dispose();
		}else if(e.getSource() == btnAdd) {
			addFunction();
			
			wm = new WarehouseModule();
			wm.setVisible(false);
			new WarehouseModule().setVisible(true);
			
			this.dispose();
		}
		
	}
}

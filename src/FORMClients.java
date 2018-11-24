/**
 *
 * @author dominikadzawislak
 */
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

public class FORMClients extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	boolean addRecord = false;

	private void clearInputBoxes() {
		txtClientID.setText("");
		txtPesl.setText("");
		txtName.setText("");
		txtSurname.setText("");
		txtNumber.setText("");
		txtEmail.setText("");
		txtStreet.setText("");
		txtCity.setText("");
		txtHouse.setText("");
		txtFlat.setText("");
		txtCountry.setText("");
		txtIDShelter.setText("");
		txtIDPost.setText("");

	}

	private void addNew() throws SQLException {
		String sql_stmt = "INSERT INTO \"Klienci\" (\"ID_Klienta\", \"Pesel\", \"Imie\", \"Nazwisko\", \"Numer_telefonu\", \"Adres_e_mail\", \"Ulica\", \"Miasto\", \"Numer_domu\", \"Numer_mieszkania\", \"Kraj\", \"ID_Schroniska\", \"ID_Poczty\")";
		sql_stmt += " VALUES ('" + txtClientID.getText() + "','" + txtPesl.getText() + "','" + txtName.getText() + "','"
				+ txtSurname.getText() + "','" + txtNumber.getText() + "','" + txtEmail.getText() + "','"
				+ txtStreet.getText() + "','" + txtCity.getText() + "','" + txtHouse.getText() + "','"
				+ txtFlat.getText() + "','" + txtCountry.getText() + "','" + txtIDShelter.getText() + "','"
				+ txtIDPost.getText() + "')";

		Shelter shelter = new Shelter();

		Shelter.ExecuteSQLStatement(sql_stmt);
	}

	private void updateRecord() throws SQLException {
		String sql_stmt = "UPDATE \"Klienci\" SET \"Pesel\" = '" + txtPesl.getText() + "'";
		sql_stmt += ", \"Imie\" = '" + txtName.getText() + "'";
		sql_stmt += ", \"Nazwisko\" = '" + txtSurname.getText() + "'";
		sql_stmt += ", \"Numer_telefonu\" = '" + txtNumber.getText() + "'";
		sql_stmt += ", \"Adres_e_mail\" = '" + txtEmail.getText() + "'";
		sql_stmt += ", \"Ulica\" = '" + txtStreet.getText() + "'";
		sql_stmt += ", \"Miasto\" = '" + txtCity.getText() + "'";
		sql_stmt += ", \"Numer_domu\" = '" + txtHouse.getText() + "'";
		sql_stmt += ", \"Numer_mieszkania\" = '" + txtFlat.getText() + "'";
		sql_stmt += ", \"Kraj\" = '" + txtCountry.getText() + "'";
		sql_stmt += ", \"ID_Schroniska\" = '" + txtIDShelter.getText() + "'";
		sql_stmt += ", \"ID_Poczty\" = '" + txtIDPost.getText() + "'";
		sql_stmt += " WHERE \"ID_Klienta\" = '" + txtClientID.getText() + "'";

		Shelter shelter = new Shelter();

		Shelter.ExecuteSQLStatement(sql_stmt);
	}

	private void deleteRecord() throws SQLException {
		String sql_stmt = "DELETE FROM \"Klienci\" WHERE \"ID_Klienta\"='" + txtClientID.getText() + "'";

		Shelter shelter = new Shelter();

		Shelter.ExecuteSQLStatement(sql_stmt);
	}

	private void loadRecords() throws SQLException {

		String sql_stmt = "SELECT * FROM \"Klienci\"";

		ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);

		jTable1.setModel(tableModel);

		jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (jTable1.getSelectedRow() >= 0) {
					Object clientid = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
					Object pesel = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
					Object name = jTable1.getValueAt(jTable1.getSelectedRow(), 2);
					Object surname = jTable1.getValueAt(jTable1.getSelectedRow(), 3);
					Object number = jTable1.getValueAt(jTable1.getSelectedRow(), 4);
					Object email = jTable1.getValueAt(jTable1.getSelectedRow(), 5);

					Object street1 = jTable1.getValueAt(jTable1.getSelectedRow(), 6);
					if (null != street1) {
						Object street = jTable1.getValueAt(jTable1.getSelectedRow(), 6);
						txtStreet.setText(street.toString());
					} else {
						txtStreet.setText("");
					}

					Object city = jTable1.getValueAt(jTable1.getSelectedRow(), 7);
					Object house = jTable1.getValueAt(jTable1.getSelectedRow(), 8);

					Object flat1 = jTable1.getValueAt(jTable1.getSelectedRow(), 9);
					if (null != flat1) {
						Object flat = jTable1.getValueAt(jTable1.getSelectedRow(), 9);
						txtFlat.setText(flat.toString());
					} else {
						txtFlat.setText("");
					}

					Object country = jTable1.getValueAt(jTable1.getSelectedRow(), 10);
					Object shelterid = jTable1.getValueAt(jTable1.getSelectedRow(), 11);
					Object postid = jTable1.getValueAt(jTable1.getSelectedRow(), 12);

					txtClientID.setText(clientid.toString());
					txtPesl.setText(pesel.toString());
					txtName.setText(name.toString());
					txtSurname.setText(surname.toString());
					txtNumber.setText(number.toString());
					txtEmail.setText(email.toString());
					txtCity.setText(city.toString());
					txtHouse.setText(house.toString());
					txtCountry.setText(country.toString());
					txtIDShelter.setText(shelterid.toString());
					txtIDPost.setText(postid.toString());

				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		});
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
	}

	/**
	 * Creates new form FORMEmployees
	 */
	public FORMClients(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		txtSurname = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		txtClientID = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtNumber = new javax.swing.JTextField();
		txtStreet = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		txtPesl = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		txtEmail = new javax.swing.JTextField();
		txtCity = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		txtCountry = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		txtIDShelter = new javax.swing.JTextField();
		txtIDPost = new javax.swing.JTextField();
		txtHouse = new javax.swing.JTextField();
		txtFlat = new javax.swing.JTextField();
		btnAddNew = new javax.swing.JButton();
		btnUpdate = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnPrintAll = new javax.swing.JButton();
		btnClose = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		setTitle("Animal Shelter - Clients");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		try {
			setIconImage(ImageIO.read(new File("\\cat.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client data",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 11))); // NOI18N

		jLabel2.setText("*Client ID:");

		jLabel3.setText("*Name:");

		jLabel4.setText("*Surname:");

		jLabel5.setText(" Street:");

		jLabel6.setText("*Phone number:");

		jLabel7.setText("*City:");

		jLabel8.setText("*PESEL number:");

		jLabel9.setText("*E-mail:");

		jLabel10.setText("*House number:");

		jLabel11.setText(" Flat number:");

		jLabel12.setText("*Country:");

		jLabel13.setText("*Shelter ID:");

		jLabel14.setText("*Post Office ID:");

		txtClientID.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtIDPostActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel6).addComponent(jLabel3).addComponent(jLabel2)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtCity, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
								.addComponent(txtNumber).addComponent(txtName).addComponent(txtClientID)
								.addComponent(txtCountry))
						.addGap(23, 23, 23)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txtIDShelter, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txtHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(22, 22, 22)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE,
																61, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(txtIDPost, javax.swing.GroupLayout.PREFERRED_SIZE,
																112, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout
														.createSequentialGroup()
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel11).addComponent(jLabel5))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(txtStreet).addComponent(txtFlat))))
										.addContainerGap())
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel8).addComponent(jLabel4).addComponent(jLabel9))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(txtSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 115,
														Short.MAX_VALUE)
												.addComponent(txtPesl))
										.addGap(236, 236, 236)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(txtClientID, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8).addComponent(txtPesl, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4).addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel6)
												.addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel9).addComponent(jLabel5)
												.addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel10).addComponent(jLabel11).addComponent(txtFlat,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7,
												Short.MAX_VALUE))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtHouse, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel12)
								.addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel13).addComponent(jLabel14)
								.addComponent(txtIDShelter, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIDPost, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		btnAddNew.setText("Add new");
		btnAddNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddNewActionPerformed(evt);
			}
		});

		btnUpdate.setText("Update");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});

		btnDelete.setText("Delete");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});

		btnPrintAll.setText("Display");
		btnPrintAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPrintAllActionPerformed(evt);
			}
		});

		btnClose.setText("Close");
		btnClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCloseActionPerformed(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { {}, {}, {}, {} }, new String[] {

		}));
		jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addComponent(btnAddNew)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnUpdate)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnDelete)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnPrintAll)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnClose)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnAddNew).addComponent(btnUpdate).addComponent(btnDelete)
								.addComponent(btnPrintAll).addComponent(btnClose))
						.addContainerGap()));

		pack();
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		try {
			loadRecords();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {
		addRecord = true;

		clearInputBoxes();

		txtClientID.requestFocus();
	}

	private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}

	Object[] options = { "Yes", "No" };

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {

		int dialogResult = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the data?",
				"Confirm the deletion of data?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
				options[0]);

		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				deleteRecord();

				loadRecords();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		int dialogResult = JOptionPane.showOptionDialog(null, "Are you sure you want to change the data?",
				"Do you confirm the change of data?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
				options[0]);

		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				if (addRecord == true) {
					addNew();
				} else {
					updateRecord();
				}

				addRecord = false;

				loadRecords();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnPrintAllActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			loadRecords();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void txtIDPostActionPerformed(java.awt.event.ActionEvent evt) {
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FORMClients.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FORMClients.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FORMClients.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FORMClients.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FORMClients dialog = new FORMClients(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// Variables declaration 
	private javax.swing.JButton btnAddNew;
	private javax.swing.JButton btnClose;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnPrintAll;
	private javax.swing.JButton btnUpdate;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField txtCity;
	private javax.swing.JTextField txtClientID;
	private javax.swing.JTextField txtCountry;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtFlat;
	private javax.swing.JTextField txtHouse;
	private javax.swing.JTextField txtIDPost;
	private javax.swing.JTextField txtIDShelter;
	private javax.swing.JTextField txtName;
	private javax.swing.JTextField txtNumber;
	private javax.swing.JTextField txtPesl;
	private javax.swing.JTextField txtStreet;
	private javax.swing.JTextField txtSurname;
}

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

public class FORMEmployees extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	boolean addRecord = false;

	private void clearInputBoxes() {
		txtIDPracownika.setText("");
		txtImie.setText("");
		txtNazwisko.setText("");
		txtPesel.setText("");
		txtDataZat.setText("");
		txtDataZwol.setText("");
		cboStanowisko.setSelectedItem("");
		txtTelefon.setText("");
		txtMail.setText("");
		txtUlica.setText("");
		txtMiasto.setText("");
		txtDom.setText("");
		txtMieszkanie.setText("");
		txtKraj.setText("");
		txtSchronisko.setText("");
		txtPoczta.setText("");

	}

	private void addNew() throws SQLException {
		String sql_stmt = "INSERT INTO \"Pracownicy\" (\"ID_Pracownika\", \"Imie\", \"Nazwisko\", \"PESEL\", \"Data_zadrudnienia\", \"Data_zwolnienia\", \"Stanowisko\", \"Numer_telefonu\", \"Adres_e_mail\", \"Ulica\", \"Miasto\", \"Numer_domu\", \"Numer_mieszkania\", \"Kraj\", \"ID_Schroniska\", \"ID_Poczty\")";
		sql_stmt += " VALUES ('" + txtIDPracownika.getText() + "','" + txtImie.getText() + "','" + txtNazwisko.getText()
				+ "','" + txtPesel.getText() + "','" + txtDataZat.getText() + "','" + txtDataZwol.getText() + "','"
				+ cboStanowisko.getSelectedItem().toString() + "','" + txtTelefon.getText() + "','" + txtMail.getText()
				+ "','" + txtUlica.getText() + "','" + txtMiasto.getText() + "','" + txtDom.getText() + "','"
				+ txtMieszkanie.getText() + "','" + txtKraj.getText() + "','" + txtSchronisko.getText() + "','"
				+ txtPoczta.getText() + "')";

		Shelter shelter = new Shelter();

		Shelter.ExecuteSQLStatement(sql_stmt);
	}

	private void updateRecord() throws SQLException {
		String sql_stmt = "UPDATE \"Pracownicy\" SET \"Imie\" = '" + txtImie.getText() + "'";
		sql_stmt += ", \"Nazwisko\" = '" + txtNazwisko.getText() + "'";
		sql_stmt += ", \"PESEL\" = '" + txtPesel.getText() + "'";
		sql_stmt += ", \"Data_zatrudnienia\" = '" + txtDataZat.getText() + "'";
		sql_stmt += ", \"Data_zwolnienia\" = '" + txtDataZwol.getText() + "'";
		sql_stmt += ", \"Stanowisko\" = '" + cboStanowisko.getSelectedItem().toString() + "'";		
		sql_stmt += ", \"Numer_telefonu\" = '" + txtTelefon.getText() + "'";
		sql_stmt += ", \"Adres_e_mail\" = '" + txtMail.getText() + "'";
		sql_stmt += ", \"Ulica\" = '" + txtUlica.getText() + "'";
		sql_stmt += ", \"Miasto\" = '" + txtMiasto.getText() + "'";
		sql_stmt += ", \"Numer_domu\" = '" + txtDom.getText() + "'";
		sql_stmt += ", \"Numer_mieszkania\" = '" + txtMieszkanie.getText() + "'";
		sql_stmt += ", \"Kraj\" = '" + txtKraj.getText() + "'";
		sql_stmt += ", \"ID_Schroniska\" = '" + txtSchronisko.getText() + "'";
		sql_stmt += ", \"ID_Poczty\" = '" + txtPoczta.getText() + "'";
		sql_stmt += " WHERE \"ID_Pracownika\" = '" + txtIDPracownika.getText() + "'";

		Shelter shelter = new Shelter();

		Shelter.ExecuteSQLStatement(sql_stmt);
	}

	private void deleteRecord() throws SQLException {
		String sql_stmt = "DELETE FROM \"Pracownicy\" WHERE \"ID_Pracownika\"='" + txtIDPracownika.getText() + "'";

		Shelter shelter = new Shelter();

		Shelter.ExecuteSQLStatement(sql_stmt);
	}

	private void loadRecords() throws SQLException {

		String sql_stmt = "SELECT * FROM \"Pracownicy\"";

		ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);

		jTable1.setModel(tableModel);

		jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (jTable1.getSelectedRow() >= 0) {
					Object employee_id = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
					Object full_name = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
					Object name = jTable1.getValueAt(jTable1.getSelectedRow(), 2);
					Object pesel = jTable1.getValueAt(jTable1.getSelectedRow(), 3);
					Object data_zat = jTable1.getValueAt(jTable1.getSelectedRow(), 4);
					
					Object data_zwol1 = jTable1.getValueAt(jTable1.getSelectedRow(), 5);
					if(null != data_zwol1) {		
						Object data_zwol = jTable1.getValueAt(jTable1.getSelectedRow(), 5);
					txtDataZwol.setText(data_zwol.toString());
					} else {
						txtDataZwol.setText("");
					}
					
					Object stanowisko = jTable1.getValueAt(jTable1.getSelectedRow(), 6);
					Object numer = jTable1.getValueAt(jTable1.getSelectedRow(), 7);
					Object mail = jTable1.getValueAt(jTable1.getSelectedRow(), 8);
					
					Object ulica1 = jTable1.getValueAt(jTable1.getSelectedRow(), 9);
					if(null != ulica1) {
					Object ulica = jTable1.getValueAt(jTable1.getSelectedRow(), 9);
					txtUlica.setText(ulica.toString());
				} else {
					txtUlica.setText("");
				}
					
					Object miasto = jTable1.getValueAt(jTable1.getSelectedRow(), 10);
					Object dom = jTable1.getValueAt(jTable1.getSelectedRow(), 11);
					
					Object mieszkanie1 = jTable1.getValueAt(jTable1.getSelectedRow(), 12);
					if(null != mieszkanie1) {
					Object mieszkanie = jTable1.getValueAt(jTable1.getSelectedRow(), 12);	
					txtMieszkanie.setText(mieszkanie.toString());
					} else {
						txtMieszkanie.setText("");
					}
					
					Object kraj = jTable1.getValueAt(jTable1.getSelectedRow(), 13);
					Object shron = jTable1.getValueAt(jTable1.getSelectedRow(), 14);
					Object poczta = jTable1.getValueAt(jTable1.getSelectedRow(), 15);

					txtIDPracownika.setText(employee_id.toString());
					txtImie.setText(full_name.toString());
					txtNazwisko.setText(name.toString());
					txtPesel.setText(pesel.toString());
					txtDataZat.setText(data_zat.toString());
					cboStanowisko.setSelectedItem(stanowisko.toString());
					txtTelefon.setText(numer.toString());
					txtMail.setText(mail.toString());
					txtMiasto.setText(miasto.toString());
					txtDom.setText(dom.toString());
					txtKraj.setText(kraj.toString());
					txtSchronisko.setText(shron.toString());
					txtPoczta.setText(poczta.toString());
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
	public FORMEmployees(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		txtIDPracownika = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		cboStanowisko = new javax.swing.JComboBox();
		jLabel5 = new javax.swing.JLabel();
		txtDataZat = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		txtMieszkanie = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtDom = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		txtDataZwol = new javax.swing.JTextField();
		txtImie = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		txtKraj = new javax.swing.JTextField();
		txtUlica = new javax.swing.JTextField();
		txtSchronisko = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		txtMail = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		txtTelefon = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		txtPoczta = new javax.swing.JTextField();
		txtMiasto = new javax.swing.JTextField();
		jLabel17 = new javax.swing.JLabel();
		txtNazwisko = new javax.swing.JTextField();
		txtPesel = new javax.swing.JTextField();
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

		setTitle("Animal Shelter - Employees");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		try {
			setIconImage(ImageIO.read(new File("\\cat.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee data",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 11))); // NOI18N

		jLabel2.setText("*Employee ID:");

		// txtIDPracownika.setEnabled(false);
		txtIDPracownika.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtIDPracownikaActionPerformed(evt);
			}
		});

		jLabel3.setText("*Surname:");

		cboStanowisko.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Chairman", "Accountant", "Janitor", "Driver" }));
		cboStanowisko.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboStanowiskoActionPerformed(evt);
			}
		});

		jLabel5.setText("*Date of employment:");

		txtDataZat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDataZatActionPerformed(evt);
			}
		});

		jLabel6.setText(" Date of release:");

		txtMieszkanie.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMieszkanieActionPerformed(evt);
			}
		});

		jLabel7.setText("*Phone number:");

		txtDom.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDomActionPerformed(evt);
			}
		});

		jLabel8.setText("*Name:");

		jLabel9.setText("*PESEL number:");

		txtDataZwol.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDataZwolActionPerformed(evt);
			}
		});

		txtImie.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtImieActionPerformed(evt);
			}
		});

		jLabel4.setText("*Position:");

		jLabel10.setText("*E-mail:");

		jLabel11.setText(" Street:");

		jLabel12.setText("*City:");

		jLabel13.setText("*House number:");

		txtUlica.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtUlicaActionPerformed(evt);
			}
		});

		jLabel14.setText(" Flat number:");

		txtMail.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMailActionPerformed(evt);
			}
		});

		jLabel15.setText("*Country:");

		txtTelefon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTelefonActionPerformed(evt);
			}
		});

		jLabel16.setText("*Post Office ID:");

		txtPoczta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtPocztaActionPerformed(evt);
			}
		});

		txtMiasto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMiastoActionPerformed(evt);
			}
		});

		jLabel17.setText("*Shelter ID:");

		txtNazwisko.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtNazwiskoActionPerformed(evt);
			}
		});

		txtPesel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtPeselActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel8)
												.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5).addComponent(jLabel12).addComponent(jLabel15))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtIDPracownika, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(txtImie, javax.swing.GroupLayout.DEFAULT_SIZE, 127,
														Short.MAX_VALUE)
												.addComponent(txtDataZat).addComponent(txtTelefon)
												.addComponent(txtMiasto).addComponent(txtKraj))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel3).addComponent(jLabel6)
														.addComponent(jLabel13).addComponent(jLabel10)
														.addComponent(jLabel17))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(txtDataZwol, javax.swing.GroupLayout.DEFAULT_SIZE,
																129, Short.MAX_VALUE)
														.addComponent(txtNazwisko).addComponent(txtMail)
														.addComponent(txtDom).addComponent(txtSchronisko))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGroup(jPanel1Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel11).addComponent(
																				jLabel4)
																		.addComponent(jLabel9))
																.addGap(41, 41, 41)
																.addGroup(jPanel1Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(txtPesel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				132,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(txtUlica,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				132,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(cboStanowisko,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGroup(jPanel1Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel14).addComponent(jLabel16))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(jPanel1Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																		.addComponent(txtMieszkanie,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				132, Short.MAX_VALUE)
																		.addComponent(txtPoczta))))
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))))
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtIDPracownika, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtImie, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3)
										.addComponent(txtNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel9).addComponent(txtPesel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup().addComponent(jLabel8).addGap(8, 8, 8)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6).addComponent(
																txtDataZwol, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtDataZat,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel5)))
												.addGap(11, 11, 11))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(cboStanowisko,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel4)).addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7).addComponent(txtTelefon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel10)))
												.addGap(0, 0, Short.MAX_VALUE))
										.addComponent(txtUlica, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtMiasto, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel13).addComponent(jLabel12)
														.addComponent(jLabel14).addComponent(txtMieszkanie,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(txtDom, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(14, 14, 14)))
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtKraj, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel15).addComponent(jLabel17))
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel16).addComponent(txtSchronisko,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(txtPoczta, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(16, 16, 16))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel11).addGap(0, 0,
										Short.MAX_VALUE)))));

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
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(18, 18, 18).addComponent(btnAddNew).addGap(18, 18, 18)
								.addComponent(btnUpdate).addGap(18, 18, 18).addComponent(btnDelete).addGap(18, 18, 18)
								.addComponent(btnPrintAll)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnClose).addGap(21, 21, 21))
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnAddNew).addComponent(btnUpdate).addComponent(btnDelete)
								.addComponent(btnPrintAll).addComponent(btnClose))
						.addGap(22, 22, 22)));

		jPanel1.getAccessibleContext().setAccessibleName("Dane pracownika");

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

		txtImie.requestFocus();
	}

	private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}
	
	Object[] options = { "Yes", "No" };

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		int dialogResult = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the data?",
				"Confirm the deletion of data?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
			    options, options[0]);

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
				"Do you confirm the change of data?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
			    options, options[0]);

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

	private void txtPeselActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtNazwiskoActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtImieActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtDataZwolActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtDomActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtMieszkanieActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void cboStanowiskoActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtMiastoActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtPocztaActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtIDPracownikaActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtDataZatActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtTelefonActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtUlicaActionPerformed(java.awt.event.ActionEvent evt) {
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
			java.util.logging.Logger.getLogger(FORMEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FORMEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FORMEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FORMEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FORMEmployees dialog = new FORMEmployees(new javax.swing.JFrame(), true);
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

	// Variables declaration - do not modify
	private javax.swing.JButton btnAddNew;
	private javax.swing.JButton btnClose;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnPrintAll;
	private javax.swing.JButton btnUpdate;
	private javax.swing.JComboBox cboStanowisko;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
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
	private javax.swing.JTextField txtDataZat;
	private javax.swing.JTextField txtDataZwol;
	private javax.swing.JTextField txtDom;
	private javax.swing.JTextField txtIDPracownika;
	private javax.swing.JTextField txtImie;
	private javax.swing.JTextField txtKraj;
	private javax.swing.JTextField txtMail;
	private javax.swing.JTextField txtMiasto;
	private javax.swing.JTextField txtMieszkanie;
	private javax.swing.JTextField txtNazwisko;
	private javax.swing.JTextField txtPesel;
	private javax.swing.JTextField txtPoczta;
	private javax.swing.JTextField txtSchronisko;
	private javax.swing.JTextField txtTelefon;
	private javax.swing.JTextField txtUlica;
}

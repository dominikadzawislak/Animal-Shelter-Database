/**
 *
 * @author dominikadzawislak
 */
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class LoginForm extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private static javax.swing.JTextField jTextField1;
	private JPasswordField jTextField2;
	private static boolean succeeded;
	static String user;
	static JFrame loginform;
	static AdminForm aform;
	static EmployeeForm eform;
	static String haslo;
	static String employeemail;
	static String cl;

	public LoginForm() {
		initComponents();
	}

	public static void init() {

		LoginForm loginform = new LoginForm();
		loginform.setVisible(true);

	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Animal Shelter");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		try {
			setIconImage(ImageIO.read(new File("\\cat.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel1.setText("Hello, enter your username and password");

		jLabel2.setText("Username:");

		jLabel3.setText("Password:");

		jButton1.setText("Login");
		jButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (authenticate(getUsername(), getPassword())) {
						JOptionPane.showMessageDialog(LoginForm.this, "Welcome " + getUsername() + "!", "Successful login",
								JOptionPane.INFORMATION_MESSAGE);
						succeeded = true;
						String ad = getUsername();
						if (ad.equals("admin")) {
							aform = new AdminForm();
							aform.setVisible(true);
							dispose();
						} else {
							eform = new EmployeeForm();
							eform.setVisible(true);
							dispose();
						}

					} else {
						JOptionPane.showMessageDialog(LoginForm.this, "Wrong username or password", "Wrong username or password",
								JOptionPane.ERROR_MESSAGE);
						jTextField1.setText("");
						jTextField2.setText("");
						succeeded = false;

					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		jButton2.setText("Leave");
		jButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		JPanel bp = new JPanel();
		bp.add(jButton1);
		bp.add(jButton2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(70, Short.MAX_VALUE).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
												.createSequentialGroup().addComponent(jLabel3).addGap(18, 18, 18)
												.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 129,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
												.addGap(18, 18, 18)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(10, 10, 10)))
								.addGap(129, 129, 129))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(jLabel1).addGap(70, 70, 70))))
				.addGroup(layout.createSequentialGroup().addGap(158, 158, 158)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(39, 39, 39)
				.addComponent(
						jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(25, 25, 25)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18).addComponent(jButton1).addGap(18, 18, 18).addComponent(jButton2)
				.addContainerGap(39, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginForm().setVisible(true);
			}
		});
	}

	
	private static void getEmployeePassword() throws SQLException {
		cl = getUsername();
			
        try {
            String url = "jdbc:oracle:thin:@...";
            Connection conn = DriverManager.getConnection(url,"username..","password..");
            Statement stmt = conn.createStatement();
            ResultSet rs;
 
            rs = stmt.executeQuery("SELECT \"Haslo\" FROM \"LOGIN\" WHERE \"Adres_e_mail\"='" + cl + "'");
            while ( rs.next() ) {
                haslo = rs.getString("Haslo");
                employeemail = cl;
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
	
	public static boolean authenticate(String username, String password) throws SQLException {
		getEmployeePassword();
		if (username.equals("admin") && password.equals("admin")) {
			user = "admin";
			return true;
		} else if (username.equals(employeemail) &&password.equals(haslo)) {
			user = "client";
			return true; 
		} else
			return false;
	}

	public static String getUsername() {
		return jTextField1.getText().trim();
	}

	public String getPassword() {
		return new String(jTextField2.getPassword());
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public static void runLoginMenu() {
		LoginForm.init();
		aform.dispose();

	}

	public static void runLoginEmployeeMenu() {
		LoginForm.init();
		eform.dispose();

	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;

}

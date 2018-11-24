/**
 *
 * @author dominikadzawislak
 */
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class EmployeeForm extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	static EmployeeForm empform;
	static AdminForm aform;
	static FORMFinance fform;

	public EmployeeForm() {
		initComponents();
	}
	
	public static void initEmployee() {

		EmployeeForm empform = new EmployeeForm();
		empform.setVisible(true);

	}
	
	public static void runEmployeeMenu() {
		EmployeeForm.initEmployee();
		fform.dispose();

	}

	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Animal Shelter");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		try {
			setIconImage(ImageIO.read(new File("\\cat.png")));
		} catch (IOException e) {

			e.printStackTrace();
		}

		jButton2.setText("View your data");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton1.setText("Edit your data");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton3.setText("Check salary");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton5.setText("Logout");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
		jLabel1.setText("Main menu");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(145, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(145, 145, 145))
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton5).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(53, 53, 53)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
						.addComponent(jButton5).addContainerGap()));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		fform = new FORMFinance();
		fform.setVisible(true);
		dispose();

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		LoginForm.runLoginEmployeeMenu();
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
			java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EmployeeForm().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton5;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	// End of variables declaration
}

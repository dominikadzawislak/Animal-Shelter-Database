/**
 *
 * @author dominikadzawislak
 */
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Employees {

	public static void runFormAdmin() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException ex) {
			System.out.println(ex.getMessage());
		}
		FORMEmployees sForm = new FORMEmployees(null, false);
		sForm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		sForm.pack();
		sForm.setLocationRelativeTo(null);

		sForm.setVisible(true);

	}

}

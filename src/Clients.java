/**
 *
 * @author dominikadzawislak
 */
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Clients {

	public static void runFormClient() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException ex) {
			System.out.println(ex.getMessage());
		}
		FORMClients cForm = new FORMClients(null, false);
		cForm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		cForm.pack();
		cForm.setLocationRelativeTo(null);

		cForm.setVisible(true);

	}

}

/**
 *
 * @author dominikadzawislak
 */
public class DisplayReports extends JasperReports {

	public void showEmployees() {
		m_sql_stmt = "SELECT * FROM \"Pracownicy\"";
		showReport("/Pracownicy/");
	}

	public void showClients() {
		m_sql_stmt = "SELECT * FROM \"Klienci\"";
		showReport("/Klienci/");
	}

}

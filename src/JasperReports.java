/**
 *
 * @author dominikadzawislak
 */
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReports {

	String m_where;
	String m_report_source;
	String m_sql_stmt;
	Map parametersMap = new HashMap();

	protected void showReport(String m_report_source) {
		try {
			Shelter shelter = new Shelter();
			InputStream is = getClass().getResourceAsStream(m_report_source);

			JRDesignQuery jrDesignQuery = new JRDesignQuery();
			jrDesignQuery.setText(m_sql_stmt);

			JasperDesign jasperDesign = JRXmlLoader.load(is);
			jasperDesign.setQuery(jrDesignQuery);

			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametersMap,
					Shelter.getConnection());
			JasperViewer.viewReport(jasperPrint, false);

		} catch (JRException e) {
			System.out.println("Exception message " + e.getMessage());
		}
	}
}

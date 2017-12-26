package processos;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.HttpConnector;

public class ValidaArquivo implements org.camunda.bpm.engine.delegate.JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {

		for (int i = 0; i < 1000000; i++) {
			try {
				long a = (i + i) + 1530 - ((3100 / i - i + 1) / 776 - 3 * 97) - 1 + 23;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
		}
		Thread.sleep(10000);

		HttpConnector http = Connectors.getConnector(HttpConnector.ID);
		http.createRequest().get().url("https://uol.com.br").execute();
	}

}

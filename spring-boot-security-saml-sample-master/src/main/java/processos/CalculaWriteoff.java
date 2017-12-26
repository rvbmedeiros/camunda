package processos;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.web.client.RestTemplate;

public class CalculaWriteoff implements org.camunda.bpm.engine.delegate.JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		
		for (int i = 0; i < 100000000; i++) {
			try {
				long a = (i + i) + 1530 - ((3100 / i - i + 1) / 776 - 3 * 97) - 1 + 23;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
		}
		Thread.sleep(10000);
	}

}

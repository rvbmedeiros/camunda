package processos;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.web.client.RestTemplate;

public class AbreDia implements org.camunda.bpm.engine.delegate.JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {

		for (int i = 0; i < 1000000000; i++) {
			try {
				long a = (i + i) + 10 - ((30 / i - i + 1) / 2 - 3 * 9) - 1 + 1;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
		}
	}

}

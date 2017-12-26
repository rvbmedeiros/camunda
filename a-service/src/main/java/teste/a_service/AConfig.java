package teste.a_service;

import java.util.Collections;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@RequestMapping("/a")
@RefreshScope
public class AConfig {

	@Value("${message:Hello default}")
	private String message;

	@Autowired
	private RabbitTemplate rt;

	public static void main(String[] args) {
		SpringApplication.run(AConfig.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@GetMapping
	public String getA() {
		return message;
	}

	@GetMapping("{pk}")
	public String getA(@PathVariable("pk") String pk) {
		return "a";
	}

	@PostMapping
	public String post() {
		RestTemplate rt2 = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("{}", headers);
		rt2.exchange("http://localhost:8098/rest/process-definition/key/Pesar/start", HttpMethod.POST, entity, String.class);
		rt.convertAndSend("teste", "teste", "testando");
		return "enviado pra fila";
	}

}

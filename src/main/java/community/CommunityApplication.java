package community;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import community.event.consumer.RankingConsumer;
import community.service.RankingService;

@SpringBootApplication
public class CommunityApplication {

	@Autowired
	private RankingConsumer consumer;
	
	@Autowired
	RankingService rankingService;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CommunityApplication.class, args);
	}
	//ť���� ranking�� �޾Ƹ� ��  consumer �� �̵� 
	@PostConstruct
	public void init() throws Exception {
		consumer.consume("ranking");
	}
}  
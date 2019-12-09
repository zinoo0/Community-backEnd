package community.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//자바 sdk 기본 패키지
import java.util.List;

//종속성으로 추가된 패키지
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//내가 만든 클래스
import community.entity.BoardEntity;
import community.repository.BoardRepository;

@RestController
public class BoardController {

	@Autowired
	BoardRepository boardRepo;

	// 게시글 저장(POST, PUT)
	// 경로: /리소스/아이디
	// 메소드: GET, POST, PUT, DELETE, PATCH, OPTIONS.. 등등
	@RequestMapping(value = "/community/boards", method = { RequestMethod.POST, RequestMethod.PUT })
	public BoardEntity saveBoard(@RequestBody BoardEntity f) throws Exception {
		// upsert - id가 있으면 update, 없으면 insert
		return boardRepo.save(f);
	}

	// 게시글 삭제
	// ex) /feeds/1
	// 메소드: DELETE
	// feeds 리소스에 아이디 1인 레코드를 DELETE 해라
	@RequestMapping(value = "/community/boards/{no}", method = RequestMethod.DELETE)
	public void removeFeed(@PathVariable long no) throws Exception {
		boardRepo.deleteById(no);
	}

	// 게시글 목록 조회
	@RequestMapping(value = "/community/boards", method = RequestMethod.GET)
	public List<BoardEntity> getBoards() throws Exception {
		return boardRepo.findAll(Sort.by(Sort.Direction.DESC, "no"));
	}

	// News Api 를 받아와 문자열 변환 
	@RequestMapping(value = "/community/boards/news/{team}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String getNews(@PathVariable String team) throws Exception {
		String serviceUrl = "https://m.sports.naver.com/kbaseball/news/list.nhn?isPhoto=N&type=team&team=";

		URL url = new URL(serviceUrl + team);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("accept", "application/json, text/javascript, */*");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

		StringBuilder builder = new StringBuilder();
		String aux = "";

		while ((aux = in.readLine()) != null) {
			builder.append(aux);
		}

		return builder.toString();
	}

}

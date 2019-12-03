package community.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import community.entity.BoardEntity;
import community.entity.CommentEntity;
import community.repository.CommentRepository;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentRepo;

	// 피드 저장(POST, PUT)
	// 경로: /리소스/아이디
	// 메소드: GET, POST, PUT, DELETE, PATCH, OPTIONS.. 등등
	// 여기에 주소
	@RequestMapping(value = "/community/boards/comments", method = { RequestMethod.POST, RequestMethod.PUT })
	public CommentEntity saveComment(@RequestBody CommentEntity f) throws Exception {
		// upsert - id가 있으면 update, 없으면 insert
		return commentRepo.save(f);
	}

	// 게시글 댓글 조회
//	@RequestMapping(value = "/community/boards/{boardNo}/comments/", method = RequestMethod.GET)
//	public List<CommentEntity> getComments(@PathVariable long boardNo) throws Exception {
//		return commentRepo.findByBoardNo(boardNo, Sort.by(Sort.Direction.DESC, "id"));
//	}

	// 게시글 댓글 삭제
	// ex) /feeds/1
	// 메소드: DELETE
	// feeds 리소스에 아이디 1인 레코드를 DELETE 해라
	@RequestMapping(value = "/community/boards/comments/{id}", method = RequestMethod.DELETE)
	public void removeComment(@PathVariable long id) throws Exception {
		commentRepo.deleteById(id);
	}

//	@RequestMapping(value = "/community/boards/{boardNo}/comments/{pageNo}/{pageSize}", method = RequestMethod.GET)
//	public Page<CommentEntity> getComment(@PathVariable long boardNo,@PathVariable int pageNo, @PathVariable int pageSize) throws Exception { //
//		
//		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
//		
//		return commentRepo.findByBoardNo(boardNo, pageRequest);
		
//		return commentRepo.findByBoardNo(boardNo,Pageable.of(pageNo, pageSize, Sort.by("id").descending()));
	
	@RequestMapping(value = "/community/boards/{boardNo}/comments/{pageNo}/{pageSize}", method = RequestMethod.GET)
	   public List<CommentEntity> getComment(@PathVariable long boardNo,@PathVariable int pageNo, @PathVariable int pageSize) throws Exception { //
			return commentRepo.findByBoardNo(boardNo, PageRequest.of(pageNo, pageSize, Sort.by("id").descending()));
	   }

//	PageRequest.of(pageNo, pageSize, Sort.by("reportingDate").descending())
	// value="/boards/{boardNo}/comments" ?????????????????????????

}

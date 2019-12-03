package community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import community.entity.RankingEntity;
import community.repository.RankingRepository;

@CrossOrigin
@RestController
public class RankingController {

	@Autowired
	RankingRepository rankingRepo;

	@RequestMapping(value = "/community/ranking", method = RequestMethod.GET)
	public List<RankingEntity> getRanking() throws Exception {
		return rankingRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

//	// 게시글 댓글 조회
//	@RequestMapping(value = "/community/boards/{boardNo}/comments/", method = RequestMethod.GET)
//	public List<CommentEntity> getComments(@PathVariable long boardNo) throws Exception {
//		return commentRepo.findByBoardNo(boardNo, Sort.by(Sort.Direction.DESC, "id"));
//	}
}

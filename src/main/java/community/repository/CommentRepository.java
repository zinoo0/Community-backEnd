package community.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import community.entity.CommentEntity;


public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

	// findBy« µÂ∏Ì
//	Page<CommentEntity> findByBoardNo(long boardNo, PageRequest pageRequest);

//	Page<CommentEntity> findByBoardNo(long boardNo);

	List<CommentEntity> findByBoardNo(long boardNo, Pageable of);

//	List<CommentEntity> findByBoardNo(long boardNo, PageRequest of);

//	List<CommentEntity> findByBoardNo(long boardNo, Sort by);






}

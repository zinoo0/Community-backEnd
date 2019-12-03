package community.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




import community.entity.BoardEntity;


public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}

package community.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 데이터베이스 연결되는 객체다
@Table(name = "comment_item") // 연결되는 테이블 이름 정의
@NoArgsConstructor // 생성자의 매개변수가 없다
@Data // 롬복으로 getter, setter 자동 생성
public class CommentEntity {

	@Id // 테이블의 pk임을 지정
	@GeneratedValue(strategy = GenerationType.AUTO) // 자동증가 컬럼
	private long id;

	@Column(nullable = false)
	private String comment;

	@Column(nullable = false)
	private long boardNo;
	
	@Column(nullable = false)
	private long reportingDate;
	
	@Column(nullable = false)
	private long commentcount;
	

}

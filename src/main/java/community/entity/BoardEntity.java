package community.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity // 데이터베이스 연결되는 객체다
@Table(name = "board_item") // 연결되는 테이블 이름 정의
@NoArgsConstructor // 생성자의 매개변수가 없다
@Data // 롬복으로 getter, setter 자동 생성
public class BoardEntity {

	@Id // 테이블의 pk임을 지정
	@GeneratedValue(strategy = GenerationType.AUTO) // 자동증가 컬럼
	private long no;

	@Column(nullable = false, updatable = false) // 테이블에 컬럼으로 필드를 지정
	private String human;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT")
	// mysql의 LONGTEXT 처리를 위해서 타입을 지정해줌
	private String contents;

	@Column(nullable = false) // 테이블에 컬럼으로 필드를 지정
	private String line;

	@Column(nullable = false) // 테이블에 컬럼으로 필드를 지정
	private long count;

	@Column(nullable = false) // 테이블에 컬럼으로 필드를 지정
	private long reportingDate;
	
	// List<CommentEntity> comments;

}

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
@Table(name = "ranking") // 연결되는 테이블 이름 정의
@NoArgsConstructor // 생성자의 매개변수가 없다
@Data // 롬복으로 getter, setter 자동 생성
public class RankingEntity {

	@Id // 테이블의 pk임을 지정
	@GeneratedValue(strategy = GenerationType.AUTO) // 자동증가 컬럼
	private int id;

	@Column(nullable = false, updatable = false) // 테이블에 컬럼으로 필드를 지정
	private String teamLogo;

	@Column(nullable = false)
	private String team;

	@Column(nullable = false)
	// mysql의 LONGTEXT 처리를 위해서 타입을 지정해줌
	private String victory;

	@Column(nullable = false) // 테이블에 컬럼으로 필드를 지정
	private String defeat;

	@Column(nullable = false) // 테이블에 컬럼으로 필드를 지정
	private String draw;
	
	@Column(nullable = false) // 테이블에 컬럼으로 필드를 지정
	private String odds;
	
	@Column(nullable = false) // 테이블에 컬럼으로 필드를 지정
	private String gamesBehind;
}

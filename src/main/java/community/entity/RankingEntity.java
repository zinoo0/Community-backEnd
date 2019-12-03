package community.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // �����ͺ��̽� ����Ǵ� ��ü��
@Table(name = "ranking") // ����Ǵ� ���̺� �̸� ����
@NoArgsConstructor // �������� �Ű������� ����
@Data // �Һ����� getter, setter �ڵ� ����
public class RankingEntity {

	@Id // ���̺��� pk���� ����
	@GeneratedValue(strategy = GenerationType.AUTO) // �ڵ����� �÷�
	private int id;

	@Column(nullable = false, updatable = false) // ���̺� �÷����� �ʵ带 ����
	private String teamLogo;

	@Column(nullable = false)
	private String team;

	@Column(nullable = false)
	// mysql�� LONGTEXT ó���� ���ؼ� Ÿ���� ��������
	private String victory;

	@Column(nullable = false) // ���̺� �÷����� �ʵ带 ����
	private String defeat;

	@Column(nullable = false) // ���̺� �÷����� �ʵ带 ����
	private String draw;
	
	@Column(nullable = false) // ���̺� �÷����� �ʵ带 ����
	private String odds;
	
	@Column(nullable = false) // ���̺� �÷����� �ʵ带 ����
	private String gamesBehind;
}

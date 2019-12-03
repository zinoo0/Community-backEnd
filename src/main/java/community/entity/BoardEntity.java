package community.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity // �����ͺ��̽� ����Ǵ� ��ü��
@Table(name = "board_item") // ����Ǵ� ���̺� �̸� ����
@NoArgsConstructor // �������� �Ű������� ����
@Data // �Һ����� getter, setter �ڵ� ����
public class BoardEntity {

	@Id // ���̺��� pk���� ����
	@GeneratedValue(strategy = GenerationType.AUTO) // �ڵ����� �÷�
	private long no;

	@Column(nullable = false, updatable = false) // ���̺� �÷����� �ʵ带 ����
	private String human;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT")
	// mysql�� LONGTEXT ó���� ���ؼ� Ÿ���� ��������
	private String contents;

	@Column(nullable = false) // ���̺� �÷����� �ʵ带 ����
	private String line;

	@Column(nullable = false) // ���̺� �÷����� �ʵ带 ����
	private long count;

	@Column(nullable = false) // ���̺� �÷����� �ʵ带 ����
	private long reportingDate;
	
	// List<CommentEntity> comments;

}

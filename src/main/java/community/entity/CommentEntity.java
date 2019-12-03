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
@Table(name = "comment_item") // ����Ǵ� ���̺� �̸� ����
@NoArgsConstructor // �������� �Ű������� ����
@Data // �Һ����� getter, setter �ڵ� ����
public class CommentEntity {

	@Id // ���̺��� pk���� ����
	@GeneratedValue(strategy = GenerationType.AUTO) // �ڵ����� �÷�
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

package pkg.member;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberVO {
	private String id;
	private String password;
	private String age;
	private String phone;
	private String area;
	private String desired_field;
	private String study_period;
	private String photo;
	private String grade;
	private String join_date;
}

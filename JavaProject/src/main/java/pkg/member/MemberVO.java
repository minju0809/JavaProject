package pkg.member;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberVO {
	private int memberCount;
	private String id;
	private String password;
	private String age;
	private String phone;
	private String region;
	private String desired_field;
	private String study_period;
	private String photo;
	private String grade;
	private String join_date;

//	public String getPassword() {
//		return password != null ? password : "";
//	}
//
//	public String getAge() {
//		return age != null ? age : "";
//	}
//
//	public String getPhone() {
//		return phone != null ? phone : "";
//	}
//
//	public String getRegion() {
//		return region != null ? region : "";
//	}
//
//	public String getDesired_field() {
//		return desired_field != null ? desired_field : "";
//	}
//
//	public String getStudy_period() {
//		return study_period != null ? study_period : "";
//	}

}

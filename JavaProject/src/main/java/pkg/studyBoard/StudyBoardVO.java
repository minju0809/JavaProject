package pkg.studyBoard;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StudyBoardVO {
	int study_board_number;
	String id;
	String study_board_title;
	String study_board_content;
}

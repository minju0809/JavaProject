package pkg.studyBoard;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StudyCommentBoardVO {
	int study_comment_board_number;
	String id;
	String study_comment_id;
	String study_comment_content;
}


package pkg.basicBoard;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BasicBoardVO {
    int boardNumber;
    String id;
    String title;
    String content;
    String regist_date;
    int cnt;
}

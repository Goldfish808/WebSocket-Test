package site.metacoding.red.web.dto.request.deadlist;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeadSaveDto {
	private Integer id;
	private String playername;
	private String position;
	private String reason;
	private Integer teamId;
	private Timestamp createdAt;
}

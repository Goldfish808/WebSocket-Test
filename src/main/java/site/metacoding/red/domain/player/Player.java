package site.metacoding.red.domain.player;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Player {
	private Integer id;
	private Integer ROWNUM;
	private String playername;
	private String position;
	private Integer teamId;
	private Timestamp createdAt;
}

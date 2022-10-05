package site.metacoding.red.web.dto.request.player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveDto {
	private String playername;
	private String position;
	private Integer teamId;
}

package site.metacoding.red.web.dto.response.player;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.domain.baseteam.Baseteam;

@Getter
@Setter
public class MainDto {
	private Integer id;
	private Integer ROWNUM;
	private String playername;
	private String position;
	private String teamname;
	private Integer teamId;
	private String stadiumname;
}

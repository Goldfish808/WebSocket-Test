package site.metacoding.red.domain.stadium;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stadium {
	private Integer id;
	private String stadiumname;
	private Integer teamId;
	private Timestamp createdAt;
}

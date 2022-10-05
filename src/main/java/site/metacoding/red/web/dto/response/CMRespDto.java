package site.metacoding.red.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CMRespDto<T> {
	private int code;
	private String msg;
	private T data;
}

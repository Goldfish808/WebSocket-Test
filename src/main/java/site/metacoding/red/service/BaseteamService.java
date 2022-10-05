package site.metacoding.red.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.baseteam.Baseteam;
import site.metacoding.red.domain.baseteam.BaseteamDao;
import site.metacoding.red.web.dto.response.player.MainDto;

@RequiredArgsConstructor
@Service
public class BaseteamService {
	
	private final BaseteamDao baseteamDao;
	
	public List<Baseteam> 목록보기() {
		List<Baseteam> teamList = baseteamDao.findAll();
		return teamList;
	}
	
	public Baseteam 구단찾기(Integer id) {
		Baseteam team = baseteamDao.findById(id);
		return team;
	}

}

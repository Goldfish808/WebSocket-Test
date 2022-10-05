package site.metacoding.red.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.baseteam.BaseteamDao;
import site.metacoding.red.domain.deadlist.DeadListDao;
import site.metacoding.red.domain.player.Player;
import site.metacoding.red.domain.player.PlayerDao;
import site.metacoding.red.web.dto.request.deadlist.DeadSaveDto;
import site.metacoding.red.web.dto.request.player.SaveDto;
import site.metacoding.red.web.dto.response.player.MainDto;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final PlayerDao playerDao;
	private final BaseteamDao baseteamDao;
	private final DeadListDao deadlistDao;

	public List<MainDto> 목록보기(Integer id) {
		List<MainDto> playerList = playerDao.findByTeamId(id);		
		return playerList;
	}

	public void 추가하기(SaveDto saveDto) {
		playerDao.insert(saveDto);
	}

	public Player 상세보기(Integer id, Integer principalId) {
		return playerDao.findById(id);
	}

	public void 수정하기(Integer id) {
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void 삭제하기(Integer id, DeadSaveDto saveDto) {
		playerDao.deleteById(id);
		deadlistDao.insert(saveDto);
	}

}

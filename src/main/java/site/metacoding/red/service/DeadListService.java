package site.metacoding.red.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.baseteam.BaseteamDao;
import site.metacoding.red.domain.deadlist.DeadList;
import site.metacoding.red.domain.deadlist.DeadListDao;
import site.metacoding.red.domain.player.Player;
import site.metacoding.red.domain.player.PlayerDao;
import site.metacoding.red.web.dto.request.deadlist.DeadSaveDto;
import site.metacoding.red.web.dto.request.player.SaveDto;
import site.metacoding.red.web.dto.response.player.MainDto;

@RequiredArgsConstructor
@Service
public class DeadListService {

	private final PlayerDao playerDao;
	private final BaseteamDao baseteamDao;
	private final DeadListDao deadlistDao;

	public List<DeadList> 목록보기() {
		List<DeadList> DeadList = deadlistDao.findAll();		
		return DeadList;
	}

	public void 추가하기(SaveDto saveDto) {
		playerDao.insert(saveDto);	
	}

	public Player 상세보기(Integer id, Integer principalId) {
		return playerDao.findById(id);
	}

	public void 수정하기(Integer id) {
	}

}

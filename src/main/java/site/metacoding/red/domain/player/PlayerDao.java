package site.metacoding.red.domain.player;

import java.util.List;

import site.metacoding.red.domain.baseteam.Baseteam;
import site.metacoding.red.web.dto.request.player.SaveDto;
import site.metacoding.red.web.dto.response.player.MainDto;

public interface PlayerDao {
	public void insert(SaveDto saveDto);
	public List<MainDto> findAll();
	public Player findById(Integer id);
	public void update(Player deadList);
	public void deleteById(Integer id);

	public List<MainDto> findByTeamId(Integer id);
}

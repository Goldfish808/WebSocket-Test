package site.metacoding.red.domain.baseteam;

import java.util.List;

public interface BaseteamDao {
	public void insert();
	public List<Baseteam> findAll();
	public Baseteam findById(Integer id);
	public void update(Baseteam baseTeam);
	public void deleteById(Integer id);
	public void updateByTeamId(Integer teamId);
}

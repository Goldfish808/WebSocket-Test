package site.metacoding.red.domain.stadium;

import java.util.List;

public interface StadiumDao {
	public void insert();
	public List<Stadium> findAll();
	public Stadium findById(Integer id);
	public void update(Stadium baseTeam);
	public void deleteById(Integer id);
	public void updateByTeamId(Integer teamId);
}

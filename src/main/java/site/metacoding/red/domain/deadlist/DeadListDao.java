package site.metacoding.red.domain.deadlist;

import java.util.List;

import site.metacoding.red.web.dto.request.deadlist.DeadSaveDto;

public interface DeadListDao {
	public void insert(DeadSaveDto saveDto);
	public List<DeadList> findAll();
	public DeadList findById(Integer id);
	public void update(DeadList deadList);
	public void deleteById(Integer id);
}

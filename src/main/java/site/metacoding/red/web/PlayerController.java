package site.metacoding.red.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.baseteam.BaseteamDao;
import site.metacoding.red.domain.player.PlayerDao;
import site.metacoding.red.service.BaseteamService;
import site.metacoding.red.service.PlayerService;
import site.metacoding.red.web.dto.request.deadlist.DeadSaveDto;
import site.metacoding.red.web.dto.request.player.SaveDto;
import site.metacoding.red.web.dto.response.CMRespDto;
import site.metacoding.red.web.dto.response.player.MainDto;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	private final BaseteamService baseteamService;
	
	@GetMapping({"/{id}", "/"}) //패스 벨리어블에 아무값이 안들어올 수 있다면, required = false 설정 
	public String findAll(@PathVariable(required = false) Integer id, Model model) {
		model.addAttribute("player",playerService.목록보기(id));
		model.addAttribute("teamList", baseteamService.목록보기());
		return "player/main";
	}
	
	@GetMapping("/find/{id}") //패스 벨리어블에 아무값이 안들어올 수 있다면, required = false 설정 
	public @ResponseBody CMRespDto<?>  findTeam(@PathVariable(required = false) Integer id,  Model model) {
		List<MainDto> list = playerService.목록보기(id);
		return new CMRespDto<>(1,"찾았습니다",list);
	}
	
	@PostMapping("/add")
	public @ResponseBody CMRespDto<?> joinPlayer(@RequestBody SaveDto saveDto) {
		playerService.추가하기(saveDto);
		return new CMRespDto<>(1,"선수영입 성공",null);
	}
	
	@DeleteMapping("/deletePlayer")
	public @ResponseBody CMRespDto<?> deletePlayer(@RequestBody List<Integer> id, DeadSaveDto saveDto) {
		for(Integer i :id) { //for each 문
			playerService.삭제하기(i, saveDto);
		}
		return new CMRespDto<>(1,"선수영입 성공",null);
	}
	
	//@GetMapping("/deadlist")

}

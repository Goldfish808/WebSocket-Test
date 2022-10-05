package site.metacoding.red.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.baseteam.Baseteam;
import site.metacoding.red.service.BaseteamService;
import site.metacoding.red.service.PlayerService;
import site.metacoding.red.web.dto.response.player.MainDto;

@RequiredArgsConstructor
@Controller
public class BaseteamController {
	private final BaseteamService baseteamService;
	private final PlayerService playerService;
	
	@GetMapping("/baseteam/{id}")
	public String findTeam(@PathVariable Integer id, Model model) {
		List<MainDto> list = playerService.목록보기(id);
		model.addAttribute("player", list);
		return "baseteam/team";
	}
}

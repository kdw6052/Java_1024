package kr.kh.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.service.BoardService;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value = "/board/insert", method = RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv,HttpServletRequest request) {
		//세션에서 회원 정보를 가져옴
		//=> 쓰기 권한잉 있는 게시판을 가져오기 위한 작업
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//사용자 권한에 맞는 게시판들을 가져옴
		ArrayList<BoardTypeVO> btList = boardService.getBoardType(user.getMe_authority());
		mv.addObject("btList",btList);
		//작성할 타입이 없으면 작성 페이지로 갈 필요가 없어서 게시글 리스트로 이동시킴
		if(btList.size()==0)
			mv.setViewName("redirect:/board/list");
		else
			mv.setViewName("/board/insert");
		return mv;
	}
	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv,BoardVO board,HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boardService.insertBoard(board,user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}

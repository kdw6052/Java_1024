package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.BoardService;
import kr.kh.test.utils.UploadFileUtils;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/insert", method = RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv, HttpServletRequest session) {
		MemberVO user = (MemberVO)session.getSession().getAttribute("user");
		ArrayList<BoardTypeVO> typeList = boardService.getBoardTypeList(user);
		mv.addObject("typeList", typeList);
		mv.setViewName("/board/insert");
		return mv;
	}
	
	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public ModelAndView boardInsert(ModelAndView mv,BoardVO board,HttpServletRequest session,
			MultipartFile []files) {
		MemberVO user = (MemberVO)session.getSession().getAttribute("user");
		String msg;
		if(boardService.insertBoard(board,user,files)) {
			msg = "게시글 등록 성공!";
		}else {
			msg = "게시글 등록 실패!";
		}
		mv.addObject("msg", msg);
		mv.addObject("url","/board/list");
		mv.setViewName("/common/message");
		return mv;
	}
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		mv.setViewName("/board/list");
		return mv;
	}
}

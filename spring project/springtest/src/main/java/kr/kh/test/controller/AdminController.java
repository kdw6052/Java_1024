package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.AdminService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.BoardTypeVO;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/admin/board/type/list")
	public ModelAndView boardType(ModelAndView mv) {
		ArrayList<BoardTypeVO> list = adminService.getBoardTypeListAll();
		mv.addObject("list", list);
		mv.setViewName("/admin/boardTypeList");
		return mv;
	}
	@RequestMapping(value = "/admin/board/type/insert", method = RequestMethod.POST)
	public ModelAndView adminBoardTypeInsert(ModelAndView mv,BoardTypeVO btVo,
			HttpServletResponse response, HttpServletRequest request) {
		//게시판 정보 확인하는 작업
		//서비스에게 게시판 정보를 주면서 등록하라고 요청한 후 등록 여부를 알려줌
		boolean isInsert = adminService.insertBoardType(btVo);
		if(isInsert) {
			//화면에 게시판 등록 성공 메세지 전송
			MessageUtils.alertAndMovePage(response, "새 게시판을 등록했습니다",
					request.getContextPath(), "/admin/board/type/list");
		}else {
			//화면에 게시판 등록 실패 메세지 전송
			MessageUtils.alertAndMovePage(response, "새 게시판 등록에 실패했습니다",
					request.getContextPath(), "/admin/board/type/list");
		}
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
	@RequestMapping(value = "/admin/board/type/update", method = RequestMethod.POST)
	public ModelAndView adminBoardTypeUpdate(ModelAndView mv,BoardTypeVO btVo,
			HttpServletResponse response, HttpServletRequest request) {
		boolean isUpdate= adminService.updateBoardType(btVo);
		if(isUpdate) {
			MessageUtils.alertAndMovePage(response, "게시판을 수정했습니다",
					request.getContextPath(), "/admin/board/type/list");
		}else {
			MessageUtils.alertAndMovePage(response, "게시판을 수정하지 못했습니다",
					request.getContextPath(), "/admin/board/type/list");
		}
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
}

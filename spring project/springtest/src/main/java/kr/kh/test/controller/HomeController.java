package kr.kh.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member) {
		boolean res = memberService.signup(member);
		
		if(res) {
			//성공했다고 알림 메시지(추후 구현 예정)
			System.out.println("회원가입 완료");
			mv.setViewName("redirect:/");
		}else {
			//실패했다고 알림 메시지(추후 구현 예정)
			System.out.println("회원가입 실패");
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value = "/email/authentication", method = RequestMethod.GET)
	public ModelAndView emailAuthentication(ModelAndView mv,MemberOKVO mok) {
		boolean res = memberService.emailAuthentication(mok);
		if(res) {
			//인증 성공 메시지
			System.out.println("인증성공");
		}else {
			//인증 실패 메세지
			System.out.println("인증실패");
		}
		mv.setViewName("redirect:/");
		return mv;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		
		mv.setViewName("/member/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv,MemberVO member) {
		MemberVO user = memberService.login(member);
		if(user != null && user.getMe_authority() > 0) {
			mv.addObject("user", user);
			mv.setViewName("redirect:/");
		}else {
			if(user != null) {
				//인증안된 회원이라고 알려주는 메세지
			}
			mv.setViewName("redirect:/login");
		}
		
		return mv;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logoutPost(ModelAndView mv, HttpSession session) {
		if(session != null)
			session.removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, MemberVO member) {
		
		mv.setViewName("/main/home");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package kr.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	String contextPath = "/test";
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member,
			HttpServletResponse response,HttpServletRequest request) {
		boolean res = memberService.signup(member);
		String msg,url;
		if(res) {
			//성공했다고 알림 메시지(추후 구현 예정)
			//MessageUtils.alertAndMovePage(response,"회원가입에 성공했습니다." ,
			//		request.getContextPath(), "/");
			msg="회원가입에 성공했습니다.";
			url="/";
			
		}else {
			//실패했다고 알림 메시지(추후 구현 예정)
			//MessageUtils.alertAndMovePage(response,"회원가입에 실패했습니다." ,
			//		request.getContextPath(), "/signup");
			msg="회원가입에 실패했습니다.";
			url="/signup";
		}
		mv.addObject("url",url);
		mv.addObject("msg", msg);
		mv.setViewName("/common/message");
		return mv;
	}
	@RequestMapping(value = "/email/authentication", method = RequestMethod.GET)
	public ModelAndView emailAuthentication(ModelAndView mv,MemberOKVO mok,
			HttpServletResponse response,HttpServletRequest request) {
		boolean res = memberService.emailAuthentication(mok);
		if(res) {
			//인증 성공 메시지
			MessageUtils.alertAndMovePage(response,"이메일 인증에 성공했습니다." ,
					request.getContextPath(), "/");
		}else {
			//인증 실패 메세지
			MessageUtils.alertAndMovePage(response,"이메일 인증에 실패했습니다." ,
					request.getContextPath(), "/");
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
	public ModelAndView loginPost(ModelAndView mv,MemberVO member,
			HttpServletResponse response,HttpServletRequest request) {
		MemberVO user = memberService.login(member);
		String msg,url;
		if(user != null && user.getMe_authority() > 0) {
			user.setAutoLogin(member.isAutoLogin());
			mv.addObject("user", user);
			msg="로그인에 성공했습니다.";
			url="/";
		}else {
			url="/login";
			if(user != null) {
				//인증안된 회원이라고 알려주는 메세지
				msg="이메일 인증을 완료해야 로그인이 가능합니다.";
				
			}else {
				msg="로그인에 실패했습니다.";
			}
		}
		mv.addObject("url",url);
		mv.addObject("msg", msg);
		mv.setViewName("/common/message");
		return mv;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logoutPost(ModelAndView mv, HttpSession session,
			HttpServletResponse response,HttpServletRequest request) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(session != null) {
			user.setMe_session_limit(null);
			memberService.updateMemberByEndSession(user);
			session.removeAttribute("user");
		}
		MessageUtils.alertAndMovePage(response,"로그아웃에 성공했습니다." ,
				request.getContextPath(), "/");
		mv.setViewName("redirect:/");
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/check/id", method = RequestMethod.POST)
	public Map<String,Object> checkId(@RequestBody MemberVO user) {
		Map<String,Object> map = new HashMap<String,Object>();
		boolean res = memberService.checkId(user);
		map.put("res", res);
		return map;
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, MemberVO member) {
		
		mv.setViewName("/main/home");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

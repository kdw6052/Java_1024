package kr.kh.test.service;

import java.util.ArrayList;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	ArrayList<CommentVO> getCommentList(Criteria cri, int bo_num);

	int getTotalCountCommentList(int bo_num);

	

}

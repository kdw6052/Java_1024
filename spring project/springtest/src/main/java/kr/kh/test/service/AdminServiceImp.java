package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.vo.BoardTypeVO;

@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public ArrayList<BoardTypeVO> getBoardTypeListAll() {
		final int adminAuthority = 9;//관리자 권한
		return boardDao.selectBoardTypeList(adminAuthority);
	}

	@Override
	public boolean insertBoardType(BoardTypeVO bt) {
		
		if(!checkBoardType(bt))
			return false;
		
		//다오에게 게시판 정보를 주면서 db에 추가하라고 요청한 후, 성공 여부를 가져옴
		int res = boardDao.insertBoardType(bt);
		return res != 0;
	}

	@Override
	public boolean updateBoardType(BoardTypeVO bt) {
		
		if(!checkBoardType(bt))
			return false;
		if(bt.getBt_num() < 1)
			return false;
		
		int res = boardDao.updateBoardType(bt);
		return res != 0;
		
	}
	//BoardTypeVO 체크(bt_num제외)
	private boolean checkBoardType(BoardTypeVO bt) {
		//bt null 체크
		if(bt == null)
			return false;
		//게시판 타입 체크
		if(bt.getBt_type() == null ||(!bt.getBt_type().equals("일반") 
				&& !bt.getBt_type().equals("이미지")))
			return false;
		//게시판 읽기 권한 체크
		if(bt.getBt_r_authority() != 0 && bt.getBt_r_authority() != 1 &&
				bt.getBt_r_authority() != 9)
			return false;
		//게시판 쓰기 권한 체크
		if(bt.getBt_w_authority() != 1 && bt.getBt_w_authority() != 9)
			return false;
		//게시판명 체크(null체크)
		if(bt.getBt_name() == null || bt.getBt_name().trim().length() ==0)
			return false;
		//게시판 중복 체크
		//다오에게 게시판 명을 주면서 게시판 정보를 가져오라고 시킴
		BoardTypeVO dbBt = boardDao.seletBoardTypeByName(bt.getBt_name());
		
		//가져온 게시판이 있는경우
		//1. 서로 다른 게시판
		if(dbBt != null && bt.getBt_num() != dbBt.getBt_num())
			return false;
		
		return true;
	}

}

package kr.kh.test.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.pagination.Criteria;
import kr.kh.test.utils.UploadFileUtils;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\uploadfiles";

	@Override
	public ArrayList<BoardTypeVO> getBoardTypeList(MemberVO user) {
		if(user == null || user.getMe_authority() ==0)
			return null;
		return boardDao.selectBoardTypeList(user.getMe_authority());
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user == null || user.getMe_authority() == 0)
			return false;
		if(board == null || board.getBo_title().trim().length() ==0 ||
				board.getBo_content().trim().length() ==0 ||
				board.getBo_bt_num() == 0)
			return false;
		board.setBo_me_id(user.getMe_id());
		int isOk = boardDao.insertBoard(board);
		if(isOk == 0)
			return false;
		//첨부파일 추가
		String path = "";
		for(MultipartFile file : files) {
			if(file == null || file.getOriginalFilename().length() == 0)
				continue;
			try {
				
				path = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(board.getBo_num(),file.getOriginalFilename(), path);
				boardDao.insertFile(fileVo);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	private void uploadFile(BoardVO board, MultipartFile[] files) {
		String path = "";
		for(MultipartFile file : files) {
			try {
				if(file.getOriginalFilename().length() == 0) {
					continue;
				}else {
					path = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					FileVO fileVo = new FileVO(board.getBo_num(),file.getOriginalFilename(), path);
					boardDao.insertFile(fileVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		cri = cri == null ? new Criteria() : cri;
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getTotalBoardList(Criteria cri) {
		cri = cri == null ? new Criteria() : cri;
		return boardDao.selectTotalCountBoard(cri);
	}
	
	

	
}

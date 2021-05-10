package me.helpeachother.springbootmybatis.board.service;

import me.helpeachother.springbootmybatis.board.dto.BoardDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {
    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

    BoardDto selectBoardDetail(int boardIdx) throws Exception;

    void deleteBoard(int boardIdx) throws Exception;

    void updateBoard(BoardDto board) throws Exception;
}

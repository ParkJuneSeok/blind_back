package com.blind.back.blind_back.board.act;

import com.blind.back.blind_back.board.biz.BoardRepository;
import com.blind.back.blind_back.board.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController  {

    private final BoardRepository boardRepository;

    @GetMapping("/list")
    public String index(Model m) {
        List<Board> boardList = boardRepository.findAll();
        m.addAttribute("list", boardList);
        return "board/list";
    }
}

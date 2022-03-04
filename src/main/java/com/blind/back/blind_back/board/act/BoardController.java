package com.blind.back.blind_back.board.act;

import com.blind.back.blind_back.board.repo.BoardRepository;
import com.blind.back.blind_back.board.entity.Board;
import com.blind.back.blind_back.board.validator.BoardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController  {

    private final BoardRepository boardRepository;
    private final BoardValidator boardValidator;

    @GetMapping("/list")
    public String index(@PageableDefault(size=5) Pageable pageable, Model m) {
        Page<Board> board = boardRepository.findAll(pageable);

        int firstPage = Math.max(1, board.getPageable().getPageNumber() - 4);
        int lastPage = Math.min(board.getTotalPages(), board.getPageable().getPageNumber() + 4);

        m.addAttribute("firstPage", firstPage);
        m.addAttribute("lastPage", lastPage);
        m.addAttribute("list", board);
        return "board/list";
    }

    @GetMapping("/insert")
    public String insertV(Model m, @RequestParam(required = false) Long no) {
        Board b = new Board();
        if(no != null) {
            b = boardRepository.findById(no).orElse(null);
        }

        m.addAttribute("board", b);
        return "board/insert";
    }

    @PostMapping("/insert")
    public String insertA(@Valid Board board, BindingResult bind) {
        boardValidator.validate(board, bind);
        if(bind.hasErrors()) {
            return "board/insert";
        }

        boardRepository.save(board);
        return "redirect:/board/list";
    }
}

package com.blind.back.blind_back.board.act;

import com.blind.back.blind_back.board.entity.Board;
import com.blind.back.blind_back.board.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {

    private final BoardRepository boardRepository;

    @GetMapping("/board")
    List<Board> all(@RequestParam(required=false) String title) {
        if(StringUtils.isEmpty(title)) {
            return boardRepository.findAll();
        } else {
            return boardRepository.findByTitle(title);
        }
    }

    @PostMapping("/board")
    Board newEmployee(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    // Single item
    @GetMapping("/board/{id}")
    Board one(@PathVariable Long id) {
        return boardRepository.findById(id).orElseThrow(() -> null);
    }

    @PutMapping("/board/{id}")
    Board replaceEmployee(@RequestBody Board board, @PathVariable Long id) {
        return boardRepository.findById(id).map(initBoard -> {
                    System.out.println(initBoard.getNo());
                    initBoard.setTitle(board.getTitle());
                    initBoard.setContents(board.getContents());
                    return boardRepository.save(initBoard);
                }).orElseGet(() -> {
                    board.setNo(id);
                    return boardRepository.save(board);
                });
    }

    @DeleteMapping("/board/{id}")
    void deleteEmployee(@PathVariable Long id) {
        boardRepository.deleteById(id);
    }
}

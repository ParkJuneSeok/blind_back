package com.blind.back.blind_back.board.act;

import com.blind.back.blind_back.board.entity.Board;
import com.blind.back.blind_back.board.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {

    private final BoardRepository boardRepository;


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/board")
    List<Board> all() {
        return boardRepository.findAll();
    }
    // end::get-aggregate-root[]

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
    Board replaceEmployee(@RequestBody Board board, @PathVariable Long no) {

        return boardRepository.findById(no)
                .map(board1 -> {
                    board1.setTitle(board.getTitle());
                    board1.setContents(board.getContents());
                    return boardRepository.save(board);
                })
                .orElseGet(() -> {
                    board.setNo(no);
                    return boardRepository.save(board);
                });
    }

    @DeleteMapping("/board/{id}")
    void deleteEmployee(@PathVariable Long id) {
        boardRepository.deleteById(id);
    }
}

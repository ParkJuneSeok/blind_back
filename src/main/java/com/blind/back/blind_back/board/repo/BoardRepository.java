package com.blind.back.blind_back.board.repo;

import com.blind.back.blind_back.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Date : 2022-02-15
 **/
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitle(String title);

    Page<Board> findByTitleContainingOrContentsContaining(String title, String contents, Pageable pageable);
}

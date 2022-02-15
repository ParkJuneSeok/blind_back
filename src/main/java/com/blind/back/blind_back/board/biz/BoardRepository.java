package com.blind.back.blind_back.board.biz;

import com.blind.back.blind_back.board.vo.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Date : 2022-02-15
 **/

public interface BoardRepository extends JpaRepository<Board, Long> {

}

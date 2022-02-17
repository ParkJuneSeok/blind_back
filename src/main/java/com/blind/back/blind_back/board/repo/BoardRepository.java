package com.blind.back.blind_back.board.repo;

import com.blind.back.blind_back.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Date : 2022-02-15
 **/
public interface BoardRepository extends JpaRepository<Board, Long> {

}

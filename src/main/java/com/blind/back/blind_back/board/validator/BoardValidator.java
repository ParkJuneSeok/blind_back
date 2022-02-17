package com.blind.back.blind_back.board.validator;


import com.blind.back.blind_back.board.entity.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /*ValidationUtils.rejectIfEmpty();*/

        Board b = (Board) target;

        if(StringUtils.isEmpty(b.getTitle())) {
            errors.rejectValue("contents", "key", "제목을 입력하세요.");
        }

        if(StringUtils.isEmpty(b.getContents())) {
            errors.rejectValue("contents", "key", "내용을 입력하세요.");
        }
    }
}

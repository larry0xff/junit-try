package com.larry.junittry.controller;

import com.larry.junittry.dao.SomethingsDAO;
import com.larry.junittry.dto.UpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/somethings")
public class SomethingsController {

    @Autowired
    private SomethingsDAO somethingsDAO;

    /**
     * 模拟数据库更新操作
     * @param update
     */
    @PostMapping("/update")
    public void updateSomething(@RequestBody UpdateDTO update) {
        ofNullable(update).map(UpdateDTO::getNewName).ifPresent(n -> somethingsDAO.updateName(n));
        ofNullable(update).map(UpdateDTO::getNewNum).ifPresent(n -> somethingsDAO.updateNum(n));
    }
}

package com.larry.junittry.dao;

import com.larry.junittry.entity.Database;
import org.springframework.stereotype.Repository;

@Repository("somethingsDAO")
public class SomethingsDAO {

    public static Database DATABASE = new Database();

    static {
        DATABASE.setName("初始化");
        DATABASE.setNum(0);
    }

    public void updateName(String name) {
        DATABASE.setName(name);
    }

    public void updateNum(Integer num) {
        DATABASE.setNum(num);
    }
}

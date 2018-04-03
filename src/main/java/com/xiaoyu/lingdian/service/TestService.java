package com.xiaoyu.lingdian.service;

import com.xiaoyu.lingdian.entity.Test;

public interface TestService {

    void saveTest();

    Test judgeByGrade(int id) throws Exception;

    Integer getGradeById(int id);

}

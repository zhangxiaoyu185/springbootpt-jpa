package com.xiaoyu.lingdian.service.impl;

import com.xiaoyu.lingdian.core.exception.BusinessException;
import com.xiaoyu.lingdian.entity.Test;
import com.xiaoyu.lingdian.enums.BusinessExceptionEnum;
import com.xiaoyu.lingdian.repository.TestRepository;
import com.xiaoyu.lingdian.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

    /**
     * 测试表
     */
    @Autowired
    private TestRepository testRepository;

    @Transactional
    @Override
    public void saveTest() {
        Test test = new Test();
        test.setId(1);
        test.setName("测试1");
        testRepository.save(test);

        test = new Test();
        test.setId(2);
        test.setName("测试2");
        testRepository.save(test);
    }

    @Override
    public Test judgeByGrade(int id) throws Exception{
        Test test = testRepository.findById(id).get();
        if(null == test) {
            throw  new BusinessException(BusinessExceptionEnum.NO_DATA);
        } else if(test.getGrade() < 3){
            throw  new BusinessException(BusinessExceptionEnum.RANK_DEFICIENT);
        }
        return test;
    }

    @Override
    public Integer getGradeById(int id){
        Test test = testRepository.findById(id).get();
        if(null == test) {
            return null;
        } else {
            return test.getGrade();
        }
    }
}

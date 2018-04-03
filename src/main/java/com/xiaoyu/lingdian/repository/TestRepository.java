package com.xiaoyu.lingdian.repository;

import com.xiaoyu.lingdian.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer>{

    List<Test> findByName(String name);

    List<Test> findByGrade(Integer grade);

}

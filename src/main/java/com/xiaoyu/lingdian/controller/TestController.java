package com.xiaoyu.lingdian.controller;

import com.xiaoyu.lingdian.config.CustomTestConfig;
import com.xiaoyu.lingdian.entity.Test;
import com.xiaoyu.lingdian.repository.TestRepository;
import com.xiaoyu.lingdian.response.RespModel;
import com.xiaoyu.lingdian.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Value("${customtest}")
    private String customtest;

    @Value("${customtest1}")
    private String customtest1;

    @Autowired
    CustomTestConfig customTestConfig;

    /**
     * 测试表
     */
    @Autowired
    private TestRepository testRepository;

    /**
     * 测试service
     */
    @Autowired
    private TestService testService;

    /**
     * 根据主键获取单个
     *
     * @param id id
     * @return
     */
    @GetMapping(value = "/views/by/id/{id}")
    public RespModel viewsTestById(
            @PathVariable(value = "id", required = true) Integer id) {
        return RespModel.success("获取单个信息成功", testRepository.findById(id));
    }

    /**
     * 根据name获取单个
     *
     * @param name name
     * @return
     */
    @GetMapping(value = "/views/by/name/{name}")
    public RespModel viewsTestByName(
            @PathVariable(value = "name", required = true) String name) {
        return RespModel.success("获取单个信息成功", testRepository.findByName(name));
    }

    /**
     * 添加(测试验证)
     *
     * @return
     */
    @PostMapping(value = "/add")
    public RespModel add(@Valid Test test, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return RespModel.failure(bindingResult.getFieldError().getDefaultMessage());
        }

        testRepository.save(test);

        return RespModel.success("添加成功");
    }

    /**
     * 保存(测试事物)
     *
     * @return
     */
    @PostMapping(value = "/save")
    public RespModel save() {
        testService.saveTest();
        return RespModel.success("保存成功");
    }

    /**
     * 判断等级，返回数据
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/judge/by/grade/{id}")
    public RespModel judgeByGrade(@PathVariable("id") Integer id) throws Exception{
        Test test = testService.judgeByGrade(id);
        return RespModel.success("查询成功", test);
    }
}
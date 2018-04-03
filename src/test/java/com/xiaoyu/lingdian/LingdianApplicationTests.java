package com.xiaoyu.lingdian;

import com.xiaoyu.lingdian.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LingdianApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TestService testService;

	@Test
	public void judgeByGradeTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/test/judge/by/grade/3"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("3"));
	}

	@Test
	public void findOneTest() {
		Integer grade = testService.getGradeById(2);
		Assert.assertEquals(new Integer(2), grade);
	}

	@Test
	public void contextLoads() {
	}

}

package com.example.jpapractice;

import com.example.jpapractice.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
//@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserService.class)
public class JpaPracticeApplicationTests {
/////
//    @Autowired
//    private MockMvc mvc;
//    @Test
//    @DisplayName("테스트 메서드")
//    public void contextLoads() throws Exception {
//
//    }

}

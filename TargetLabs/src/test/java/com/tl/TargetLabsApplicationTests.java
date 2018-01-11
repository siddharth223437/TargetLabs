package com.tl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TargetLabsApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired 
	private WebApplicationContext wac;
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void uploadFileTest() throws Exception{
		InputStream uploadStream = TargetLabsApplicationTests.class.getClassLoader().getResourceAsStream("Person-10001.xlsx");
		MockMultipartFile file = new MockMultipartFile("file", uploadStream);
		assert uploadStream !=null;
		this.mockMvc.perform(fileUpload("/upload").file(file)).andExpect(status().isOk());
	}

}

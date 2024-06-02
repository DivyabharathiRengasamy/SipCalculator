package com.divi.spi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.sipCalculator.pojo.*;

class SipCalculatorTest {

	
	MockMvc mockmvc;

    @BeforeEach
    public void setup() {
    	 SIPController sipController = new SIPController();
        mockmvc = MockMvcBuilders.standaloneSetup(sipController).build();
    }


	@Test
	void testGetParams() throws Exception {

	mockmvc.perform(get("/SipCalculator"))
	.andExpect(status().isOk())
	.andExpect(view()
	.name("SipCalculator.html"));
	}
	
	@Test
	public void testReturnResult() throws  Exception{
		Parameters params=new Parameters();
		params.setInterest(10);
		params.setNoOfyears(10);
		params.setPrincipal(9000);
		mockmvc.perform(post("/SipCalculator").flashAttr("params", params))
				.andExpect(status().isOk())
				.andExpect(view().name("SipCalculator.html"))
				.andExpect(model().attributeExists("amount"))
				.andExpect(model().attributeExists("interestEarned"))
				.andExpect(model().attributeExists("principal"));
				
			
	}

}

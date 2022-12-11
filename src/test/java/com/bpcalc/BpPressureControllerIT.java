package com.bpcalc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BpPressureController.class)
class BpPressureControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShowIndex() throws Exception {
      this.mockMvc
        .perform(get("/"))
        .andExpect(status().isOk());
    }

    @Test
    void testShowHistory() throws Exception {
      this.mockMvc
        .perform(get("/history"))
        .andExpect(status().isOk());
    }

    @Test
    void testUpdateIndex() throws Exception {
        this.mockMvc
        .perform(post("/")
        .param("systolic", "120")
        .param("diastolic", "80"))
        .andExpect(status().isOk());
    }
}

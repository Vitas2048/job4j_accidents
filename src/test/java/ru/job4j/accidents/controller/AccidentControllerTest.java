package ru.job4j.accidents.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.accidents.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class AccidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String id = "1";

    @Test
    @WithMockUser
    public void whenUpdatePage() throws Exception {
        this.mockMvc.perform(get("/formUpdateAccident?id={ID}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/formUpdateAccident"));
    }

    @Test
    @WithMockUser
    public void whenCreatePage() throws Exception {
        this.mockMvc.perform(get("/createAccident"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("createAccident"));
    }

    @Test
    @WithMockUser
    public void whenEditPage() throws Exception {
        this.mockMvc.perform(get("/edit/{ID}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/editAccident"));
    }
}
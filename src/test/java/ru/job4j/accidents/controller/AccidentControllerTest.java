package ru.job4j.accidents.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.accidents.Main;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.AccidentService;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ActiveProfiles("main")
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class AccidentControllerTest {

    @MockBean
    private AccidentService accidentService;

    @Autowired
    private MockMvc mockMvc;

    private final String id = "1";

    @Test
    @WithMockUser
    public void whenUpdatePage() throws Exception {
        when(accidentService.getById(1)).thenReturn(Optional.of(new Accident()));
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
        when(accidentService.getById(1)).thenReturn(Optional.of(new Accident()));
        this.mockMvc.perform(get("/edit/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/editAccident"));
    }

    @Test
    @WithMockUser
    public void whenSaveNew() throws Exception {
        this.mockMvc.perform(post("/saveAccident")
                        .param("name", "Accident"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Accident> argument = ArgumentCaptor.forClass(Accident.class);
        verify(accidentService).save(argument.capture());
        assertThat(argument.getValue().getName(), is("Accident"));
    }

    @Test
    @WithMockUser
    public void whenEdit() throws Exception {
        this.mockMvc.perform(post("/update")
                        .param("name", "Accident"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Accident> argument = ArgumentCaptor.forClass(Accident.class);
        verify(accidentService).save(argument.capture());
        assertThat(argument.getValue().getName(), is("Accident"));
    }
}
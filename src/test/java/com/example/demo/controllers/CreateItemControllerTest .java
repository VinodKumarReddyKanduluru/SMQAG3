package com.example.demo.controllers;  

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class CreateItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateItemForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/create-item"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("create-item"));

        System.out.println("testCreateItemForm ran successfully");
    }

    @Test
    void testCreateItemSubmit_ValidData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/create-item")
                .param("item_name", "Test Item")
                .param("item_price", "10.99")
                .param("item_id", "https://shorturl.at/tACY2")
                .param("item_description", "Description")
                .param("veg_non_veg", "veg")
                .param("item_category", "burger"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
        // Add more assertions as needed

        System.out.println("testCreateItemSubmit_ValidData ran successfully");
    }

    @Test
    void testCreateItemSubmit_InvalidData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/create-item"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrors("menu", "item_name"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrors("menu", "item_price"));
        // Add more assertions for other invalid cases

        System.out.println("testCreateItemSubmit_InvalidData ran successfully");
    }
}

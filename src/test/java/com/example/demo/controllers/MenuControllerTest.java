package com.example.demo.controllers;

import com.example.controllers.MenuController;
import com.example.model.Menu;
import com.example.service.MenuService; // Make esure to import the correct packag
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuControllerTest {

    @Mock
    private MenuService menuService;

    @InjectMocks
    private MenuController menuController;

    @Test
    void testGetAllMenus() {
        // Mock data
        List<Menu> mockMenus = new ArrayList<>();
        // Add menu items to mockMenus...

        // Mock the behavior of menuService.getAllMenus()
        Mockito.when(menuService.getAllMenus()).thenReturn(mockMenus);

        // Mock Model
        Model model = Mockito.mock(Model.class);

        // Call the method to test
        String viewName = menuController.getAllMenus(model);

        // Verify that the correct view name is returned
        assertEquals("menuList", viewName);

        // Verify that the model attribute is set correctly
        Mockito.verify(model, Mockito.times(1)).addAttribute("menus", mockMenus);
    }
}

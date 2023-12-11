import com.example.controllers.ItemController;
import com.example.model.Menu;
import com.example.service.MenuService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemControllerTest {

    @Mock
    private MenuService menuService;

    @InjectMocks
    private ItemController itemController;

    @Test
    void testDisplayMenu() {
        // Mock data
        List<Menu> mockMenus = new ArrayList<>();
        // Add menu items to mockMenus...

        // Mock the behavior of menuService.getAllMenus()
        Mockito.when(menuService.getAllMenus()).thenReturn(mockMenus);

        // Mock Model
        Model model = Mockito.mock(Model.class);

        // Call the method to test
        String viewName = itemController.displayMenu(model);

        // Verify that the correct view name is returned
        assertEquals("display-menu", viewName);

        // Verify that the model attribute is set correctly
        Mockito.verify(model, Mockito.times(1)).addAttribute("menus", mockMenus);
    }
}

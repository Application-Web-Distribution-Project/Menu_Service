package com.esprit.microservice.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }
    public Menu getById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));
    }

    public Menu updateMenu(Long id, Menu newMenu) {
        Optional<Menu> existingMenuOptional = menuRepository.findById(id);
        if (existingMenuOptional.isPresent()) {
            Menu existingMenu = existingMenuOptional.get();
            existingMenu.setName(newMenu.getName());
            existingMenu.setDescription(newMenu.getDescription());
            existingMenu.setPrice(newMenu.getPrice());
            return menuRepository.save(existingMenu);
        } else {
            return null;
        }
    }

    public String deleteMenu(Long id) {
        if (menuRepository.findById(id).isPresent()) {
            menuRepository.deleteById(id);
            return "Menu deleted";
        } else {
            return "Menu not found, deletion failed";
        }
    }
    private final String apiKey = "f34e45d241754dd1947ebd1ebfe15e2e"; // Your Spoonacular API key

    // Method to get similar recipes
    public String getSimilarRecipes(String dishName) {
        String url = "https://api.spoonacular.com/recipes/complexSearch?query=" + dishName +
                "&number=3&apiKey=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody(); // Return the response body (JSON with similar recipes)
    }

    // Method to get nutrition info by recipe ID
    public String getNutritionInfo(int recipeId) {
        String url = "https://api.spoonacular.com/recipes/" + recipeId + "/nutritionWidget.json?apiKey=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody(); // Return the nutrition info
    }
}

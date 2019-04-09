package loc.mark52.managermoney.service;

import loc.mark52.managermoney.data.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    List<Category> findAll();
}

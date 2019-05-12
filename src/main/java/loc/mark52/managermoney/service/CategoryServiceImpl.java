package loc.mark52.managermoney.service;

import loc.mark52.managermoney.data.entity.Category;
import loc.mark52.managermoney.data.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category edit(long id, Category newCategory) {
        Category category = categoryRepository.findById(id)
                .map(c -> {
                    c.setName(newCategory.getName());
                    c.setCapacity(newCategory.getCapacity());
                    return c;
                }).orElse(newCategory);

        return categoryRepository.save(category);
    }
}

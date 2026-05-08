package com.turkcell.library_cqrs.application.features.category.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Category;
import com.turkcell.library_cqrs.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateCategoryHandler implements CommandHandler<CreateCategoryCommand, CreateCategoryResponse> {

    private final CategoryRepository repository;

    public CreateCategoryHandler(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateCategoryResponse handle(CreateCategoryCommand request) {
        Category entity = new Category();
        entity.setName(request.getName());
        
        entity = repository.save(entity);
        return new CreateCategoryResponse(entity.getId());
    }
}

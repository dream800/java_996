package com.dream.service.solo;

import com.dream.entity.dto.Result;
import com.dream.entity.vo.Category;
import com.dream.entity.vo.HeadLine;

import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
public interface CategoryService {

    Result<Boolean> create(Category category);

    Result<Boolean> delete(int id);


    Result<Boolean> edit(Category category);

    Result<Category> getById(int id);


    Result<List<Category>> getAll(Category category);

    Result<List<Category>> getAll(Category category, int page, int size);

}

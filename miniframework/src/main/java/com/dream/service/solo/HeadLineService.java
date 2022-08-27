package com.dream.service.solo;

import com.dream.entity.dto.Result;
import com.dream.entity.vo.HeadLine;

import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
public interface HeadLineService {

    Result<Boolean> create(HeadLine headLine);

    Result<Boolean> delete(int id);


    Result<Boolean> edit(HeadLine headLine);



    Result<HeadLine> getById(int id);


    Result<List<HeadLine>> getAll(HeadLine headLine);

    Result<List<HeadLine>> getAll(HeadLine headLine, int page, int size);




}

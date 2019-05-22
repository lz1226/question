package com.paper.question.dao.mapper;


import com.paper.question.domain.dto.common.ImageResource;

public interface ImageResourceMapper {

    int insertSelective(ImageResource resource);

    ImageResource findImageResource(Integer resourceId);
}
package com.ale.udemyspring.dto

import com.ale.udemyspring.entity.Category
import dev.krud.shapeshift.enums.AutoMappingStrategy
import dev.krud.shapeshift.resolver.annotation.AutoMapping

@AutoMapping(Category::class, strategy = AutoMappingStrategy.BY_NAME)
data class CategoryDto(val name: String?, val description: String?)

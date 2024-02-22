package com.ale.udemyspring.entity

import com.ale.udemyspring.dto.CategoryDto
import dev.krud.shapeshift.enums.AutoMappingStrategy
import dev.krud.shapeshift.resolver.annotation.AutoMapping
import dev.krud.shapeshift.resolver.annotation.DefaultMappingTarget
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "category")
@AutoMapping(CategoryDto::class, strategy = AutoMappingStrategy.BY_NAME)
@DefaultMappingTarget(CategoryDto::class)
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String?,
    var description: String?,
    private val serialVersionUID: Long = -687991492884005033L
) : Serializable {}
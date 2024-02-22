package com.ale.udemyspring.controller

import com.ale.udemyspring.dto.CategoryDto
import com.ale.udemyspring.entity.Category
import com.ale.udemyspring.services.CategoryService
import dev.krud.shapeshift.ShapeShiftBuilder
import dev.krud.shapeshift.dsl.mapper
import dev.krud.shapeshift.enums.AutoMappingStrategy
import jakarta.persistence.Id
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/category")
class CategoryController {
    val shapeShift = ShapeShiftBuilder().build()

    @Autowired
    private lateinit var categoryService: CategoryService

    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableIterable<Category>> {
        val result = categoryService.getAll()
        return ResponseEntity(result, HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Category> {
        val result = categoryService.getById(id)
        return ResponseEntity(result, HttpStatus.OK)
    }
    @GetMapping("/name/{name}")
    fun getByName(@PathVariable name: String): ResponseEntity<Category> {
        val result = categoryService.getByName(name)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @PostMapping("/")
    fun saveCategory(@RequestBody categoryDto: CategoryDto): ResponseEntity<Category> {
        val category = shapeShift.map<CategoryDto,Category>(categoryDto)
        categoryService.saveCategory(category)
        return ResponseEntity(HttpStatus.OK)
    }
}
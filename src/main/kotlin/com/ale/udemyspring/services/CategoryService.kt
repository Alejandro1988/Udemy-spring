package com.ale.udemyspring.services

import com.ale.udemyspring.DuplicateCategoryException
import com.ale.udemyspring.dao.CategoryDao
import com.ale.udemyspring.entity.Category
import jakarta.persistence.Id
import jakarta.transaction.Transactional
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CategoryService {

    private val logger = KotlinLogging.logger {}
    @Autowired
    private lateinit var categoryDao: CategoryDao

    @Transactional
    fun getAll(): MutableIterable<Category> {
        logger.info { "CategoryService - searchAll" }
        return categoryDao.findAll()
    }

    @Transactional
    fun getById(id:Long): Category? {
        logger.info { "CategoryService - getByID" }
        return categoryDao.findByIdOrNull(id)
    }

    @Transactional
    fun getByName(name: String): Category? {
        logger.info { "CategoryService - getByName" }
        return categoryDao.findByName(name)
    }

    @Transactional
    fun saveCategory(category: Category) {
        logger.info { "CategoryService - saveCategory" }
        if (categoryDao.findByName(category.name) != null) throw DuplicateCategoryException("The category ${category.name} already exist")
        categoryDao.save(category)
    }
}
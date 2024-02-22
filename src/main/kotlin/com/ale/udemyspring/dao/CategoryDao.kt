package com.ale.udemyspring.dao

import com.ale.udemyspring.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryDao: JpaRepository<Category, Long> {
    fun findByName(name: String?): Category?
}
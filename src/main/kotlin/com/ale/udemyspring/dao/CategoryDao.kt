package com.ale.udemyspring.dao

import com.ale.udemyspring.entity.Category
import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository

interface CategoryDao: CrudRepository<Category, Id> {
}
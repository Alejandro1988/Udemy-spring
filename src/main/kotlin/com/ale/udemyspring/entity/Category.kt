package com.ale.udemyspring.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "category")
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String,
    var description: String,
    private val serialVersionUID: Long = -687991492884005033L
) : Serializable {
}
package com.example.webfluxpractice

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.relational.core.mapping.Table
import java.awt.Menu
import java.time.LocalDateTime

@Table(name = "users")
class User(
    val name : String,
    val age : Int,
) {
    @Id
    var id : Long = 0
        private set
    val profilePictureUrl : String? = null
    @CreatedDate
    var createdAt : LocalDateTime? = null
        private set
    @LastModifiedDate
    var updatedAt : LocalDateTime? = null
        private set

    override fun toString(): String {
        return "User(name='$name', age=$age, id=$id, profilePictureUrl=$profilePictureUrl, createdAt=$createdAt, updatedAt=$updatedAt)"
    }

}
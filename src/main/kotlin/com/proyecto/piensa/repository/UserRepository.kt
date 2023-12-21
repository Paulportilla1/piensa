package com.proyecto.piensa.repository

import com.proyecto.piensa.model.Notification
import com.proyecto.piensa.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long?> {
    fun findById (id: Long?): User?
}
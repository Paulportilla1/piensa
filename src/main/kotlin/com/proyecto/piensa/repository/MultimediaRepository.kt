package com.proyecto.piensa.repository

import com.proyecto.piensa.model.Multimedia
import com.proyecto.piensa.model.Notification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MultimediaRepository: JpaRepository<Multimedia, Long?> {
    fun findById (id: Long?): Multimedia?
}
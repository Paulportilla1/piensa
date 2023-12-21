package com.proyecto.piensa.repository

import com.proyecto.piensa.model.Notification
import com.proyecto.piensa.model.Progress
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProgressRepository: JpaRepository<Progress, Long?> {
    fun findById (id: Long?): Progress?
}
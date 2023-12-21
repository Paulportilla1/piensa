package com.proyecto.piensa.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "progress")
class Progress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var score: String? = null
    var date: Date? = null
}
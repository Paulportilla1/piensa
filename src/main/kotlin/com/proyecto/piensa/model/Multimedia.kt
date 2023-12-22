package com.proyecto.piensa.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "multimedia")
class Multimedia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var type1: String? = null
    var url: Date? = null
    @Column(name = "user1_id")
    var user1Id: Long? = null
}
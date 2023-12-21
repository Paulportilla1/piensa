package com.proyecto.piensa.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "user1")
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fullname: String? = null
    var age: String? = null
    var registration: String? = null
    var date: Date? = null
}


package com.proyecto.piensa.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "notification")
class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var read: String? = null
    var message: String? = null
}
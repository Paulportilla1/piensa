package com.proyecto.piensa.service

import com.proyecto.piensa.model.Notification
import com.proyecto.piensa.repository.NotificationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class NotificationService {
    @Autowired
    lateinit var notificationRepository: NotificationRepository

    fun list (pageable: Pageable, notification: Notification): Page<Notification> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return notificationRepository.findAll(Example.of(notification, matcher), pageable)
    }

    fun save(notification: Notification): Notification {
        try{
            notification.message?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return notificationRepository.save(notification)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(notification: Notification): Notification {
        try {
            notificationRepository.findById(notification.id)
                ?: throw Exception("ID no existe")

            return notificationRepository.save(notification)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(notification: Notification): Notification {
        try{
            val response = notificationRepository.findById(notification.id)
                ?: throw Exception("ID no existe")
            response.apply {
                read=notification.read
            }
            return notificationRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = notificationRepository.findById(id)

                ?: throw Exception("ID no existe")
            notificationRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?): Notification?{
        return notificationRepository.findById(id)
    }

}
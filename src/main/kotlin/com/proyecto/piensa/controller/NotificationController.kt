package com.proyecto.piensa.controller

import com.proyecto.piensa.model.Notification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notification")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class NotificationController {
    @Autowired
    lateinit var notificationService: NotificationService

    @GetMapping
    fun list (notification: Notification, pageable: Pageable):ResponseEntity<*>{
        val response= notificationService.list(pageable,notification)
        return ResponseEntity(response, HttpStatus.OK)
    }

//@RequestParam searchValue:String


//@RequestParam searchValue:String

    @PostMapping
    fun save (@RequestBody notification: Notification): ResponseEntity<Notification> {
        return ResponseEntity(notificationService.save(notification), HttpStatus.OK )
    }

    @PutMapping
    fun update (@RequestBody notification: Notification): ResponseEntity<Notification> {
        return ResponseEntity(NoService.update(client), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.updateName(client), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return clientService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(clientService.listById (id), HttpStatus.OK)

    }

}
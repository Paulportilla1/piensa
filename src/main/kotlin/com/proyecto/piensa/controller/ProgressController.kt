package com.proyecto.piensa.controller

import com.proyecto.piensa.model.Notification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/progress")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class ProgressController {
    @Autowired
    lateinit var progressService: ProgressService

    @GetMapping
    fun list (progress: Progress, pageable: Pageable):ResponseEntity<*>{
        val response= progressService.list(pageable,progress)
        return ResponseEntity(response, HttpStatus.OK)
    }

//@RequestParam searchValue:String


//@RequestParam searchValue:String

    @PostMapping
    fun save (@RequestBody progress: Progress): ResponseEntity<Progress> {
        return ResponseEntity(progressService.save(progress), HttpStatus.OK )
    }

    @PutMapping
    fun update (@RequestBody notification: Notification): ResponseEntity<Notification> {
        return ResponseEntity(NoService.update(notification), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody notification: Notification): ResponseEntity<Notification> {
        return ResponseEntity(notificationService.updateName(notification), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return notificationService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(notificationService.listById (id), HttpStatus.OK)

    }

}
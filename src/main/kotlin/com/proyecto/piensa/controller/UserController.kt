package com.proyecto.piensa.controller

import com.proyecto.piensa.model.Notification
import com.proyecto.piensa.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun list (user: User pageable: Pageable):ResponseEntity<*>{
        val response= userService.list(pageable,user)
        return ResponseEntity(response, HttpStatus.OK)
    }

//@RequestParam searchValue:String


//@RequestParam searchValue:String

    @PostMapping
    fun save (@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(userService.save(user), HttpStatus.OK )
    }

    @PutMapping
    fun update (@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(NoService.update(user), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(userService.updateName(user), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return userService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(userService.listById (id), HttpStatus.OK)

    }

}
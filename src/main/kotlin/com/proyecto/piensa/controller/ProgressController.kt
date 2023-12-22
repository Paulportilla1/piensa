package com.proyecto.piensa.controller

import com.proyecto.piensa.model.Progress
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun update (@RequestBody progress: Progress): ResponseEntity<Progress> {
        return ResponseEntity(NoService.update(progress), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody progress: Progress): ResponseEntity<Progress> {
        return ResponseEntity(progressService.updateName(progress), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return progressService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(progressService.listById (id), HttpStatus.OK)

    }

}
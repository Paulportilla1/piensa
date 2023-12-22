package com.proyecto.piensa.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/multimedia")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class MultimediaController {
    @Autowired
    lateinit var multimediaService: MultimediaService

    @GetMapping
    fun list (multimedia: Multimedia, pageable: Pageable):ResponseEntity<*>{
        val response= multimediaService.list(pageable,multimedia)
        return ResponseEntity(response, HttpStatus.OK)
    }

//@RequestParam searchValue:String


//@RequestParam searchValue:String

    @PostMapping
    fun save (@RequestBody multimedia: Multimedia): ResponseEntity<Multimedia> {
        return ResponseEntity(multimediaService.save(multimedia), HttpStatus.OK )
    }

    @PutMapping
    fun update (@RequestBody multimedia: Multimedia): ResponseEntity<Multimedia> {
        return ResponseEntity(multimediaService.update(multimedia), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody multimedia: Multimedia): ResponseEntity<Multimedia> {
        return ResponseEntity(multimediaService.updateName(multimedia), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return multimediaService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(multimediaService.listById (id), HttpStatus.OK)

    }

}
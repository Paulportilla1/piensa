package com.proyecto.piensa.service

import com.proyecto.piensa.model.Multimedia
import com.proyecto.piensa.repository.MultimediaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class MultimediaServiceService {
    @Autowired
    lateinit var multimediaRepository: MultimediaRepository

    fun list (pageable: Pageable, multimedia: Multimedia): Page<Multimedia> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return multimediaRepository.findAll(Example.of(multimedia, matcher), pageable)
    }

    fun save(multimedia: Multimedia): Multimedia {
        try{
            multimedia.type1?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return multimediaRepository.save(multimedia)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(multimedia: Multimedia): Multimedia {
        try {
            multimediaRepository.findById(multimedia.id)
                ?: throw Exception("ID no existe")

            return multimediaRepository.save(multimedia)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(multimedia: Multimedia): Multimedia {
        try{
            val response = multimediaRepository.findById(multimedia.id)
                ?: throw Exception("ID no existe")
            response.apply {
                url=multimedia.url
            }
            return multimediaRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = multimediaRepository.findById(id)

                ?: throw Exception("ID no existe")
            multimediaRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?): Multimedia?{
        return multimediaRepository.findById(id)
    }

}
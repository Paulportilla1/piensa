package com.proyecto.piensa.service

import com.proyecto.piensa.model.Progress
import com.proyecto.piensa.repository.ProgressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ProgressService {
    @Autowired
    lateinit var progressRepository: ProgressRepository

    fun list (pageable: Pageable, progress: Progress): Page<Progress> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return progressRepository.findAll(Example.of(progress, matcher), pageable)
    }

    fun save(progress: Progress): Progress {
        try{
            progress.score?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return progressRepository.save(progress)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(progress: Progress): Progress {
        try {
            progressRepository.findById(progress.id)
                ?: throw Exception("ID no existe")

            return progressRepository.save(progress)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(progress: Progress): Progress {
        try{
            val response = progressRepository.findById(progress.id)
                ?: throw Exception("ID no existe")
            response.apply {
                date=progress.date
            }
            return progressRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = progressRepository.findById(id)

                ?: throw Exception("ID no existe")
            progressRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?): Progress?{
        return progressRepository.findById(id)
    }

}
package com.proyectoleslie.factura.service

import com.proyecto.piensa.model.User
import com.proyecto.piensa.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun list (pageable: Pageable,user: User):Page<User>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return userRepository.findAll(Example.of(user, matcher), pageable)
    }

    fun save(user: User): User {
        try{
            user.fullname?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            return userRepository.save(user)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(user: User): User{
        try {
            userRepository.findById(user.id)
                ?: throw Exception("ID no existe")

            return userRepository.save(user)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(user: User): User{
        try{
            val response = userRepository.findById(user.id)
                ?: throw Exception("ID no existe")
            response.apply {
                age=user.age
            }
            return userRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = userRepository.findById(id)

                ?: throw Exception("ID no existe")
            userRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):User?{
        return userRepository.findById(id)
    }

}
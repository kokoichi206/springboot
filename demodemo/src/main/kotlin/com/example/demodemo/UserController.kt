package com.example.demodemo

import com.example.demodemo.database.User
import com.example.demodemo.database.UserMapper
import com.example.demodemo.database.insert
import com.example.demodemo.database.selectByPrimaryKey
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController(
    val userMapper: UserMapper,
) {

    @GetMapping("/select/{id}")
    fun select(@PathVariable("id") id: Int): User? {
        return userMapper.selectByPrimaryKey(id)
    }

    /**
     * curl -H 'Content-Type:application/json' -X POST -d '{"id":106,"name":"John Doe","age":109,"profile":"no profile yet"}' http://localhost:8080/user/insert
     */
    @PostMapping("/insert")
    fun insert(@RequestBody request: InsertRequest): InsertResponse {
        val record = User(request.id, request.name, request.age, request.profile)
        return InsertResponse(userMapper.insert(record))
    }
}

data class InsertRequest(val id: Int, val name: String, val age: Int, val profile: String)
data class InsertResponse(val count: Int)

package com.example.ormapper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrmapperApplication

fun main(args: Array<String>) {
    runApplication<OrmapperApplication>(*args)

    selectByPK()
    selectWhere()
    count()
    insert()
    insertList()
}

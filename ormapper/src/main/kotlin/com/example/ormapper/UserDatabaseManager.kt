package com.example.ormapper

import database.*
import database.insert
import database.insertMultiple
import database.UserDynamicSqlSupport.age
import database.UserDynamicSqlSupport.name
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.mybatis.dynamic.sql.SqlBuilder.where
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.elements.isGreaterThan
import org.mybatis.dynamic.sql.util.kotlin.elements.isLessThan

fun createSessionFactory(): SqlSessionFactory {
    val resource = "mybatis-config.xml"
    val inputStream = Resources.getResourceAsStream(resource)
    return SqlSessionFactoryBuilder().build(inputStream)
}

fun selectByPK() {
    // use -> Loan パターンを実現する関数であり、リソースの close を行てくれる！
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val user = mapper.selectByPrimaryKey(100)
        println(user)
    }
}

fun selectWhere() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val userList = mapper.select {
            // FIXME: Deprecated.
            where(name, isEqualTo("Jiro"))
        }
        println(userList)
    }
}

fun count() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.count {
            // FIXME: Deprecated.
            where(age, isGreaterThan(25))
        }
        println(count)
    }
}

/**
 * TODO: UK が被っていた場合のエラーをどのように検知・処理するか
 */
fun insert() {
    val user = User(
        id = 103,
        name = "wapi",
        age = 109,
        profile = "yossha",
    )
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.insert(user)
        session.commit()
        println("$count 行のレコードを挿入しました")
    }
}

fun insertList() {
    val list = listOf(
        User(104, "gopher", 15, "piii"),
        User(105, "roppi", 13, "puha-"),
    )
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.insertMultiple(list)
        session.commit()
        println("$count 行のレコードを挿入しました")
    }
}

fun update() {
    // null の指定されているレコードは更新されない。
    val user = User(id = 105, profile = "new profile!")
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.updateByPrimaryKey(user)
        session.commit()
        println("$count 行のレコードを更新しました")
    }
}

fun delete() {
    // null の指定されているレコードは更新されない。
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.deleteByPrimaryKey(104)
        session.commit()
    }
}

fun deleteWhere() {
    // null の指定されているレコードは更新されない。
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.delete {
            where(age, isLessThan(2))
        }
        session.commit()
    }
}

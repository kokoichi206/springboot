package com.example.demodemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greeter")
class GreeterController(
    // Spring 推奨の DI はコンストラクタインジェクション
    // 引数だけ見て、これが Inject される対象だ！ってわからんくない？
    private val greeter: Greeter,
) {
//    @Autowired  // DI の対象であることを表す
//    private lateinit var greeter: Greeter

    /**
     * クエリパラメータ。
     */
    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {
        val message = greeter.sayHello(name)
        return HelloResponse(message)
    }

    /**
     * パスパラメータ。
     */
    @GetMapping("/hello/{name}")
    fun helloPathValue(@PathVariable("name") name: String): HelloResponse {
        val message = greeter.sayHello(name)
        return HelloResponse(message)
    }

    /**
     * リクエストボディ。
     *
     * ### 疑問
     * - HelloRequest に不適な json が来た時どうなる？
     * - 空の時の挙動？
     *
     * ``` sh
     * $ curl -H 'Content-Type:application/json' -X POST -d '{"name":"Me"}' http://localhost:8080/greeter/hello
     * ```
     */
    @PostMapping("/hello")
    fun helloByPost(@RequestBody request: HelloRequest): HelloResponse {
        val message = greeter.sayHello(request.name)
        return HelloResponse(message)
    }
}
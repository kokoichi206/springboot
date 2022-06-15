package jp.mydns.kokoichichi0206.firstboot.kokoichi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KokoichiApplication

fun main(args: Array<String>) {
	runApplication<KokoichiApplication>(*args)
}

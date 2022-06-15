package jp.mydns.kokoichichi0206.firstboot.kokoichi.controller

import jp.mydns.kokoichichi0206.firstboot.kokoichi.model.Bank
import jp.mydns.kokoichichi0206.firstboot.kokoichi.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    // when return the object, it is automatically converted to JSON format
    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()
}

package jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.network

import jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.BankDataSource
import jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.network.dto.BankList
import jp.mydns.kokoichichi0206.firstboot.kokoichi.model.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetWorkDataSource(
    @Autowired private val restTemplate: RestTemplate
) : BankDataSource {

    override fun retrieveBanks(): Collection<Bank> {
        val response: ResponseEntity<BankList> =
            restTemplate.getForEntity<BankList>("192.168.0.100/banks")

        return response.body?.results
            ?: throw IOException("could not get body")
    }

    override fun retrieveBank(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountNumber: String) {
        TODO("Not yet implemented")
    }
}
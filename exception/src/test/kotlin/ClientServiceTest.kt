import com.google.gson.Gson
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class ClientServiceTest {

    private val gson = Gson()
    private val clientService = ClientService()

    @Test
    fun `success save client`() {
        val client = getClientFromJson("/success/user.json")
        val result = clientService.saveClient(client)
        assertNotNull(result)
    }
    @Test
    fun `fail save client - validation error - bad phone`() {
        val client = getClientFromJson("/fail/user_with_bad_phone.json")
        val exception = assertThrows<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(ErrorCode.INVALID_PHONE, exception.errorCode[0])
        assertEquals(exception.errorCode.size, 1)
    }

    @Test
    fun `fail save client - validation error - bad name`() {
        val client = getClientFromJson("/fail/user_with_bad_name.json")
        val exception = assertThrows<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(ErrorCode.INVALID_FIO, exception.errorCode[0])
        assertEquals(exception.errorCode.size, 1)
    }

    @Test
    fun `fail save client - validation error - bad email`() {
        val client = getClientFromJson("/fail/user_with_bad_email.json")
        val exception = assertThrows<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(ErrorCode.INVALID_EMAIL, exception.errorCode[0])
        assertEquals(exception.errorCode.size, 1)
    }

    @Test
    fun `fail save client - validation error - bad snils`() {
        val client = getClientFromJson("/fail/user_with_bad_phone.json")
        val exception = assertThrows<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(ErrorCode.INVALID_PHONE, exception.errorCode[0])
        assertEquals(exception.errorCode.size, 1)
    }

    @Test
    fun `fail save client - validation errors user_date_corrupted`() {
        val client = getClientFromJson("/fail/user_data_corrupted.json")
        val exception = assertFailsWith<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(ErrorCode.NULL_VALUE, exception.errorCode[0])
        assertEquals(ErrorCode.INVALID_FIO, exception.errorCode[1])
        assertEquals(ErrorCode.INVALID_PHONE, exception.errorCode[2])
        assertEquals(ErrorCode.INVALID_CHECK_SUM_SNILS, exception.errorCode[3])

        assertEquals(exception.errorCode.size, 4)


    }

    private fun getClientFromJson(fileName: String): Client = this::class.java.getResource(fileName)
        .takeIf { it != null }
        ?.let { gson.fromJson(it.readText(), Client::class.java) }
        ?: throw Exception("Что-то пошло не так))")

}
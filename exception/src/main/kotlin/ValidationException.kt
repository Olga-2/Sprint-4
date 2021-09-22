class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    NULL_VALUE(0, "Поле не может быть пустым"),

    INVALID_FIO(100, "Недопустимый символ, неверная длина поля имя/фамилия"),
    INVALID_PHONE(200, "Некорректно введен номер телефона: ожидается 11 цифр, начиная с 7 или 8"),

    INVALID_EMAIL(300, "Неверен email: ожидаются латинские буквыи и @ИмяДомена и строка длиной неболее 32 символов"),

    INVALID_DIGITAL_SNILS(400, "Некорректно введен снилс: ожидается 11 цифр"),
    INVALID_CHECK_SUM_SNILS(500, "Неверное значение СНИЛС")

}
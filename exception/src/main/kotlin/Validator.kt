import java.util.regex.Pattern

abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>

    fun notMatcher(pattern: Pattern, input :String): Boolean {
    return !pattern.matcher(input).matches()
    }
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {

        if (value == null) {
            return listOf(ErrorCode.NULL_VALUE)
        }
       val pattern :Pattern = "^[7|8]\\d{10}$".toRegex().toPattern()
       return if (notMatcher(pattern, value)) listOf(ErrorCode.INVALID_PHONE)  else listOf()
    }
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        if (value == null) {
            return listOf(ErrorCode.NULL_VALUE)
        }
        val pattern :Pattern = "^[А-Яа-яЁё]{1,16}$".toRegex().toPattern()
        return if (notMatcher(pattern, value)) listOf(ErrorCode.INVALID_FIO)  else listOf()
    }
}

class EMailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        if (value == null) {
            return listOf(ErrorCode.NULL_VALUE)
        }
        val pattern: Pattern = "^[A-Za-z]+@[A-Za-z.]+\$".toRegex().toPattern()
        return if (notMatcher(pattern, value) || value.length>32) listOf(ErrorCode.INVALID_EMAIL) else listOf()

    }
}

class SNILSValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        if (value == null) {
            return listOf(ErrorCode.NULL_VALUE)
        }
        val pattern: Pattern = "^\\d{11}\$".toRegex().toPattern()
        val errCodes: ArrayList<ErrorCode> = ArrayList()
        if (notMatcher(pattern, value))
            errCodes.add(ErrorCode.INVALID_DIGITAL_SNILS)
        else if (isNotValidCheckSum(value))
            errCodes.add(ErrorCode.INVALID_CHECK_SUM_SNILS)

        return errCodes
    }

    private fun isNotValidCheckSum(value: String) : Boolean{
        var s = 0
        val d = 10
        var intValue = value.substring(0,9).toInt()
        val checkSum = value.substring(9).toInt()
        for (i  in 1..9) {

            s += intValue % d * i
            intValue /= d
        }

        if (s > 101)
            s %= 101

        if (s < 100)
            return checkSum != s
        if (listOf(100, 101).contains(s))
            return checkSum != 0
        return true
    }
}
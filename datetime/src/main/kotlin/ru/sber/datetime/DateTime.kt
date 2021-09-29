package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter

import java.util.*

// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    val s = ZoneId.getAvailableZoneIds()
    val result = mutableSetOf<String>()
    for (i in s) {
        val offSet = ZonedDateTime.now(ZoneId.of(i)).offset.toString()
        if (offSet.length > 4 && !offSet.split(":")[1].equals("00")) {
            result.add(ZoneId.of(i).id)
        }
    }

return result
}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {
    val dayWeekList = mutableListOf<String>()
    val lastMonthDay = LocalDate.of(year,1, 31)

    for(i in 0L..11L) {
        dayWeekList.add(lastMonthDay.plusMonths(i).dayOfWeek.name)
    }

    return dayWeekList
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {
    var count = 0
    val lastMonthDay = LocalDate.of(year,1, 13)

    for(i in 0L..11L) {
        if (lastMonthDay.plusMonths(i).dayOfWeek == DayOfWeek.FRIDAY) {count++}
    }
    return count
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {
    return dateTime.format(DateTimeFormatter.ofPattern("dd MMM uuuu, HH:mm").withLocale(Locale.US))
}




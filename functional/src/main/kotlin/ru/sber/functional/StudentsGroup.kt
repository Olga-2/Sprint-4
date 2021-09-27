package ru.sber.functional

import kotlin.streams.toList

class StudentsGroup {

    lateinit var students: List<Student>

    fun init () {
        students = listOf(
            Student(firstName = "Иванов", lastName = "Иван", middleName = "Петрович", age = 20, averageRate = 4.5 ),
            Student(firstName = "Петров", lastName = "Петр", middleName = "Иванович", age = 21, averageRate = 5.0 ),
            Student(firstName = "Сидоров", lastName = "Николай", middleName = "Иванович", age = 19, averageRate = 4.5 ),
            Student(firstName = "Мигалкин", lastName = "Федор", middleName = "Михайлович", age = 20, averageRate = 3.0 ),
            Student(firstName = "Сопелкин", lastName = "Михаил", middleName = "Иванович", age = 22, averageRate = 4.5 ),
            Student(firstName = "Свистелкин", lastName = "Олег", middleName = "Михайлович", age = 20, averageRate = 4.5 ),

        )
    }
    fun filterByPredicate(pred: (Student) -> Boolean) : List<Student>
    { return students.stream().filter(pred).toList()
    }
}

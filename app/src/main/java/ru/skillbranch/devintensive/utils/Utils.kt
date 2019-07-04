package ru.skillbranch.devintensive.utils

/**
 * Created by Artur (gaket) on 2019-07-02.
 */
object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstName.isNullOrBlank()) firstName = null
        if (lastName.isNullOrBlank()) lastName = null

        return Pair(firstName, lastName)
    }
}
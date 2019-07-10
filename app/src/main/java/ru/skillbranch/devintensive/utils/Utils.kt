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

    fun toInitials(firstName: String?, lastName: String?): String? {
        val first = getFirstLetter(firstName)
        val last = getFirstLetter(lastName)
        if (first == null && last == null) {
            return null
        }

        return "${if(first!=null) first else ""}${if(last!=null) last else ""}".toUpperCase()
    }

    fun transliteration( payload: String, divider:String = " ") {
        var translit: String
        if (divider != " ") {
            translit = payload.replace(" ", divider)
        }
    }

    private fun getFirstLetter(word: String?): String? {
        if (word.isNullOrBlank()) {
            return null
        }

        return "${word[0]}"
    }
}
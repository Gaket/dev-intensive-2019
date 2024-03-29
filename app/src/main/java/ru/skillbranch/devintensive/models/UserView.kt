package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Created by Artur (gaket) on 2019-07-02.
 */
data class UserView(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {
    var introBit: String

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe $id")

    init {
        introBit = getIntro()
        println("Works! The name is $firstName $lastName. ${introBit}")
    }

    companion object Factory {
        private var lastId: Int = -1

        fun makeUser(fullName: String?): UserView {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)

            return UserView(lastId.toString(), firstName, lastName)
        }
    }

    private fun getIntro() = """
        la la
        topolya
        $firstName
        ${"\n"}
        $lastName
    """.trimIndent()

    fun printMe() = println(
        """
        id: $id
        firstName: $firstName
        lastName: $lastName
        avatar: $avatar
        rating: $rating
        respect: $respect
        lastVisit: $lastVisit
        isOnline: $isOnline
    """.trimIndent()
    )
}
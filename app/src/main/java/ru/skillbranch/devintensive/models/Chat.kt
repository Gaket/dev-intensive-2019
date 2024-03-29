package ru.skillbranch.devintensive.models

/**
 * Created by Artur (gaket) on 2019-07-04.
 */
class Chat(
        val id: String,
        val members: MutableList<User> = mutableListOf(),
        val messages: MutableList<BaseMessage> = mutableListOf()
)
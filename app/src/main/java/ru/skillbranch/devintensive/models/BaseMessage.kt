package ru.skillbranch.devintensive.models

import java.util.*

/**
 * Created by Artur (gaket) on 2019-07-04.
 */
abstract class BaseMessage(
        val id: String,
        val from: User?,
        val chat: Chat,
        val isIncoming: Boolean = false,
        val date: Date = Date()
) {

    abstract fun formatMessage(): String

    companion object Factory {
        var lastId = -1
        fun makeMessage(from: User?, chat: Chat, date: Date = Date(), type: String = "text", payload: Any?, isIncoming: Boolean = false): BaseMessage {
            lastId++
            return when (type) {
                "image" ->  ImageMessage(lastId.toString(), from, chat, isIncoming, date, payload as String?)
                else ->  TextMessage(lastId.toString(), from, chat, isIncoming, date, payload as String?)
            }
        }
    }
}
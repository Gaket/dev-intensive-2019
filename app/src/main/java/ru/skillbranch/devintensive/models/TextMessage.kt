package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

/**
 * Created by Artur (gaket) on 2019-07-04.
 */
class TextMessage(
        id: String,
        from: User?,
        chat: Chat,
        isIncoming: Boolean = false,
        date: Date = Date(),
        val text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage():String = "id:$id ${from?.firstName} ${if(isIncoming) "received" else "sent"} a message \"$text\" ${date.humanizeDiff()}"
}
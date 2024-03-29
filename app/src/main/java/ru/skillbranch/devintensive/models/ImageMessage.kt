package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

/**
 * Created by Artur (gaket) on 2019-07-04.
 */
class ImageMessage(
        id: String,
        from: User?,
        chat: Chat,
        isIncoming: Boolean = false,
        date: Date = Date(),
        val image: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage():String = "id:$id ${from?.firstName} ${if(isIncoming) "received" else "sent"} an image \"$image\" ${date.humanizeDiff()}"

}
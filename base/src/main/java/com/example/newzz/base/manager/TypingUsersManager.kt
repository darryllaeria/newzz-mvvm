package com.example.newzz.base.manager

import com.example.newzz.base.EmptyCallback
import com.example.newzz.base.StringCallback
import java.util.*
import kotlin.concurrent.timerTask

class TypingUsersManager {

    // MARK: - Inner Class
    inner class TypingUser(val id: String, val name: String, var timer: Timer? = null) {
        fun invalidateTimer() {
            timer?.cancel()
            timer = null
        }
    }

    // MARK: - Companion Object
    companion object {
        const val DISPLAY_TIME_IN_SECONDS: Long = 6
    }

    // MARK: - Public Callbacks
    var didEndTypingCallback: EmptyCallback? = null
    var didModifyUsersCallback: StringCallback? = null

    // MARK: - Private Variable
    private var typingUsers: MutableList<TypingUser> = mutableListOf()

    // MARK: - Public Functions
    fun addUser(id: String, name: String) {
        typingUsers.firstOrNull { it.id == id }?.let {
            it.invalidateTimer()
            setTimer(it)
        } ?: run {
            val user = TypingUser(id, name)
            typingUsers.add(user)
            setTimer(user)
            didModifyUsersCallback?.invoke(buildText())
        }
    }

    fun invalidateTimers() {
        typingUsers.forEach { it.invalidateTimer() }
        typingUsers.clear()
    }

    // MARK: - Private Functions
    private fun buildText(): String {
        var text = ""
        if (typingUsers.isEmpty()) {
            return text
        }
        text = when (typingUsers.size) {
            1 -> {
                "${typingUsers[0].name} is typing"
            }
            2 -> {
                "${typingUsers[0].name} and ${typingUsers[1].name} are typing"
            }
            3 -> {
                "${typingUsers[0].name}, ${typingUsers[1].name} and 1 more person are typing"
            }
            else -> {
                "${typingUsers[0].name}, ${typingUsers[1].name} and ${typingUsers.size - 2} more people are typing"
            }
        }
        return text
    }

    private fun setTimer(user: TypingUser) {
        val timer = Timer()
        timer.schedule(timerTask {
            user.invalidateTimer()
            typingUsers = typingUsers.filter { it.id != user.id }.toMutableList()
            if (typingUsers.isEmpty()) didEndTypingCallback?.invoke() else didModifyUsersCallback?.invoke(buildText())
        }, DISPLAY_TIME_IN_SECONDS * 1000)
        user.timer = timer
    }
}
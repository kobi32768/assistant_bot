package io.github.kobi32768.assistantbot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import javax.security.auth.login.LoginException

class DiscordBot : ListenerAdapter() {

    fun start() {
        try {
            val jda = JDABuilder(Token.token)
                .addEventListeners(this)
                .build()
            jda.awaitReady()
            println("Finished Building JDA.")
        }
        catch (ex: LoginException) {
            ex.printStackTrace()
        }
        catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {

    }
}
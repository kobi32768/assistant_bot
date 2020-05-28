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
        println("- - - - - - - - - -")
        println("Message detected")
        val content = event.message.contentDisplay
        val command = content.split(" ")[1]
        val args = content.split(" ").drop(2)
        val chnl = ChannelManagement()

        if(content.startsWith("sudo")) {
            when(command) {
                "mktc" -> chnl.makeTextChannel(event, args[0])
                "mkvc" -> chnl.makeVoiceChannel(event, args[0])
                "findcat" -> chnl.findCategory(event, args[0])
            }
            println("Command detected")
            println(event.guild.channels)
            println(event.guild.categories)
        }

    }
}
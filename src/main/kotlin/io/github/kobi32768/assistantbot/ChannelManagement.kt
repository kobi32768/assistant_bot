package io.github.kobi32768.assistantbot

import net.dv8tion.jda.api.entities.Category
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import java.nio.channels.Channel

class ChannelManagement {
    fun makeTextChannel(event: MessageReceivedEvent, name: String) {
        event.guild.createTextChannel(name).complete()
        println(findChannel(event, name)?.position)
        println("AC: Make TC")
    }

    fun makeVoiceChannel(event: MessageReceivedEvent, name: String) {
        event.guild.createVoiceChannel(name).complete()
        println("AC: Make VC")
    }

    fun makeCategory(event: MessageReceivedEvent, name:String) {
        event.guild.createCategory(name)
        println("AC: Make GC")
    }

    fun findCategory(event: MessageReceivedEvent, name: String): Category? {
        val cat = event.guild.categories
        for(i in cat.indices) {
            if (cat[i].name == name) {
                println("AC: Find GC")
                return cat[i]
            }
        }
        println("WA: Find GC")
        return null
    }

    fun findChannel(event: MessageReceivedEvent, name: String): TextChannel? {
        val ch = event.guild.textChannels
        for(i in ch.indices) {
            if(ch[i].name == name) {
                println("AC: Find TC")
                return ch[i]
            }
        }
        println("WA: Find TC")
        return null
    }
}
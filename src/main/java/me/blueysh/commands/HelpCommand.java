package me.blueysh.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class HelpCommand {
    public static void run(MessageReceivedEvent e) {
        e.getChannel().sendMessageEmbeds(new EmbedBuilder()
        .setColor(Color.PINK)
        .setTitle(":bubble_tea: BobaBot Help")
        .setDescription("Hi there! I'm BobaBot! Needing some help?\n**Commands**\n`b?help` - Sends this help message.\n`b?boba` - The main command, drinks your favorite boba or sends a mentioned user their favorite boba.\n`b?picker` - An owner-only command that sends the boba picker message.\n\n**Helpful Stuff**\n[Website](https://blueysh.github.io/bobabot) - [Invite Me](https://discord.com/api/oauth2/authorize?client_id=970009513170190459&permissions=8&scope=bot) - [Join Bot Server](https://discord.gg/hCZPyPJPpK)\n\nHope this helped! :bubble_tea:")
        .build()).queue();
    }
}

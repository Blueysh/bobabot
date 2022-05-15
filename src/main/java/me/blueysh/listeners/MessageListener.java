package me.blueysh.listeners;

import me.blueysh.commands.*;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;

        Message messageRaw = e.getMessage();
        String message = messageRaw.toString();
        /*
        if (message.contains("b?picker")) {
            messageRaw.delete().queue();
            PickerCommand.run(e);
            return;
        }
         */

        if (message.contains("b?boba")) {
            e.getMessage().delete().queue();
            BobaCommand.run(e);
            return;
        }

        if (message.contains("b?help")) {
            HelpCommand.run(e);
        }
    }
}

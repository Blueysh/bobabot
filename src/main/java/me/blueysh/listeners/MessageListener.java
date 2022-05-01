package me.blueysh.listeners;

import me.blueysh.BobaBot;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;

        Message messageRaw = e.getMessage();
        String message = messageRaw.toString();
        if (message.contains("?boba")) {
            if (messageRaw.getMentionedMembers().isEmpty()) {
                messageRaw.delete().queue();

                assert e.getMember() != null;
                messageRaw.getChannel().sendMessage(messageRaw.getAuthor().getName() + " drank some yummy {}! :bubble_tea:".replace("{}", getPreferredBoba(e.getMember()))).queue();
                if (getPreferredBoba(e.getMember()).equals("boba tea"))
                    messageRaw.getChannel().sendMessage("P.S. - " + messageRaw.getAuthor().getName() + ", you can choose your favorite boba tea in this server's rules channel!").queue();
            } else {
                messageRaw.delete().queue();

                assert e.getMember() != null;
                if (messageRaw.getMentionedMembers().get(0).getUser().getName().equals(e.getAuthor())) {
                    messageRaw.getChannel().sendMessage(messageRaw.getAuthor().getName() + " sent- themselves bubble tea? Ok then! :bubble_tea:").queue();
                    return;
                }
                if (messageRaw.getMentionedMembers().get(0).getUser().equals(BobaBot.getJDA().getSelfUser())) {
                    messageRaw.getChannel().sendMessage("Thanks for the boba, " + messageRaw.getAuthor().getName() + "! :hugging:").queue();
                    return;
                }

                messageRaw.getChannel().sendMessage(messageRaw.getAuthor().getName() + " sends {} some []! :bubble_tea:".replace("{}", messageRaw.getMentionedMembers().get(0).getUser().getName()).replace("[]", getPreferredBoba(messageRaw.getMentionedMembers().get(0)))).queue();
            }
        }
    }

    private String getPreferredBoba(Member member) {
        for (Role role : member.getRoles()) {
            if (role.getName().toLowerCase().contains("tea")) {
                return role.getName();
            }
            return "boba tea";
        }
        return "boba tea";
    }
}

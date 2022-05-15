package me.blueysh.commands;

import me.blueysh.BobaBot;
import me.blueysh.utils.BobaRoles;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class BobaCommand {
    public static void run(MessageReceivedEvent e) {
        if (e.getMessage().getMentionedMembers().isEmpty()) {
            assert e.getMember() != null;
            e.getMessage().getChannel().sendMessage(e.getMessage().getAuthor().getName() + " drank some yummy {}! :bubble_tea:".replace("{}", BobaRoles.getPreferredBoba(e.getMember()))).queue();
            if (BobaRoles.getPreferredBoba(e.getMember()).equals("boba tea"))
                e.getMessage().getChannel().sendMessage("P.S. - " + e.getMessage().getAuthor().getName() + ", you can choose your favorite boba tea in this server's rules channel!").queue();
        } else {
            assert e.getMember() != null;
            if (e.getMessage().getMentionedMembers().get(0).getUser().getName().equals(e.getAuthor().getName())) {
                e.getMessage().getChannel().sendMessage(e.getMessage().getAuthor().getName() + " sent- themselves bubble tea? Ok then! :bubble_tea:").queue();
                return;
            }
            if (e.getMessage().getMentionedMembers().get(0).getUser().equals(BobaBot.getJDA().getSelfUser())) {
                e.getMessage().getChannel().sendMessage("Thanks for the boba, " + e.getMessage().getAuthor().getName() + "! :hugging:").queue();
                return;
            }

            e.getMessage().getChannel().sendMessage(e.getMessage().getAuthor().getName() + " sends {} some []! :bubble_tea:".replace("{}", e.getMessage().getMentionedMembers().get(0).getUser().getName()).replace("[]", BobaRoles.getPreferredBoba(e.getMessage().getMentionedMembers().get(0)))).queue();
        }
    }
}

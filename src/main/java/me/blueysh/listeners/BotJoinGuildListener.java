package me.blueysh.listeners;

import me.blueysh.BobaBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;

public class BotJoinGuildListener extends ListenerAdapter {
    @Override
    public void onGuildJoin(GuildJoinEvent e) {
        System.out.println("Bot joined guild '" + e.getGuild().getName() + "'");
        User owner = e.getGuild().retrieveOwner().complete().getUser();

        if (e.getGuild().getRulesChannel() == null) {
            assert owner != null;
            owner.openPrivateChannel().flatMap(channel -> channel.sendMessage("Hello {}! Your server doesn't have a rules channel - members won't be able to choose their favorite boba tea! I send a message where members can select in your server's rules channel. Once you've created one, re-add me to your server.".replace("{}", owner.getName()))).queue();
            e.getGuild().leave().queue();

            return;
        }

        try {
            e.getGuild().createRole().setName("Black / Milk Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Strawberry Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Honey Green Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Wintermelon Tea").setColor(Color.PINK).queue();
        } catch (InsufficientPermissionException ex) {
            owner.openPrivateChannel().flatMap(channel -> channel.sendMessage("Hello {}! I don't have permission to create roles in your server, so even if members pick a flavor, they won't get the role!".replace("{}", owner.getName()))).queue();
        }
    }

    @Override
    public void onGuildLeave(GuildLeaveEvent e) {
        for (Role role : e.getGuild().getRoles()) {
            if (role.getName().toLowerCase().contains("tea")) role.delete().queue();
        }
    }
}

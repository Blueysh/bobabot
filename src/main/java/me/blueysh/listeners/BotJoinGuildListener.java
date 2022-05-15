package me.blueysh.listeners;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import java.awt.*;

public class BotJoinGuildListener extends ListenerAdapter {
    @Override
    public void onGuildJoin(GuildJoinEvent e) {
        System.out.println("Bot joined guild '" + e.getGuild().getName() + "'");
        User owner = e.getGuild().retrieveOwner().complete().getUser();

        e.getGuild().upsertCommand("boba", "Drink your favorite boba, or send someone else theirs!").addOption(OptionType.MENTIONABLE, "member", "The member you want to send boba to.", false).queue();
        e.getGuild().upsertCommand("pickboba", "Select your favorite boba flavor.").queue();

        try {
            e.getGuild().createRole().setName("Black / Milk Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Strawberry Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Honey Green Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Wintermelon Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Coffee Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Fruity Iced Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Chocolate Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Taro Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Peach Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Almond Milk Boba Tea").setColor(Color.PINK).queue();
            e.getGuild().createRole().setName("Melon Boba Tea").setColor(Color.PINK).queue();
            owner.openPrivateChannel().flatMap(channel -> channel.sendMessage("Hello {}! Thanks for adding me to []! If you want to allow users to choose their favorite bubble tea flavors, just send `?bpicker` in the channel you want the picker to be sent. Thanks! :bubble_tea:".replace("{}", owner.getName()).replace("[]",e.getGuild().getName()))).queue();
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

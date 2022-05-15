package me.blueysh.listeners;

import me.blueysh.utils.BobaRoles;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        Member member = e.getMember();
        Guild guild = e.getGuild();

        if (e.getName().equals("boba")) {
            if (e.getOption("user") == null) {
                e.reply("() drank some yummy {}!".replace("()", e.getMember().getUser().getName()).replace("{}", BobaRoles.getPreferredBoba(e.getMember()))).queue();
            } else {
                e.reply("() sends {} some []!".replace("()", e.getMember().getUser().getName()).replace("{}", e.getOption("user").getAsMember().getUser().getName()).replace("[]", BobaRoles.getPreferredBoba(e.getOption("user").getAsMember()))).queue();
            }
        }
        /*if (e.getName().equals("pickboba")) {
            switch (e.getOption("Boba").getAsRole().getName()) {
                case "Black / Milk Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Black / Milk Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Black / Milk Boba Tea").setEphemeral(true).queue();
                    break;
                case "Strawberry Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Strawberry Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Strawberry Boba Tea").setEphemeral(true).queue();
                    break;
                case "Honey Green Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Honey Green Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Honey Green Boba Tea").setEphemeral(true).queue();
                    break;
                case "Wintermelon Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Wintermelon Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Wintermelon Boba Tea").setEphemeral(true).queue();
                    break;
                case "Coffee Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Coffee Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Coffee Boba Tea").setEphemeral(true).queue();
                    break;
                case "Fruity Iced Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Fruity Iced Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Fruity Iced Boba Tea").setEphemeral(true).queue();
                    break;
                case "Chocolate Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Chocolate Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Chocolate Boba Tea").setEphemeral(true).queue();
                    break;
                case "Taro Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Taro Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Taro Boba Tea").setEphemeral(true).queue();
                    break;
                case "Peach Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Peach Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Peach Boba Tea").setEphemeral(true).queue();
                    break;
                case "Almond Milk Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Almond Milk Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Almond Milk Boba Tea").setEphemeral(true).queue();
                    break;
                case "Melon Boba Tea":
                    for (Role role : member.getRoles()) {
                        if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                    }
                    guild.addRoleToMember(member, guild.getRolesByName("Melon Boba Tea", true).get(0)).queue();
                    e.reply("Your preferred flavor has been set to - Melon Boba Tea").setEphemeral(true).queue();
                    break;
            }
        }*/

        if (e.getName().equals("pickboba")) {
            e.replyEmbeds(new EmbedBuilder()
            .setColor(Color.PINK)
            .setFooter("Sent by BobaBot")
            .setTitle(":bubbletea: Choose your favorite bubble tea flavor.")
            .setDescription("Choose a flavor below! Want to have a flavor added? DM `Blueysh#0594!`")
            .addField(new MessageEmbed.Field("Flavor", "flavor", false, true))
            .build()).queue();
        }
    }
}

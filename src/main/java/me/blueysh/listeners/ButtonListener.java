package me.blueysh.listeners;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ButtonListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(ButtonInteractionEvent e) {
        Guild guild = e.getGuild();
        Member member = e.getMember();
        switch (e.getButton().getId()) {
            case "milk_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Black / Milk Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Black / Milk Boba Tea").setEphemeral(true).queue();
                break;
            case "strawberry_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Strawberry Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Strawberry Boba Tea").setEphemeral(true).queue();
                break;
            case "honey_green_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Honey Green Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Honey Green Boba Tea").setEphemeral(true).queue();
                break;
            case "wintermelon_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Wintermelon Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Wintermelon Boba Tea").setEphemeral(true).queue();
                break;
            case "coffee_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Coffee Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Coffee Boba Tea").setEphemeral(true).queue();
                break;
            case "fruity_iced_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Fruity Iced Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Fruity Iced Boba Tea").setEphemeral(true).queue();
                break;
            case "chocolate_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Chocolate Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Chocolate Boba Tea").setEphemeral(true).queue();
                break;
            case "taro_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Taro Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Taro Boba Tea").setEphemeral(true).queue();
                break;
            case "peach_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Peach Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Peach Boba Tea").setEphemeral(true).queue();
                break;
            case "almond_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Almond Milk Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Almond Milk Boba Tea").setEphemeral(true).queue();
                break;
            case "melon_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Melon Boba Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Melon Boba Tea").setEphemeral(true).queue();
                break;
        }
    }
}

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
                guild.addRoleToMember(member, guild.getRolesByName("Black / Milk Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Black / Milk Tea").setEphemeral(true).queue();
                break;
            case "strawberry_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Strawberry Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Strawberry Tea").setEphemeral(true).queue();
                break;
            case "honey_green_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Honey Green Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Honey Green Tea").setEphemeral(true).queue();
                break;
            case "wintermelon_tea":
                for (Role role : member.getRoles()) {
                    if (role.getName().toLowerCase().contains("tea")) e.getGuild().removeRoleFromMember(member, role).queue();
                }
                guild.addRoleToMember(member, guild.getRolesByName("Wintermelon Tea", true).get(0)).queue();
                e.reply("Your preferred flavor has been set to - Wintermelon Tea").setEphemeral(true).queue();
                break;
        }
    }
}

package me.blueysh.utils;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.Member;

public class BobaRoles {
    public static String getPreferredBoba(Member member) {
        if (member.getRoles().get(member.getRoles().toArray().length - 1).getName().toLowerCase().contains("tea")) {
            return member.getRoles().get(member.getRoles().toArray().length - 1).getName();
        }
        return "boba tea";
    }

    public static void setPreferredBoba(String name, Member member) {
        for (Role role : member.getRoles()) {
            if (role.getName().toLowerCase().contains("tea")) {
                member.getGuild().removeRoleFromMember(member, role).queue();
            }
        }
        member.getGuild().addRoleToMember(member, member.getGuild().getRolesByName(name, true).get(0)).queue();
    }
}

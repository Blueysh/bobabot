package me.blueysh.utils;

import net.dv8tion.jda.api.entities.Member;

public class BobaRoles {
    public static String getPreferredBoba(Member member) {
        if (member.getRoles().get(member.getRoles().toArray().length - 1).getName().toLowerCase().contains("tea")) {
            return member.getRoles().get(member.getRoles().toArray().length - 1).getName();
        }
        return "boba tea";
    }
}

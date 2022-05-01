package me.blueysh;

import me.blueysh.listeners.BotJoinGuildListener;
import me.blueysh.listeners.ButtonListener;
import me.blueysh.listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Role;

import javax.security.auth.login.LoginException;

public class BobaBot {
    private static JDA jda;

    private static String TOKEN = "OTcwMDA5NTEzMTcwMTkwNDU5.Ym1twQ.d-5vr8CUGsdNSMzRqt5EiSJM3Hg";
    public static String PREFIX = "?";

    public static void main(String[] args) throws LoginException, InterruptedException {
        jda = JDABuilder.createDefault(TOKEN)
                .setActivity(Activity.watching("for ?boba!"))
                .build();

        jda.addEventListener(new MessageListener());
        jda.addEventListener(new BotJoinGuildListener());
        jda.addEventListener(new ButtonListener());

        jda.awaitReady();
        System.out.println("Bot is online!");
    }

    public static JDA getJDA() {
        return jda;
    }
}

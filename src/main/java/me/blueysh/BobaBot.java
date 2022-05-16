package me.blueysh;

import me.blueysh.listeners.BotJoinGuildListener;
import me.blueysh.listeners.ButtonListener;
import me.blueysh.listeners.MenuListener;
import me.blueysh.listeners.MessageListener;
import me.blueysh.listeners.SlashCommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

import javax.security.auth.login.LoginException;

public class BobaBot {
    private static JDA jda;

    public static void main(String[] args) throws LoginException, InterruptedException {
        if (args.length < 1) throw new IllegalArgumentException("You must provide a bot token as the first argument!");

        jda = JDABuilder.createDefault(args[0])
                .setActivity(Activity.watching("for boba!"))
                .build();

        jda.addEventListener(new SlashCommandListener(), new MenuListener(), new BotJoinGuildListener());

        // Removed the button based picker for now - jda.addEventListener(new ButtonListener());

        jda.awaitReady();
        System.out.println("BobaBot is online!");
        if (args.length > 1 && args[1].equals("--updated")) {
            System.out.println("The bot has updated, sending all guild owners a message!");
            for (Guild guild : jda.getGuilds()) {
                User guildOwner = guild.retrieveOwner().complete().getUser();
                guildOwner.openPrivateChannel().flatMap(channel -> channel.sendMessage("Hi {}, BobaBot here! The bot has updated, and in order for the bot to fully work, **you need to kick the bot from your server and re-add it**.\nHere's an easy link to re-add the bot to your server: https://blueysh.github.io/bobabot\n\nSee ya soon! :bubble_tea:".replace("{}",guildOwner.getName()))).queue();
            }
        }
    }

    public static JDA getJDA() {
        return jda;
    }
}

package me.blueysh.listeners;

import me.blueysh.utils.BobaRoles;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

import java.awt.*;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        Member member = e.getMember();
        Guild guild = e.getGuild();

        if (e.getName().equals("boba")) {
            if (e.getOptionsByType(OptionType.MENTIONABLE).size() == 0) {
                e.reply("() drank some yummy {}!".replace("()", e.getMember().getUser().getName()).replace("{}", BobaRoles.getPreferredBoba(e.getMember()))).queue();
            } else {
                if (e.getOptionsByType(OptionType.MENTIONABLE).get(0).getAsMember().getUser().getName().equals("BobaBot")) {
                    e.reply("Thanks for the boba, {}! :hugging::bubble_tea:".replace("{}", e.getMember().getUser().getName())).queue();
                    return;
                }
                e.reply("() sends {} some []!".replace("()", e.getMember().getUser().getName()).replace("{}", e.getOptionsByType(OptionType.MENTIONABLE).get(0).getAsMember().getUser().getName()).replace("[]", BobaRoles.getPreferredBoba(e.getOptionsByType(OptionType.MENTIONABLE).get(0).getAsMember()))).queue();
            }
        }
        if (e.getName().equals("pickboba")) {
            e.replyEmbeds(new EmbedBuilder()
            .setColor(Color.PINK)
            .setFooter("Sent by BobaBot")
            .setTitle(":bubble_tea: Choose your favorite bubble tea flavor.")
            .setDescription("Choose a flavor below! Want to have a flavor added? DM `Blueysh#0594!`")
            .build()).addActionRow(
                SelectMenu.create("menu:flavor")
                .setRequiredRange(1, 1)
                .addOption("Coffee Boba Tea", "coffeetea")
                .addOption("Strawberry Boba Tea", "strawberrytea")
                .addOption("Black / Milk Boba Tea", "blacktea")
                .addOption("Honey Green Boba Tea", "honeygreentea")
                .addOption("Wintermelon Boba Tea", "wintermelontea")
                .addOption("Fruity Iced Boba Tea", "fruityicedtea")
                .addOption("Chocolate Boba Tea", "chocolatetea")
                .addOption("Taro Boba Tea", "tarotea")
                .addOption("Peach Boba Tea", "peachtea")
                .addOption("Almond Milk Boba Tea", "almondmilktea")
                .addOption("Melon Boba Tea", "melontea")
                .addOption("Hokkaido Boba Tea", "hokkaidotea")
                .build()
            )
            .setEphemeral(true)
            .queue();
        }
    }
}

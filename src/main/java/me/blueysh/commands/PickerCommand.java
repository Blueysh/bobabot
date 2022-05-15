package me.blueysh.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;

public class PickerCommand {
    public static void run(MessageReceivedEvent e) {
        if (!e.getAuthor().equals(e.getGuild().retrieveOwner().complete().getUser())) {
            e.getMessage().getAuthor().openPrivateChannel().flatMap(channel -> channel.sendMessage("Hi {}, you don't have permission to send the boba picker message in that server. Tell the server owner to use the b?picker command.".replace("{}",e.getAuthor().getName()))).queue();
            return;
        }
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(":v: Hey there! What's your favorite Boba Tea?")
                .setDescription("Choose your favorite flavor!\n*Don't see your favorite? DM `blueysh#0594`!*")
                .setColor(Color.PINK);

        MessageBuilder messageBuilder = new MessageBuilder()
                .setEmbeds(embedBuilder.build());

        e.getMessage().getChannel().sendMessage(messageBuilder.build())
                .setActionRows(
                        ActionRow.of(net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("milk_tea", "Black / Milk Boba Tea"),
                                net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("strawberry_tea", "Strawberry Boba Tea"),
                                net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("honey_green_tea", "Honey Green Boba Tea"),
                                net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("wintermelon_tea", "Wintermelon Boba Tea"),
                                net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("coffee_tea", "Coffee Boba Tea")),
                        ActionRow.of(net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("fruity_iced_tea", "Fruity Iced Boba Tea"),
                                net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("chocolate_tea", "Chocolate Boba Tea"),
                                net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("taro_tea", "Taro Boba Tea"),
                                net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("peach_tea", "Peach Boba Tea"),
                                net.dv8tion.jda.api.interactions.components.buttons.Button.secondary("almond_tea", "Almond Milk Boba Tea")),
                        ActionRow.of(Button.secondary("melon_tea", "Melon Boba Tea"))
                )
                .queue();
    }
}

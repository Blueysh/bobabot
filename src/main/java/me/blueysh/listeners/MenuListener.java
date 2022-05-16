package me.blueysh.listeners;

import me.blueysh.utils.BobaRoles;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MenuListener extends ListenerAdapter {
    @Override
    public void onSelectMenuInteraction(SelectMenuInteractionEvent e) {
        Member member = e.getMember();
        if (e.getSelectMenu().getId().equals("menu:flavor")) {
            switch (e.getSelectedOptions().get(0).getValue()) {
                case "coffeetea":
                    BobaRoles.setPreferredBoba("Coffee Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Coffee Boba Tea.").queue();
                    break;
                case "strawberrytea":
                    BobaRoles.setPreferredBoba("Strawberry Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Strawberry Boba Tea.").queue();
                    break;
                case "blacktea":
                    BobaRoles.setPreferredBoba("Black / Milk Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Black / Milk Boba Tea.").queue();
                    break;
                case "honeygreentea":
                    BobaRoles.setPreferredBoba("Honey Green Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Honey Green Boba Tea.").queue();
                    break;
                case "wintermelontea":
                    BobaRoles.setPreferredBoba("Wintermelon Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Wintermelon Boba Tea.").queue();
                    break;
                case "fruityicedtea":
                    BobaRoles.setPreferredBoba("Fruity Iced Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Fruity Iced Boba Tea.").queue();
                    break;
                case "chocolatetea":
                    BobaRoles.setPreferredBoba("Chocolate Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Chocolate Boba Tea.").queue();
                    break;
                case "tarotea":
                    BobaRoles.setPreferredBoba("Taro Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Taro Boba Tea.").queue();
                    break;
                case "peachtea":
                    BobaRoles.setPreferredBoba("Peach Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Peach Boba Tea.").queue();
                    break;
                case "almondmilktea":
                    BobaRoles.setPreferredBoba("Almond Milk Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Almond Milk Boba Tea.").queue();
                    break;
                case "melontea":
                    BobaRoles.setPreferredBoba("Melon Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Melon Boba Tea.").queue();
                    break;
                case "hokkaidotea":
                    BobaRoles.setPreferredBoba("Hokkaido Boba Tea", member);
                    e.deferReply(true).setContent("Your preferred flavor has been set to Hokkaido Boba Tea.").queue();
                    break;
            }
        }
    }
}

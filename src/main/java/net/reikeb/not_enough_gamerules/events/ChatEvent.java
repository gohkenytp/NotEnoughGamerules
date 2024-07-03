package net.reikeb.not_enough_gamerules.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.reikeb.not_enough_gamerules.Gamerules;
import net.reikeb.not_enough_gamerules.NotEnoughGamerules;

@EventBusSubscriber(modid = NotEnoughGamerules.MODID)
public class ChatEvent {

    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        if (event.getPlayer() == null) return;
        if (event.getPlayer().level().getLevelData().getGameRules().getBoolean(Gamerules.DISABLE_CHAT)) {
            event.setCanceled(event.isCanceled());
        }
    }
}

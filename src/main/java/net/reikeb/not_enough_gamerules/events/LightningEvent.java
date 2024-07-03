package net.reikeb.not_enough_gamerules.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;
import net.reikeb.not_enough_gamerules.Gamerules;
import net.reikeb.not_enough_gamerules.NotEnoughGamerules;

@EventBusSubscriber(modid = NotEnoughGamerules.MODID)
public class LightningEvent {

    @SubscribeEvent
    public static void onLightning(EntityStruckByLightningEvent event) {
        int lightningDamage = event.getLightning().level().getLevelData().getGameRules().getInt(Gamerules.LIGHTNING_DAMAGE);
        if (lightningDamage > -1) {
            event.setCanceled(event.isCanceled());
            event.getEntity().hurt(event.getEntity().damageSources().lightningBolt(), (float) lightningDamage);
        }
    }
}

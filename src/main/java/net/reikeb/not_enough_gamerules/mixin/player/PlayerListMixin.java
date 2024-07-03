package net.reikeb.not_enough_gamerules.mixin.player;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.reikeb.not_enough_gamerules.Gamerules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerList.class)
public class PlayerListMixin {

    @Inject(method = "respawn", at = @At("TAIL"))
    private void respawn(ServerPlayer pPlayer, boolean pKeepEverything, Entity.RemovalReason p_348558_, CallbackInfoReturnable<ServerPlayer> cir) {
        Player newPlayer = cir.getReturnValue();
        if (newPlayer.level().getGameRules().getBoolean(Gamerules.KEEP_EFFECTS)) {
            for (int i = 0; i < pPlayer.getActiveEffects().size(); i++) {
                MobEffectInstance effectInstance = pPlayer.getActiveEffects().stream().toList().get(i);
                newPlayer.addEffect(effectInstance, pPlayer);
            }
        }
    }
}

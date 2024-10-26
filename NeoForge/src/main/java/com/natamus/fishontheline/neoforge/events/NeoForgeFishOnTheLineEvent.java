package com.natamus.fishontheline.neoforge.events;

import com.natamus.fishontheline.events.FishOnTheLineEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeFishOnTheLineEvent {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Pre e) {
		Player player = e.getEntity();
		Level level = player.level();
		if (level.isClientSide) {
			return;
		}

		FishOnTheLineEvent.onPlayerTick((ServerLevel)level, (ServerPlayer)player);
	}
}

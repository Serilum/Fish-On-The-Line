package com.natamus.fishontheline.forge.events;

import com.natamus.fishontheline.events.FishOnTheLineEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeFishOnTheLineEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeFishOnTheLineEvent.class);

		PlayerTickEvent.Pre.BUS.addListener(ForgeFishOnTheLineEvent::onPlayerTick);
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Pre e) {
		Player player = e.player();
		Level level = player.level();
		if (level.isClientSide()) {
			return;
		}

		FishOnTheLineEvent.onPlayerTick((ServerLevel)level, (ServerPlayer)player);
	}
}

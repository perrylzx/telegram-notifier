package com.telegramnotifier;

import com.google.inject.Provides;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;
import net.runelite.client.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;

@Slf4j
@PluginDescriptor(
		name = "Telegram Notifier",
		description = "Sends Telegram messages on valuable drops",
		tags = {"drop", "telegram", "loot", "notify"}
)
public class TelegramNotifierPlugin extends Plugin
{
	@Inject
	private ScheduledExecutorService executor;

	@SuppressWarnings("unused")
	@Provides
	TelegramNotifierConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TelegramNotifierConfig.class);
	}

	@Inject
	private TelegramNotifierConfig config;

	@Inject
	private TelegramNotifierService telegramService;

	@SuppressWarnings("unused")
	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = event.getMessage();

		if (message.matches(config.pattern()))
		{
			executor.execute(() -> telegramService.sendMessage(message));
		}
	}
}

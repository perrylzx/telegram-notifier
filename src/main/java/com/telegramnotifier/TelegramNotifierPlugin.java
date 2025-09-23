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
	private String buildPattern() {
		String keywords = config.keywords().trim();
		if (keywords.isEmpty()) {
			return "a^"; // Match nothing if no keywords specified
		}
		
		String[] keywordArray = keywords.split(",");
		StringBuilder pattern = new StringBuilder("(?i).*?\\b(");
		
		for (int i = 0; i < keywordArray.length; i++) {
			String keyword = keywordArray[i].trim();
			if (!keyword.isEmpty()) {
				// Escape special regex characters in the keyword
				keyword = keyword.replaceAll("[\\[\\](){}.*+?^$|\\\\]", "\\\\$0");
				pattern.append(keyword);
				if (i < keywordArray.length - 1) {
					pattern.append("|");
				}
			}
		}
		
		pattern.append(")\\b.*?");
		return pattern.toString();
	}

	@SuppressWarnings("unused")
	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String rawMessage = event.getMessage();
		
		final String message = rawMessage.replaceAll("<[^>]*>", "");

		if (message.matches(buildPattern()))
		{
			executor.execute(() -> telegramService.sendMessage(message));
		}
	}
}

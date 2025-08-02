package com.telegramnotifier;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("telegramnotifier")
public interface TelegramNotifierConfig extends Config
{
	@ConfigItem(
			keyName = "pattern",
			name = "Message Pattern",
			description = "Regex pattern for messages to send to Telegram"
	)


	default String pattern() {
		return ".*valuable drop*";
	}
	@ConfigItem(
			keyName = "telegramBotToken",
			name = "Telegram Bot Token",
			description = "Your bot token from BotFather"
	)
	default String telegramBotToken()
	{
		return "";
	}

	@ConfigItem(
			keyName = "telegramChatId",
			name = "Telegram Chat ID",
			description = "Your Telegram chat ID"
	)
	default String telegramChatId()
	{
		return "";
	}

}

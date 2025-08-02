package com.telegramnotifier;


import javax.inject.Inject;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class TelegramNotifierService
{
    private final TelegramNotifierConfig config;

    @Inject
    public TelegramNotifierService(TelegramNotifierConfig config)
    {
        this.config = config;
    }

    public void sendMessage(String message)
    {
        try {
            String TELEGRAM_BOT_TOKEN = config.telegramBotToken();
            String CHAT_ID = config.telegramChatId();
            String urlStr = String.format(
                    "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                    TELEGRAM_BOT_TOKEN, CHAT_ID, URLEncoder.encode(message, StandardCharsets.UTF_8)
            );
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");
            conn.getInputStream().close();
        } catch (IOException e) {
            log.warn("Error while sending telegram message: {}", e.getMessage());
        }
    }
}

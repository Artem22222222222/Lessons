package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultWebhook;

public class Main {
    public static void main(String[] args) {
        String webhookUrl = "https://yourdomain.com:8443/YOUR_WEBHOOK_PATH";

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultWebhook.class);

            MyTelegramBot bot = new MyTelegramBot("YourBotUsername", "YOUR_BOT_TOKEN", "YOUR_WEBHOOK_PATH");

            SetWebhook setWebhook = new SetWebhook();
            setWebhook.setUrl(webhookUrl);

            botsApi.registerBot(bot, setWebhook);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
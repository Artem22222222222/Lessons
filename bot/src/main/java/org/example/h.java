package org.example;

import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebhookController {
    private final MyTelegramBot telegramBot;

    public WebhookController(MyTelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostMapping("/YOUR_WEBHOOK_PATH")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
    }
}

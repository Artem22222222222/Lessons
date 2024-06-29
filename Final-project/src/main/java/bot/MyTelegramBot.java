package bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class MyTelegramBot extends TelegramLongPollingBot {
    private final long adminID = 5627136609L;


    @Value("${telegram.bot.username}")
    private String botUsername = "Lbot";

    @Value("${telegram.bot.token}")
    private String botToken = "7290756550:AAFocdm5ZFO8dUegvWonh0zOwMgX3rVBDzg";

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.startsWith("/appeal")){
                String parseMessage = messageText.substring(8);
                sendMessage(parseMessage, adminID);
                sendMessage("sent", chatId);
            }
        }
    }
    private void sendMessage(String text, long ID){
        SendMessage message = new SendMessage();
        message.setChatId(ID);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}


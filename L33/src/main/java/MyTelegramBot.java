import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyTelegramBot extends TelegramLongPollingBot {
    ArrayList<User1> users = new ArrayList<>();
    ArrayList<String> gameField = new ArrayList<>();
    boolean gameStart = false;
    long nextUser;
    int course;
    SendMessage message;

    @Override
    public String getBotUsername() {
        return "Cijgeksogcgbot"; // замініть на ім'я вашого бота
    }

    @Override
    public String getBotToken() {
        return "7290756550:AAFocdm5ZFO8dUegvWonh0zOwMgX3rVBDzg"; // замініть на токен вашого бота
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();



            beforStart(chatId);

            switcher(chatId, messageText);



        }
    }

    private void game(String messageText, User1 user1) {

            course = Integer.parseInt(messageText);
            gameField.set(course, user1.getCross());
            sendField();

    }

    private void sendField() {
        sendMasege("ти ходиш", nextUser);
        for (int i = 0; i < users.size(); i++) {
            message = new SendMessage();
            message.setChatId(String.valueOf(users.get(i).getId()));
            message.setText(Field.draw(gameField));
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    private void sendMasege(String mesege,  long id) {
            message = new SendMessage();
            message.setChatId(String.valueOf(id));
            message.setText(mesege);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
    }



    private void switcher(long chatId, String message) {
        if (nextUser == chatId && gameStart){
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() != chatId){
                    nextUser = users.get(i).getId();
                }else {
                    game(message, users.get(i));
                }
            }
        }
    }

    private void beforStart(long chatId) {
        if (!gameStart) {


                    if (users.isEmpty()) {
                        users.add(new User1(chatId, "x"));
                        nextUser = chatId;
                        System.out.print("add first");
                    }else {
                        users.add(new User1(chatId, "o"));
                        System.out.print("add 2");
                    }


        }else return;
        if (users.size() == 2){
            for (int i = 0; i < 9; i++) {
                gameField.add("_");
            }

            gameStart = true;
        }
    }


    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}

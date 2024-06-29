import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class OpenAIClient {
    public String getOpenAIResponse(String userMessage) {
        String apiKey = "sk-proj-TBphi6fmuR2ELmveL8CNT3BlbkFJTEit8IGWIEvqlvgsSlLV";
        String apiEndpoint = "https://api.openai.com/v1/chat/completions";

        HttpClient client = HttpClient.newHttpClient();
        JsonObject json = new JsonObject();
        json.addProperty("model", "gpt-3.5-turbo"); // або gpt-4, залежно від вашої моделі
        JsonArray messages = new JsonArray();

        JsonObject message = new JsonObject();
        message.addProperty("role", "user");
        message.addProperty("content", userMessage);
        messages.add(message);

        json.add("messages", messages);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiEndpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject responseBody = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonArray choices = responseBody.getAsJsonArray("choices");
            if (choices.size() > 0) {
                return choices.get(0).getAsJsonObject().get("message").getAsJsonObject().get("content").getAsString();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "Sorry, I couldn't process your request.";
    }
}

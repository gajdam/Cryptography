import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class WordChecker {
    private static String RAPIDAPI_KEY;

    static {
        try {
            // Load the properties file
            Properties prop = new Properties();
            InputStream inputStream = WordChecker.class.getClassLoader().getResourceAsStream("config.properties");
            if (inputStream != null) {
                prop.load(inputStream);
                RAPIDAPI_KEY = prop.getProperty("rapidapi.key");
            } else {
                // Handle case when config.properties is not found
                throw new RuntimeException("config.properties not found in the classpath");
            }
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

    public static boolean checkWord(String word) {
        try {
            // Create URL for Words API query
            String urlString = "https://wordsapiv1.p.rapidapi.com/words/" + word;
            URL url = new URL(urlString);

            // Establish connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-rapidapi-key", RAPIDAPI_KEY);
            connection.setRequestProperty("x-rapidapi-host", "wordsapiv1.p.rapidapi.com");

            // Get response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Check if response indicates the word exists
                return response.toString().contains("\"word\":\"" + word + "\"");
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}

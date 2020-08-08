package sl.selftraining.backend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Erandika Harshani
 * Created on July 29, 2020
 */

//@Configuration
public class FirebaseConfig {
  @Value("${puplication.firebaseUrl}")
  private String fireBaseUrl;

    @Bean
    public FirebaseApp firebase() throws IOException {
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl(fireBaseUrl)
                .build();

        return FirebaseApp.initializeApp(options);
    }
}

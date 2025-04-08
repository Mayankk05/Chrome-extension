package time.tracker.time.tracker.model;



import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "website_activity")
public class WebsiteActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String websiteUrl;
    private Long timeSpent; // in seconds

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // Format timestamp
    private LocalDateTime timestamp;

    // Default constructor (Required by JPA)
    public WebsiteActivity() {}

    // Constructor for saving data
    public WebsiteActivity(String websiteUrl, Long timeSpent) {
        this.websiteUrl = websiteUrl;
        this.timeSpent = timeSpent;
        this.timestamp = LocalDateTime.now();
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for websiteUrl
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    // Getter and Setter for timeSpent
    public Long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Long timeSpent) {
        this.timeSpent = timeSpent;
    }

    // Getter and Setter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

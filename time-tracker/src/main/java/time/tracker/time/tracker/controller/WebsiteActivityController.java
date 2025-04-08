package time.tracker.time.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import time.tracker.time.tracker.model.WebsiteActivity;
import time.tracker.time.tracker.service.WebsiteActivityService;

@RestController
@RequestMapping("/api/activity")
public class WebsiteActivityController {

    @Autowired
    private WebsiteActivityService service;

    // Track website activity
    @PostMapping("/track")
    public ResponseEntity<WebsiteActivity> trackWebsite(@RequestParam String websiteUrl, @RequestParam Long timeSpent) {
        WebsiteActivity activity = service.saveActivity(websiteUrl, timeSpent);

        // Log the full object explicitly to verify it's being saved correctly
        System.out.println("Saved Activity: ID=" + activity.getId() +
                ", Website=" + activity.getWebsiteUrl() +
                ", Time Spent=" + activity.getTimeSpent() +
                ", Timestamp=" + activity.getTimestamp());

        return ResponseEntity.ok(activity); // Return the entity as JSON
    }

    // Fetch all tracked activities
    @GetMapping("/all")
    public Iterable<WebsiteActivity> getAllActivities() {
        return service.getAllActivities();
    }
}


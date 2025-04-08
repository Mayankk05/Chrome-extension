package time.tracker.time.tracker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import time.tracker.time.tracker.model.WebsiteActivity;
import time.tracker.time.tracker.repo.WebsiteActivityRepository;

@Service
public class WebsiteActivityService {

    @Autowired
    private WebsiteActivityRepository repository;

    // Save activity and return it
    public WebsiteActivity saveActivity(String websiteUrl, Long timeSpent) {
        WebsiteActivity activity = new WebsiteActivity(websiteUrl, timeSpent);
        return repository.save(activity); // Save and return the entity
    }

    // Fetch all activities
    public Iterable<WebsiteActivity> getAllActivities() {
        return repository.findAll();
    }
}


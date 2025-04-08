package time.tracker.time.tracker.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import time.tracker.time.tracker.model.WebsiteActivity;

import java.util.List;


@Repository
public interface WebsiteActivityRepository extends JpaRepository<WebsiteActivity, Long> {
    List<WebsiteActivity> findByWebsiteUrl(String websiteUrl);
}

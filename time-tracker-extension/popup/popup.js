// popup.js

document.getElementById('refreshBtn').addEventListener('click', fetchActivities);

function fetchActivities() {
    fetch('http://localhost:8080/api/activity/all')
        .then(response => response.json())
        .then(data => {
            const activitiesDiv = document.getElementById('activities');
            activitiesDiv.innerHTML = ""; // Clear the current activities

            if (data.length === 0) {
                activitiesDiv.innerHTML = "<p>No activities tracked yet.</p>";
            } else {
                data.forEach(activity => {
                    const activityElement = document.createElement('div');
                    activityElement.innerHTML = `
                        <p>Website: ${activity.websiteUrl}</p>
                        <p>Time Spent: ${activity.timeSpent} seconds</p>
                        <p>Timestamp: ${activity.timestamp}</p>
                        <hr>
                    `;
                    activitiesDiv.appendChild(activityElement);
                });
            }
        })
        .catch(error => {
            console.error('Error fetching activities:', error);
        });
}

// Fetch activities initially when the popup is opened
fetchActivities();

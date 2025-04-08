// background.js

let activeTabUrl = "";

// Listen for changes in the active tab
chrome.tabs.onActivated.addListener((activeInfo) => {
    chrome.tabs.get(activeInfo.tabId, (tab) => {
        activeTabUrl = tab.url;
        // Send the time spent to the backend
        sendTimeSpentToBackend(activeTabUrl, 1);  // Here, we're assuming 1 second for simplicity
    });
});

// Function to send time spent to backend
function sendTimeSpentToBackend(websiteUrl, timeSpent) {
    fetch(`http://localhost:8080/api/activity/track?websiteUrl=${websiteUrl}&timeSpent=${timeSpent}`, {
        method: 'POST',
    }).then((response) => {
        return response.json();
    }).then((data) => {
        console.log("Activity saved:", data);
    }).catch((error) => {
        console.error("Error:", error);
    });
}

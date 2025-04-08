// api.js

const API_BASE_URL = 'http://localhost:8080/api/activity';

export function trackActivity(websiteUrl, timeSpent) {
    return fetch(`${API_BASE_URL}/track?websiteUrl=${websiteUrl}&timeSpent=${timeSpent}`, {
        method: 'POST',
    }).then((response) => response.json())
    .catch((error) => {
        console.error("Error:", error);
    });
}

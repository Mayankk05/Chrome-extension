// content.js

let startTime = Date.now();

window.onbeforeunload = function () {
    let timeSpent = (Date.now() - startTime) / 1000;  // Time spent in seconds
    chrome.runtime.sendMessage({ websiteUrl: window.location.href, timeSpent: timeSpent });
};

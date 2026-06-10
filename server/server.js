const express = require('express');
const path = require('path');
const app = express();

const TARGET = process.env.TARGET_URL || 'https://toffeelive.com/en/watch/sy5m-JQBv9knK3AHYTTk';
const PORT = process.env.PORT || 3000;

// Immediate server redirect at root
app.get('/', (req, res) => {
  res.redirect(302, TARGET);
});

// Serve branded landing page at /landing
app.get('/landing', (req, res) => {
  res.sendFile(path.join(__dirname, '..', 'site', 'index.html'));
});

// Serve static assets for the landing page
app.use('/assets', express.static(path.join(__dirname, '..', 'site', 'assets')));

app.listen(PORT, () => {
  console.log(`Open Live TV server listening on port ${PORT}`);
});

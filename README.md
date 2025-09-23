# 📬 RuneLite Telegram Notifier Plugin

This RuneLite plugin sends Telegram messages to your phone when specific in-game events happen — like rare loot drops, level-ups, or anything else you want to track.

---

## 🚀 Features

- Sends real-time alerts to Telegram
- Customizable triggers (e.g. loot, levels, chat messages)
- Lightweight and private — no 3rd-party servers required

---

## 📲 How to Set Up Telegram Notifications

### ✅ Step 1: Create a Telegram Bot

1. Open Telegram and search for [`@BotFather`](https://t.me/BotFather).
2. Start a chat and send:
   ```
   /newbot
   ```
3. Follow the prompts:
   - Set a **name** (e.g. `RuneNotifier`)
   - Set a **username** (must end with `bot`, e.g. `RuneNotifier_bot`)
4. After completing setup, BotFather will give you a **Bot Token** like:
   ```
   123456789:ABCDefGhIJKlmNoPQRstuVWxyz12345678
   ```

🔒 **Save this token** — you’ll need it for the plugin.

---

### 🆔 Step 2: Get Your Telegram Chat ID

1. In Telegram, search for [`@userinfobot`](https://t.me/userinfobot).
2. Start a chat and send any message.
3. The bot will reply with your info. Look for a line like:
   ```
   Your Chat ID: 123456789
   ```
4. Copy this number — it’s your **Telegram Chat ID**.

---

### ⚙️ Step 3: Configure the Plugin

1. Launch RuneLite and open the **plugin panel**.
2. Find and enable `Telegram Notifier`.
3. Open the plugin configuration:
   - Paste your **Bot Token** from Step 1.
   - Paste your **Chat ID** from Step 2.
   - Set your **Message Pattern** (see below for details).
4. Done! You'll now receive Telegram alerts when your triggers fire.

---

## 🎯 Setting Up Keywords

The plugin uses **keyword matching** to detect when to send notifications. Simply enter a comma-separated list of words or phrases you want to track.

### 📝 Examples

**For rare drops:**
```
superior, granite maul, abyssal whip, abyssal dagger, dragon dagger
```

**For prayer warnings:**
```
low prayer, prayer potion, restore potion
```

**For combat alerts:**
```
the effects of your goading potion, low health, low run energy
```

### 💡 Tips

- **Case-insensitive**: `"ABYSSAL WHIP"` and `"abyssal whip"` both work
- **Whole words only**: `"whip"` won't match `"whipped"` 
- **Multiple words**: Just separate with commas (e.g., `granite maul, abyssal whip`)

---

## 🔐 Privacy & Security

- Your bot token and chat ID are stored **locally** using RuneLite's built-in config system.
- Messages are sent directly from your PC to Telegram using their **official API** — no data is sent elsewhere.

---

## 🧪 Troubleshooting

- **Not receiving messages?**
  - Make sure you've messaged your bot at least once on Telegram.
  - Double-check your bot token and chat ID.
  - Verify your keywords are set correctly (not empty).
- **Getting too many notifications?**
  - Make your keywords more specific (e.g., `"abyssal whip"` instead of just `"whip"`).
  - Remove common words that appear in many messages.
- **Not getting notifications for specific items?**
  - Check that the exact text appears in the game chat.
  - Try adding variations (e.g., both `"dragon dagger"` and `"dragon dagger (p++)"`).
- **Still stuck?**
  - Enable developer logs in RuneLite and check for Telegram API errors.

---

## 🤝 Contributing

Feel free to fork and modify this plugin to suit your needs. Pull requests welcome.

---

## 📜 License

MIT
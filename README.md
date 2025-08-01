# 🔐 Secure Chat App

A real-time encrypted chat application built for private and secure communication using modern cryptographic techniques.

## 🚀 Features

- ✅ End-to-end encryption (AES & RSA)
- ✅ Real-time messaging via WebSockets
- ✅ User authentication and session management
- ✅ Secure message storage (optional)
- ✅ Minimal and responsive UI

## 🧱 Tech Stack

- **Frontend:** HTML5, CSS3, JavaScript
- **Backend:** Python (Django or Flask)
- **Real-time:** Django Channels / WebSocket
- **Encryption:** Python `cryptography` / `PyCrypto` / custom RSA-AES integration
- **Database:** PostgreSQL / SQLite

## 🛠 Installation

```bash
# 1. Clone the repository
git clone https://github.com/yourusername/secure-chat-app.git
cd secure-chat-app

# 2. Set up a virtual environment (optional but recommended)
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate

# 3. Install dependencies
pip install -r requirements.txt

# 4. Run the app
python manage.py runserver


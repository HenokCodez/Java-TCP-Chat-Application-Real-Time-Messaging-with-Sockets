# **Java TCP Chat Application**

### *Advanced Programming Project — Network Programming (TCP)*

This project is my implementation of a **real-time chat system** using Java’s TCP socket programming — specifically the concepts introduced in Chapter 4 of my Advanced Programming course. The goal is to apply what I learned about server sockets, client sockets, I/O streams, and multithreaded client handling to build a working client–server chat application.

## **Project Description**

The chat system is built around the classic **request–response model**:

* A **server** waits on a specific TCP port using a `ServerSocket`.
* Clients connect using `Socket`, providing the server’s IP address and port number.
* Once the connection is established, both sides communicate through **I/O streams** (using `BufferedReader`, `PrintWriter`, or Data streams).
* Each client runs on its own thread so the server can handle multiple users at the same time.

The application puts into practice the following topics from the chapter:

### **✔ ServerSocket and Socket**

Creating a server that continuously listens for connection requests and clients that connect using the server’s hostname and port.

### **✔ Input and Output Streams**

Using `getInputStream()` and `getOutputStream()` to exchange data through the socket, wrapped in higher-level classes for strings and text communication.

### **✔ Multithreading**

Every new client connection is assigned its own thread so multiple users can chat without blocking each other — exactly as covered in the “server serving multiple clients” section.

### **✔ InetAddress**

Retrieving and printing client IP and hostname details for transparency and basic logging.

Although UDP and datagrams were also introduced in class, this project focuses entirely on the *connection-oriented* TCP model.

---

## **What the Repository Will Contain**

* `Server.java` — handles all incoming connections, creates threads for each client
* `Client.java` — connects to the server and sends/receives messages via TCP
* `ClientHandler.java` — a thread class that manages communication for a single client
* `README.md` (this file)
* `/src` folder with all classes
* Config files such as `.gitignore`

This repository will track my progress as I implement each piece — starting from a basic connection and building toward full multi-user messaging.

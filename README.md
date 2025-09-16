# CSC3935Project1_Ashworth_Liang_Oullette
This project implements the server-side functionality of a simplified e-mail system, inspired by late-90s style mail servers. The goal is to gain hands-on experience with network programming, concurrency, and protocol design while working in a collaborative team environment.

Students will develop two multi-threaded servers:

SMTP Server (RFC 821) – handles sending and relaying of mail messages.

POP3 Server (RFC 1939) – handles retrieval and management of messages for client mailboxes.

The servers use the maildir format to store e-mail messages in per-user directories with new and tmp subfolders. Configuration is JSON-based, and logging is performed to external text files.


Aplikasi Chat Sederhana dengan TCP







Proyek ini merupakan implementasi aplikasi chat sederhana yang dikerjakan oleh 


Pazrian Nurul LatiP Nim ; 362201004 


okky agung sunata Nim : 362201008


menggunakan model jaringan TCP (Transmission Control Protocol). Aplikasi ini terdiri dari server (ChatTCPServer) dan klien (ChatTCPClient). Server dapat menangani beberapa klien secara simultan dengan menggunakan thread individual untuk setiap koneksi.

Fitur
Server (ChatTCPServer.java)
Menerima koneksi dari klien.
Membuat thread khusus (ChatServerThread) untuk setiap klien yang terhubung.
Mengelola daftar klien yang terhubung.
Menyebarkan pesan dari satu klien ke semua klien yang terhubung.
Server Thread (ChatServerThread.java)
Membaca nama pengguna dari klien saat pertama kali terhubung.
Mengirimkan pesan bergabung ke semua klien saat klien baru terhubung.
Membaca dan menyebarkan pesan dari klien.
Mengatasi keluar masuknya klien dan memberikan pemberitahuan ke semua klien.
Klien (ChatTCPClient.java)
Menghubungkan diri ke server menggunakan TCP.
Menerima input pengguna untuk nama pengguna.
Mengirim dan menerima pesan dari server.



-Penggunaan


1
Kompilasi berkas Java server dan client:
-javac ChatTCPServer.java

-javac ChatServerThread.java

-javac ChatTCPClient.java

2
Jalankan server:
java ChatTCPServer

3
Jalankan klien(s):

3
java ChatTCPClient
Masukkan nama pengguna untuk setiap klien.

Mulai berbicara!

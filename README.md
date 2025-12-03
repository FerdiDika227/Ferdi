# Sistem Informasi Mahasiswa
 Project ini merupakan aplikasi sederhana berbasis Java (NetBeans) yang menggunakan JDBC,
 Hibernate, dan JasperReport untuk mengelola data mahasiswa serta menampilkan laporan dalam
 bentuk PDF/Report.

[![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

## Fitur Utama
- Tambah, edit, hapus data mahasiswa
- Penyimpanan data menggunakan database MySQL
- Koneksi database menggunakan Hibernate
- Generate laporan menggunakan JasperReport
- Struktur project mengikuti standar NetBeans (MVC sederhana)

## Struktur Folder
 /src
 /config → Konfigurasi Hibernate
 /controller → Logic aplikasi
 /model → Model entity Hibernate
 /report → File JRXML (LaporanMahasiswa.jrxml)
 /view → Tampilan form Swing
 /nbproject → Konfigurasi NetBeans
 /build → Hasil compile
 build.xml → Build script
 manifest.mf → File manifest program

## Teknologi Yang Digunakan
- Java JDK 8+
- NetBeans IDE
- MySQL Database
- Hibernate ORM
- JasperReport + iReport/JasperSoft Studio

## Cara Menjalankan Aplikasi
 1. Clone repository
 git clone https://github.com/FerdiDika227/Ferdi
 2. Buka project di NetBeans
 3. Import JDBC & Hibernate library (jika belum otomatis)
 4. Buat database MySQL sesuai konfigurasi di hibernate.cfg.xml
 5. Jalankan file utama (Main.java)
 6. Untuk melihat laporan → klik tombol Cetak Laporan
 
## Link Github
https://github.com/FerdiDika227/Ferdi

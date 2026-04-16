package com.example.prototypevolunteerapp.data.model

import com.example.prototypevolunteerapp.R

data class ActivityData(
    val title: String,
    val location: String,
    val description: String,
    val imageRes: Int,
    val instagram: String?= null,
    val link:String?= null
)

// 3 data asli dari instagram
fun getDummyActivities() = listOf(
    ActivityData(
        "Little Chef Day: Petualangan Rasa dan Cerita di Wizzmie Solo",
        "Wizzmie Solo",
        """
Yuk, isi akhir pekanmu dengan kegiatan yang seru dan penuh makna! 👨‍🍳🍳

Di kegiatan “Little Chef Day: Petualangan Rasa dan Cerita di Wizzmie Solo” kali ini, kita akan mengikuti cooking class bersama Wizzmie dan adik-adik untuk mengeksplorasi dunia kuliner dan mencicipi berbagai menu lezat.

Bukan cuma sekadar kelas memasak, di sini kita juga akan:
• Berbagi cerita
• Tertawa bersama
• Menghadirkan kebahagiaan dalam suasana hangat 💖✨

🎁 Benefit yang kamu dapatkan:
• Sertifikat
• Kaos Peduly (khusus volunteer baru)
• Konsumsi Wizzmie
• Dokumentasi kegiatan
• Teman baru yang seru & inspiratif
• Diskon spesial untuk peserta lama

📅 Minggu, 12 April 2026
⏰ 10.00 – 13.00 WIB
📍 Wizzmie Solo

⚠️ Kuota terbatas! Hanya untuk 15 orang dan TANPA SELEKSI.

🔗 Daftar sekarang:
peduly.com/littlechefdaysolo

Jangan sampai ketinggalan! 🚀
""".trimIndent(),
        R.drawable.social_activity1,
        instagram = "https://www.instagram.com/p/DWh7HgyCV54/?utm_source=ig_web_copy_link",
        link = "https://peduly.com/littlechefdaysolo"

    ),

    ActivityData(
        "Abdination Indonesia | Chapter Labuan Bajo",
        "Labuan Bajo, NTT",
        """
⚓ OPEN VOLUNTEER GELOMBANG 2 ABDINATION MENGABDI #3 ⚓

Hai Abdiners! Gelombang 2 resmi dibuka dan menunggu kamu 🔥🙌

Abdination Indonesia mengajak kamu untuk:
• Mengabdi
• Belajar
• Menjelajahi keindahan Labuan Bajo

📅 Timeline:
• Pendaftaran: 5 – 30 April 2026
• Pelaksanaan: 11 – 22 Agustus 2026

📍 Lokasi:
Pulau Longos, Manggarai Barat – Labuan Bajo, NTT

📌 Pilihan Divisi:
• Pendidikan
• Kesehatan
• Lingkungan

✨ Keuntungan:
• Transportasi & akomodasi GRATIS
• Sertifikat internasional
• Webinar beasiswa luar negeri
• Pendampingan sponsorship
• Fasilitas program kerja
• Dokumentasi lengkap
• Rompi, ID Card & Lanyard
• Pengalaman & eksplorasi Labuan Bajo

👥 Syarat:
• Terbuka untuk umum (tanpa batas umur)
• Memiliki ide dan siap bekerja sama

🔗 Daftar:
https://linktr.ee/AbdinationIndonesiaMengabdi3

Pemuda Mengabdi, Indonesia Emas ✨
""".trimIndent(),
        R.drawable.social_activity2,
        instagram = "https://www.instagram.com/p/DWv13w-D2NX/?utm_source=ig_web_copy_link",
        link = "https://linktr.ee/AbdinationIndonesiaMengabdi3"
    ),

    ActivityData(
        "From Heart to Paper: A Day of Kind Words",
        "KGJ Ciliwung, Jakarta Timur",
        """
Karena kata-kata baik bisa lahir dari hati yang tulus 💌✨

Melalui kegiatan ini, kamu akan belajar:
• Menulis dengan makna
• Mengekspresikan perasaan
• Menyebarkan kebaikan 🌱

Kegiatan yang akan kamu ikuti:
• Bonding session
• Fun games
• Workshop membuat kipas kertas
• Menulis & menghias surat
• Sharing session penuh makna

Sebuah ruang sederhana untuk mengingat bahwa:
kebaikan bisa dimulai dari hal kecil 🤍

📅 Minggu, 12 April 2026
⏰ 10.00 – 13.00 WIB
📍 KGJ Ciliwung, Jakarta Timur

🔗 Pendaftaran:
https://forms.gle/G6W3YQk3yJ3DgdaP8

📲 Info lebih lanjut:
@tebarbaik.idn

Yuk, jadi bagian dari kebaikan ini! 🌟
""".trimIndent(),
        R.drawable.social_activity3,
        instagram = "https://www.instagram.com/p/DW0XLLtklJF/?utm_source=ig_web_copy_link",
        link = "https://forms.gle/G6W3YQk3yJ3DgdaP8"
    )
)
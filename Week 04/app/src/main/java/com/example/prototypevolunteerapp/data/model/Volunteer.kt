package com.example.prototypevolunteerapp.data.model

import com.example.prototypevolunteerapp.R

data class Volunteer(
    val name: String,
    val description: String,
    val imageRes: Int,
    val phone: String? = null,
    val email: String? = null,
    val education: String
)

// dummy description, image from real tim
fun getDummyVolunteers() = listOf(
    Volunteer(
        "Saskya Aliya Azizah",
        """


📍 Tempat, Tanggal Lahir:
Yogyakarta, 12 Mei 2005

🎓 Pendidikan:
Mahasiswa S-1 Informatika, Universitas Sebelas Maret angkatan 2024

💡 Keahlian:
Leadership, UI/UX Design, Problem Solving, Teamwork, Communication Skill, Public Speaking

❤️ Minat:
Kegiatan sosial, pendidikan anak, lingkungan, dan pengembangan komunitas

📝 Tentang Saya:
Saya adalah seorang relawan yang memiliki semangat tinggi dalam berkontribusi untuk masyarakat. Saya percaya bahwa perubahan besar dimulai dari langkah kecil, dan melalui kegiatan sosial saya ingin memberikan dampak positif bagi lingkungan sekitar.

🌍 Pengalaman Volunteer & Social Activity:
• Relawan "Aksi Bersih Pantai Parangtritis" (2025)  
• Volunteer "Donor Darah Bersama PMI Yogyakarta" (2025)  
• Kegiatan "Penanaman Pohon di Sleman" (2024)  
• Event "Little Chef Day" (2026)  

🤝 Pengalaman Organisasi:
• Staff Kementrian Riset dan Data – BEM UNS (2025)
• Anggota Divisi Kurikulum – DataTalks (2025)
• Aktif dalam kegiatan mengajar dan sosialisasi 
• Anggota Divisi Sosial di Komunitas Mahasiswa Peduli Lingkungan

        """.trimIndent(),
        R.drawable.volunteer1,
        phone = "6285183163106",
        email = "saskyaaliyaazizah06@email.com",
        education = "Mahasiswa Informatika, UNS"
    ),
    Volunteer(
        "Mumtazah Nur Hidayati",
        """
            
            
📍 Tempat, Tanggal Lahir:
Klaten, 20 Agustus 2006

🎓 Pendidikan:
Mahasiswa S-1 Informatika, Universitas Sebelas Maret angkatan 2024

💡 Keahlian:
Time Management, Creative Thinking, Teamwork, Communication Skill, Problem Solving

❤️ Minat:
Pemberdayaan perempuan, kesehatan mental, literasi digital, dan bantuan kemanusiaan

📝 Tentang Saya:
Saya adalah pribadi yang memiliki empati tinggi dan dedikasi untuk membantu sesama. Saya sangat tertarik pada isu-isu sosial dan percaya bahwa kolaborasi antar individu dapat menciptakan solusi yang bermakna bagi permasalahan di masyarakat.

🌍 Pengalaman Volunteer & Social Activity:
• Relawan "Sahabat Anak Jalanan" (2025)
• Volunteer "Emergency Response Team" (2025) 
• Kegiatan "Klaten Membaca" (2024) 
• Event "Health Awareness Week" (2026) 

🤝 Pengalaman Organisasi:
- Public Relation (Humas) 
- Staf Divisi PSDM (Pengembangan Sumber Daya Mahasiswa)

        """.trimIndent(),
        R.drawable.volunteer2,
        phone = "6285743192088",
        email = "mumtatazah@gmail.com",
        education = "Mahasiswa Informatika, UNS"
    ),
    Volunteer(
        "Sanny Tazkiyah Fastabiqul Husna",
        """
            
            
📍 Tempat, Tanggal Lahir:
Boyolali, 09 Maret 2007

🎓 Pendidikan:
Mahasiswa S-1 Informatika, Universitas Sebelas Maret angkatan 2024

💡 Keahlian:
• Technical Logic: Analisis Logika, Pemrograman (C, C++, Java), Struktur Data, Perancangan Sistem, Dasar Data Science, dan Dasar Cyber Security.
• Human Skills: Leadershi, UI/UX Design, & Social Media Management.

❤️ Minat:
Statistika, pengembangan game interaktif, isu lingkungan, edukasi, hingga eksplorasi alam.

📝 Tentang Saya:
Saya adalah mahasiswa Informatika yang percaya bahwa teknologi terbaik lahir dari logika yang kuat dan empati yang dalam. Meskipun perjalanan akademik penuh dengan tantangan dan dinamika, saya telah belajar untuk menjadi pribadi yang resilient dan adaptif. Fokus saya adalah mengubah kompleksitas algoritma menjadi solusi yang berdampak nyata bagi masyarakat, baik melalui baris kode maupun aksi sosial di lapangan.

🌍 Pengalaman Volunteer & Social Activity:
• Manajemen Logistik & Penyaluran Donasi Sekolah (2023)
• Proyek Instalasi Hidroponik & Optimalisasi Ruang Hijau (2022)

🤝 Pengalaman Organisasi:
• Deputi Pengawas dan Penguji Mutu – BEM FATISDA (2026)
• Staff Divisi Bisnis dan Kemitraan – BEM FATISDA
• Divisi Sosial – Komunitas Peduli Lingkungan

        """.trimIndent(),
        R.drawable.volunteer3,
        phone = "6285800379000",
        email = "sannytazkiyah@gmail.com",
        education = "Mahasiswa Informatika, UNS"
    ),
    Volunteer(
        "Queen Nika Prahara Mutiara Phasya",
        """
           
           
📍 Tempat, Tanggal Lahir:
Ngawi, 04 Oktober 2006

🎓 Pendidikan:
Mahasiswa S-1 Informatika, Universitas Sebelas Maret angkatan 2024.

💡 Keahlian:
- Technical Logic: Machine Learning, Data Analytics, Web Development (HTML, CSS, JavaScript), dan Cloud Computing.
- Human Skills: Public Speaking, Team Collaboration, Time Management, dan Creative Problem Solving.

❤️ Ketertarikan: Teknologi informasi, inovasi pendidikan, pengembangan komunitas digital, dan pemberdayaan perempuan dalam teknologi.

📝 Profil Singkat:
Saya adalah mahasiswa Informatika yang berdedikasi untuk memanfaatkan teknologi sebagai alat transformasi sosial. Saya percaya bahwa inovasi teknologi harus diiringi dengan empati dan kesadaran akan dampaknya bagi masyarakat. Fokus saya adalah menciptakan solusi digital yang inklusif dan berkelanjutan.

🌍 Pengalaman Volunteer & Social Activity:
- Mentor Program Coding untuk Pelajar (2023) 
- Kampanye Lingkungan Digital (2022)

🤝 Pengalaman Organisasi:
- Anggota Divisi Teknologi 
- Koordinator Acara – Komunitas Teknologi Perempuan (2024)

        """.trimIndent(),
        R.drawable.volunteer4,
        phone = "6282139452707",
        email = "queennikamutiara@gmail.com",
        education = "Mahasiswa Informatika, UNS"
    )
)
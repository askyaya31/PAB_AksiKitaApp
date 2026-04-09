package com.example.prototypevolunteerapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    val context = LocalContext.current
    val volunteers = getDummyVolunteers()
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { volunteers.size })

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "Meet the Volunteers",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->

            val volunteer = volunteers[page]
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()) // ✅ SCROLL AKTIF
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = volunteer.imageRes),
                        contentDescription = volunteer.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(20.dp))
                    )

                    Spacer(modifier = Modifier.height(11.dp))
                    Text(volunteer.name,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        volunteer.education,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Explicit intent untuk ke View Profile
                    Button(
                        onClick = {
                            val intent = Intent(context, DetailProfileActivity::class.java).apply {
                                putExtra("name", volunteer.name)
                                putExtra("desc", volunteer.description)
                                putExtra("image", volunteer.imageRes)
                                putExtra("phone", volunteer.phone)
                                putExtra("email", volunteer.email)
                            }
                            context.startActivity(intent)
                        },
                        modifier = Modifier.fillMaxWidth().height(30.dp),
                        contentPadding = PaddingValues(vertical = 4.dp)
                    ) {
                        Text("View Profile", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }

        // button navigasi
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(
                onClick = {
                    scope.launch {
                        if (pagerState.currentPage > 0) {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                }
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Previous")
            }

            IconButton(
                onClick = {
                    scope.launch {
                        if (pagerState.currentPage < volunteers.size - 1) {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
            ) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Next")
            }
        }
        //footer
        Text(
            "AksiKita © 2026",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            textAlign = TextAlign.Center
        )
    }
}

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

📱 No HP:
085183163106

📧 Email:
saskyaaliyaazizah06@email.com

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

📱 No HP:
085743192088

📧 Email:
mumtatazah@gmail.com

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

📱 No HP:
085800379000

📧 Email:
sannytazkiyah@gmail.com

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

📱 No HP:
082139452707

📧 Email:
queennikamutiara@gmail.com

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
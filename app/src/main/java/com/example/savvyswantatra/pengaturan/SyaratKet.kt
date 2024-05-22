package com.example.savvyswantatra.pengaturan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

val customTextStyle = TextStyle(
    fontFamily = poppinsFontFamily,
    fontSize = 10.sp,
    color = WhiteSavvy,
    textAlign = TextAlign.Justify // Mengatur teks menjadi rata kanan kiri
)



@Composable
fun SyaratKet() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)
            .verticalScroll(rememberScrollState())
            .padding(15.dp)
    ) {

// Tittle
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Syarat dan Ketentuan", style = Typography.titleLarge, color = WhiteSavvy)

        Spacer(modifier = Modifier.height(20.dp) )
        Text(
            text = "Selamat datang di Savvy!\n\n" +
                    "Syarat dan ketentuan ini menguraikan aturan dan regulasi untuk penggunaan Aplikasi Savvy, yang berlokasi di www.savvy.com.\n\n" +
                    "Dengan mengakses aplikasi ini kami menganggap Anda menerima syarat dan ketentuan ini. Jangan lanjutkan menggunakan Savvy jika Anda tidak setuju untuk menerima semua syarat dan ketentuan yang dinyatakan pada halaman ini.",
            style = customTextStyle
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Istilah berikut berlaku untuk Syarat dan Ketentuan, Pernyataan Privasi dan Pemberitahuan Penyangkalan dan semua Perjanjian: \"Klien\", \"Anda\" dan \"Anda\" merujuk kepada Anda, orang yang masuk ke aplikasi ini dan patuh terhadap syarat dan ketentuan Perusahaan. \"Perusahaan\", \"Kami\", \"Kami\", \"Kami\" dan \"Kami\", merujuk ke Perusahaan kami. \"Pihak\", \"Pihak\", atau \"Kami\", merujuk kepada Klien dan kami sendiri. Semua istilah mengacu pada penawaran, penerimaan dan pertimbangan pembayaran yang diperlukan untuk melakukan proses bantuan kami kepada Klien dengan cara yang paling tepat untuk tujuan yang jelas memenuhi kebutuhan Klien sehubungan dengan penyediaan layanan Perusahaan yang dinyatakan, sesuai dengan dan tunduk pada, hukum yang berlaku dari af. Setiap penggunaan istilah di atas atau kata-kata lain dalam bentuk tunggal, jamak, kapitalisasi dan/atau dia/dia, dianggap dapat dipertukarkan dan oleh karena itu merujuk ke yang sama.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Cookies\n\nKami menggunakan cookies. Dengan mengakses Savvy, Anda setuju untuk menggunakan cookies sesuai dengan Kebijakan Privasi Savvy.\n\nSebagian besar aplikasi interaktif menggunakan cookies untuk memungkinkan kami mengambil detail pengguna untuk setiap kunjungan. Cookies digunakan oleh aplikasi kami untuk mengaktifkan fungsionalitas area tertentu untuk memudahkan orang yang mengunjungi aplikasi kami. Beberapa mitra afiliasi / iklan kami juga dapat menggunakan cookies.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Lisensi\n\nKecuali dinyatakan lain, Savvy dan/atau pemberi lisensinya memiliki hak kekayaan intelektual untuk semua materi di Savvy. Semua hak kekayaan intelektual dilindungi undang-undang. Anda dapat mengakses ini dari Savvy untuk penggunaan pribadi Anda sendiri tunduk pada pembatasan yang ditetapkan dalam syarat dan ketentuan ini.\n\n" +
                    "Anda tidak boleh:\n\n" +
                    "Menerbitkan ulang materi dari Savvy\n" +
                    "Menjual, menyewakan atau memberi sub-lisensi materi dari Savvy\n" +
                    "Menggandakan, menduplikasi atau menyalin materi dari Savvy\n" +
                    "Mendistribusikan ulang konten dari Savvy\n\n" +
                    "Perjanjian ini akan dimulai pada tanggal ini. Syarat dan Ketentuan kami dibuat dengan bantuan Generator Syarat dan Ketentuan Gratis.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Bagian dari aplikasi ini menawarkan kesempatan bagi pengguna untuk memposting dan bertukar pendapat dan informasi di area tertentu dari aplikasi. Savvy tidak memfilter, mengedit, menerbitkan atau meninjau Komentar sebelum kehadiran mereka di aplikasi. Komentar tidak mencerminkan pandangan dan pendapat Savvy, agen dan/atau afiliasinya. Komentar mencerminkan pandangan dan pendapat orang yang memposting pandangan dan pendapat mereka. Sejauh diizinkan oleh hukum yang berlaku, Savvy tidak akan bertanggung jawab atas Komentar atau atas kewajiban, kerugian atau biaya yang disebabkan dan/atau dialami sebagai akibat dari penggunaan dan/atau pengeposan dan/atau penampilan Komentar di aplikasi ini.\n\n" +
                    "Savvy berhak memantau semua Komentar dan menghapus Komentar apa pun yang dapat dianggap tidak pantas, menyinggung atau menyebabkan pelanggaran Syarat dan Ketentuan ini.\n\n" +
                    "Anda menjamin dan menyatakan bahwa:\n\n" +
                    "Anda berhak untuk memposting Komentar di aplikasi kami dan memiliki semua lisensi dan persetujuan yang diperlukan untuk melakukannya;\n" +
                    "Komentar tidak melanggar hak kekayaan intelektual apa pun, termasuk tanpa batasan hak cipta, paten atau merek dagang pihak ketiga mana pun;\n" +
                    "Komentar tidak mengandung materi yang memfitnah, memfitnah, menyinggung, tidak senonoh atau melanggar hukum lainnya yang merupakan invasi privasi\n" +
                    "Komentar tidak akan digunakan untuk meminta atau mempromosikan bisnis atau kustom atau menyajikan aktivitas komersial atau aktivitas ilegal.\n\n" +
                    "Anda dengan ini memberikan Savvy lisensi non-eksklusif untuk menggunakan, mereproduksi, mengedit dan mengizinkan orang lain untuk menggunakan, mereproduksi dan mengedit Komentar Anda dalam bentuk, format atau media apa pun.",
            style = customTextStyle
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Hyperlink ke Konten Kami\n\nOrganisasi berikut dapat menautkan ke Aplikasi kami tanpa persetujuan tertulis sebelumnya:\n\n" +
                    "Lembaga pemerintah;\n" +
                    "Mesin pencari;\n" +
                    "Organisasi berita;\n" +
                    "Distributor direktori online dapat menautkan ke Aplikasi kami dengan cara yang sama seperti mereka menautkan ke Aplikasi dari bisnis lain yang terdaftar; dan\n" +
                    "Bisnis Terakreditasi Sistem Luas kecuali organisasi nirlaba yang mencari, pusat perbelanjaan amal, dan kelompok penggalangan dana amal yang tidak boleh menautkan ke Aplikasi kami.\n\n" +
                    "Organisasi ini dapat menautkan ke halaman utama kami, ke publikasi atau ke informasi Aplikasi lainnya selama tautan: (a) tidak dengan cara apa pun menyesatkan; (b) tidak secara salah mengimplikasikan sponsor, dukungan atau persetujuan pihak yang menautkan dan produk dan/atau layanannya; dan (c) sesuai dengan konteks situs pihak yang menautkan.\n\n" +
                    "Kami dapat mempertimbangkan dan menyetujui permintaan tautan lain dari jenis organisasi berikut:\n\n" +
                    "sumber informasi konsumen dan/atau bisnis yang dikenal umum;\n" +
                    "situs komunitas dot.com;\n" +
                    "asosiasi atau kelompok lain yang mewakili amal;\n" +
                    "distributor direktori online;\n" +
                    "portal internet;\n" +
                    "firma akuntansi, hukum dan konsultasi; dan\n" +
                    "lembaga pendidikan dan asosiasi perdagangan.\n\n" +
                    "Kami akan menyetujui permintaan tautan dari organisasi ini jika kami memutuskan bahwa: (a) tautan tidak akan membuat kami terlihat tidak menguntungkan bagi kami atau bisnis terakreditasi kami; (b) organisasi tidak memiliki catatan negatif dengan kami; (c) manfaat bagi kami dari visibilitas hyperlink mengkompensasi ketiadaan Savvy; dan (d) tautan ada dalam konteks informasi sumber daya umum.\n\n" +
                    "Organisasi ini dapat menautkan ke halaman utama kami selama tautan: (a) tidak dengan cara apa pun menyesatkan; (b) tidak secara salah mengimplikasikan sponsor, dukungan atau persetujuan pihak yang menautkan dan produk atau layanannya; dan (c) sesuai dengan konteks situs pihak yang menautkan.\n\n" +
                    "Jika Anda adalah salah satu organisasi yang terdaftar di paragraf 2 di atas dan tertarik untuk menautkan ke aplikasi kami, Anda harus memberi tahu kami dengan mengirim e-mail ke Savvy. Harap sertakan nama Anda, nama organisasi Anda, informasi kontak serta URL situs Anda, daftar URL mana saja dari mana Anda bermaksud menautkan ke Aplikasi kami, dan daftar URL di situs kami ke mana Anda ingin menautkan. Tunggu 2-3 minggu untuk mendapatkan respons.\n\n" +
                    "Organisasi yang disetujui dapat menautkan ke Aplikasi kami sebagai berikut:\n\n" +
                    "Dengan menggunakan nama perusahaan kami; atau\n" +
                    "Dengan menggunakan lokator sumber daya seragam yang ditautkan; atau\n" +
                    "Dengan menggunakan deskripsi lain dari Aplikasi kami yang ditautkan yang masuk akal dalam konteks dan format konten di situs pihak yang menautkan.\n\n" +
                    "Tidak ada penggunaan logo atau karya seni lainnya Savvy yang akan diizinkan untuk menautkan tanpa perjanjian lisensi merek dagang.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "iFrames\n\nTanpa persetujuan dan izin tertulis sebelumnya, Anda tidak boleh membuat frame di sekitar halaman Aplikasi kami yang mengubah tampilan visual atau penampilan Aplikasi kami dengan cara apa pun.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Tanggung Jawab Konten\n\nKami tidak bertanggung jawab atas konten apa pun yang muncul di Aplikasi Anda. Anda setuju untuk melindungi dan membela kami terhadap semua klaim yang muncul di Aplikasi Anda. Tidak ada tautan yang harus muncul di Aplikasi mana pun yang dapat ditafsirkan sebagai fitnah, cabul atau kriminal, atau yang melanggar, melanggar, atau menganjurkan pelanggaran atau pelanggaran lainnya, hak pihak ketiga mana pun.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Reservasi Hak\n\nKami berhak meminta Anda untuk menghapus semua tautan atau tautan tertentu ke Aplikasi kami. Anda menyetujui untuk segera menghapus semua tautan ke Aplikasi kami atas permintaan. Kami juga berhak mengubah syarat dan ketentuan ini dan kebijakan penautan kami kapan saja. Dengan terus menautkan ke Aplikasi kami, Anda setuju untuk terikat dan mengikuti syarat dan ketentuan penautan ini.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Penghapusan tautan dari aplikasi kami\n\nJika Anda menemukan tautan apa pun di Aplikasi kami yang menyinggung dengan alasan apa pun, Anda bebas untuk menghubungi dan memberi tahu kami kapan saja. Kami akan mempertimbangkan permintaan untuk menghapus tautan tetapi kami tidak berkewajiban untuk melakukannya atau untuk merespons Anda secara langsung.\n\n" +
                    "Kami tidak menjamin bahwa informasi di aplikasi ini benar, kami tidak menjamin kelengkapannya atau keakuratannya; juga kami tidak berjanji untuk memastikan bahwa aplikasi tetap tersedia atau bahwa materi di aplikasi diperbarui.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Penyangkalan\n\nSejauh diizinkan oleh hukum yang berlaku, kami mengecualikan semua pernyataan, jaminan, dan kondisi yang berkaitan dengan aplikasi kami dan penggunaan aplikasi ini. Tidak ada dalam penyangkalan ini yang akan:\n\n" +
                    "membatasi atau mengecualikan tanggung jawab kami atau Anda atas kematian atau cedera pribadi;\n" +
                    "membatasi atau mengecualikan tanggung jawab kami atau Anda atas penipuan atau penyajian palsu yang curang;\n" +
                    "membatasi tanggung jawab kami atau Anda dengan cara apa pun yang tidak diizinkan menurut hukum yang berlaku; atau\n" +
                    "mengecualikan tanggung jawab kami atau Anda yang mungkin tidak dikecualikan menurut hukum yang berlaku.\n\n" +
                    "Batasan dan larangan tanggung jawab yang ditetapkan dalam Bagian ini dan di tempat lain dalam penyangkalan ini: (a) tunduk pada paragraf sebelumnya; dan (b) mengatur semua kewajiban yang timbul di bawah penyangkalan, termasuk kewajiban yang timbul dalam kontrak, dalam pelanggaran dan karena pelanggaran kewajiban hukum.\n\n" +
                    "Selama aplikasi dan informasi dan layanan di aplikasi disediakan secara gratis, kami tidak akan bertanggung jawab atas kehilangan atau kerusakan apa pun.",
            style = customTextStyle

        )
        Spacer(modifier = Modifier.height(8.dp))


    }
}

@Preview(showBackground = true)
@Composable
private fun SyaratKetPrev(){
    SyaratKet()
}
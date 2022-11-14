import java.util.Scanner;

public class JawabanNo3 {
    public class Cek {


        static int jmlTopLevel = 0;
        static int jmlMiddleLevel = 0;
        static int jmlRegStaff = 0;
        static int jmlStaff = 0;


        static boolean success = false;

        public static void main(String[] args) {
            String[] busInfo = {"01-TopLevel", "02-MiddleLevel", "03-RegularStaff", "04-Staff"};

            for (int i = 0; i < 200; i++) {
                nik();
            }
        }

        static void cekNIKKaryawan(String nik) {
            // pengecekan pertama dicek apakan nik yang dimasukkan kurang dari 10 digit
            if (nik.length() <= 10) {
                // jika nik kurang dari 10 digit artinya benar, dan akan dilakukan pengecekan selanjutnya seperti dibawah ini
                // akan dicek apakah nik mengandung huruf C01, jika iya jumlah penumpang dibus top level akan bertambah 1
                // jika tidak akan pergi ke pengkondisian kedua
                if (nik.contains("C01")) {
                    success = true;
                    jmlTopLevel++;
                } else if (nik.contains("J02")) { // ini pengkondisian kedua akan dicek apakah nik mengandung huruf J02, jika iya jumlah penumpang dibus middle level akan bertambah 1
                    success = true;             // jika tidak akan pergi ke pengkondisian ketiga
                    jmlMiddleLevel++;
                } else if (nik.contains("N03")) { // ini pengkondisian ketiga akan dicek apakah nik mengandung huruf N03, jika iya jumlah penumpang dibus reguler staff akan bertambah 1
                    success = true;         // jika tidak akan pergi ke pengkondisian terakhir
                    jmlRegStaff++;
                } else if (nik.contains("P04")) { // ini pengkondisian terakhir akan dicek apakah nik mengandung huruf P04, jika iya jumlah penumpang dibus staf akan bertambah 1
                    success = true;             // jika ini salah, maka akan menjalankan esle
                    jmlStaff++;
                } else {
                    // ini yang akan dijalankan ketika semua kondisi diatas salah
                    success = false;
                    System.out.println("Gagal, Nik registrasi Anda tidak terdaftar dalam list busInfo");
                }
            } else {
                // ini yang akan dijalankan ketika nik lebih dari 10 digit
                success = false;
                System.out.println("Gagal, Pastikan jumlah NIK tidak lebih dari 10, silahkan isi ulang NIK");

            }

        }

        static void nik() {

            Scanner inputRegistJrasi = new Scanner(System.in);
            System.out.println("Masukkan NIK untuk registrasi");
            String nik = inputRegistJrasi.nextLine();

            cekNIKKaryawan(nik);

            if (success) {
                printResult();
            }

        }

        static void printResult() {

            System.out.println("Jumlah peserta di bus 01-TopLevel = " + jmlTopLevel);
            System.out.println("Jumlah peserta di bus 02-MiddleLevel = " + jmlMiddleLevel);
            System.out.println("Jumlah peserta di bus 03-RegulerStaff = " + jmlRegStaff);
            System.out.println("Jumlah peserta di bus 04-Staff = " + jmlStaff);
            System.out.println();

        }


    }

    public static void main(String[] args) {
        while (true){
            Cek.nik();
        }

    }




}


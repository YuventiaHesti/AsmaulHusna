package com.example.asmaulhusna.Model;

import com.example.asmaulhusna.R;

import java.util.ArrayList;

public class DataModelQuiz {
    public static String[][] data = new String[][]{
            {"1",
                    "Apakah Arti Dari Al-Maalik ?",
                    "D",
                    "A. Yang Maha Pemberi Keamanan",
                    "B. Yang Maha Melapangkan",
                    "C. Yang Maha Gagah",
                    "D. Yang Maha Merajai",
            },
            {"2",
                    "Sebutkan judul kisah yang mecerminkan salah satu Asmaul Husna yaitu Al-Khaafidh !",
                    "C",
                    "A. Nabi Daud dan Seekor Ulat",
                    "B. Makanan dari Allah untuk Siti Maryam",
                    "C. Keteguhan Iman Dua Tawanan Muslim",
                    "D. Kasih Sayang Allah Melalui Sakit",
            },
            {"3",
                    "Allah memiliki kebaikan dan pemberi karunia yang tak terbalas, sehingga Allah  memiliki nama ?",
                    "A",
                    "A. Al-Wahhaab",
                    "B. Al-Baari'",
                    "C. Al-Muntaqim",
                    "D. Al-Warits",
            },
            {"4",
                    "\"Akibat Lalai Zakat dan Sedekah\" merupakan judul kisah yang mencerminkan nama Allah yaitu ?",
                    "C",
                    "A. Al-Waali",
                    "B. Al-Baaqii",
                    "C. Al-Mudzill",
                    "D. Ar-Raqiib",
            },
            {"5",
                    "Apakah arti dari Al-Jabbaar",
                    "A",
                    "A. Yang Maha Perkasa",
                    "B. Yang Maha Mendengar",
                    "C. Yang Maha Mulia",
                    "D. Yang Maha Meninggikan",
            },
            {"6",
                    "Allah pembuka pintu yang tertutup. Allah membuka pintu-pintu rahmat dan rezeki, sehingga Allah memiliki nama ?",
                    "B",
                    "A. Al-Lathiif",
                    "B. Al-Fattaah",
                    "C. Al-Qahhaar",
                    "D. Al-Waasi'",
            },
            {"7",
                    "Sebutkan judul kisah yang mencerminkan salah satu Asmaul Husna yaitu Al-Mushawwir !",
                    "A",
                    "A. Nabi Daud dan Seekor Ulat",
                    "B. Pahlawan yang Misterius",
                    "C. Zakat Tsa'labah yang Ditolak Rasulullah",
                    "D. Lamaran Orang Tak Berilmu",
            },
            {"8",
                    "\"Bekal Imam Syafi'i Habis untuk Sedekah\" merupakan judul kisah yang mencerminkan nama Allah yaitu ?",
                    "D",
                    "A. Al-Waduud",
                    "B. Al-Muqiit",
                    "C. Al-Haliim",
                    "D. Al-Baasith",
            },
            {"9",
                    "Apakah arti dari Al-Muhaimin ?",
                    "A",
                    "A. Yang Maha Memelihara/Merawat",
                    "B. Yang Maha Lembut",
                    "C. Yang Maha Memuliakan",
                    "D. Yang Maha Mengetahui",
            },
            {"10",
                    "Sebutkan judul kisah yang mencerminkan salah satu Asmaul Husna yaitu Ar-Raafi'",
                    "B",
                    "A. Ibu Soed",
                    "B. Ular Raksasa yang Mengejar Malik bin Dinar",
                    "C. Akibat Meninggalkan shalat",
                    "D. Suara dari Langit",
            },
    };
    public static ArrayList<ModelAsmaulHusna> getListData(){
        ModelAsmaulHusna models = null;
        ArrayList<ModelAsmaulHusna> list = new ArrayList<>();
        for (String[] aData : data) {
            models = new ModelAsmaulHusna();
            models.setNomor(aData[0]);
            models.setSoal(aData[1]);
            models.setJawaban(aData[2]);
            models.setJawabana(aData[3]);
            models.setJawabanb(aData[4]);
            models.setJawabanc(aData[5]);
            models.setJawaband(aData[6]);
            list.add(models);
        }
        return list;
    }

}

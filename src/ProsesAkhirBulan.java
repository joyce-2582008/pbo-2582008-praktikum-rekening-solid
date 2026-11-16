public class ProsesAkhirBulan {
    private String formatRupiah(int nominal) {
        return String.format("Rp%,d", nominal).replace(',', '.');
    }

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            int admin = r.potongBiayaAdmin();
            System.out.printf("%s biaya admin  : %s%n", r.getNomor(), formatRupiah(admin));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            System.out.printf("%s bunga        : %s%n", b.getNomor(), formatRupiah(bunga));
        }
    }

    public void autodebet(Rekening[] semua, int jumlah) {
        for (Rekening r : semua) {
            boolean berhasil = r.tarik(jumlah);
            if (berhasil) {
                System.out.printf("%s autodebet    : %s%n", r.getNomor(), formatRupiah(jumlah));
            } else {
                System.out.printf("%s autodebet    : gagal%n", r.getNomor());
            }
        }
    }
}
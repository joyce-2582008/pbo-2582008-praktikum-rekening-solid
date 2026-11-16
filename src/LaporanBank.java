public class LaporanBank {
    private String formatRupiah(int nominal) {
        return String.format("Rp%,d", nominal).replace(',', '.');
    }

    public void cetakDaftar(String judul, Rekening[] semua) {
        System.out.println(judul);
        for (Rekening r : semua) {
            System.out.printf("%s | %-6s | %12s%n", r.getNomor(), r.getPemilik(), formatRupiah(r.getSaldo()));
            System.out.println("      " + r.keterangan());
        }
    }

    public void cetakTotal(Rekening[] semua) {
        int total = 0;
        for (Rekening r : semua) {
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + formatRupiah(total));
    }
}
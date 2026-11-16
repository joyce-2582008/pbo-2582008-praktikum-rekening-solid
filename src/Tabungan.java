public class Tabungan extends Rekening implements BerBunga {
    private double sukuBunga;

    public Tabungan(String nomor, String pemilik, int saldo, double sukuBunga) {
        super(nomor, pemilik, saldo);
        this.sukuBunga = sukuBunga;
    }

    @Override
    public int potongBiayaAdmin() {
        int admin = (saldo < 500000) ? 5000 : 0;
        saldo -= admin;
        return admin;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) (saldo * (sukuBunga / 100.0));
        saldo += bunga;
        return bunga;
    }

    @Override
    public String keterangan() {
        return String.format("Tabungan, bunga %.1f%% per bulan", sukuBunga);
    }
}
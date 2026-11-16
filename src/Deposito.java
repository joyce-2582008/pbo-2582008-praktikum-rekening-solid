public class Deposito extends Rekening implements BerBunga {
    private double sukuBunga;

    public Deposito(String nomor, String pemilik, int saldo, double sukuBunga) {
        super(nomor, pemilik, saldo);
        this.sukuBunga = sukuBunga;
    }

    @Override
    public int potongBiayaAdmin() {
        return 0; // Tanpa biaya admin
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) (saldo * (sukuBunga / 100.0));
        saldo += bunga;
        return bunga;
    }

    @Override
    public String keterangan() {
        return String.format("Deposito, bunga %.1f%% per bulan", sukuBunga);
    }

    // Langkah 7 awal: sengaja melempar exception untuk uji coba LSP
    @Override
    public boolean tarik(int jumlah) {
        throw new UnsupportedOperationException("Deposito tidak bisa ditarik");
    }
}
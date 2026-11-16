public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && (saldo + batasOverdraft) >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public int potongBiayaAdmin() {
        int admin = 15000;
        saldo -= admin;
        return admin;
    }

    @Override
    public String keterangan() {
        String formatOverdraft = String.format("Rp%,d", batasOverdraft).replace(',', '.');
        return "Giro, batas overdraft " + formatOverdraft;
    }
}
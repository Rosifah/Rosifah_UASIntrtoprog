package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Pengiriman {
    private final String kodePengiriman;
    private final String jarakTempuh;
    private final String alamatAsal;
    private final String alamatTujuan;
    private final String waktuPengiriman;
    private final String durasiPengiriman;
    private final String hargaOngkir;


    @Override
    public String toString() {
        return "data.Pengiriman{" +
                "kodePengiriman='" + kodePengiriman + '\'' +
                ", jarakTempuh='" + jarakTempuh + '\'' +
                ", alamatAsal='" + alamatAsal + '\'' +
                ", alamatTujuan='" + alamatTujuan + '\'' +
                ", waktuPengiriman='" + waktuPengiriman + '\'' +
                ", durasiPengiriman='" + durasiPengiriman + '\'' +
                ", hargaOngkir='" + hargaOngkir + '\'' +
                '}';
    }

    public Pengiriman(String kodePengiriman, double rawJarakTempuh, String alamatAsal, String alamatTujuan, String waktuPengiriman) {
        this.kodePengiriman = kodePengiriman;
        this.jarakTempuh = formatJarakTempuh(rawJarakTempuh);
        this.alamatAsal = alamatAsal;
        this.alamatTujuan = alamatTujuan;
        this.waktuPengiriman = validateWaktuPengiriman(waktuPengiriman);
        this.durasiPengiriman = formatDurasiPengiriman(rawJarakTempuh);
        this.hargaOngkir = formatRupiah(formatHargaOngkir(rawJarakTempuh));
    }

    private String validateWaktuPengiriman(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return date.format(formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use 'dd-MM-yyyy'.");
        }
    }

    private String formatJarakTempuh(double jarakTempuh) {
        return String.format("%.0f KM", jarakTempuh);
    }

    private String formatDurasiPengiriman(double jarakTempuh) {
        int days = jarakTempuh <= 60 ? 1 : (int) Math.ceil(jarakTempuh / 60);
        return String.format("%d Hari", days);
    }

    private int formatHargaOngkir(double jarakTempuh) {
        int hargaPer10Km = 1000;
        int minimalOngkir = 6000;
        int biayaOngkir = (int) Math.ceil(jarakTempuh / 10) * hargaPer10Km;
        return Math.max(biayaOngkir, minimalOngkir);
    }

    private String formatRupiah(int amount) {
        return String.format("Rp%,d", amount);
    }

}


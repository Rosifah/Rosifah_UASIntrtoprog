import data.Pengiriman;
import utils.Base;

public class Number2 extends Base {
    public static void main(String[] args) {


        shipments.add(new Pengiriman("PK001", 20, "Jakarta", "Bandung", "12-05-2024"));
        shipments.add(new Pengiriman("PK002", 70, "Surabaya", "Semarang", "13-05-2024"));
        shipments.add(new Pengiriman("PK003", 120, "Medan", "Palembang", "14-05-2024"));
        shipments.add(new Pengiriman("PK004", 50, "Bali", "Lombok", "15-05-2024"));
        shipments.add(new Pengiriman("PK005", 300, "Makassar", "Manado", "16-05-2024"));
        for (Pengiriman pengiriman : shipments) {
            System.out.println(pengiriman.toString());
        }
    }
}
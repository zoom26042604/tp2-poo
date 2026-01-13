import java.io.FileWriter;
import java.io.IOException;

public class FacturePersistenceService {
    public void saveFacture(Facture facture) {
        try (FileWriter writer = new FileWriter("factures.txt", true)) {
            writer.write("FACTURE | " + facture.getDate()
                    + " | Client=" + facture.getClientName()
                    + " | HT=" + facture.getMontantHT()
                    + " | TVA=" + facture.getTva()
                    + " | TTC=" + facture.getTotal() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDevis(Devis devis) {
        try (FileWriter writer = new FileWriter("devis.txt", true)) {
            writer.write("DEVIS | " + devis.getDate()
                    + " | HT=" + devis.getMontantHT()
                    + " | TVA=" + devis.getTva()
                    + " | TTC=" + devis.getTotal()
                    + " | validite=30j\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

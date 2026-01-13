import java.time.LocalDate;

public class FacturationService {
    private final TaxCalculator taxCalculator;
    private final FactureDisplayService displayService;
    private final FacturePersistenceService persistenceService;

    public FacturationService(TaxCalculator taxCalculator,
                              FactureDisplayService displayService,
                              FacturePersistenceService persistenceService) {
        this.taxCalculator = taxCalculator;
        this.displayService = displayService;
        this.persistenceService = persistenceService;
    }

    public void creerFacture(double montantHT, String clientName) {
        double tva = taxCalculator.calculateTVA(montantHT);
        double total = taxCalculator.calculateTotal(montantHT, tva);

        Facture facture = new Facture(LocalDate.now(), clientName, montantHT, tva, total);

        displayService.displayFacture(facture);
        persistenceService.saveFacture(facture);
    }

    public void creerDevis(double montantHT) {
        double tva = taxCalculator.calculateTVA(montantHT);
        double total = taxCalculator.calculateTotal(montantHT, tva);

        Devis devis = new Devis(LocalDate.now(), montantHT, tva, total);

        displayService.displayDevis(devis);
        persistenceService.saveDevis(devis);
    }
}

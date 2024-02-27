public class ConversionServiceImpl implements IConversionService {
    @Override
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    @Override
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) throws Exception {
        // Création du registre RMI
        LocateRegistry.createRegistry(1099);

        // Enregistrement du service dans le registre
        Naming.rebind("rmi://localhost:1099/ConversionService", new ConversionServiceImpl());

        System.out.println("Serveur RMI prêt...");
    }
}

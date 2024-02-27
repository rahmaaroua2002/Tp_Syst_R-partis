public class ConversionClient {
    public static void main(String[] args) throws Exception {
        // Récupération du service depuis le registre
        IConversionService service = (IConversionService) Naming.lookup("rmi://localhost:1099/ConversionService");

        String str = "Hello World";
        String upperCase = service.toUpperCase(str);
        String lowerCase = service.toLowerCase(str);

        System.out.println("Chaîne originale: " + str);
        System.out.println("En majuscules: " + upperCase);
        System.out.println("En minuscules: " + lowerCase);
    }
}

import java.util.Scanner;

/**
 * classe di test per verificare le funzionalita della classe studente
 * acquisendo i dati degli studenti e i relativi voti da tastiera tramite scanner.
 * 
 * @author pollastro alessio
 * @version 1.0
 */
public class TestStudente
{

    /**
     * metodo principale di avvio dell applicazione.
     *
     * @param args 
     */
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inserimento dati primo studente");
        Studente s1 = creaStudente(scanner);

        System.out.println();
        System.out.println("inserimento dati secondo studente");
        Studente s2 = creaStudente(scanner);

        System.out.println();
        System.out.println("inserimento voti per " + s1.getNomeCompleto().toLowerCase());
        inserisciVoti(scanner, s1);

        System.out.println();
        System.out.println("inserimento voti per " + s2.getNomeCompleto().toLowerCase());
        inserisciVoti(scanner, s2);

        System.out.println();
        stampaScheda(s1);
        
        System.out.println();
        stampaScheda(s2);

        System.out.println();
        double media1 = Math.round(s1.calcolaMedia() * 100.0) / 100.0;
        double media2 = Math.round(s2.calcolaMedia() * 100.0) / 100.0;

        System.out.println("confronto medie:");
        if (media1 > media2)
        {
            System.out.println(s1.getNomeCompleto() + " ha la media piu alta (" + media1 + " - " + media2 + ").");
        } else if (media2 > media1)
        {
            System.out.println(s2.getNomeCompleto() + " ha la media piu alta (" + media2 + " - " + media1 + ").");
        } else
        {
            System.out.println("parita! entrambi gli studenti hanno la media del " + media1 + ".");
        }

        scanner.close();
    }

    /**
     * metodo di utilita per leggere da tastiera i dati anagrafici e scolastici
     * e restituire un nuovo oggetto studente.
     *
     * @param scanner
     * @return 
     */
    private static Studente creaStudente(Scanner scanner) 
    {
        System.out.print("inserisci il nome: ");
        String nome = scanner.nextLine();

        System.out.print("inserisci il cognome: ");
        String cognome = scanner.nextLine();

        System.out.print("inserisci l anno di corso (da 1 a 5): ");
        int anno = scanner.nextInt();
        scanner.nextLine();

        System.out.print("inserisci l indirizzo di studi: ");
        String indirizzo = scanner.nextLine();

        System.out.print("inserisci la sezione: ");
        String sezione = scanner.nextLine();

        System.out.print("inserisci il numero totale di materie: ");
        int numeroMaterie = scanner.nextInt();
        scanner.nextLine();

        return new Studente(nome, cognome, anno, indirizzo, sezione, numeroMaterie);
    }

    /**
     * metodo di utilita per richiedere all utente l inserimento dei voti per uno studente,
     * verificando che siano validi (da 1 a 10).
     *
     * @param scanner
     * @param s
     */
    private static void inserisciVoti(Scanner scanner, Studente s)
    {
        System.out.println("devi inserire " + s.getNumeroMaterie() + " voti.");
        
        int count = 0;
        while (count < s.getNumeroMaterie()) 
        {
            System.out.print("inserisci il voto numero " + (count + 1) + " (da 1 a 10): ");
            int voto = scanner.nextInt();
            scanner.nextLine();

            int esito = s.inserisciVoto(voto);
            if (esito == 1) 
            {
                count++;
            } else if (esito == -1) 
            {
                System.out.println("errore: il voto deve essere compreso tra 1 e 10. riprova.");
            } else 
            {
                System.out.println("array dei voti pieno.");
                break;
            }
        }
    }

    /**
     * metodo di utilita per stampare in console la descrizione completa e
     * tutte le statistiche relative al rendimento di uno studente.
     *
     * @param 
     */
    private static void stampaScheda(Studente s)
    {
        double mediaArrotondata = Math.round(s.calcolaMedia() * 100.0) / 100.0;
        System.out.println(s.toString());
        System.out.println("media voti: " + mediaArrotondata);
        System.out.println("voto piu alto: " + s.votoMax());
        System.out.println("voto piu basso: " + s.votoMin());
        System.out.println("numero insufficienze: " + s.nVotiIns());
        System.out.println("media sufficiente: " + (s.mediaSufficiente() ? "si" : "no"));
    }
}
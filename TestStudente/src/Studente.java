
public class Studente
{
    private String nome;
    private String cognome;
    private int anno;
    private String indirizzo;
    private String sezione;
    private int numeroMaterie;
    private int[] votiFinali;

    /**
     * costruisce un nuovo oggetto Studente inizializzando i dati anagrafici,
     * scolastici e l array dei voti (inizializzato a 0)
     *
     * @param nome          Il nome dello studente
     * @param cognome       Il cognome dello studente
     * @param anno          L anno di corso frequentato
     * @param indirizzo     L indirizzo di studi
     * @param sezione       La sezione della classe
     * @param numeroMaterie Il numero totale di materie 
     */
    public Studente(String nome, String cognome, int anno, String indirizzo, String sezione, int numeroMaterie)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.anno = anno;
        this.indirizzo = indirizzo;
        this.sezione = sezione;
        this.numeroMaterie = numeroMaterie;
        this.votiFinali = new int[numeroMaterie];
    }

    /**
     * restituisce il nome dello studente.
     *
     * @return il nome dello studente.
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * modifica il nome dello studente.
     *
     * @param nome il nuovo nome da assegnare.
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * restituisce il cognome dello studente.
     *
     * @return il cognome dello studente.
     */
    public String getCognome() 
    {
        return cognome;
    }

    /**
     * modifica il cognome dello studente.
     *
     * @param cognome il nuovo cognome da assegnare.
     */
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    /**
     * restituisce l'anno di corso frequentato dallo studente.
     *
     * @return l'anno scolastico 
     */
    public int getAnno() 
    {
        return anno;
    }

    /**
     * modifica l'anno di corso dello studente.
     *
     * @param anno il nuovo anno scolastico.
     */
    public void setAnno(int anno)
    {
        this.anno = anno;
    }

    /**
     * restituisce l'indirizzo di studi dello studente.
     *
     * @return l'indirizzo scolastico.
     */
    public String getIndirizzo()
    {
        return indirizzo;
    }

    /**
     * modifica l'indirizzo di studi dello studente.
     *
     * @param indirizzo il nuovo indirizzo scolastico.
     */
    public void setIndirizzo(String indirizzo)
    {
        this.indirizzo = indirizzo;
    }

    /**
     * restituisce la sezione della classe.
     *
     * @return la lettera o sigla della sezione.
     */
    public String getSezione()
    {
        return sezione;
    }

    /**
     * modifica la sezione della classe.
     *
     * @param sezione la nuova sezione.
     */
    public void setSezione(String sezione)
    {
        this.sezione = sezione;
    }

    /**
     * restituisce il numero totale di materie previste.
     *
     * @return il numero di materie.
     */
    public int getNumeroMaterie()
    {
        return numeroMaterie;
    }

    /**
     * modifica il numero totale di materie e ridimensiona l'array dei voti.
     *
     * @param numeroMaterie il nuovo numero di materie.
     */
    public void setNumeroMaterie(int numeroMaterie) 
    {
        this.numeroMaterie = numeroMaterie;
        this.votiFinali = new int[numeroMaterie];
    }

    /**
     * restituisce l'array completo dei voti finali dello student
     *
     * @return un array di interi contenente i voti (0 indica una posizione libera)
     */
    public int[] getVotiFinali() 
    {
        return votiFinali;
    }

    /**
     * Imposta un nuovo array di voti finali per lo studente.
     *
     * @param votiFinali il nuovo array di voti da assegnare.
     */
    public void setVotiFinali(int[] votiFinali) 
    {
        this.votiFinali = votiFinali;
        this.numeroMaterie = votiFinali.length;
    }

    /**
     * restituisce nome e cognome dello studente concatenati.
     *
     * @return una stringa nel formato "nome cognome".
     */
    public String getNomeCompleto()
    {
        return nome + " " + cognome;
    }

    /**
     * inserisce un nuovo voto nella prima posizione libera (uguale a 0) dell array
     *
     * @param v il voto da inserire (deve essere compreso tra 1 e 10)
     * @return 1 se il voto e stato inserito correttamente, 
     *         meno 1 se il voto non e valido (fuori dal range da 1 a 10), 
     *         0 se l array dei voti e gia pieno
     */
    public int inserisciVoto(int v)
    {
        if (v < 1 || v > 10)
        {
            return -1;
        }
        for (int i = 0; i < numeroMaterie; i++)
        {
            if (votiFinali[i] == 0) {
                votiFinali[i] = v;
                return 1;
            }
        }
        return 0;
    }

    /**
     * calcola la media aritmetica dei voti attualmente inseriti nell'array
     * gli elementi uguali a 0 vengono ignorati nel conteggio
     *
     * @return la media dei voti come valore double, oppure 0.0 se non ci sono voti
     */
    public double calcolaMedia()
    {
        int somma = 0;
        int numeroVoti = 0;
        double media = 0.0;

        for (int i = 0; i < numeroMaterie; i++)
        {
            if (votiFinali[i] != 0)
            {
                somma = somma + votiFinali[i];
                numeroVoti++;
            }
        }

        if (numeroVoti > 0) {
            media = (double) somma / numeroVoti;
        }
        
        return media;
    }

    /**
     * individua il voto piu alto tra quelli inseriti nell'array.
     *
     * @return il voto massimo trovato, oppure 0 se non sono stati inseriti voti.
     */
    public int votoMax() 
    {
        int max = 0;
        for (int i = 0; i < numeroMaterie; i++)
        {
            if (votiFinali[i] != 0 && votiFinali[i] > max)
            {
                max = votiFinali[i];
            }
        }
        return max;
    }

    /**
     * individua il voto piu basso tra quelli inseriti nell'array
     *
     * @return il voto minimo trovato, oppure 0 se non sono stati inseriti voti.
     */
public int votoMin()
    {
        int min = Integer.MAX_VALUE;
        boolean trovatoAlmenoUnVoto = false;

        for (int i = 0; i < numeroMaterie; i++) 
        {
            if (votiFinali[i] != 0)
            {
                trovatoAlmenoUnVoto = true;
                if (votiFinali[i] < min)
                {
                    min = votiFinali[i];
                }
            }
        }
        
        if (trovatoAlmenoUnVoto == false)
        {
            return 0;
        }
        return min;
    }

    /**
     * conta quanti voti insufficienti (strettamente minori di 6 e diversi da 0)
     * ha ottenuto lo studente.
     *
     * @return il numero totale di insufficienze.
     */
    public int nVotiIns() 
    {
        int c = 0;
        for (int i = 0; i < numeroMaterie; i++)
        {
            if (votiFinali[i] != 0 && votiFinali[i] < 6)
            {
                c++;
            }
        }
        return c;
    }

    /**
     * verifica se la media complessiva dello studente raggiunge la sufficienza (maggiore o uguale a 6.0).
     *
     * @return true se la media e maggiore o uguale a 6.0, false altrimenti.
     */
    public boolean mediaSufficiente()
    {
        return calcolaMedia() >= 6.0;
    }

    /**
     * restituisce una rappresentazione testuale dello studente comprensiva dei suoi
     * dati scolastici e dell elenco dei voti effettivamente inseriti.
     *
     * @return una stringa descrittiva dello studente.
     */
    @Override
    public String toString()
    {
        String elencoVoti = "[";
        boolean primo = true;

        for (int i = 0; i < numeroMaterie; i++)
        {
            if (votiFinali[i] != 0)
            {
                if (!primo)
                {
                    elencoVoti += ", ";
                }
                elencoVoti += votiFinali[i];
                primo = false;
            }
        }
        elencoVoti += "]";

        return "Studente: " + nome + " " + cognome +  " | Classe: " + anno + sezione + " (" + indirizzo + ")" + " | Voti: " + elencoVoti;
    }
}
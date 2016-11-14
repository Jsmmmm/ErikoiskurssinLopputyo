package application.model;

public class Henkilo {
	

		public String sukunimi;
		public String etunimi;
		public int ika;
		public String sukupuoli;
		public static final int NIMI_MAX_PITUUS = 64;
		public String joukkue;
		
		
		
		public Henkilo(String etunimi, String sukunimi, int ika, String sp){
			this.etunimi=etunimi;
			this.sukunimi=sukunimi;
			this.ika=ika;
			this.sukupuoli=sp;
			
		}
		
		public static boolean tarkistaNimi(String nimi) {

			if (nimi.length() < 1 || nimi.length() > NIMI_MAX_PITUUS)
				return false;

			for (int i = 0; i < nimi.length(); ++i) {
				int merkki = nimi.codePointAt(i);
				if (merkki != '-' && !Character.isLetter(merkki))
					return false;
			}

			return true;
		}
		
		
		 boolean asetaEtunimi(String etunimi) {		
			if(tarkistaNimi(etunimi)){
			this.etunimi = etunimi;
			return true; 
			}
			return false;
			
		}

		 boolean asetaSukunimi(String sukunimi) {		
			if(tarkistaNimi(sukunimi)){
			this.sukunimi = sukunimi;
			return true;
			}
			return false;
		}

		 boolean asetaIka(int ika) {
			if(ika>0 && ika <150){
			this.ika = ika;
			return true; }
			return false;
		}

		 void asetaSukupuoli(String sukupuoli) {
			this.sukupuoli = sukupuoli;
		}
		
		public String kerroEtunimi(){
			return this.etunimi;
		}
		
		public String kerroSukunimi(){
			return this.sukunimi;
		}
		
		public int kerroIka(){
			return this.ika;
		}
		
		public String kerroSukupuoli(){
			return this.sukupuoli;
		}
		
		@Override
		public String toString(){
			return this.etunimi+" "+this.sukunimi;
		}
}

package application.model;

import java.util.ArrayList;

public class Sport {

	String sportName;

	public ArrayList<Participant> sportParticipants = new ArrayList<Participant>();

	public Serie general;
	public Serie mens;
	public Serie mensU18;
	public Serie womens;
	public Serie womensU18;
	public boolean booleanGeneral = false;
	public boolean booleanMens = false;
	public boolean booleanWomens = false;
	public boolean booleanMensU18 = false;
	public boolean booleanWomensU18 = false;
	
	public String resultFormat;
	public int numberOfResultsPerParticipant;
	

	public Sport(String name, boolean booleanGeneral, boolean booleanMen, boolean booleanWomen, boolean booleanMenU18,
			boolean booleanWomenU18, String resultFormat, int numberOfResultsPerParticipant) {
		this.sportName = name;
		this.booleanGeneral = booleanGeneral;
		this.booleanMens = booleanMen;
		this.booleanWomens = booleanWomen;
		this.booleanMensU18 = booleanMenU18;
		this.booleanWomensU18 = booleanWomenU18;
		this.resultFormat=resultFormat;
		this.numberOfResultsPerParticipant=numberOfResultsPerParticipant;
		
		if (booleanGeneral == true) {
			general = new Serie("General");
		}
		if (booleanMens == true) {
			mens = new Serie("Men");
		}
		if (booleanMensU18 == true) {
			mensU18 = new Serie("Men U18");
		}
		if (booleanWomens == true) {
			womens = new Serie("Women's");
		}
		if (booleanWomensU18 == true) {
			womensU18 = new Serie("Women's U18");
		}
	}

	private void addParticipantToSerie(Participant participant, Serie serie) {
		if (serie.serieParticipants.contains(participant)) {
			System.out.println(participant.competitor.toString() + "ei lis�tty koska l�ytyi jo valmiiksi lajista");
		} else {
			serie.serieParticipants.add(participant);
		}
	}

	public void placeParticipantsToSeries() {

		for (Participant participant : sportParticipants) {

			if (booleanGeneral) {
				addParticipantToSerie(participant, general);
				// yleisSarja.sarjanOsallistujat.add(osallistuja);

			}

			// miesten osallistuminen
			if (participant.competitor.isMale) {

				if (booleanMensU18 && participant.competitor.getAge() < 18) {
					addParticipantToSerie(participant, mensU18);
					// miestenU18Sarja.sarjanOsallistujat.add(osallistuja);

				} else if (!booleanMensU18 && booleanMens) {
					addParticipantToSerie(participant, mens);
					// miestenYleisSarja.sarjanOsallistujat.add(osallistuja);

				} else if (booleanMensU18 && booleanMens && participant.competitor.getAge() >= 18) {
					addParticipantToSerie(participant, mens);
					// miestenYleisSarja.sarjanOsallistujat.add(osallistuja);

				}

				// naisten osallistuminen
			} else {
				if (booleanWomensU18 && participant.competitor.getAge() < 18) {
					addParticipantToSerie(participant, womensU18);
					// naistenU18Sarja.sarjanOsallistujat.add(osallistuja);

				} else if (booleanWomensU18 == false && booleanWomens) {
					addParticipantToSerie(participant, womens);
					// naistenYleisSarja.sarjanOsallistujat.add(osallistuja);

				} else if (booleanWomensU18 && booleanWomens && participant.competitor.getAge() >= 18) {
					addParticipantToSerie(participant, womens);
					// naistenYleisSarja.sarjanOsallistujat.add(osallistuja);
				}
			}
		}
		sportParticipants.clear();

	}
	
	
	//t�n paskan voi salee poistaa
	/*public Participant findParticipant(Competitor competitor){
		Participant searched = null;
		for(Participant participant : sportParticipants){
			if(competitor.equals(participant.competitor)){
				searched=participant;
			}
		}return searched;
	}*/
	
	
	

	@Override
	public String toString() {
		return this.sportName;
	}

}

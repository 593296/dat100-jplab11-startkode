package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg{

	private Innlegg[]innleggTabell;
	private int nesteLedig;

	public Blogg() {
		innleggTabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggTabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		int pos = 0;
		boolean funnet = false;
		
		while(pos < nesteLedig && !funnet) {
			
			if(innleggTabell[pos].erLik(innlegg)) {
				funnet = true;
			}
			else pos++;
		}
		if(funnet) {
			return pos;
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
	
		for(int i = 0; i < nesteLedig; i++) {
			
			if(innleggTabell[i].erLik(innlegg)) {
				return true;
			}
		
		}
		
		return false;
	}

	public boolean ledigPlass() {
		
		//for(int i = 0; i < innleggTabell.length; i++) {
			if(nesteLedig < innleggTabell.length) 
				return true;
		//}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		if(ledigPlass() && !(finnes(innlegg))) {
			innleggTabell[nesteLedig] = innlegg;
			 nesteLedig++;
		return true;
		}		
		return false;	
	}
	
	public String toString() { 
		String utTxt = nesteLedig + "\n";
		
		for(int i = 0; i < nesteLedig; i++) {
			utTxt += innleggTabell[i].toString();
		}		
		return utTxt;		
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[2*innleggTabell.length];
		int NesteLedige = 0;
		
		for(int i = 0; i < nesteLedig; i++) {
			nyTabell[i] = innleggTabell[i];
			NesteLedige++;
		}
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}
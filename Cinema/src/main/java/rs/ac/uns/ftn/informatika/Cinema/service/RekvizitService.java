package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.List;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;

public interface RekvizitService {
	
	//Metoda koja ce biti zaduzena da vrati sve zvanicne rekvizite 
	//izdate od strane administratora fanzone
	List<ZvanicniRekvizit> findAll();
	//Metoda zaduzena za upis novog rekvizita u bazu
	ZvanicniRekvizit save(ZvanicniRekvizit rekvizit);

}

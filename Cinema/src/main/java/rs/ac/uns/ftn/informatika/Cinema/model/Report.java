package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Izvestaj")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	//Klasa izvestaj treba da sadrzi:
	//prosecnu cenu ambijenta, predstave/projekcije
	//grafika posecenosti pozorista/bioskopa
	//prihod pozorista/bioskopa u odredjenom periodu
	
	public Report() {
		
		
		
	}
	
	
}

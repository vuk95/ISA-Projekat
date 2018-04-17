package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.NewOglasForm;
import rs.ac.uns.ftn.informatika.Cinema.model.NewRekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.model.Ponuda;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.repository.OglasRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.OglasService;

@Service
@Transactional
public class OglasServiceImpl implements OglasService{

	@Autowired
	private OglasRepository repository;
	
	@Override
	public Iterable<Oglas> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Oglas find(Long id) {
		// TODO Auto-generated method stub
		return (Oglas) repository.getOne(id);
	}

	@Override
	public void save(Oglas oglas) {
		// TODO Auto-generated method stub
		repository.save(oglas);
	}
	
	@Override
	public void delete(Oglas oglas) {
		// TODO Auto-generated method stub
		repository.delete(oglas);
	}
	
	@Override
	public Oglas addPonuda(Ponuda p, Long id) {
		// TODO Auto-generated method stub
		Oglas oglas = repository.findOne(id);
		oglas.getPonudeZaOglas().add(p);
		return repository.save(oglas);
	}
	
	@Override
	public Oglas createNewOglas(NewOglasForm oglasForm) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Oglas oglas = new Oglas();
		oglas.setNaziv(oglasForm.getNaziv());
		oglas.setOpis(oglasForm.getOpis());
		try {
			oglas.setDatum(formatter.parse(oglasForm.getDatum()));
			System.out.println(oglas.getDatum());
            System.out.println(formatter.format(oglas.getDatum()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return repository.save(oglas);
	}

}

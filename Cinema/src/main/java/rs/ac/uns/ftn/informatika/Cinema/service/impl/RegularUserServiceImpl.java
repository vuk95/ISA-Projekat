package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.model.Ponuda;
import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.model.users.NewUserForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.ProfileForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Role;
import rs.ac.uns.ftn.informatika.Cinema.repository.RegularUserRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Transactional
@Service
public class RegularUserServiceImpl implements RegularUserService {

	@Autowired
	public RegularUserRepository regUserRepository;
	
	@Autowired
	public AllUsersService allUserService;
	
	@Override
	public RegularUser findOne(Long Id) {
		return regUserRepository.findOne(Id);
	}

	@Override
	public List<RegularUser> findAll() {
		return regUserRepository.findAll();
	}
	
	@Override
	public RegularUser findByConfirmationToken(String confirmationToken) {
		return regUserRepository.findByConfirmationToken(confirmationToken);
	}
	
	@Override
	public RegularUser createNewRegularUser(NewUserForm newUser) {
		if(allUserService.emailExists(newUser.getEmail())) {
			return null;
		} else {
		
			RegularUser user = new RegularUser();
			user.setRole(Role.REGULAR);
			user.setEnabled(false);
			user.setConfirmationToken(UUID.randomUUID().toString());
			user.setEmail(newUser.getEmail());
			user.setName(newUser.getName());
			user.setLastname(newUser.getLastname());
			user.setCity(newUser.getCity());
			user.setPhone(newUser.getPhone());
			user.setPassword(newUser.getPassword());
			
			return regUserRepository.save(user);
		}
	}

	@Override
	public RegularUser save(RegularUser regUser) {
		return regUserRepository.save(regUser);
	}

	@Override
	public List<RegularUser> save(List<RegularUser> regUsers) {
		return regUserRepository.save(regUsers);
	}

	@Override
	public RegularUser delete(Long Id) {

		RegularUser regUser = regUserRepository.findOne(Id);	
		
		if(regUser == null) {
			
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant regular user");
		}
		
			regUserRepository.delete(regUser);
		
		return regUser;
	}

	@Override
	public void delete(List<Long> ids) {
		
		for(Long id:ids) {
			
			this.delete(id);
			
		}
		
	}

	@Override
	public RegularUser updateRegularUserProfile(ProfileForm form) {
		RegularUser user = regUserRepository.findOne(form.getId());
		user.setName(form.getName());
		user.setLastname(form.getLastname());
		user.setCity(form.getCity());
		user.setPhone(form.getPhone());
		
		return regUserRepository.save(user);
	}

	@Override
	public RegularUser findByEmail(String email) {
		return regUserRepository.findByEmail(email);
	}

	@Override
	public RegularUser addRekvizit(ZvanicniRekvizit r, Long Id) {
		// TODO Auto-generated method stub
		RegularUser regUser = regUserRepository.findOne(Id);
		regUser.getMojiRekviziti().add(r);
		regUserRepository.save(regUser);
		return regUser;
	}

	@Override
	public RegularUser addMojOglas(Oglas o, Long id) {
		// TODO Auto-generated method stub
		
		RegularUser regUser = regUserRepository.findOne(id);
		regUser.getMojiOglasi().add(o);
		regUserRepository.save(regUser);
		return regUser;
	}
	
	@Override
	public RegularUser deleteMojOglas(Oglas o, Long id) {
		// TODO Auto-generated method stub
		RegularUser regUser = regUserRepository.findOne(id);
		for(int i = 0; i < regUser.getMojiOglasi().size(); i++) {
			if(o.getId().equals(regUser.getMojiOglasi().get(i).getId())) {
				regUser.getMojiOglasi().get(i).setUser(null);
				regUser.getMojiOglasi().remove(i);
			}
		}
		
		regUserRepository.save(regUser);
		return regUser;
	}

	@Override
	public boolean daoPonudu(Oglas o, RegularUser user) {
		// TODO Auto-generated method stub
		for(int i = 0; i < o.getPonudeZaOglas().size(); i++) {
			if(o.getPonudeZaOglas().get(i).getUser().equals(user)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean nemozePonuditi(Oglas o, RegularUser user) {
		// TODO Auto-generated method stub
		for(int i = 0; i < user.getMojiOglasi().size(); i++) {
			if(user.getMojiOglasi().get(i).equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void addVisitedCinemaTheatre(CinemaTheatre ct, Long userId) {
		RegularUser user = regUserRepository.findOne(userId);
		user.getVisitedCinemaTheatre().add(ct);
		regUserRepository.save(user);
	}

	@Override
	public void addReservation(Reservation reservation, Long userId) {
		RegularUser user = regUserRepository.findOne(userId);
		user.getReservations().add(reservation);
		regUserRepository.save(user);
	}

	@Override
	public Set<RegularUser> findFutureFriends(String name, String lastname) {
		//TODO: treba dodati da se prikazuju samo oni korisnici koji vec nisu prijatelji
		
		Set<RegularUser> users = new HashSet<RegularUser>();
		
		if(name.equals("") && lastname.equals("")) {
			//do nothing
		} else if(name.equals("")) {
			users = regUserRepository.findByLastname(lastname);
		} else if(lastname.equals("")) {
			users = regUserRepository.findByName(name);
		} else {
			users = regUserRepository.findByNameAndLastname(name, lastname);
		}
		
		return users;
	}

	@Override
	public Set<Reservation> getMyReservations(RegularUser user) {
		Set<Reservation> reservations = null;
//		for(Reservation res : user.getReservations()) {
//			LocalTime localTime = res.getProjection().getTime().toLocalTime();
//			if(localTime.minusMinutes(30) < )
		
		
		
		return reservations;
	}
		

}

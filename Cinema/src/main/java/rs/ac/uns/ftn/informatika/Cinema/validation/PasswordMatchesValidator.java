package rs.ac.uns.ftn.informatika.Cinema.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import rs.ac.uns.ftn.informatika.Cinema.model.users.NewUserForm;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches arg0) {
			
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		NewUserForm user = (NewUserForm) obj;
		
		return user.getPassword().equals(user.getMatchingPassword());
	}

}

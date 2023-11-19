package com.example.market.validations;


import com.example.market.annotation.ExistedUser;
import com.example.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserExistsValidation implements ConstraintValidator<ExistedUser,String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(ExistedUser constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        return !userRepository.existsByEmail(email);
    }
}

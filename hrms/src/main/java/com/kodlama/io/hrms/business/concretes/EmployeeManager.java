package com.kodlama.io.hrms.business.concretes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.EmployeeService;
import com.kodlama.io.hrms.business.abstracts.UserService;
import com.kodlama.io.hrms.core.utilities.IdentityValidationService;
import com.kodlama.io.hrms.core.utilities.business.BusinessRules;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import com.kodlama.io.hrms.entities.concretes.Employee;
import com.kodlama.io.hrms.entities.concretes.User;
import com.kodlama.io.hrms.entities.dtos.EmployeeForRegisterDto;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	private UserService userService;
    private IdentityValidationService identityValidationService;
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,UserService userService,IdentityValidationService identityValidationService) {
		super();
		this.employeeDao = employeeDao;
		this.userService = userService;
		this.identityValidationService = identityValidationService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
	}

	@Override
	public Result register(EmployeeForRegisterDto employee) {	
		Result businessRules = BusinessRules.run(
				isPasswordsMatch(employee.getPassword(), employee.getVerifyPassword()),
				isUserExistWithEmail(employee.getEmail()),
				isUserExistWithNationalityId(employee.getNationalityId())
				);
		if(businessRules!=null) return businessRules;
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(employee.getDateOfBirth());
		if(!identityValidationService.validate(employee.getNationalityId(), 
			employee.getFirstName(), 
			employee.getLastName(), 			
			calendar.get(Calendar.YEAR)).isSuccess()) {
			return new ErrorResult("TC Kimlik Numarası doğrulaması başarısız.");
		}
		
		User userToRegister = new User(employee.getEmail(), employee.getPassword(),false, UUID.randomUUID().toString());
		userService.add(userToRegister);
		
		Employee employeeToRegister = new Employee(userToRegister.getId(), 
				employee.getFirstName(),
				employee.getLastName(), 
				employee.getNationalityId(),
				employee.getDateOfBirth());
		this.employeeDao.save(employeeToRegister);
		return new SuccessResult("İş arayan kayıdı başarılı. Lütfen e-posta adresinize gönderilen doğrulama linkiyle hesabınızı doğrulayınız.");
	}
	
	
	
	
	private Result isPasswordsMatch(String password, String passwordVerify) {
		if(!password.equals(passwordVerify)) {
			return new ErrorResult("Şifreler uyuşmalıdır.");
		}
		return new SuccessResult();
	}
	
	private Result isUserExistWithEmail(String email) {
		if(userService.getByEmail(email).getData() != null)
			return new ErrorResult("Bu e-posta adresiyle başka bir kullanıcı mevcut.");
		return new SuccessResult();
	}
	private Result isUserExistWithNationalityId(String nationalityId) {
		if(employeeDao.findByNationalityId(nationalityId) != null)
			return new ErrorResult("Bu TCKN ile başka bir kullanıcı mevcut.");
		return new SuccessResult();
	}

	@Override
	public DataResult<Employee> getById(int id) {
		Employee employee = employeeDao.getOne(id);
		if(employee==null) return new ErrorDataResult<Employee>();
		return new SuccessDataResult<Employee>(employee);
	}

}

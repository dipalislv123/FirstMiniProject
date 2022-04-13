package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.PhoneContact;
import in.ashokit.repo.PhoneContactRepository;

@Service
public class PhoneContactServiceImp implements IPhoneContactService{
	
	@Autowired
	private PhoneContactRepository repo;

	@Override
	public boolean savePhoneContact(PhoneContact phContact) {
		phContact.setActiveSw("Y");
		PhoneContact pc=repo.save(phContact);
		
		if(pc.getId()!=null) {
		return true;
		}else
			return false;
	}

	@Override
	public PhoneContact getPhoneContactById(Integer id) {
		Optional<PhoneContact> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public List<PhoneContact> getAllPhoneContacts() {
		PhoneContact pc=new PhoneContact();
		pc.setActiveSw("Y");
		return repo.findAll(Example.of(pc));
	}
	
	@Override
	public boolean deletePhoneContact(Integer id) {
		Optional<PhoneContact> optional=repo.findById(id);
		if(optional.isPresent()) {
			PhoneContact pc= optional.get();
			pc.setActiveSw("N");
			repo.save(pc);
			return true;
			}else
		
		return false;
	}


}

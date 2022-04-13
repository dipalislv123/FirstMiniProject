package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.PhoneContact;

public interface IPhoneContactService {
  
	public boolean savePhoneContact(PhoneContact phContact);
	public boolean deletePhoneContact(Integer id);
	public PhoneContact getPhoneContactById(Integer id);
	public List<PhoneContact> getAllPhoneContacts();
}

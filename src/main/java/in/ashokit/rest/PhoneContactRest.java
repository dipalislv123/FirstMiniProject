package in.ashokit.rest;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.constants.AppConstants;
import in.ashokit.entity.PhoneContact;
import in.ashokit.props.AppProperties;
import in.ashokit.service.IPhoneContactService;

@RestController
@RequestMapping("contact-app")
@CrossOrigin("*")
public class PhoneContactRest {
	
	//injecting service interface obj
		@Autowired
		private IPhoneContactService service;
		
		//injecting app pros obj
		
		@Autowired
		private AppProperties appProps;
		
		
		@PostMapping("/contact")
		public String savePhoneContact(@RequestBody PhoneContact contact) {
			Map<String,String> msg=appProps.getMsg();
			
			boolean status=service.savePhoneContact(contact);
			if(status) {
				return msg.get(AppConstants.CONTACT_SAVE_SUCCESS);
			}else
			{
				return msg.get(AppConstants.CONTACT_SAVE_FAIL);
			}
			
		}
		
		@GetMapping("/contact/{id}")
		public PhoneContact editContact(@PathVariable Integer id) {
			return service.getPhoneContactById(id);
		}
		
		@GetMapping("/contacts")
		public List<PhoneContact>getAll(){
			return service.getAllPhoneContacts();
		}
		
		public String deleteContact(@PathVariable Integer id) {
	         Map<String,String> msg=appProps.getMsg();
			
			boolean status=service.deletePhoneContact(id);
			if(status) {
				return msg.get(AppConstants.CONTACT_DEL_SUCCESS);
			}else
				return msg.get(AppConstants.CONTACT_DEL_FAIL);
			
		}
		
		

	}


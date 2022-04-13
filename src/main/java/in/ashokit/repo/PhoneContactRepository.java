package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.PhoneContact;


@Repository
public interface PhoneContactRepository extends JpaRepository <PhoneContact,Integer> {

}

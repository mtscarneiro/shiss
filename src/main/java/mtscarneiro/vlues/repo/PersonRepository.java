package mtscarneiro.vlues.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import mtscarneiro.vlues.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
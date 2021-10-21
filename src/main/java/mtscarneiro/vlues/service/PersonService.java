package mtscarneiro.vlues.service;

import java.util.List;
import java.util.Optional;

import mtscarneiro.vlues.service.exception.DatabaseException;
import mtscarneiro.vlues.service.exception.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mtscarneiro.vlues.entities.Person;
import mtscarneiro.vlues.repo.PersonRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class PersonService {

    private PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public List<Person> findAll() {
        return repo.findAll();
    }

    public Person findByID(Long id) {
        Optional<Person> opt = repo.findById(id);
        return opt.orElseThrow(() -> new EmptyResultDataAccessException(id.intValue()));
    }

    public Person insert(Person obj) {
        return repo.save(obj);
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Person update(Long id, Person obj) {
        try {
            Person entity = repo.getById(id);
            updateData(entity, obj);
            return repo.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Person entity, Person obj) {
        entity.setFirstName(obj.getFirstName());
        entity.setLastName(obj.getLastName());
        entity.setCpf(obj.getCpf());
        entity.setBirthDate(obj.getBirthDate());
    }
}

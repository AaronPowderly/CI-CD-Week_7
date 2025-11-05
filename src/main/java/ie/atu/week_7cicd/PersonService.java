package ie.atu.week_7cicd;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repo;
    public PersonService(PersonRepository repo)
    { this.repo = repo; }

    public Person create(Person p)
    { return repo.save(p); }

    public List<Person> findAll()
    { return repo.findAll(); }

    public Person findByEmployeeId(String id)
    {
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

    public Person update(String id, Person person)
    {

    }

    public void delete(String id)
    {
        if (!repo.existsById(id)){
            throw new IllegalArgumentException("Person not found");
        }
        repo.deleteById(id);
    }
}
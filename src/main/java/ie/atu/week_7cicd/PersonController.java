package ie.atu.week_7cicd;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;
    public PersonController(PersonService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@Valid @RequestBody Person person)
    {
        return service.create(person);
    }
    @GetMapping
    public List<Person> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Person byEmployeeId(@PathVariable String id)
    {
        return service.findByEmployeeId(id);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable String id, @RequestBody Person person)
    {
        return service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id)
    {
        service.delete(id);
    }
}

package dnb.reskillassignment.restlayer;


import dnb.reskillassignment.businesslayer.EnvironmentService;
import dnb.reskillassignment.datalayer.ConfigDataRepository;
import dnb.reskillassignment.models.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/assignment")
@CrossOrigin
public class RestClass {
    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private ConfigDataRepository configDataRepository;

    @GetMapping(value="/all", produces={"application/json","application/xml"})
    public ResponseEntity<Collection<Environment>>getAllProducts() {
        Collection<Environment> environments = environmentService.getAllProducts();
        return ResponseEntity.ok().body(environments);
    }

    @GetMapping(value="/getID/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Environment> read(@PathVariable long id) {
        Environment environment = environmentService.read(id);
        return ResponseEntity.ok().body(environment);
    }

    @PutMapping(value="/update/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Boolean> update(@PathVariable long id) {
        boolean result = environmentService.update(id);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping(value="/delete/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Environment> create(@PathVariable Environment p) {
        Environment pr = environmentService.create(p);
        return ResponseEntity.ok().body(pr);
    }



}

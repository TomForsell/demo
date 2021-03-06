package dnb.reskillassignment.businesslayer;

import dnb.reskillassignment.models.Environment;

import java.util.Collection;

public interface EnvironmentService {

    Collection<Environment> getAllProducts();
    Environment create(Environment p);
    Environment read(long id);
    boolean update(long id);
    boolean delete(long id);

}

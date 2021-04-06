package dnb.reskillassignment.datalayer;

import dnb.reskillassignment.models.Environment;

import java.util.Collection;

public interface EnvironmentRepository {
    Collection <Environment> getAllEnvironments();
    Environment create(Environment e);
    Environment read(long id);
    boolean update(long id);
    boolean delete(long id);
}

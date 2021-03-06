package dnb.reskillassignment.datalayer;

import dnb.reskillassignment.models.Environment;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;

import java.util.Collection;

@Repository
public class DataRepositoryH2 implements EnvironmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Environment> getAllEnvironments() {
        String sql = "SELECT e FROM Environment e";
        TypedQuery<Environment> collection = this.entityManager.createQuery(sql, Environment.class);
        return collection.getResultList();
    }
    @Transactional
    @Override
    public Environment create(Environment e) {

        if(e.getId() != -1) {
            throw new IllegalArgumentException("Product id must be -1 to be inserted");
        }
        entityManager.persist(e);
        return e;
    }

    @Override
    public Environment read(long id) {
        return entityManager.find(Environment.class, id);
    }

    @Transactional
    @Override
    public boolean update(long id) {
        Environment p = entityManager.find(Environment.class, id);
        if(p!=null) {
            p.setDescription(p.getDescription());
            p.setPrice(p.getPrice());
            p.setInStock(p.getInStock());
            return true;
        }
        else
            return false;
    }
    @Transactional
    @Override
    public boolean delete(long id) {
        Environment p = entityManager.find(Environment.class, id);
        if(p!=null) {
            entityManager.remove(p);
            return true;
        }
        else
            return false;

    }

}






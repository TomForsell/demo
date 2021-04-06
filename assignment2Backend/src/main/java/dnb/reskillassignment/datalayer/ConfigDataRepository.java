package dnb.reskillassignment.datalayer;

import dnb.reskillassignment.models.ConfigData;
import dnb.reskillassignment.models.Environment;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface ConfigDataRepository extends CrudRepository<ConfigData,Long>{
    List<ConfigData> findByEnvironment(Environment environment);
}


package htw_berlin.kochbuch_backend;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}

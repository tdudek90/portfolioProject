package pl.tomekdudek.portfolioProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomekdudek.portfolioProject.models.User;

import java.util.List;

/**
 * Created by Tomek on 2017-06-25.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

List<User> findByRole(String role);


}

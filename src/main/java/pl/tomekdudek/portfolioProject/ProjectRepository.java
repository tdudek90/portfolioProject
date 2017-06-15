package pl.tomekdudek.portfolioProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomekdudek.portfolioProject.models.Project;

import java.util.List;

/**
 * Created by Tomek on 2017-06-10.
 */

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer>{

    List<Project> findAll();

}

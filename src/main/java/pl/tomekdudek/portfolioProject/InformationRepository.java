package pl.tomekdudek.portfolioProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomekdudek.portfolioProject.models.Information;

import java.util.List;

/**
 * Created by Tomek on 2017-06-15.
 */
@Repository
public interface InformationRepository extends CrudRepository <Information, Integer> {

    List<Information> findAll();
}

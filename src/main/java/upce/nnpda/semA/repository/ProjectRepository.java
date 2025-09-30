package upce.nnpda.semA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upce.nnpda.semA.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}

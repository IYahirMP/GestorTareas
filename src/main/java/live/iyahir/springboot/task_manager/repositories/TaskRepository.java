package live.iyahir.springboot.task_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import live.iyahir.springboot.task_manager.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	
}

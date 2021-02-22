package br.com.jt.worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jt.commons.entities.worker.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}

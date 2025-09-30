package upce.nnpda.semA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upce.nnpda.semA.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}

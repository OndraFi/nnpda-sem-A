package upce.nnpda.semA.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "app_tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private TicketType type;

    @NonNull
    private TicketState state;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

}

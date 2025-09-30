package upce.nnpda.semA.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "app_projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private ProjectState state;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", user=" + user +
                '}';
    }
}

package decimal.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "projects", schema = "test")
public class Project {

    public Project() {
    }

    private Long id;
    private String projectName;
    private List<Draw> draws;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "project_name", unique = true)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    public List<Draw> getDraws() {
        return draws;
    }

    public void setDraws(List<Draw> products) {
        this.draws = products;
    }

    public void addDraws(Draw draw) {
        draws.add(draw);
    }


    //TODO  как починить ленивую реализацию загрузки списка чертежей ?
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
//                ", draws=" + draws +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectName.equals(project.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName);
    }
}

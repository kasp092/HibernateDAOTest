
package decimal.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "drawings", schema = "test")
public class Draw {
    public Draw() {
    }

    private Long id;
    private String drawName;
    private String decimalNumber;
    private String author;
    private String comments;
    private Integer inventoryNumber;
    private Project project;

    public Draw(String drawName, String decimalNumber) {
        this.drawName = drawName;
        this.decimalNumber = decimalNumber;
    }

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Column(name = "draw_name", nullable = false)
    public String getDrawName() {
        return drawName;
    }

    public void setDrawName(String darawName) {
        this.drawName = darawName;
    }

    @Column(name = "decimal_number", nullable = false, unique = true)
    public String getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(String decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column (name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "inventory_number", unique = true)
    public Integer getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Integer inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
        project.addDraws(this);
    }

    @Override
    public String toString() {
        return "Draw{" +
                "id=" + id +
                ", drawName='" + drawName + '\'' +
                ", decimalNumber='" + decimalNumber + '\'' +
                ", author='" + author + '\'' +
                ", comments='" + comments + '\'' +
                ", inventoryNumber=" + inventoryNumber +
                ", project=" + project +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Draw draw = (Draw) o;
        return drawName.equals(draw.drawName) &&
                decimalNumber.equals(draw.decimalNumber) &&
                Objects.equals(inventoryNumber, draw.inventoryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drawName, decimalNumber, inventoryNumber);
    }
}

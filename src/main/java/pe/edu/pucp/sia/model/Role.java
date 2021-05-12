package pe.edu.pucp.sia.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// import lombok.Getter;
// import lombok.Setter;

@Entity
public class Role {
    @Id @Column(name="id_role") @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer id;
    private String description;
    @ManyToOne						
	@JoinColumn(name="id_faculty")		
	private Faculty faculty;
    
    @ManyToOne
    @JoinColumn(name="id_activity")
    private Activity activity;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public Activity getActivity(){
        return this.activity;
    }
    public void setActivity(Activity activity){
        this.activity=activity;
    }
    public Faculty getFaculty(){
        return this.faculty;
    }
    public void setFaculty(Faculty faculty){
        this.faculty=faculty;
    }

}

package hiber.model;

import javax.persistence.*;

@Entity
@Table (name = "Car")
public class Car {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn (name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;

    public Car() {}

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "user=" + user +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}';
    }
}

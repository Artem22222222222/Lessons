package org.example;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table
public class Homework {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EqualsAndHashCode.Exclude
    private String description;
    @EqualsAndHashCode.Exclude
    private LocalDate deadline;
    @EqualsAndHashCode.Exclude
    private int mark;
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Student student;

    public Homework(Long id, String description, LocalDate deadline, int mark, Student student) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.mark = mark;
        this.student = student;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public int getMark() {
        return mark;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", mark=" + mark +
                '}';
    }
}


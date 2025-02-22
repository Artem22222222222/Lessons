package org.example;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentDao implements GenericDao<Student, Long>{

    private final EntityManagerFactory entityManagerFactory;

    public StudentDao(){
        Map<String, String> jpaConf = new HashMap<>();
        jpaConf.put("jakarta.persistence.jdbc.url" , "jdbc:mysql://" + System.getenv("url"));
        jpaConf.put("jakarta.persistence.jdbc.user" , System.getenv("user"));
        jpaConf.put("jakarta.persistence.jdbc.password" , System.getenv("password"));
        jpaConf.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        jpaConf.put("hibernate.hbm2ddl.auto", "update");
        jpaConf.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        entityManagerFactory = Persistence.createEntityManagerFactory("hillel-persistence-unit", jpaConf);
    }

    @Override
    public void save(Student entity) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            if (entity.getId() == null || entityManager.find(Student.class, entity.getId()) == null) {
                entityManager.getTransaction().begin();
                entityManager.persist(entity);
                entityManager.getTransaction().commit();
            } else {
                update(entity);
            }
        }
    }


    @Override
    public Student findById(Long aLong) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            return entityManager.find(Student.class, aLong);
        }
    }

    @Override
    public Student findByEmail(String email) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            TypedQuery<Student> request = entityManager.createQuery("select s from Student s where s.email = :email", Student.class);
            request.setParameter("email", email);
            return request.getResultList().getFirst();
        }
    }

    @Override
    public List<Student> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            TypedQuery<Student> request = entityManager.createQuery("select s from Student s", Student.class);
            return request.getResultList();
        }
    }

    @Override
    public boolean deleteById(Long aLong) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Student student = entityManager.find(Student.class, aLong);


            if (student != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(student);
                entityManager.getTransaction().commit();
                return true;
            }
            return false;
        }

    }

    @Override
    public Student update(Student entity) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();

            entityManager.merge(entity);

            entityManager.getTransaction().commit();
            return entityManager.find(Student.class, entity.getId());
        }
    }
}

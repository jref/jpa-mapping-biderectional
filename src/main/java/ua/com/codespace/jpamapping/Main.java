package ua.com.codespace.jpamapping;

import ua.com.codespace.jpamapping.model.Account;
import ua.com.codespace.jpamapping.model.Company;
import ua.com.codespace.jpamapping.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Company company = new Company("google");
        Employee employee1 = new Employee("Fred");
        employee1.setCompany(company);
        Employee employee2 = new Employee("Steve");
        employee2.setCompany(company);
        company.setEmployees(Arrays.asList(employee1, employee2));
        Account account1 = new Account("fredAccount");
        account1.setEmployee(employee1);
        Account account2 = new Account("steveAccount");
        account2.setEmployee(employee2);
        employee1.setAccount(account1);
        employee2.setAccount(account2);


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(company);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}

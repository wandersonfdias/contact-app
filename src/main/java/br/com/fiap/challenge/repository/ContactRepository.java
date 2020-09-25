package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.entity.Contact;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ContactRepository implements PanacheRepository<Contact> {

}
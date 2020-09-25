package br.com.fiap.challenge.business;

import br.com.fiap.challenge.entity.Contact;
import br.com.fiap.challenge.repository.ContactRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ContactBusiness {

    @Inject
    private ContactRepository contactRepository;

    public Contact update(Long id, Contact contact) {
        Contact entity = contactRepository.findById(id);

        if (entity == null) {
            throw new WebApplicationException("Contact not found.", Response.Status.NOT_FOUND);
        }

        // update contact fields
        entity.setName(contact.getName());
        entity.setEmail(contact.getEmail());
        entity.setPhone(contact.getPhone());

        return entity;
    }
}

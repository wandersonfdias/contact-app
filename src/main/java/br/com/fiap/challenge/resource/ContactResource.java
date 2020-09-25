package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.business.ContactBusiness;
import br.com.fiap.challenge.entity.Contact;
import br.com.fiap.challenge.repository.ContactRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {

    @Inject
    private ContactRepository contactRepository;

    @Inject
    private ContactBusiness contactBusiness;

    @GET
    public List<Contact> findAll() {
        return contactRepository.listAll();
    }
    @POST
    @Transactional
    public Response create(Contact contact) {
        contactRepository.persist(contact);
        return Response.ok(contact).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Contact contact) {
        Contact result = contactBusiness.update(id, contact);
        return Response.ok(result).build();
    }
    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Contact entity = contactRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Contact does not exist.", Response.Status.NOT_FOUND);
        }
        contactRepository.delete(entity);
        return Response.status(204).build();
    }
}

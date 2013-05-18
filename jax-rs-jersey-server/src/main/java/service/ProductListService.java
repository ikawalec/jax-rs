package service;

import com.sun.jersey.spi.resource.Singleton;
import dao.ProductListDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/product")
public class ProductListService {

    private ProductListDAO dao;

    public ProductListService(){
        dao = new ProductListDAO();
        dao.add("orange");
        dao.add("lemon");
        dao.add("banana");
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@PathParam("id") Integer id){
        return dao.get(id);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void add(String name){
        dao.add(name);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void update(@PathParam("id") Integer id, String name){
        dao.update(id, name);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        dao.delete(id);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String getList(){
        return dao.toString();
    }

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String search(@FormParam("name") String name, @FormParam("limit") String limit){
        return dao.search(name, limit);
    }

}

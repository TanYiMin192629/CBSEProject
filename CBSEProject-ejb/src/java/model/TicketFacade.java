/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Ticket;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yi Min
 */
@Stateless
public class TicketFacade extends AbstractFacade<Ticket> {

    @PersistenceContext(unitName = "CBSEProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketFacade() {
        super(Ticket.class);
    }
    
}

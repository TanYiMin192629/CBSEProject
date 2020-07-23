/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ticket;
import entities.Events;
import entities.Ticket;
import entities.Users;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.TicketFacade;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Yi Min
 */
@Named(value = "ticketController")
@SessionScoped
public class ticketController implements Serializable {

    @EJB
    private ticket ticket;


    @EJB
    private TicketFacade ticketFacade;
    
    
    private Events e = new Events();
    Users user;
    StreamedContent chart = null;

    
    public Events getE() {
        return e;
    }
    
    public void setE(Events e) {
        this.e = e;
    }
    
     public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public StreamedContent getChart() {
        return chart;
    }

    public void setChart(StreamedContent chart) {
        this.chart = chart;
    }
    
    public List<Ticket> findall(){
        return this.ticketFacade.findAll();
    }
    
    public StreamedContent generateChart() throws IOException{
    
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Object[]> data = this.ticket.countTicket();
        FileInputStream fis = null;
        
        for (Object[] objects : data) {
        dataset.setValue(new Double(objects[1].toString()), objects[0].toString(), objects[0].toString());
        }
        
        
        JFreeChart barChart = ChartFactory.createBarChart("Events Analysis", "Event's Name", "Number of Participants", dataset,PlotOrientation.VERTICAL, true, true, false);
        
        
        int width = 640;    /* Width of the image */
        int height = 1000;   /* Height of the image */ 
        
        File BarChart = new File("D:\\chart.jpg"); 
        ChartUtilities.saveChartAsJPEG(BarChart , barChart , width , height);
        
        fis = new FileInputStream(BarChart);
        this.chart = new DefaultStreamedContent(fis);
        fis.close();
        
        return this.chart;
    
    
    }
    /**
     * Creates a new instance of joinEventController
     */
    public ticketController() {
    }
    
}

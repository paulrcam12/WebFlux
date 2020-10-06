/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author PaulRCam
 */



@Document(collection = "Pulsos")
public class Pulso {

    public Pulso(String Machine, String Hora) {
        this.Machine = Machine;
        this.Hora = Hora;
    }

    public Pulso() {
    }
    
    
    @Id
    private String _id;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
    
    private Long idPulses;
    private String Machine;

    @Override
    public String toString() {
        return "Pulso{" + "_id=" + _id + ", idPulses=" + idPulses + ", Machine=" + Machine + ", Hora=" + Hora + '}';
    }

    
    private String Hora;

    public Long getIdPulses() {
        return idPulses;
    }

    public void setIdPulses(Long idPulses) {
        this.idPulses = idPulses;
    }

    public String getMachine() {
        return Machine;
    }

    public void setMachine(String Machine) {
        this.Machine = Machine;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    
    
    
}

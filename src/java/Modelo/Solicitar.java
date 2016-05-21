package Modelo;
// Generated 19/05/2016 10:58:30 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Solicitar generated by hbm2java
 */
public class Solicitar  implements java.io.Serializable {


     private int idsolicitud;
     private Objeto objeto;
     private Usuario usuarioByIdprestador;
     private Usuario usuarioByIdconsumidor;
     private Date fechasolicitud;
     private int tiemposolicitado;
     private String medida;

    public Solicitar() {
    }

	
    public Solicitar(int idsolicitud, Objeto objeto, Usuario usuarioByIdprestador, Usuario usuarioByIdconsumidor, int tiemposolicitado) {
        this.idsolicitud = idsolicitud;
        this.objeto = objeto;
        this.usuarioByIdprestador = usuarioByIdprestador;
        this.usuarioByIdconsumidor = usuarioByIdconsumidor;
        this.tiemposolicitado = tiemposolicitado;
    }
    public Solicitar(int idsolicitud, Objeto objeto, Usuario usuarioByIdprestador, Usuario usuarioByIdconsumidor, Date fechasolicitud, int tiemposolicitado, String medida) {
       this.idsolicitud = idsolicitud;
       this.objeto = objeto;
       this.usuarioByIdprestador = usuarioByIdprestador;
       this.usuarioByIdconsumidor = usuarioByIdconsumidor;
       this.fechasolicitud = fechasolicitud;
       this.tiemposolicitado = tiemposolicitado;
       this.medida = medida;
    }
   
    public int getIdsolicitud() {
        return this.idsolicitud;
    }
    
    public void setIdsolicitud(int idsolicitud) {
        this.idsolicitud = idsolicitud;
    }
    public Objeto getObjeto() {
        return this.objeto;
    }
    
    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
    public Usuario getUsuarioByIdprestador() {
        return this.usuarioByIdprestador;
    }
    
    public void setUsuarioByIdprestador(Usuario usuarioByIdprestador) {
        this.usuarioByIdprestador = usuarioByIdprestador;
    }
    public Usuario getUsuarioByIdconsumidor() {
        return this.usuarioByIdconsumidor;
    }
    
    public void setUsuarioByIdconsumidor(Usuario usuarioByIdconsumidor) {
        this.usuarioByIdconsumidor = usuarioByIdconsumidor;
    }
    public Date getFechasolicitud() {
        return this.fechasolicitud;
    }
    
    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }
    public int getTiemposolicitado() {
        return this.tiemposolicitado;
    }
    
    public void setTiemposolicitado(int tiemposolicitado) {
        this.tiemposolicitado = tiemposolicitado;
    }
    public String getMedida() {
        return this.medida;
    }
    
    public void setMedida(String medida) {
        this.medida = medida;
    }
    public int hashCode() {
        int num= (objeto.hashCode() * 17) * 31;
        num = (num + usuarioByIdconsumidor.hashCode()) * 17;
        num = (num + usuarioByIdprestador.hashCode()) * 17; 
        return num; //To change body of generated methods, choose Tools | Templates.
    }



}


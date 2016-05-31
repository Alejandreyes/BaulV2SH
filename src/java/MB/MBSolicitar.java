/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import Controlador.dao.PrestarDao;
import Controlador.dao.SolicitudDao;
import Modelo.Objeto;
import Modelo.Prestamo;
import Modelo.Solicitar;
import Modelo.Usuario;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rodrigorojo
 */
@ManagedBean (name="mBSolicitar")
@RequestScoped
public class MBSolicitar {
    
    private int idsolicitud;
    private Objeto objeto;
    private Usuario usuarioByIdprestador;
    private Usuario usuarioByIdconsumidor;
    private Date fechasolicitud;
    private int tiemposolicitado;
    private String medida;
    /**
     * Creates a new instance of MBSolicitar
     */
    public MBSolicitar() {
    }

    /**
     * @return the idsolicitud
     */
    public int getIdsolicitud() {
        return idsolicitud;
    }

    /**
     * @param idsolicitud the idsolicitud to set
     */
    public void setIdsolicitud(int idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    /**
     * @return the objeto
     */
    public Objeto getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the usuarioByIdprestador
     */
    public Usuario getUsuarioByIdprestador() {
        return usuarioByIdprestador;
    }

    /**
     * @param usuarioByIdprestador the usuarioByIdprestador to set
     */
    public void setUsuarioByIdprestador(Usuario usuarioByIdprestador) {
        this.usuarioByIdprestador = usuarioByIdprestador;
    }

    /**
     * @return the usuarioByIdconsumidor
     */
    public Usuario getUsuarioByIdconsumidor() {
        return usuarioByIdconsumidor;
    }

    /**
     * @param usuarioByIdconsumidor the usuarioByIdconsumidor to set
     */
    public void setUsuarioByIdconsumidor(Usuario usuarioByIdconsumidor) {
        this.usuarioByIdconsumidor = usuarioByIdconsumidor;
    }

    /**
     * @return the fechasolicitud
     */
    public Date getFechasolicitud() {
        return fechasolicitud;
    }

    /**
     * @param fechasolicitud the fechasolicitud to set
     */
    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    /**
     * @return the tiemposolicitado
     */
    public int getTiemposolicitado() {
        return tiemposolicitado;
    }

    /**
     * @param tiemposolicitado the tiemposolicitado to set
     */
    public void setTiemposolicitado(int tiemposolicitado) {
        this.tiemposolicitado = tiemposolicitado;
    }

    /**
     * @return the medida
     */
    public String getMedida() {
        return medida;
    }

    /**
     * @param medida the medida to set
     */
    public void setMedida(String medida) {
        this.medida = medida;
    }
    public String aceptarSolicitud(){
        System.out.println("Entro a aceptar");
        SolicitudDao sltDao = new SolicitudDao();                      
        Prestamo prstm = new Prestamo();
        Date date = new Date();
        
        Solicitar slt = sltDao.Buscar(idsolicitud);        
        Objeto obj = slt.getObjeto();

        prstm.setObjeto(obj);
        prstm.setUsuarioByIdprestador(slt.getUsuarioByIdconsumidor());
        prstm.setUsuarioByIdconsumidor(slt.getUsuarioByIdprestador());        
        prstm.setFechaprestamo(date);
        prstm.setIdprestamo(prstm.hashCode());
        
        PrestarDao prstDao = new PrestarDao();
        prstDao.Guardar(prstm);
        
        sltDao.Eliminar(slt);
        return "index";
    }
    public String rechazarSolicitud(){
        System.out.println("Entro a rechazar");
        SolicitudDao sltDao = new SolicitudDao();  
        Solicitar slt = sltDao.Buscar(idsolicitud);
        sltDao.Eliminar(slt);
        return "index";
    }
    
}

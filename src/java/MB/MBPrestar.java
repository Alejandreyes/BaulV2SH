/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import Controlador.dao.ObjetoDao;
import Controlador.dao.PrestarDao;
import Controlador.dao.SolicitudDao;
import Controlador.dao.UsuarioDao;
import Modelo.Objeto;
import Modelo.Prestamo;
import Modelo.Solicitar;
import Modelo.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Stein
 */
@ManagedBean (name="mBPrestar")
@RequestScoped
public class MBPrestar {

    @ManagedProperty(value="#{mBUsuario}")
    MBUsuario mBUsuario;
    private Objeto objeto;
    private String nombreObjeto;
    private String nombreUsuario;
    private Usuario usuarioByNombreprestador;
    private Usuario usuarioByNombreconsumidor;
    private Date fechaprestamo;
    private Integer calificacionprestador;
    private Integer calificaconsumidor;
    private String opiniondePrestador;
    private String opiniondeConsumidor;
    private Usuario us;
    private boolean flag;
    private Integer idPrestamo;
    
    public MBPrestar() {
    }
    
    public String getOpiniondePrestador(){
        return opiniondePrestador;
    }
    public void setOpiniondePrestador(String opiniondePrestador){
        this.opiniondePrestador = opiniondePrestador;
    }
    public String getOpiniondeConsumidor(){
        return opiniondeConsumidor;
    }
    public void setOpiniondeConsumidor(String opiniondeConsumidor){
        this.opiniondeConsumidor = opiniondeConsumidor;
    }
    public boolean getFlag(){
        return flag;
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public Integer getIdPrestamo(){
        return idPrestamo;
    }
    public void setIdPrestamo(Integer idPrestamo){
        this.idPrestamo = idPrestamo;
    }
    public MBUsuario getmBUsuario() {
        return mBUsuario;
    }

    public void setmBUsuario(MBUsuario mBUsuario) {
        this.mBUsuario = mBUsuario;
    }


    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public Usuario getUsuarioByNombreprestador() {
        return usuarioByNombreprestador;
    }

    public void setUsuarioByNombreprestador(Usuario usuarioByNombreprestador) {
        this.usuarioByNombreprestador = usuarioByNombreprestador;
    }

    public Usuario getUsuarioByNombreconsumidor() {
        return usuarioByNombreconsumidor;
    }

    public void setUsuarioByNombreconsumidor(Usuario usuarioByNombreconsumidor) {
        this.usuarioByNombreconsumidor = usuarioByNombreconsumidor;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Integer getCalificacionprestador() {
        return calificacionprestador;
    }

    public void setCalificacionprestador(Integer calificacionprestador) {
        this.calificacionprestador = calificacionprestador;
    }

    public Integer getCalificaconsumidor() {
        return calificaconsumidor;
    }

    public void setCalificaconsumidor(Integer calificaconsumidor) {
        this.calificaconsumidor = calificaconsumidor;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
    
    public void solicitarPrestamo(){
        ObjetoDao objd = new ObjetoDao();
        
        int i = nombreObjeto.hashCode()*13;
        Objeto obj = objd.Buscar(i);
        objeto = obj;
        
        Date date = new Date();
        Prestamo prst = new Prestamo();
        PrestarDao prstd = new PrestarDao();
        
        UsuarioDao usdao = new UsuarioDao();
        Usuario us1 = usdao.Buscar(mBUsuario.getIdUsuario()); //el de la sesion iniciada

        prst.setUsuarioByIdconsumidor(us1);
        prst.setUsuarioByIdprestador(obj.getUsuario());
        prst.setFechaprestamo(date);
        
        prstd.Guardar(prst);
    }
    public String prueba(){        
        System.out.println("entro aqui");        
        return "index";
    }
    public String calificarPrestador(){
        PrestarDao prstDao = new PrestarDao();
        Prestamo prst = new Prestamo();
        prst = prstDao.Buscar(idPrestamo);        
        prst.setCalificacionprestador(calificacionprestador);
        prst.setOpinionsobreprestador(opiniondePrestador);
        prstDao.califPrestador(prst);        
        return "index";
    }
    public String calificarConsumidor(){
        System.out.println("entrooo1");        
        PrestarDao prstDao = new PrestarDao();
        Prestamo prst = new Prestamo();
        prst = prstDao.Buscar(idPrestamo);
        prst.setCalificaconsumidor(calificaconsumidor);
        prst.setOpinionsobreconsumidor(opiniondeConsumidor);
        System.out.println("id: "+prst.getIdprestamo()+" califcons: "+prst.getCalificaconsumidor()+" opincons: "+prst.getOpinionsobreconsumidor());
        prstDao.califConsumidor(prst);
        System.out.println("saliooo 1");
        return "index";
    }
    

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
}

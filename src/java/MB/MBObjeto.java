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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stein
 */
@ManagedBean(name="mBObjeto")
@RequestScoped
public class MBObjeto {

    @ManagedProperty(value="#{mBUsuario}")
    private MBUsuario mBUsuario;
    String cadenaBusqueda;
    int idlibro;
    String nombreLibro;
    String buscarLibro;
    String autor;
    Integer edicion;
    Integer anio;
    String genero;
    String sinopsis;
    Integer numPaginas;
    String nombreUsuario;
    String resultado;
    List<Objeto> objetosParam = new ArrayList<Objeto>();
    int idPrestador;
    Date fechap;
    int numDias;
    private String usuarioIniciado;
    
    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }
    public Date getFechap() {
        return fechap;
    }

    public void setFechap(Date fechap) {
        this.fechap = fechap;
    }

    public String getCadenaBusqueda() {
        return cadenaBusqueda;
    }

    public void setCadenaBusqueda(String cadenaBusqueda) {
        this.cadenaBusqueda = cadenaBusqueda;
    }
    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }  
    public int getIdPrestador(){
        return idPrestador;
    }
    public void setIdPrestador(int idPrestador){
        this.idPrestador = idPrestador;
    }   
    List<Objeto> objetos = new ArrayList<Objeto>();
    public MBObjeto() {
    }

    public MBUsuario getmBUsuario() {
        return mBUsuario;
    }

    public void setmBUsuario(MBUsuario mBUsuario) {
        this.mBUsuario = mBUsuario;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getBuscarLibro() {
        return buscarLibro;
    }

    public void setBuscarLibro(String buscarLibro) {
        this.buscarLibro = buscarLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getEdicion() {
        return edicion;
    }

    public void setEdicion(Integer edicion) {
        this.edicion = edicion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Objeto> getObjetosParam() {
        objetosParam = inicia("nombrelibro");
        return objetosParam;
    }

    public void setObjetosParam(List<Objeto> objetosParam) {
        this.objetosParam = objetosParam;
    }
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }
    public String getCedanaBusqueda() {
        return cadenaBusqueda;
    }

    public void setCedanaBusqueda(String cedanaBusqueda) {
        this.cadenaBusqueda = cedanaBusqueda;
    }
    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }
    public String altaObjeto(){
        Usuario us= new Usuario(mBUsuario.getIdUsuario() ,mBUsuario.getNombreusuario(), mBUsuario.getContrasenia(), mBUsuario.getNombre(),mBUsuario.getApellidos(),mBUsuario.getCorreo() );
        Objeto obj;
        obj = new Objeto();
        obj.setNombrelibro(nombreLibro);
        obj.setAutor(autor);
        obj.setEdicion(edicion);
        obj.setAnio(anio);
        obj.setGenero(genero);
        obj.setSinopsis(sinopsis);
        obj.setNumpaginas(numPaginas);
        obj.setUsuario(us);
        obj.setIdlibro(obj.hashCode());
        ObjetoDao objd = new ObjetoDao();
        objd.Guardar(obj);FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.setAttribute("nombreLibro",Integer.toString(obj.getIdlibro()));
        return "AltaObjetoImagenIH";
    }
    public String consultarObjeto(){
         //Usuario us= new Usuario(mBUsuario.getNombreusuario(), mBUsuario.getContrasenia(), mBUsuario.getNombre(),mBUsuario.getApellidos(),mBUsuario.getCorreo() );        
        ObjetoDao objd = new ObjetoDao();        
        int i = buscarLibro.hashCode()*13;
        Objeto obj = objd.Buscar(i);
        
        nombreLibro = obj.getNombrelibro();
        autor = obj.getAutor();
        edicion = obj.getEdicion();
        anio = obj.getAnio();
        genero = obj.getGenero();
        sinopsis = obj.getSinopsis();
        numPaginas = obj.getNumpaginas();
        
        idPrestador = obj.getUsuario().getIdusuario();
        
        //nombreLibro = obj.getNombrelibro();        
        return "ConsultaObjetoIH.xhtml";
    }
    public String bajaObjeto(){        
        Objeto obj;// = new Objeto();
        ObjetoDao objd = new ObjetoDao();
        obj = objd.Buscar(idlibro);
        objd.Eliminar(obj);       
        return "index.xhtml";
    }
    public String cambiarObjeto(){
        Objeto obj;
        ObjetoDao objd = new ObjetoDao();

        obj = objd.Buscar(idlibro);
        obj.setAutor(autor);
        obj.setEdicion(edicion);
        obj.setAnio(anio);
        obj.setGenero(genero);
        obj.setSinopsis(sinopsis);
        obj.setNumpaginas(numPaginas);
        objd.Actualizar(obj);
        return "index.xhtml?faces-redirect=true";
    }
    public List<Objeto> getAllObjetos(){
        ObjetoDao dao=new ObjetoDao();
        return dao.obtenerTodos();
    }
    public String solicitarPrestamo(){
        ObjetoDao objd = new ObjetoDao();
        Objeto obj = objd.Buscar(idlibro);
        Date date = new Date();
        Solicitar prst = new Solicitar();
        SolicitudDao prstd = new SolicitudDao();
        UsuarioDao usdao = new UsuarioDao();
        Usuario us1 = usdao.Buscar(mBUsuario.getIdUsuario()); //el de la sesion iniciada
        prst.setUsuarioByIdconsumidor(us1);
        prst.setUsuarioByIdprestador(obj.getUsuario());
        prst.setObjeto(obj);
        prst.setFechasolicitud(fechap);
        prst.setIdsolicitud(prst.hashCode());
        prst.setTiemposolicitado(numDias);
        prst.setMedida("Dias");
        prstd.Guardar(prst);
        return "SolicitarPrestamoIH.xhtml";
    }
    public List<Solicitar> verSolicitudes(){
         SolicitudDao sltdao = new SolicitudDao();         
         List<Solicitar> lsts = sltdao.obtenerSolicitudes(idlibro);
         return lsts;
    }
    public List<Prestamo> verPrestamos(){
        List<Prestamo> lstPrestamos = new ArrayList<Prestamo>();
        PrestarDao prstDao = new PrestarDao();
        lstPrestamos = prstDao.obtenerPrestamos(idlibro);
        return lstPrestamos;
    }
    public boolean puedeCalificarPrestador(int idConsumidor){
        PrestarDao prstDao = new PrestarDao();
        List<Integer> list = prstDao.verConsumidores(idlibro);
        return (list.contains(idConsumidor));
    }
    public Prestamo prestamoConsumidorPorLibro(int idConsumidor){
        PrestarDao pDao = new PrestarDao();
        return pDao.obtenerPrestamosPorConsumidor(idlibro,idConsumidor).get(0);
    }
    public int prestamoConsumidorPorLibroId(int idConsumidor){
        PrestarDao pDao = new PrestarDao();
        Prestamo prst = pDao.obtenerPrestamosPorConsumidor(idlibro,idConsumidor).get(0);
        System.out.println("este es el bueno: "+prst.getIdprestamo());
        return prst.getIdprestamo();
    }

    
    /**
     * @return the usuarioIniciado
     */
    public String getUsuarioIniciado() {
        return usuarioIniciado;
    }

    /**
     * @param usuarioIniciado the usuarioIniciado to set
     */
    public void setUsuarioIniciado(String usuarioIniciado) {
        this.usuarioIniciado = usuarioIniciado;
    }
    public void eliminaPrestamos(){
        
    }
    public String prestado(Objeto obj){
        PrestarDao da=new PrestarDao();
        return (da.disponible(obj))? "Disponible" : "Prestado" ;
    }
    public String consultarObjeto(Objeto obj){        
        idlibro = obj.getIdlibro();
        nombreLibro = obj.getNombrelibro();
        autor = obj.getAutor();
        edicion = obj.getEdicion();
        anio = obj.getAnio();
        genero = obj.getGenero();
        sinopsis = obj.getSinopsis();
        numPaginas = obj.getNumpaginas();
        nombreUsuario = obj.getUsuario().getNombreusuario();
        nombreUsuario = obj.getUsuario().getNombreusuario();
        System.out.println("idPrestador: "+ obj.getUsuario().getIdusuario());
        idPrestador = obj.getUsuario().getIdusuario();
        return "ConsultaObjetoIH.xhtml";
    }   
    
    public int calificacionPrestador(int idPrestador){
        PrestarDao pd = new PrestarDao();
        return pd.getCalifPrestador(idPrestador);
    }
    public int calificacionConsumidor(int idConsumidor){
        PrestarDao pd = new PrestarDao();
        return pd.getCalifconsumidor(idConsumidor);
    }
    private List<Objeto> inicia(String param){
        ObjetoDao dao= new ObjetoDao();
        System.out.println(cadenaBusqueda);
        return dao.obtenerObjetosParam(param,cadenaBusqueda);
    }
    public String consultarCadena(){
        objetosParam = inicia("nombrelibro");
        return "ConsultarObjetosParamIH.xhtml";
    }
}

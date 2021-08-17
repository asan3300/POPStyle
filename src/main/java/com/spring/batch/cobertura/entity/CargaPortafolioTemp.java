package com.spring.batch.cobertura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carga_portafolio_temp")
public class CargaPortafolioTemp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
    @Column(name = "cod_servicio")
	private String codServicio;
    @Column(name = "nombre_servicio")
	private String nombreServicio;
    @Column(name = "cod_unidad_negocio")
	private String codUnidadNegocio;
    @Column(name = "nombre_unidad_negocio")
	private String nombreUnidadNegocio;
    @Column(name = "cod_linea")
	private String codLinea;
    @Column(name = "nombre_linea")
	private String nombreLinea;
    @Column(name = "cod_sub_linea")
	private String codSubLinea;
    @Column(name = "nombre_sub_linea")
	private String nombreSubLinea;
    @Column(name = "cod_tipo_venta")
	private String codTipoVenta;
    @Column(name = "nombre_tipo_venta")
	private String nombreTipoVenta;
    @Column(name = "porcentaje_imp")
	private String porcentajeImp;
    @Column(name = "clase_condicion")
	private String claseCondicion;
    @Column(name = "indicador_imp")
	private String indicadorImp;
    @Column(name = "cod_centro_logistico")
	private Integer codCentroLogistico;
    @Column(name = "nombre_centro_logistico")
	private String nombreCentroLogistico;
    @Column(name = "cod_centro_beneficio")
	private String codCentroBeneficio;
    @Column(name = "nombre_centro_beneficio")
	private String nombreCentroBeneficio;
    @Column(name = "cod_tabla15")
	private Integer codTabla15;
    @Column(name = "nombre_tabla15")
	private String nombreTabla15;
    @Column(name = "reporta_SSF")
	private String reportaSSF;
    @Column(name = "cod_cuenta_contable")
	private String codCuentaContable;
    @Column(name = "nombre_cuentaContable")
	private String nombreCuentaContable;
    @Column(name = "cod_impuesto")
	private Integer codImpuesto;
    @Column(name = "impuesto")
	private String impuesto;
    @Column(name = "grupo_imputacion")
	private String grupoImputacion;
    @Column(name = "cod_tipo_servicio")
	private String codTipoServicio;
    @Column(name = "descripcion_tipo_servicio")
	private String descripcionTipoServicio;
    @Column(name = "cod_tipo_uso")
	private String codTipoUso;
    @Column(name = "descripcion_tipo_uso")
	private String descripcionTipoUso;
    @Column(name = "intensidad_horario")
	private String intensidadHorario;
    @Column(name = "numero_participantes")
	private String numeroParticipantes;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodServicio() {
		return codServicio;
	}
	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public String getCodUnidadNegocio() {
		return codUnidadNegocio;
	}
	public void setCodUnidadNegocio(String codUnidadNegocio) {
		this.codUnidadNegocio = codUnidadNegocio;
	}
	public String getNombreUnidadNegocio() {
		return nombreUnidadNegocio;
	}
	public void setNombreUnidadNegocio(String nombreUnidadNegocio) {
		this.nombreUnidadNegocio = nombreUnidadNegocio;
	}
	public String getCodLinea() {
		return codLinea;
	}
	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}
	public String getNombreLinea() {
		return nombreLinea;
	}
	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}
	public String getCodSubLinea() {
		return codSubLinea;
	}
	public void setCodSubLinea(String codSubLinea) {
		this.codSubLinea = codSubLinea;
	}
	public String getNombreSubLinea() {
		return nombreSubLinea;
	}
	public void setNombreSubLinea(String nombreSubLinea) {
		this.nombreSubLinea = nombreSubLinea;
	}
	public String getCodTipoVenta() {
		return codTipoVenta;
	}
	public void setCodTipoVenta(String codTipoVenta) {
		this.codTipoVenta = codTipoVenta;
	}
	public String getNombreTipoVenta() {
		return nombreTipoVenta;
	}
	public void setNombreTipoVenta(String nombreTipoVenta) {
		this.nombreTipoVenta = nombreTipoVenta;
	}
	public String getPorcentajeImp() {
		return porcentajeImp;
	}
	public void setPorcentajeImp(String porcentajeImp) {
		this.porcentajeImp = porcentajeImp;
	}
	public String getClaseCondicion() {
		return claseCondicion;
	}
	public void setClaseCondicion(String claseCondicion) {
		this.claseCondicion = claseCondicion;
	}
	public String getIndicadorImp() {
		return indicadorImp;
	}
	public void setIndicadorImp(String indicadorImp) {
		this.indicadorImp = indicadorImp;
	}
	public Integer getCodCentroLogistico() {
		return codCentroLogistico;
	}
	public void setCodCentroLogistico(Integer codCentroLogistico) {
		this.codCentroLogistico = codCentroLogistico;
	}
	public String getNombreCentroLogistico() {
		return nombreCentroLogistico;
	}
	public void setNombreCentroLogistico(String nombreCentroLogistico) {
		this.nombreCentroLogistico = nombreCentroLogistico;
	}
	public String getCodCentroBeneficio() {
		return codCentroBeneficio;
	}
	public void setCodCentroBeneficio(String codCentroBeneficio) {
		this.codCentroBeneficio = codCentroBeneficio;
	}
	public String getNombreCentroBeneficio() {
		return nombreCentroBeneficio;
	}
	public void setNombreCentroBeneficio(String nombreCentroBeneficio) {
		this.nombreCentroBeneficio = nombreCentroBeneficio;
	}
	public Integer getCodTabla15() {
		return codTabla15;
	}
	public void setCodTabla15(Integer codTabla15) {
		this.codTabla15 = codTabla15;
	}
	public String getNombreTabla15() {
		return nombreTabla15;
	}
	public void setNombreTabla15(String nombreTabla15) {
		this.nombreTabla15 = nombreTabla15;
	}
	public String getReportaSSF() {
		return reportaSSF;
	}
	public void setReportaSSF(String reportaSSF) {
		this.reportaSSF = reportaSSF;
	}
	public String getCodCuentaContable() {
		return codCuentaContable;
	}
	public void setCodCuentaContable(String codCuentaContable) {
		this.codCuentaContable = codCuentaContable;
	}
	public String getNombreCuentaContable() {
		return nombreCuentaContable;
	}
	public void setNombreCuentaContable(String nombreCuentaContable) {
		this.nombreCuentaContable = nombreCuentaContable;
	}
	public Integer getCodImpuesto() {
		return codImpuesto;
	}
	public void setCodImpuesto(Integer codImpuesto) {
		this.codImpuesto = codImpuesto;
	}
	public String getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	public String getGrupoImputacion() {
		return grupoImputacion;
	}
	public void setGrupoImputacion(String grupoImputacion) {
		this.grupoImputacion = grupoImputacion;
	}
	public String getCodTipoServicio() {
		return codTipoServicio;
	}
	public void setCodTipoServicio(String codTipoServicio) {
		this.codTipoServicio = codTipoServicio;
	}
	public String getDescripcionTipoServicio() {
		return descripcionTipoServicio;
	}
	public void setDescripcionTipoServicio(String descripcionTipoServicio) {
		this.descripcionTipoServicio = descripcionTipoServicio;
	}
	public String getCodTipoUso() {
		return codTipoUso;
	}
	public void setCodTipoUso(String codTipoUso) {
		this.codTipoUso = codTipoUso;
	}
	public String getDescripcionTipoUso() {
		return descripcionTipoUso;
	}
	public void setDescripcionTipoUso(String descripcionTipoUso) {
		this.descripcionTipoUso = descripcionTipoUso;
	}
	public String getIntensidadHorario() {
		return intensidadHorario;
	}
	public void setIntensidadHorario(String intensidadHorario) {
		this.intensidadHorario = intensidadHorario;
	}
	public String getNumeroParticipantes() {
		return numeroParticipantes;
	}
	public void setNumeroParticipantes(String numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

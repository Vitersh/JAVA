package com.bice.cambio_cupo_cclv.entities;

import java.util.Date;

public class MontoCorredora {

    String rut_corredora;
    int monto_diario;
    String cuenta_corredora;
    String nom_cliente;
    Date fecha_job;
    int saldo_disp_ov;

    public MontoCorredora(String rut_corredora, int monto_diario, String cuenta_corredora, String nom_cliente,
            Date fecha_job, int saldo_disp_ov) {
	super();
	this.rut_corredora = rut_corredora;
	this.monto_diario = monto_diario;
	this.cuenta_corredora = cuenta_corredora;
	this.nom_cliente = nom_cliente;
	this.fecha_job = fecha_job;
	this.saldo_disp_ov = saldo_disp_ov;
    }

    /**
     * @return the rut_corredora
     */
    public String getRut_corredora() {
	return rut_corredora;
    }

    /**
     * @param rut_corredora the rut_corredora to set
     */
    public void setRut_corredora(String rut_corredora) {
	this.rut_corredora = rut_corredora;
    }

    /**
     * @return the monto_diario
     */
    public int getMonto_diario() {
	return monto_diario;
    }

    /**
     * @param monto_diario the monto_diario to set
     */
    public void setMonto_diario(int monto_diario) {
	this.monto_diario = monto_diario;
    }

    /**
     * @return the cuenta_corredora
     */
    public String getCuenta_corredora() {
	return cuenta_corredora;
    }

    /**
     * @param cuenta_corredora the cuenta_corredora to set
     */
    public void setCuenta_corredora(String cuenta_corredora) {
	this.cuenta_corredora = cuenta_corredora;
    }

    /**
     * @return the nom_cliente
     */
    public String getNom_cliente() {
	return nom_cliente;
    }

    /**
     * @param nom_cliente the nom_cliente to set
     */
    public void setNom_cliente(String nom_cliente) {
	this.nom_cliente = nom_cliente;
    }

    /**
     * @return the fecha_job
     */
    public Date getFecha_job() {
	return fecha_job;
    }

    /**
     * @param fecha_job the fecha_job to set
     */
    public void setFecha_job(Date fecha_job) {
	this.fecha_job = fecha_job;
    }

    /**
     * @return the saldo_disp_ov
     */
    public int getSaldo_disp_ov() {
	return saldo_disp_ov;
    }

    /**
     * @param saldo_disp_ov the saldo_disp_ov to set
     */
    public void setSaldo_disp_ov(int saldo_disp_ov) {
	this.saldo_disp_ov = saldo_disp_ov;
    }

}

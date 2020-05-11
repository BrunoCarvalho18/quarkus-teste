package br.com.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name="PRODUTO")
public class Produto extends PanacheEntity {
	
	//Panache Entity tem o que gera o @ID e o @Generated Value se você utitlizar heranca herdará os gereneted value
	
	public String nome;
	public BigDecimal valor;
	
	@CreationTimestamp
	public Date dataCriacao;
	
	@UpdateTimestamp
	public Date dataAtualizacao;
	

}

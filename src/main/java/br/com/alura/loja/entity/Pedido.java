package br.com.alura.loja.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate data = LocalDate.now();

	@ManyToOne
	private Cliente cliente;

	private BigDecimal valorTotal;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	@Deprecated
	public Pedido() {
		
	}
	
	public Pedido(Cliente cliente, BigDecimal valorTotal) {
		this.cliente = cliente;
		this.valorTotal = valorTotal;
	}

	// LEMBRAR SEMPRE NO RELACIONAMENTO BIDIRECIONAL DE FAZER AS ENTIDADES SE CONHECEREM
	public void adicionaItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getPreco() {
		return valorTotal;
	}

	public void setPreco(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}

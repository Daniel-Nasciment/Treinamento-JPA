package br.com.alura.loja.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	
	// POR PADRÃO OS RELACIONAMENTOS "ToOne" SÃO EAGER E ISSO PODE GERAR PROBLEMA DE PERFORMANCE NAS CONSULTAS
	// OS RELACIONAMENTOS "ToMany" SÃO LAZI POR PADRÃO
	// UMA BOA PRATICA É ALTERAR RELACIONAMENTOS TOONE PARA "LAZE"
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	// CASO A ANOTAÇÃO @Column SEJA CRIADA DEPOIS DA CRIAÇÃO DA TABELA, NO MOMENTO
	// DE EXECUÇÃO SERA CRIADA UMA NOVA COLUNA NA TABELAS
	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	// NO CASO DE item_pedido, É DEPENDENTE DE pedido
	// ENTÃO, USANDO CASCADE TUDO QUE ACONTECER COM PEDIDO VAI ACONTECER COM
	// ITEM_PEDIDO TAMBEM
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	@Deprecated
	public Pedido() {

	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	// LEMBRAR SEMPRE NO RELACIONAMENTO BIDIRECIONAL DE FAZER AS ENTIDADES SE
	// CONHECEREM
	public void adicionaItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = new BigDecimal(item.getQuantidade()).multiply(item.getValorUnitario());
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
